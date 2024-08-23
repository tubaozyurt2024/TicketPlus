package com.patika.ticketplusservice.service;


import com.patika.ticketplusservice.exception.GeneralException;
import com.patika.ticketplusservice.exception.Message;
import com.patika.ticketplusservice.model.User;
import com.patika.ticketplusservice.model.enums.ErrorCode;
import com.patika.ticketplusservice.request.LoginRequest;
import com.patika.ticketplusservice.request.UserRequest;
import com.patika.ticketplusservice.response.TokenResponse;
import com.patika.ticketplusservice.response.UserResponse;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final TokenService tokenService;

    private final PasswordEncoder encoder;

    public AuthService(AuthenticationManager authenticationManager, UserService userService,
                       TokenService tokenService, PasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.tokenService = tokenService;
        this.encoder = encoder;
    }

    public TokenResponse login(LoginRequest loginRequest) {
        try {
            Authentication auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword()));

            return TokenResponse
                    .builder()
                    .accessToken(tokenService.generateToken(auth))
                    .user(userService.getUserDto(loginRequest.getEmail()))
                    .build();

        } catch (final BadCredentialsException badCredentialsException) {
            throw new GeneralException(Message.INVALID, HttpStatus.BAD_REQUEST, ErrorCode.INVALID);
        }
    }

    public UserResponse getAuthenticatedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.getUserDto(username);
    }

    @Transactional
    public UserResponse register(UserRequest userRequest) throws Exception {
        var isAllReadyRegistered = userService.existsByEmail(userRequest.getEmail());

        if (isAllReadyRegistered) {
            new GeneralException(Message.ALREADY_USED_EMAIL, HttpStatus.FOUND, ErrorCode.FOUND);
        }

        var user = User.builder()
                .email(userRequest.getEmail())
                .password(encoder.encode(userRequest.getPassword()))
                .role(userRequest.getRole())
                .userType(userRequest.getUserType())
                .phoneNumber(userRequest.getPhoneNumber())
                .build();

        User fromDb = userService.createUser(user);

        return UserResponse.builder()
                .id(fromDb.getId())
                .email(fromDb.getEmail())
                .role(fromDb.getRole())
                .phoneNumber(fromDb.getPhoneNumber())
                .userType(fromDb.getUserType())
                .build();

    }
}

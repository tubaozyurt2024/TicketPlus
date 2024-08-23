package com.patika.ticketplusservice.controller;


import com.patika.ticketplusservice.model.User;
import com.patika.ticketplusservice.response.UserResponse;
import com.patika.ticketplusservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = Logger.getLogger(UserController.class.getName());

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        logger.log(Level.INFO, "[UserController] -- user retrieved successfully. ");
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email) {
        logger.log(Level.INFO, "[UserController] -- user of type {0} retrieved. ", email);
        return ResponseEntity.ok(userService.getByEmail(email));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<User>> getByUserId(@PathVariable("id") Integer userId) throws Exception {
        return ResponseEntity.ok(userService.getById(userId));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userService.delete(id);
    }

}
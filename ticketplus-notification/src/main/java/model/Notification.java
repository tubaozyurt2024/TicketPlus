package model;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import model.enums.NotificationType;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
@Getter
@Setter
public class Notification {

    @CreationTimestamp
    private LocalDateTime createdDate;

    private String message;

    private String email;

    private String phoneNumber;

    private Integer deviceId;

    private String detail;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_type")
    private NotificationType notificationType;
}

package listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.Email;
import model.Notification;
import model.Push;
import model.SMS;
import model.enums.NotificationType;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import repository.EmailNotificationRepository;
import repository.PushNotificationRepository;
import repository.SMSNotificationRepository;

import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class NotificationListener {


    private final EmailNotificationRepository emailNotificationRepository;


    private final PushNotificationRepository pushNotificationRepository;


    private final SMSNotificationRepository smsNotificationRepository;


    @RabbitListener(queues = "ticketplus.notification")
    public void notificationListener(Notification notification) {
        if (NotificationType.EMAIL.equals(notification.getNotificationType())) {
            Email resultEmail = new Email();
            resultEmail.setMessage("The user is registered in the system.");
            resultEmail.setEmail(notification.getEmail());
            resultEmail.setCreatedDate(LocalDateTime.now());
            resultEmail.setNotificationType(NotificationType.EMAIL);

            emailNotificationRepository.save(resultEmail);

        } else if (NotificationType.SMS.equals(notification.getNotificationType())) {
            SMS resultSMS = new SMS();
            resultSMS.setMessage("Ticket details have been sent as SMS.");
            resultSMS.setPhoneNumber(notification.getPhoneNumber());
            resultSMS.setDetail(notification.getDetail());
            resultSMS.setNotificationType(NotificationType.SMS);

            smsNotificationRepository.save(resultSMS);

        } else if (NotificationType.PUSH.equals(notification.getNotificationType())) {
            Push resultPush = new Push();
            resultPush.setMessage("Push notification sent. ");
            resultPush.setDetail(notification.getDetail());
            resultPush.setNotificationType(NotificationType.PUSH);

            pushNotificationRepository.save(resultPush);
        }
    }
}

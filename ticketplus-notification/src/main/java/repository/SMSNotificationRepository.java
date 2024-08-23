package repository;

import model.SMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SMSNotificationRepository extends JpaRepository<SMS, Integer> {
}

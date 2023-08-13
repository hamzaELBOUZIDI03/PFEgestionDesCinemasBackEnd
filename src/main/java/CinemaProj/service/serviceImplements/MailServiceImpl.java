package CinemaProj.service.serviceImplements;

import CinemaProj.entite.MailEntity;
import CinemaProj.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MailServiceImpl implements MailService {

    private JavaMailSender mailSender;
    private String senderEmail;

    @Autowired
    public MailServiceImpl(JavaMailSender mailSender, @Value("${spring.mail.username}") String senderEmail) {
        this.mailSender = mailSender;
        this.senderEmail = senderEmail;
    }

    @Override
    public void sendMail(MailEntity mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.getEmail()); // Set the sender email address
        message.setFrom(senderEmail); // Use the recipientEmail property
        message.setSubject(mail.getSubject());
        message.setText(mail.getMessage());

        mailSender.send(message);

}

}

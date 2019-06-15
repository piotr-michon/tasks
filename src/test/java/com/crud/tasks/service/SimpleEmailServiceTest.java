package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SimpleEmailServiceTest {
    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {
        //Given
        Mail mail = new Mail("test@test.com", "test2@test.com","Test", "Test message");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        if (mail.getToCc() == null || mail.getToCc() == "") {
            mailMessage.setTo(mail.getMailTo());
            mailMessage.setSubject(mail.getSubject());
            mailMessage.setText(mail.getMessage());
        } else {
            mailMessage.setTo(mail.getMailTo());
            mailMessage.setCc(mail.getToCc());
            mailMessage.setSubject(mail.getSubject());
            mailMessage.setText(mail.getMessage());
        }
        //When
        simpleEmailService.send(mail);
        //Then
        verify(javaMailSender, times(1)).send(mailMessage);
    }
}
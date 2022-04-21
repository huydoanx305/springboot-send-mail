package com.example.springbootsendmail.service;

import com.example.springbootsendmail.dto.DataMailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Objects;

@Service
public class MailServiceImpl implements MailService{
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMail(DataMailDTO dataMail, MultipartFile[] files) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        helper.setTo(dataMail.getTo());
        helper.setSubject(dataMail.getSubject());
        helper.setText(dataMail.getContent());
        if(files != null && files.length > 0) {
            for (MultipartFile file : files) {
                helper.addAttachment(Objects.requireNonNull(file.getOriginalFilename()), file);
            }
        }
        mailSender.send(message);
    }
}

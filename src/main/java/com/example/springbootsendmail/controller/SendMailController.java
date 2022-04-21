package com.example.springbootsendmail.controller;

import com.example.springbootsendmail.dto.DataMailDTO;
import com.example.springbootsendmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.util.Map;

@RestController
public class SendMailController {
    @Autowired
    private MailService mailService;

    @PostMapping("/send-mail")
    public ResponseEntity<?> demoSendMail(@RequestParam Map<String, String> dataMail,
                                          @RequestParam MultipartFile[] files) {
        try {
            mailService.sendMail(new DataMailDTO(dataMail.get("to"), dataMail.get("subject"), dataMail.get("content")), files);
        } catch (MessagingException e) {
            return ResponseEntity.ok().body("Send failed");
        }
        return ResponseEntity.ok().body("Send mail successfully");
    }
}

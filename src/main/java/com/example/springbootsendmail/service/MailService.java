package com.example.springbootsendmail.service;

import com.example.springbootsendmail.dto.DataMailDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;

public interface MailService {
    void sendMail(DataMailDTO dataMail, MultipartFile[] files) throws MessagingException;
}

package com.example.springbootsendmail.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataMailDTO {
    private String to;
    private String subject;
    private String content;
}

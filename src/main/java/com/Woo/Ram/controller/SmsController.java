package com.Woo.Ram.controller;

import com.Woo.Ram.dto.MessageDTO;
import com.Woo.Ram.dto.Request;
import com.Woo.Ram.dto.SmsRequestDTO;
import com.Woo.Ram.dto.SmsResponseDTO;
import com.Woo.Ram.service.SmsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
@Slf4j
@Controller
@RequiredArgsConstructor
public class SmsController {
    private final SmsService smsService;

    @GetMapping("/send")
    public String getSmsPage() {

        return "articles/sendSms";
    }

    @PostMapping("/sms/send")
    public String sendSms(MessageDTO messageDto, Model model) throws JsonProcessingException, RestClientException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        SmsResponseDTO response = smsService.sendSms(messageDto);
        log.info(response.toString());
        model.addAttribute("response", response);
        return "articles/result";
    }

}

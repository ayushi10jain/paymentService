package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/phonepe")
public class PhonepeController {

    @GetMapping()
    public String getDetails(){
      return null;
    }

    @PostMapping()
    public String getDetails1(){
        return null;
    }
}

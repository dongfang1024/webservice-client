package com.bat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {

    @GetMapping("success")
    public String successPage(){
        return "success";
    }

}

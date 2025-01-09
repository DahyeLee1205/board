package com.example.common.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CommonController {

    @GetMapping("/")
    private String boardView(){
        return "forward:/WEB-INF/views/main.jsp";
    }
}

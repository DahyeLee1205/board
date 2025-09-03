package com.example.common.controller
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class CommonController {

    @GetMapping("/")
    fun  boardView() : String{
        return "forward:/WEB-INF/views/main.jsp";
    }
}

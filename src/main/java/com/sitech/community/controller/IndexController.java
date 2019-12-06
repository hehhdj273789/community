package com.sitech.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/***

 *Controller：允许这个类去接收前端的请求

 */

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

}

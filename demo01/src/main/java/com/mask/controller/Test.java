package com.mask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

    @RequestMapping("/testList")
    public String testList(){
        System.out.println("---------------");
        return "data-table";

    }
}

package ru.digdes.site.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "hello";
    }
}

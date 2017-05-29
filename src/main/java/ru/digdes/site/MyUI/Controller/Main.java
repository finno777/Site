package ru.digdes.site.MyUI.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.digdes.site.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslavtsev.I on 25.05.2017.
 */

@Controller
public class Main {
    @RequestMapping ("/")
//    @ResponseBody
    public String index() {
        return "hello.html";
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(null,"Ivan", "Ivanov"));
        return users;
    }
}


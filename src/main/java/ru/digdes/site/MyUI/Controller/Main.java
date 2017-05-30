package ru.digdes.site.MyUI.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.digdes.site.model.User;
import ru.digdes.site.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslavtsev.I on 25.05.2017.
 */

@Controller
public class Main {
    private UserService userService;
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
    @RequestMapping("/user/add")
    public String addUser(@ModelAttribute("user") User user){
        if(user.getId()==0){
            this.userService.addNewUser(user);
        }
        return "redirect:/getAllUsers";
    }
    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable ("id") Long id){

        this.userService.deleteUser(id);
        return "redirect:/getAllUsers";
    }
    @RequestMapping(value = "/persons/edit")
    public String getEdit(@RequestParam (value="id", required=true) Long id,
                          Model model) {
        model.addAttribute("userAttribute", userService.getUser(id));

        return "redirect:/getAllUsers";
    }

}


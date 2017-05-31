package ru.digdes.site.MyUI.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.digdes.site.model.Equipment;
import ru.digdes.site.model.User;
import ru.digdes.site.service.EquipmentService;
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
    private EquipmentService equipmentService;
    @RequestMapping ("/")
//    @ResponseBody
    public String index() {
        return "hello.html";
    }
    //US
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
    @RequestMapping("/remove/user/{id}")
    public String removeUser(@PathVariable ("id") Long id){

        this.userService.deleteUser(id);
        return "redirect:/getAllUsers";
    }
    @RequestMapping("user/edit")
    public User getUserById(@RequestParam(value = "id",required = true) Long id){
        return userService.getUser(id);
    }
    //EQ
    @RequestMapping("/getAllEquipment")
    public List<Equipment> getAllEquipment(){
        List<Equipment> equipments =new ArrayList<>();
        equipments.add(new Equipment(null,"104","104"));
        return equipments;
    }
    @RequestMapping("/equipment/add")
    public String addEquipment(@ModelAttribute("equipment") Equipment equipment){
        this.equipmentService.addNewEquipment(equipment);
        return "redirect:/getAllEquipment";
    }
    @RequestMapping("/remove/equipment/{id}")
    public String removeEquipment(@PathVariable("id") Long id){
        this.equipmentService.deleteEquipment(id);
        return "redirect:/getAllEquipment";
    }
    @RequestMapping("equipment/edit")
    public Equipment getEquipmentById(@RequestParam(value = "id",required = true) Long id){
        return equipmentService.getEquipment(id);
    }
}


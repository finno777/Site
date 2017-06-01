package ru.digdes.site.MyUI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.digdes.site.model.Equipment;
import ru.digdes.site.model.User;
import ru.digdes.site.service.EquipmentService;
import ru.digdes.site.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.digdes.site.service.impl.UserServiceImpl;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslavtsev.I on 25.05.2017.
 */

@Controller
public class Main {
@Autowired
    UserService userService;
    @Autowired
    EquipmentService equipmentService;

    @RequestMapping ("/")
//    @ResponseBody
    public String index() {
        return "hello.html";
    }
    //work
    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List<User> getAllUsers(){
        List<User> all = userService.getAll();
        return all;
    }
    //work
    @RequestMapping("/user/add")
    public String addUser(@RequestParam(value = "firstName") String firstname, @RequestParam(value = "lastName") String lastname ){
        User user = new User(null, firstname,lastname);
        this.userService.addNewUser(user);
        return "redirect:/getAllUsers";
    }
    //work
    @RequestMapping("/user/remove/{id}")
    public String removeUser(@PathVariable ("id") Long id){
        User user =new User(id);
        user.getId();
        this.userService.deleteUser(id);
        return "redirect:/getAllUsers";
    }
    @RequestMapping(value ="user/edit/{id}")
    public User updateUser(@RequestParam(value = "firstName") String firstname, @RequestParam(value = "lastName") String lastname ){
        User user = new User(null, firstname,lastname);
        this.userService.updateUser(user);
        return user;
    }
    //EQ
    @RequestMapping("/getAllEquipment")
    public List<Equipment> getAllEquipment(){
        List<Equipment> equipments =equipmentService.getAllEquipment();
        return equipments;
    }
    @RequestMapping("/equipment/add")
    public String addEquipment(@RequestParam(value = "nameEquipment") String nameEquipment,@RequestParam(value = "networkName") String networkName){
        Equipment equipment=new Equipment(null,nameEquipment,networkName);
        return "redirect:/getAllEquipment";
    }
    @RequestMapping("/remove/equipment/{id}")
    public String removeEquipment(@PathVariable("id") Long id){
        Equipment equipment=new Equipment(id);
        equipment.getId();
        this.equipmentService.deleteEquipment(id);
        return "redirect:/getAllEquipment";
    }
//    @RequestMapping("equipment/edit")
//    public Equipment getEquipmentById(@RequestParam(value = "id",required = true) Long id){
//        return equipmentService.getEquipment(id);
//    }
}


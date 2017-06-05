package ru.digdes.site.MyUI.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.digdes.site.model.Equipment;
import ru.digdes.site.model.Inventory;
import ru.digdes.site.model.User;
import ru.digdes.site.service.EquipmentService;
import ru.digdes.site.service.InventoryService;
import ru.digdes.site.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.digdes.site.service.impl.UserServiceImpl;

import javax.swing.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslavtsev.I on 25.05.2017.
 */

@Controller
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    @Autowired
    UserService userService;
    @Autowired
    EquipmentService equipmentService;
    @Autowired
    InventoryService inventoryService;

    @RequestMapping ("/")
//    @ResponseBody
    public String index() {
        return "hello.html";
    }
    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List<User> getAllUsers(){
        logger.info("ВЫвод на экран");
        List<User> all = userService.getAll();
        return all;
    }
    @RequestMapping("/user/add")
    public String addUser(@RequestParam(value = "firstName") String firstname, @RequestParam(value = "lastName") String lastname ){
        logger.debug("User add");
        User user = new User(null, firstname,lastname);
        this.userService.addNewUser(user);
        return "redirect:/getAllUsers";
    }
    @RequestMapping("/user/remove/{id}")
    public String removeUser(@PathVariable ("id") Long id){
        User user =new User(id);
        user.getId();
        this.userService.deleteUser(id);
        return "redirect:/getAllUsers";
    }
    //work
    @RequestMapping(value ="user/edit/{id}")
    public String updateUser(@PathVariable ("id") Long id,@RequestParam(value = "firstName") String firstname, @RequestParam(value = "lastName") String lastname){
        User user = new User(id,firstname,lastname);
        this.userService.updateUser(user);
        return "redirect:/getAllUsers";
    }
    //EQ
    @RequestMapping("/getAllEquipment")
    @ResponseBody
    public List<Equipment> getAllEquipment(){
        List<Equipment> equipments =equipmentService.getAllEquipment();
        return equipments;
    }
    @RequestMapping("/equipment/add")
    public String addEquipment(@RequestParam(value = "nameEquipment") String nameEquipment,@RequestParam(value = "networkName") String networkName){
        Equipment equipment=new Equipment(null,nameEquipment,networkName);
        this.equipmentService.addNewEquipment(equipment);
        return "redirect:/getAllEquipment";
    }
    @RequestMapping("/equipment/remove/{id}")
    public String removeEquipment(@PathVariable("id") Long id){
        Equipment equipment=new Equipment(id);
        equipment.getId();
        this.equipmentService.deleteEquipment(id);
        return "redirect:/getAllEquipment";
    }
    @RequestMapping("equipment/edit/{id}")
    public String updateEquipment(@RequestParam(value = "id") Long id,@RequestParam(value = "nameEquipment") String nameEquipment,@RequestParam(value = "networkName") String networkName){
        Equipment equipment=new Equipment(id,nameEquipment,networkName);
        this.equipmentService.updateEquipment(equipment);
        return "redirect:/getAllEquipment";
    }
    //Inventory
    @RequestMapping("/getAllInventory")
    @ResponseBody
    public List<Inventory> getAllInventory(){
        List<Inventory> all=inventoryService.getAll();
        return all;
    }
    //TODO додделать
    @RequestMapping("/inventory/add")
    public String addInventory(@RequestParam(value = "userId") Long userId,@RequestParam(value = "equipmentId") Long equipmentId){
        Inventory inventory =new Inventory();
        Equipment equipment = equipmentService.getEquipment(equipmentId);
        User user = userService.getUser(userId);
        inventory.setEquipment(equipment);
        inventory.setUser(user);
        inventoryService.addNewInventory(inventory);
        return  "redirect:/getAllInventory";
    }
    @RequestMapping("/inventory/remove")
    public String removeInventory(@PathVariable("id")Long id){
        Inventory inventory=new Inventory();
        inventory.getId();
        this.inventoryService.deleteInventory(id);
        return "redirect:/getAllInventory";
    }
}


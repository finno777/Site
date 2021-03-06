//package ru.digdes.site;
//
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.stereotype.Component;
//import ru.digdes.site.MyUI.App;
//import ru.digdes.site.config.AppConfig;
//import ru.digdes.site.config.HibernateConfig;
//import ru.digdes.site.model.Equipment;
//import ru.digdes.site.model.Inventory;
//import ru.digdes.site.model.User;
//import ru.digdes.site.service.EquipmentService;
//import ru.digdes.site.service.InventoryService;
//import ru.digdes.site.service.UserService;
//
//import java.io.Console;
//
///**
// * Created by Yaroslavtsev.I on 23.05.2017.
// */
//@Component
//public class Application {
//    private static final Logger logger = Logger.getLogger(Application.class);
//
//    @Autowired
//    private UserService userService ;
//    @Autowired
//    private EquipmentService equipmentService;
//    @Autowired
//    private InventoryService inventoryService;
//
//    public static void main(String[] args) {
//        //создаем контекст для взаимодействия , т.к. main не может общаться с методами run
//        AnnotationConfigApplicationContext ctx =
//                new AnnotationConfigApplicationContext(AppConfig.class, HibernateConfig.class);
//
//        Application app = ctx.getBean(Application.class);
//        app.run();
//    }
//
//    public void run(){
////
//        User userNew= new User(1L,"ilya","jarsl");
//        userService.addNewUser(userNew);
//        logger.info("Юзер добавлен");
//        Equipment equipment = new Equipment(1L,"11111","11111");
//        equipmentService.addNewEquipment(equipment);
//        logger.info("Добалено оборудование");
////
//        Inventory inventory = new Inventory();
//        inventory.setEquipment(equipment);
//        inventory.setUser(userNew);
//        inventoryService.addNewInventory(inventory);
//
//
////        User user= new User(null,"vasya","vasyall");
////        userService.addNewUser(user);
////         inventoryService.deleteInventory(1L);
////        inventoryService.deleteInventory(3L);
//    }
//}
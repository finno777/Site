package ru.digdes.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.digdes.site.config.AppConfig;
import ru.digdes.site.config.HibernateConfig;
import ru.digdes.site.model.Equipment;
import ru.digdes.site.model.Inventory;
import ru.digdes.site.model.User;
import ru.digdes.site.service.EquipmentService;
import ru.digdes.site.service.InventoryService;
import ru.digdes.site.service.UserService;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
@Component
public class Application {

    @Autowired
    private UserService userService ;
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private InventoryService inventoryService;

    public static void main(String[] args) {
        //создаем контекст для взаимодействия , т.к. main не может общаться с методами run
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class, HibernateConfig.class);

        Application app = ctx.getBean(Application.class);
        app.run();
    }

    public void run(){
        User userNew= new User(null,"vasya","yaroslav");
        userService.addNewUser(userNew);

        Equipment equipment = new Equipment(null,"1-02-nb-0000","102nb1111");
        equipmentService.addNewEquipment(equipment);

        Inventory inventory = new Inventory();
        inventory.setEquipment(equipment);
        inventory.setUser(userNew);
        inventoryService.addNewInventory(inventory);

//        User user= new User(null,"vasya","vasyall");
//        userService.addNewUser(user);
        // inventoryService.deleteInventory(1L);
//        inventoryService.deleteInventory(3L);

    }
}
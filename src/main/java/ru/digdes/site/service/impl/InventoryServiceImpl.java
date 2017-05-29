package ru.digdes.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digdes.site.dao.InventoryDao;
import ru.digdes.site.model.Inventory;
import ru.digdes.site.service.InventoryService;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryDao inventoryDao;

    @Override
    public Inventory getInventory(Long id) {
        return inventoryDao.findById(id);
    }

    @Override
    public void addNewInventory(Inventory inventory) {
        inventoryDao.save(inventory);
    }

    @Override
    public void deleteInventory(Long id){
        inventoryDao.deleteInventory(id);
    }
    
    @Override
    public void updateInventory(Inventory inventory){
        inventoryDao.updateInventory(inventory);
    }
}


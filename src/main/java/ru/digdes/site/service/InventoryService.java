package ru.digdes.site.service;

import ru.digdes.site.model.Inventory;
import java.util.List;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */

public interface InventoryService {
    Inventory getInventory(Long id);

    void addNewInventory(Inventory inventory);

    void deleteInventory(Long id);

    void updateInventory(Inventory inventory);

    List<Inventory> getAll();
}

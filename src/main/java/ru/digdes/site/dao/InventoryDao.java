package ru.digdes.site.dao;

import ru.digdes.site.model.Inventory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
public interface InventoryDao {
    Serializable save(Inventory inventory);
    Inventory findById(Serializable id);

    void deleteInventory(long id);

    void updateInventory(Inventory inventory);

    List<Inventory> getAll();
}

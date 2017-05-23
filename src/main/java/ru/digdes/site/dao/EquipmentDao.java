package ru.digdes.site.dao;

import ru.digdes.site.model.Equipment;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
public interface EquipmentDao {
    Serializable save(Equipment equipment);

    Equipment findById(Serializable id);

    void deleteEquipment(long id);

    void updateEquipment(Equipment equipment);

    List<Equipment> getAllEquipment();
}

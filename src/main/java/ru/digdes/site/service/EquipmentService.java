package ru.digdes.site.service;

import ru.digdes.site.model.Equipment;

import java.util.List;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */

public interface EquipmentService {
    Equipment getEquipment(Long id);

    void addNewEquipment(Equipment equipment);

    void updateEquipment(Equipment equipment);

    void deleteEquipment(Long id);

    List<Equipment> getAllEquipment();
}

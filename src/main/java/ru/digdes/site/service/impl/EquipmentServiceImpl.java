package ru.digdes.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digdes.site.dao.EquipmentDao;
import ru.digdes.site.model.Equipment;
import ru.digdes.site.service.EquipmentService;

import java.util.List;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentDao equipmentDao;
    @Override
    public Equipment getEquipment(Long id) {
        return equipmentDao.findById(id);
    }

    @Override
    public void addNewEquipment(Equipment equipment) {
        equipmentDao.save(equipment);
    }

    @Override
    public void updateEquipment(Equipment equipment){
        equipmentDao.updateEquipment(equipment);
    }

    @Override
    public void deleteEquipment(Long id){
        equipmentDao.deleteEquipment(id);
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentDao.getAllEquipment();
    }
}

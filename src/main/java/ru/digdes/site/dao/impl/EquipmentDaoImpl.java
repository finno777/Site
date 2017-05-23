package ru.digdes.site.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.digdes.site.dao.EquipmentDao;
import ru.digdes.site.model.Equipment;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
@Repository
public class EquipmentDaoImpl implements EquipmentDao {
    @Autowired
    private SessionFactory sessionFactory;
    protected Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }
    @Override
    public Serializable save(Equipment equipment) {
        return getSession().save(equipment);
    }
    @Override
    public Equipment findById(final Serializable id) {
        return getSession().get(Equipment.class, id);
    }
    @Override
    public void deleteEquipment(long id){

        Equipment equipment=findById(id);
        if(equipment!=null)
            getSession().delete(equipment);
    }
    @Override
    public void updateEquipment(Equipment equipment){
        Equipment equipmentToUpdate=findById(equipment.getId());
        equipmentToUpdate.setNetworkName(equipment.getNetworkName());
        equipmentToUpdate.setNameEquipment(equipment.getNameEquipment());
        getSession().update(equipmentToUpdate);
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return getSession().createCriteria(Equipment.class).list();
    }
}


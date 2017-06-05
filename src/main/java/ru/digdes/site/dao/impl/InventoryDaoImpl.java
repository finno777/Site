package ru.digdes.site.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.digdes.site.dao.InventoryDao;
import ru.digdes.site.model.Inventory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
@Repository
public class InventoryDaoImpl implements InventoryDao{
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){return this.sessionFactory.getCurrentSession();}

    @Override
    public Serializable save(Inventory inventory){return  getSession().save(inventory);}
    @Override
    public Inventory findById(final Serializable id){return (Inventory) getSession().get(Inventory.class, id);}

    @Override
    public void deleteInventory(long id){
        Inventory inventory=findById(id);
        if(inventory!=null)
            getSession().delete(inventory);
    }

    @Override
    public void updateInventory(Inventory inventory){
        Inventory inventoryToUpdate=findById(inventory.getId());
        inventoryToUpdate.setEquipment(inventory.getEquipment());
        inventoryToUpdate.setUser(inventory.getUser());
        getSession().update(inventoryToUpdate);
    }

    @Override
    public List<Inventory> getAll() {return  getSession().createCriteria(Inventory.class).list();
        }
    }




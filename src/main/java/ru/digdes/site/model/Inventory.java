package ru.digdes.site.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
@Entity
@Data
@Table (name = "Inventory")
@SequenceGenerator (name = "entity1Seq", sequenceName="ENTITY1_SEQ", allocationSize = 1)
public class Inventory implements Serializable {

    @Id
    @GeneratedValue (generator = "entity1Seq")
    private Long id;

    //привязка идет к объекту а не к конкретной переменной
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "userId")
    private User user;


    //привязка идет к объекту а не к конкретной переменной
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "equipmentId")
    private Equipment equipment;

    public Inventory() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

}

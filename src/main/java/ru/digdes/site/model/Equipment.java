package ru.digdes.site.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
@Entity
@Data
@Table (name = "Equipment")
@SequenceGenerator (name = "entity3Seq", sequenceName="ENTITY3_SEQ",allocationSize = 1)
public class Equipment implements Serializable {


    @Id
    @GeneratedValue (generator = "entity3Seq")
    @Column(name = "equipmentId")
    private Long id;

    @Column(name = "nameEquipment")
    private String nameEquipment;

    @Column(name = "networkName")
    private String networkName;

    public Equipment(){

    }

    public Equipment(Long id){this.id=id;}

    public Equipment(Long id, String nameEquipment, String networkName){
        this.id=id;
        this.nameEquipment=nameEquipment;
        this.networkName=networkName;
    }
    public Long getId(){
        return id;
    }
    public String getNameEquipment(){
        return nameEquipment;
    }
    public void setNameEquipment(String nameEquipment){
        this.nameEquipment=nameEquipment;
    }
    public String getNetworkName(){
        return networkName;
    }
    public void setNetworkName(String networkName){
        this.networkName=networkName;
    }


    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Inventory> inventories;

}
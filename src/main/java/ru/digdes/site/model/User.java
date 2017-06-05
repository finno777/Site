package ru.digdes.site.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Yaroslavtsev.I on 23.05.2017.
 */
@Entity
@Data
@Table(name = "Users")
@SequenceGenerator (name = "entity2Seq", sequenceName="ENTITY2_SEQ",allocationSize = 1)//Генерация ключа

public class User implements Serializable {

    @Id
    @GeneratedValue (generator = "entity2Seq")
    @Column (name = "userId")
    private Long id;

    @Column(name = "firstName", length = 20)
    private String firstName;

    @Column(name = "lastName" ,length = 50)
    private String lastName;

    public  User() {
    }

    public User(Long id){this.id=id;}

    public User(Long id, String firstName, String lastName){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public Long getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    @JsonIgnore
    @OneToMany (mappedBy = "id",fetch = FetchType.EAGER, cascade = CascadeType.DETACH)//Связь с таблицой Инвентаризация
    private List<Inventory> inventories;
}
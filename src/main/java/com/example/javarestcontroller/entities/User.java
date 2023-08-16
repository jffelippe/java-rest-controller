package com.example.javarestcontroller.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="User") 
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String name;
    private String lastname;
    private Integer phone;
    private String email;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Integer getPhone() {
        return phone;
    }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

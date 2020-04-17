package com.ksoft.spring_mvc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Room {
    private @Id @GeneratedValue Long id;
    private String name;
    private double pricePerNight;

    public Room() {}

    public Room(String name, double pricePerNight) {
        this.name = name;
        this.pricePerNight = pricePerNight;
    }
}

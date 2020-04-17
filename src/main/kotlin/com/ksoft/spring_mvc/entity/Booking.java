package com.ksoft.spring_mvc.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Booking {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private Room room;

    @NotNull
    private String customerName;

    @NotNull
    private Date checkInTime;

    private Date checkOutTime;

    @NotNull
    private int numOfGuesses;

    public Booking() {

    }

    public Booking(Room room, @NotNull String customerName, @NotNull Date checkInTime, @NotNull int numOfGuesses) {
        this.room = room;
        this.customerName = customerName;
        this.checkInTime = checkInTime;
        this.numOfGuesses = numOfGuesses;
    }
}

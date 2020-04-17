package com.ksoft.spring_mvc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Service {
    @Id @GeneratedValue
    private Long id;

    @NotNull
    private String serviceName;

    @NotNull
    private String unit;

    @NotNull
    private double pricePerUnit;

    public Service() {

    }

    public Service(@NotNull String serviceName, @NotNull String unit, @NotNull double pricePerUnit) {
        this.serviceName = serviceName;
        this.unit = unit;
        this.pricePerUnit = pricePerUnit;
    }
}

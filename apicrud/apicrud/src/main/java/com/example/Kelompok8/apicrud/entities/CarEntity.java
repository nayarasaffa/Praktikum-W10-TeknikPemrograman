package com.example.Kelompok8.apicrud.entities;

import com.example.Kelompok8.apicrud.audit.AuditableBase;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class CarEntity extends AuditableBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String carName;
    private String type;
    private String number;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

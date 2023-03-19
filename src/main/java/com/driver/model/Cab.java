package com.driver.model;

//import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import javax.persistence.*;

@Entity
public class Cab{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabId;

    private int perKMRate;

    private boolean isAvailable;

    @OneToOne
    @JoinColumn
    Driver driver;


    public Cab(){

    }

    public Cab(int cabId, int perKMRate, boolean isAvailable, Driver driver) {
        this.cabId = cabId;
        this.perKMRate = perKMRate;
        this.isAvailable = isAvailable;
        this.driver = driver;
    }

    public int getCabId() {
        return cabId;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public int getPerKMRate() {
        return perKMRate;
    }

    public void setPerKMRate(int perKMRate) {
        this.perKMRate = perKMRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
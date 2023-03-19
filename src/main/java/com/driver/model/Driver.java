package com.driver.model;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int driverId;

    private String mobNo;

    private String password;

    @OneToOne(mappedBy = "driver" , cascade = CascadeType.ALL)
    Cab cab;

    @OneToMany(mappedBy = "driver" , cascade = CascadeType.ALL)
    List<TripBooking> tripBookingList = new ArrayList<>();

    public Driver(){
    }

    public Driver(int driverId, String mobNo, String password) {
        this.driverId = driverId;
        this.mobNo = mobNo;
        this.password = password;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public List<TripBooking> getTripBookingList() {
        return tripBookingList;
    }

    public void setTripBookingList(List<TripBooking> tripBookingList) {
        this.tripBookingList = tripBookingList;
    }
}
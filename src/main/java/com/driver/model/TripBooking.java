package com.driver.model;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import javax.persistence.*;

@Entity
public class TripBooking{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripBookingId;

    private String from_Location;

    private String to_Location;

    private int distanceInKm;

    @Enumerated(value = EnumType.STRING)
    private TripStatus status;

    private int bill;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToOne
    @JoinColumn
    Driver driver;

    public int getTripBookingId() {
        return tripBookingId;
    }

    public void setTripBookingId(int tripBookingId) {
        this.tripBookingId = tripBookingId;
    }

    public String getFrom_Location() {
        return from_Location;
    }

    public void setFrom_Location(String from_Location) {
        this.from_Location = from_Location;
    }

    public String getTo_Location() {
        return to_Location;
    }

    public void setTo_Location(String to_Location) {
        this.to_Location = to_Location;
    }

    public int getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(int distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public TripBooking(){

    }
    public TripBooking(int tripBookingId, String from_Location, String to_Location, int distanceInKm, TripStatus status, int bill) {
        this.tripBookingId = tripBookingId;
        this.from_Location = from_Location;
        this.to_Location = to_Location;
        this.distanceInKm = distanceInKm;
        this.status = status;
        this.bill = bill;
    }
}
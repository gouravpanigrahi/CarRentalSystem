package com.carrental.app.rent_a_car.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "VEHICLE_DETAILS")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String vehicleTitle;
    String vehiclesBrand;
    String vehicleOverview;
    double pricePerDay;
    String fuelType;
    int modelYear;
    int seatingCapacity;
    String image1;
    String image2;
    String image3;
    String image4;
    String image5;
    boolean airConditioner;
    boolean powerDoorLocks;
    boolean antiLockBrakingSystem;
    boolean brakeAssist;
    boolean powerSteering;
    boolean driverAirbag;
    boolean passengerAirbag;
    boolean powerWindows;
    boolean cdPlayer;
    boolean centralLocking;
    boolean crashSensor;
    boolean leatherSeats;
    Timestamp regDate;
    Timestamp updateDate;
}

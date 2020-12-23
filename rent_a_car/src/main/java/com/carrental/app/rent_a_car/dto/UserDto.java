package com.carrental.app.rent_a_car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserDto {

    long id;
    String fullName;
    String emailId;
    String password;
    String contactNo;
    Timestamp dob;
    String address;
    String city;
    String country;
    Timestamp regDate;
    Timestamp updateDate;
}

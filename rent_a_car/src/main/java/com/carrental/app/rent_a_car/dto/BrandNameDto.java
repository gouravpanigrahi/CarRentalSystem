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
public class BrandNameDto {
    long id;
    String brandName;
    Timestamp creationDate;
    Timestamp updateDate;
}
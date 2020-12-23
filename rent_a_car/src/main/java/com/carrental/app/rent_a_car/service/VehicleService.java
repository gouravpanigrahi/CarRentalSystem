package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.dto.VehicleDto;

import java.util.List;

public interface VehicleService {
    VehicleDto createVehicle(VehicleDto vehicleDto);

    List<VehicleDto> getVehicles();

    VehicleDto getVehicle(long id);

    VehicleDto updateVehicle(VehicleDto vehicleDto);

    void deleteVehicle(long id);
}

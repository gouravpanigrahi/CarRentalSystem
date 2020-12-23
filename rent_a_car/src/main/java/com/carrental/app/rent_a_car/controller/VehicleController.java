package com.carrental.app.rent_a_car.controller;

import com.carrental.app.rent_a_car.dto.VehicleDto;
import com.carrental.app.rent_a_car.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle/")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to vehicle ...";
    }

    @PostMapping(value = "createVehicle")
    public VehicleDto createVehicle(@RequestBody VehicleDto vehicleDto) {
        return vehicleService.createVehicle(vehicleDto);
    }

    @GetMapping(value = "getVehicles")
    public List<VehicleDto> getVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping(value = "getVehicle/{id}")
    public VehicleDto getVehicle(@PathVariable long id) {
        return vehicleService.getVehicle(id);
    }

    @PostMapping(value = "updateVehicle")
    public VehicleDto updateVehicle(@RequestBody VehicleDto vehicleDto) {
        return vehicleService.updateVehicle(vehicleDto);
    }

    @GetMapping(value = "deleteVehicle/{id}")
    public void deleteVehicle(@PathVariable long id) {
        vehicleService.deleteVehicle(id);
    }
}

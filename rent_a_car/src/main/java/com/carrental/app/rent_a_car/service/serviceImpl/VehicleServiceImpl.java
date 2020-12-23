package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.dto.VehicleDto;
import com.carrental.app.rent_a_car.entity.VehicleEntity;
import com.carrental.app.rent_a_car.repository.VehicleRepository;
import com.carrental.app.rent_a_car.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {

        ModelMapper modelMapper = new ModelMapper();

        VehicleEntity vehicleEntity = modelMapper.map(vehicleDto, VehicleEntity.class);

        vehicleEntity = vehicleRepository.save(vehicleEntity);

        VehicleDto returnValue = modelMapper.map(vehicleEntity, VehicleDto.class);

        return returnValue;
    }

    @Override
    public List<VehicleDto> getVehicles() {
        List<VehicleDto> returnValue = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        Iterable<VehicleEntity> vehicleEntities = vehicleRepository.findAll();
        for (VehicleEntity vehicleEntity : vehicleEntities) {
            returnValue.add(modelMapper.map(vehicleEntity, VehicleDto.class));
        }
        return returnValue;
    }

    @Override
    public VehicleDto getVehicle(long id) {

        ModelMapper modelMapper = new ModelMapper();
        VehicleEntity vehicleEntity = vehicleRepository.findVehicleEntityById(id);

        if (vehicleEntity == null)
            throw new RuntimeException("Record Not Available...");

        VehicleDto returnValue = modelMapper.map(vehicleEntity, VehicleDto.class);

        return returnValue;
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto) {

        ModelMapper modelMapper = new ModelMapper();

        VehicleEntity vehicleEntity = modelMapper.map(vehicleDto, VehicleEntity.class);

        if (vehicleRepository.findVehicleEntityById(vehicleEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");

        vehicleEntity = vehicleRepository.save(vehicleEntity);

        VehicleDto returnValue = modelMapper.map(vehicleEntity, VehicleDto.class);

        return returnValue;
    }

    @Override
    public void deleteVehicle(long id) {
        if (vehicleRepository.findVehicleEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        vehicleRepository.deleteById(id);
    }
}

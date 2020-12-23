package com.carrental.app.rent_a_car.repository;

import com.carrental.app.rent_a_car.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    VehicleEntity findVehicleEntityById(long id);
}

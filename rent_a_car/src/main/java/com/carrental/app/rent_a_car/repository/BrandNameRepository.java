package com.carrental.app.rent_a_car.repository;

import com.carrental.app.rent_a_car.entity.BrandNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandNameRepository extends JpaRepository<BrandNameEntity, Long> {
    BrandNameEntity findBrandNameEntityById(long id);
}

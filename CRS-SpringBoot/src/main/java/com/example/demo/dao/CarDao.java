package com.example.demo.dao;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;

import javax.transaction.Transactional;

@Repository
public interface CarDao extends JpaRepository<Car,Long> {

    Optional<Car> findByCarNo(BigInteger carNo);

    @Transactional
    @Modifying
    @Query("delete from Car c where c.carNo=:carNo")
    void deleteByCarNo(@Param("carNo") BigInteger carNo);
}

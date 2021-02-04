package com.example.demo.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Schedule;
@Repository
public interface ScheduleDao extends JpaRepository<Schedule, BigInteger> {

}

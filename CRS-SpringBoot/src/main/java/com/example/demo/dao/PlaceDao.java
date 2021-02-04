package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.*;

import java.util.Optional;

@Repository
public interface PlaceDao extends JpaRepository<Place,Long> {
    Optional<Place> findByPlaceCode(String placeCode);
    void deleteByPlaceCode(String placeCode);

}

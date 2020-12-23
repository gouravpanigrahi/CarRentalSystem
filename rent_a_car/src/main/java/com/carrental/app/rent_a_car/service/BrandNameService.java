package com.carrental.app.rent_a_car.service;

import com.carrental.app.rent_a_car.dto.BrandNameDto;

import java.util.List;

public interface BrandNameService {
    BrandNameDto createBrandName(BrandNameDto brandNameDto);

    List<BrandNameDto> getBrandNames();

    BrandNameDto getBrandName(long id);

    BrandNameDto updateBrandName(BrandNameDto brandNameDto);

    void deleteBrandName(long id);
}
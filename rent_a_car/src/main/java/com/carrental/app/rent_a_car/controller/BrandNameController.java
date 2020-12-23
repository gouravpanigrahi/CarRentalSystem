package com.carrental.app.rent_a_car.controller;


import com.carrental.app.rent_a_car.dto.BrandNameDto;
import com.carrental.app.rent_a_car.service.BrandNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brandName/")
public class BrandNameController {

    @Autowired
    BrandNameService brandNameService;

    @GetMapping(value = "")
    public String welcome() {
        return "Welcome to BrandName ...";
    }

    @PostMapping(value = "createBrandName")
    public BrandNameDto createBrandName(@RequestBody BrandNameDto brandNameDto) {
        return brandNameService.createBrandName(brandNameDto);
    }

    @GetMapping(value = "getBrandNames")
    public List<BrandNameDto> getBrandNames() {
        return brandNameService.getBrandNames();
    }

    @GetMapping(value = "getBrandName/{id}")
    public BrandNameDto getBrandName(@PathVariable long id) {
        return brandNameService.getBrandName(id);
    }

    @PostMapping(value = "updateBrandName")
    public BrandNameDto updateBrandName(@RequestBody BrandNameDto brandNameDto) {
        return brandNameService.updateBrandName(brandNameDto);
    }

    @GetMapping(value = "deleteBrandName/{id}")
    public void deleteBrandName(@PathVariable long id) {
        brandNameService.deleteBrandName(id);
    }
}
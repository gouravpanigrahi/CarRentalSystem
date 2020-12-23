package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.dto.BrandNameDto;
import com.carrental.app.rent_a_car.entity.BrandNameEntity;
import com.carrental.app.rent_a_car.repository.BrandNameRepository;
import com.carrental.app.rent_a_car.service.BrandNameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BrandNameServiceImpl implements BrandNameService {

    @Autowired
    BrandNameRepository brandNameRepository;

    @Override
    public BrandNameDto createBrandName(BrandNameDto brandNameDto) {

        ModelMapper modelMapper = new ModelMapper();

        BrandNameEntity brandNameEntity = modelMapper.map(brandNameDto, BrandNameEntity.class);

        brandNameEntity = brandNameRepository.save(brandNameEntity);

        BrandNameDto returnValue = modelMapper.map(brandNameEntity, BrandNameDto.class);

        return returnValue;
    }

    @Override
    public List<BrandNameDto> getBrandNames() {
        List<BrandNameDto> returnValue = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        Iterable<BrandNameEntity> brandNameEntities = brandNameRepository.findAll();
        for (BrandNameEntity brandNameEntity : brandNameEntities) {
            returnValue.add(modelMapper.map(brandNameEntity, BrandNameDto.class));
        }
        return returnValue;
    }

    @Override
    public BrandNameDto getBrandName(long id) {

        ModelMapper modelMapper = new ModelMapper();
        BrandNameEntity brandNameEntity = brandNameRepository.findBrandNameEntityById(id);

        if (brandNameEntity == null)
            throw new RuntimeException("Record Not Available...");

        BrandNameDto returnValue = modelMapper.map(brandNameEntity, BrandNameDto.class);

        return returnValue;
    }

    @Override
    public BrandNameDto updateBrandName(BrandNameDto brandNameDto) {

        ModelMapper modelMapper = new ModelMapper();

        BrandNameEntity brandNameEntity = modelMapper.map(brandNameDto, BrandNameEntity.class);

        if (brandNameRepository.findBrandNameEntityById(brandNameEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");

        brandNameEntity = brandNameRepository.save(brandNameEntity);

        BrandNameDto returnValue = modelMapper.map(brandNameEntity, BrandNameDto.class);

        return returnValue;
    }

    @Override
    public void deleteBrandName(long id) {
        if (brandNameRepository.findBrandNameEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        brandNameRepository.deleteById(id);
    }
}
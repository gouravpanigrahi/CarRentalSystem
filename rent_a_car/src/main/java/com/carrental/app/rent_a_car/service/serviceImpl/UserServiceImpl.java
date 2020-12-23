package com.carrental.app.rent_a_car.service.serviceImpl;

import com.carrental.app.rent_a_car.dto.UserDto;
import com.carrental.app.rent_a_car.entity.UserEntity;
import com.carrental.app.rent_a_car.repository.UserRepository;
import com.carrental.app.rent_a_car.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        ModelMapper modelMapper = new ModelMapper();

        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

        userEntity = userRepository.save(userEntity);

        UserDto returnValue = modelMapper.map(userEntity, UserDto.class);

        return returnValue;
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserDto> returnValue = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        Iterable<UserEntity> userEntities = userRepository.findAll();
        for (UserEntity userEntity : userEntities) {
            returnValue.add(modelMapper.map(userEntity, UserDto.class));
        }
        return returnValue;
    }

    @Override
    public UserDto getUser(long id) {

        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = userRepository.findUserEntityById(id);

        if (userEntity == null)
            throw new RuntimeException("Record Not Available...");

        UserDto returnValue = modelMapper.map(userEntity, UserDto.class);

        return returnValue;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        ModelMapper modelMapper = new ModelMapper();

        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

        if (userRepository.findUserEntityById(userEntity.getId()) == null)
            throw new RuntimeException("Record Not Available...");

        userEntity = userRepository.save(userEntity);

        UserDto returnValue = modelMapper.map(userEntity, UserDto.class);

        return returnValue;
    }

    @Override
    public void deleteUser(long id) {
        if (userRepository.findUserEntityById(id) == null)
            throw new RuntimeException("Record Not Available...");
        userRepository.deleteById(id);
    }
}

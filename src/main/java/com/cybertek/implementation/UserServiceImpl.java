package com.cybertek.implementation;

import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;
import com.cybertek.mapper.UserMapper;
import com.cybertek.repository.UserRepository;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.util.SpringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    UserMapper userMapper;

//    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
//        this.userRepository = userRepository;
//        this.userMapper = userMapper;
//    }

    public UserRepository getUserRepository(){
        return SpringUtils.getBean(UserRepository.class);
    }

    public UserMapper getUserUserMapper(){
        return SpringUtils.getBean(UserMapper.class);
    }

    @Override
    public List<UserDTO> listAllUsers() {
        List<User> list = getUserRepository().findAll(Sort.by("firstName"));
        return list.stream().map(obj ->{return getUserUserMapper().convertToDto(obj);}).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String username) {
        return null;
    }

    @Override
    public void save(UserDTO dto) {

    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }

    @Override
    public void delete(String username) {

    }
}

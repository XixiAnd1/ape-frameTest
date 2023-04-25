package com.jingdianjichi.user.service.impl;

import com.jingdianjichi.user.mapper.UserMapper;
import com.jingdianjichi.user.service.UserService;
import entity.dto.UserDto;
import entity.po.UserPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(UserDto userDto) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDto,userPo);
        int count = userMapper.insert(userPo);
        return count;
    }
}

package com.services;

import com.dto.UserInfo;
import com.entity.User;
import com.mapper.UserMapper;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    public UserInfo findByName(String name) {
        List<User> users = userRepository.findByName(name);
        if(users.size() != 0) {
            User user = userRepository.findByName(name).get(0);
            UserInfo userInfo = userMapper.map(user, UserInfo.class);

            return userInfo;
        }

        return null;
    }

    public UserInfo addUser(UserInfo userInfo) {
        User user = userMapper.map(userInfo, User.class);
        user = userRepository.save(user);

        return userMapper.map(user, UserInfo.class);
    }

    public UserInfo updateUser(UserInfo userInfo) throws Exception {
        if (userInfo == null) throw new NullPointerException("userInfo");

        User old = userRepository.findOne(userInfo.getId());
        if (old == null) throw new Exception("can not find user {id=" + userInfo.getId() + "}");

        old.setName(userInfo.getName());
        userRepository.save(old);

        return userInfo;
    }
}

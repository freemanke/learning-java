package com.service;

import com.dto.UserInfo;
import com.entity.User;
import com.mapper.UserMapper;
import com.repository.UserRepository;
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
        if (users.size() != 0) {
            User user = userRepository.findByName(name).get(0);
            UserInfo userInfo = userMapper.map(user, UserInfo.class);

            return userInfo;
        }

        return null;
    }

    public UserInfo addUser(UserInfo userInfo) {
        if (userInfo == null) throw new IllegalArgumentException("userInfo can't be null");
        if (userInfo.getName() == null) throw new IllegalArgumentException("name can't be null");

        userInfo.setId(0);
        User user = userMapper.map(userInfo, User.class);
        user = userRepository.save(user);

        return userMapper.map(user, UserInfo.class);
    }

    public UserInfo updateUser(UserInfo userInfo) throws Exception {
        if (userInfo == null) throw new IllegalArgumentException("userInfo");
        if (userInfo.getId() <= 0) throw new IllegalArgumentException("id");

        User old = userRepository.findOne(userInfo.getId());
        if (old == null) throw new Exception("can not find user {id=" + userInfo.getId() + "}");

        old.setName(userInfo.getName());
        userRepository.save(old);

        return userInfo;
    }
}

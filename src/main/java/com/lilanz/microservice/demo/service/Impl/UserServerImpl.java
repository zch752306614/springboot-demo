package com.lilanz.microservice.demo.service.Impl;

import com.lilanz.microservice.demo.bean.User;
import com.lilanz.microservice.demo.dao.UserMapper;
import com.lilanz.microservice.demo.service.UserServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Alice
 * @version 1.0
 * @date 2020/8/8 9:02
 */
@Service
public class UserServerImpl implements UserServer {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int insert_sql(String sql) {
        return userMapper.insert_sql(sql);
    }

}

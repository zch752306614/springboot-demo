package com.lilanz.microservice.demo.service;

import com.lilanz.microservice.demo.bean.User;

/**
 * @author Alice
 * @version 1.0
 * @date 2020/8/8 9:00
 */
public interface UserServer {

    int insert(User user);

    int insert_sql(String sql);

}

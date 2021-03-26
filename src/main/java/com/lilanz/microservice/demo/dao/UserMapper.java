package com.lilanz.microservice.demo.dao;

import com.lilanz.microservice.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author Alice
 * @version 1.0
 * @date 2020/8/8 9:06
 */
public interface UserMapper {

    int insert(User user);

    int insert_sql(@Param("sql") String sql);

}

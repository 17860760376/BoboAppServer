package com.bobo.dao;

import com.bobo.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);



    /**
     * 判断用户名是否存在
     */
    int findByUsername(@Param("username") String username);
    /**
     * 判断用户名和密码是否正确
     *
     */
    User findByUsernameAndPassword(@Param("username") String username,@Param("password")String password);
    /**
     * 修改对应用户名的密码
     */
    int updatePasswordByUsername(@Param("username") String username,@Param("password") String password);

}
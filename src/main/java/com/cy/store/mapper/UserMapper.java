package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

// 用户模块的持久层接口
public interface UserMapper {

    /**
     * 插入用户数据
     * @param user 用户数据
     * @return 受影响的行数(增、删、改，都有受影响的行数作为返回值，根据返回值判断是否执行成功)
     */
    Integer insert(User user);

    /**
     * 根据用户名查询用户数据
     * @param username 用户名
     * @return 用户数据，如果没有则返回null值
     */
    User findByUsername(String username);

    User findByUid(Integer uid);

    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    Integer updateInfoByUid(User user);//根据uid更新用户资料,user封装用户id和新个人资料，返回行数

    // @Param("SQL映射文件中#{}占位符的变量名")，解决的问题：当SQL语句的占位符和映射的接口方法参数名不一致时，需要将某个参数强行注入
    // 到某个占位符变量上时。可以使用@Param这个注解来标注映射的关系。
    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);
}

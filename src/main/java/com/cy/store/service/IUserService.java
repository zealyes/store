package com.cy.store.service;

import com.cy.store.entity.User;

public interface IUserService {
    /**
     * 用户注册
     * @param user 用户的数据对象
     */
    void reg(User user);

    /**
     *
     * @param username
     * @param password
     * @return 返回用户数据，没有则返回null
     */
    User login(String username, String password);

    //修改密码
    void changePassword(Integer uid, String username, String oldPassword, String newPassword);

    //获取当前登录用户的信息,返回当前的登录用户的信息
    User getByUid(Integer uid);

    //修改用户个人资料
    void changeInfo(Integer uid,String username,User user);

    //上传用户头像
    void changeAvatar(Integer uid, String username,String avatar );
}

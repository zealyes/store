package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest：表示标注当前的类是一个测试类，不会随同项目一起打包
@SpringBootTest
// @RunWith：表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数，必须是SpringRunner的实例类型
// @RunWith(SpringRunner.class) @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解
public class UserServiceTest {
    // idea有检测的功能，接口是不能够直接直接创建Bean的（动态代理技术来解决）
    @Autowired
    private IUserService userService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("apple");
            user.setPassword("orange");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    // 登录用户验证测试
    @Test
    public void login() {
        User user = userService.login("apple", "orange");
        System.out.println(user);
    }

    //测试改变密码
    @Test
    public void changePassword(){
        userService.changePassword(6,"管理员","123","orange");
    }

    //测试获取到用户名称
    @Test
    public void getByUid() {
        try {
            Integer uid = 3;
            User user = userService.getByUid(uid);
            System.out.println(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    //测试修改个人资料
    @Test
    public void changeInfo() {
        try {
            Integer uid = 6;
            String username = "数据管理员";

            User user = new User();
            user.setPhone("15512328888");
            user.setEmail("admin03@cy.cn");
            user.setGender(2);

            userService.changeInfo(uid, username, user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    //测试上传用户头像图片
    @Test
    public void changAvatar(){
        userService.changeAvatar(6, "小明", "/upload/test.png");
    }

}

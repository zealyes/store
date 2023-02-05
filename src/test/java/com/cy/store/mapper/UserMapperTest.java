package com.cy.store.mapper;

import com.cy.store.entity.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//@SpringBootTest：表示标注当前的类是一个测试类，不会随同项目一起打包
@SpringBootTest
// @RunWith：表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数，必须是SpringRunner的实例类型
// @RunWith(SpringRunner.class) @RunWith(SpringRunner.class)注解是一个测试启动器，可以加载Springboot测试注解
public class UserMapperTest {
    // idea有检测的功能，接口是不能够直接直接创建Bean的（动态代理技术来解决）
    @Autowired
    private UserMapper userMapper;
    /**
     * 必须@Test注解修饰
     * 返回值必须是void
     * 方法的参数列表不指定任何类型
     * 方法的访问修饰符必须是public
     */
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("phigors");
        user.setPassword("123");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void findByUserName() {
        User user = userMapper.findByUsername("tim");
        System.out.println(user);
    }

    // 测试修改的信息
    @Test
    public void findByUid() {
        System.out.println(userMapper.findByUid(3));
    }

    //测试更新用户信息
    @Test
    public void updatePasswordByUid() {
        userMapper.updatePasswordByUid(3,"orange","管理员",new Date());
    }

    //测试个人资料
    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(6);
        user.setPhone("17858802222");
        user.setEmail("admin@gmail.com");
        user.setGender(1);
        user.setModifiedUser("系统管理员");
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void updateAvatarByUid() {
        userMapper.updateAvatarByUid(
                6,
                "/upload/avatar.png",
                "管理员",
                new Date());
    }
}

package com.sherlockqwq.weibo.service;

import com.sherlockqwq.weibo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class TestService {
    @Autowired
    private ListPost listPost;
    @Autowired
    private UserService userService;
    @Test
    void TestPage(){
        System.out.println(listPost.getPage(4,5));
    }
    @Test
    void TestGetById(){
        System.out.println(userService.getById(2));;

    }
    @Test
    void TestSave(){
        User user =new User();
        user.setUsername("老张");
        user.setPassword("laozhang");
        userService.save(user);
    }
    @Test
    void TestUpdate(){
        User user =new User();
        user.setId(3);
        user.setUsername("老王");
        user.setPassword("lao王");
        userService.updateById(user);
    }
    @Test
    void TestDelete(){
        userService.removeById(5);
    }
    @Test
    void TestGetAll(){
        System.out.println(userService.list());
    }
    @Test
    void Test(){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("username","老王");
        System.out.println(userService.listByMap(hashMap));

    }

}

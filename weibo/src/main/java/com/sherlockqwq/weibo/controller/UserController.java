package com.sherlockqwq.weibo.controller;

import com.sherlockqwq.weibo.domain.User;
import com.sherlockqwq.weibo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService userService ;
    @GetMapping("/{id}")
    public User SelectUserById(@PathVariable int id){
        return userService.getById(id);
    }
    @GetMapping("/login")
    public boolean login(@RequestBody User user, HttpServletRequest request){
        HttpSession session=request.getSession();
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("username",user.getUsername());
        hashMap.put("password",user.getPassword());
        User trueUser=userService.listByMap(hashMap).get(0);
        if(userService.listByMap(hashMap).isEmpty()){
            System.out.println("密码错误或用户不存在");
            return false;
        }
        else{
            System.out.println("登录成功");

            session.setAttribute("account",trueUser);
            session.setMaxInactiveInterval(50*60);
            return true;
        }
    }

    @PostMapping("/register")//注册
    public boolean register(@RequestBody User user){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("username",user.getUsername());
        if(!userService.listByMap(hashMap).isEmpty()){
            System.out.println("已被注册");
            return false;
        }
        else
            return userService.save(user);
    }
    @DeleteMapping("/logout")//注销
    public boolean logout(@RequestBody User user){
        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("username",user.getUsername());
        hashMap.put("password",user.getPassword());
        List<User> userList=userService.listByMap(hashMap);
        if(userList.isEmpty()){
            System.out.println("不存在这样的用户");
            return false;
        }
        else
            return userService.removeById(userList.get(0).getId());
    }


}

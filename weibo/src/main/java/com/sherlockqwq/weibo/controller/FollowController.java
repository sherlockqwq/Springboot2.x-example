package com.sherlockqwq.weibo.controller;

import com.sherlockqwq.weibo.domain.Follow;
import com.sherlockqwq.weibo.domain.User;
import com.sherlockqwq.weibo.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/subscribe")
public class FollowController {
    @Autowired
    private FollowService followService;
    @GetMapping("/{id}")
    public boolean FollowOthers(@PathVariable int id, HttpServletRequest request){
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("account");
        Follow follow=new Follow();
        follow.setUserId(user.getId());
        follow.setFollowedId(id);
        HashMap hashMap=new HashMap();
        hashMap.put("user_id",follow.getUserId());
        hashMap.put("followed_id",follow.getFollowedId());
        if(followService.listByMap(hashMap).isEmpty()){
            System.out.println("成功关注");
            return followService.save(follow);
        }else {
            System.out.println("你已经关注了");
            return false;
        }
    }
    @DeleteMapping("/undo")
    public boolean unsubscribe(@RequestParam(value = "uid",required=true,defaultValue="-1") int uid,HttpServletRequest request){
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("account");
        if(uid==-1){
            System.out.println("参数不合法");
            return false;
        }
        HashMap hashMap=new HashMap();
        hashMap.put("user_id",user.getId());
        hashMap.put("followed_id",uid);
        List<Follow> follows=followService.listByMap(hashMap);
        if(follows.isEmpty()){
            System.out.println("你并未关注");
            return false;
        }
        else {
            System.out.println("正在取关");
            return followService.removeById(follows.get(0).getId());
        }
    }
    @GetMapping("/followersnumber")
    public int GetFollowersNumber(HttpServletRequest request){
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("account");
        HashMap hashMap=new HashMap();
        hashMap.put("user_id",user.getId());
        List<Follow> follows=followService.listByMap(hashMap);
        System.out.println(follows);
        return follows.size();

    }
}

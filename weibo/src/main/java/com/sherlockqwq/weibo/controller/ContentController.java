package com.sherlockqwq.weibo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sherlockqwq.weibo.domain.Content;
import com.sherlockqwq.weibo.domain.Follow;
import com.sherlockqwq.weibo.domain.User;
import com.sherlockqwq.weibo.service.ContentService;
import com.sherlockqwq.weibo.service.FollowService;
import com.sherlockqwq.weibo.service.ListPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
     private ContentService contentService;
    @Autowired
    private  FollowService followService;
    @Autowired
    private ListPost listPost;
    @GetMapping("/{id}")
    public Content GetContentById(@PathVariable int id){
        return contentService.getById(id);
    }
    @PostMapping("/submit")
    public Content SubmitNewContent(@RequestBody Content content){
        contentService.save(content);
        return content;
    }
    @DeleteMapping("delete/{cid}")
    public boolean DeleteContent(@PathVariable int cid){
        return contentService.removeById(cid);
    }
    @GetMapping("follow")
    public List<Content> GetFollowingContents(HttpServletRequest request){
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute("account");//获得session里的account
        List<Content> contents,tempContent;
        contents= new ArrayList<Content>();
        List<Follow> follows;
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("user_id",user.getId());//为了构造进行user查找的map

        follows=followService.listByMap(hashMap);
        for(int i=0; i<follows.size();i++){
            int followId=follows.get(i).getFollowedId();
            contents.addAll(contentService.SelectByAuthorId(followId));
            System.out.println(followId+"--------------------------------------");
        }

        return contents;

    }

}

package com.sherlockqwq.weibo.dao;

import com.sherlockqwq.weibo.domain.Follow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class DaoTest {
    @Autowired
    private ContentDao contentDao;
    @Autowired
    private FollowDao followDao;
    @Autowired UserDao userDao;
    @Test
    void TestGetById(){
        System.out.println(contentDao.selectById(2));

    }
    @Test
    void TestUpdate(){
        Follow follow=new Follow();
        follow.setUserId(1);
        follow.setFollowedId(4);
        followDao.insert(follow);
    }
    @Test
    void TestGetAll(){
        followDao.selectList(null);
        System.out.println(followDao.selectList(null));

    }
}

package com.sherlockqwq.weibo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sherlockqwq.weibo.dao.UserDao;
import com.sherlockqwq.weibo.domain.User;
import com.sherlockqwq.weibo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

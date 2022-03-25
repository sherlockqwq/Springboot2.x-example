package com.sherlockqwq.weibo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sherlockqwq.weibo.dao.FollowDao;
import com.sherlockqwq.weibo.domain.Follow;
import com.sherlockqwq.weibo.service.FollowService;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl extends ServiceImpl<FollowDao, Follow> implements FollowService {
}

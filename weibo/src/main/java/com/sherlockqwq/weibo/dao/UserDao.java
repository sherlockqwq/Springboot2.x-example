package com.sherlockqwq.weibo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sherlockqwq.weibo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}

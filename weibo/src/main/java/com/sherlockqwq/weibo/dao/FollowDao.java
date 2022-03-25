package com.sherlockqwq.weibo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sherlockqwq.weibo.domain.Follow;
import org.apache.ibatis.annotations.Mapper;


@Mapper

public interface FollowDao extends BaseMapper<Follow> {
}

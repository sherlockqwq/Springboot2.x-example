package com.sherlockqwq.weibo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sherlockqwq.weibo.dao.ContentDao;
import com.sherlockqwq.weibo.domain.Content;
import com.sherlockqwq.weibo.service.ListPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListPostImpImpl implements ListPost {
    @Autowired
    private ContentDao contentDao;
    @Override
    public IPage<Content> getPage(int currentPage, int pageSize) {
        IPage<Content> page=new Page<>(currentPage,pageSize);
        QueryWrapper<Content> qw = new QueryWrapper<>();
        qw.select().orderByDesc("date");
        contentDao.selectPage(page,qw);
        return page;
    }
}

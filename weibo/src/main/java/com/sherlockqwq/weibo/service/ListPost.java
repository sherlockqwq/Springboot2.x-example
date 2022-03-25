package com.sherlockqwq.weibo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sherlockqwq.weibo.domain.Content;

public interface ListPost {
    public IPage<Content> getPage(int currentPage, int pageSize);
}

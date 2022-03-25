package com.sherlockqwq.weibo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sherlockqwq.weibo.domain.Content;

import java.util.List;

public interface ContentService extends IService<Content> {

    List<Content> SelectByAuthorId(int authorId);
}

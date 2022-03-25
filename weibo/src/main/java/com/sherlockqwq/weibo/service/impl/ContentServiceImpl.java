package com.sherlockqwq.weibo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sherlockqwq.weibo.dao.ContentDao;
import com.sherlockqwq.weibo.domain.Content;
import com.sherlockqwq.weibo.service.ContentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ContentServiceImpl extends ServiceImpl<ContentDao, Content> implements ContentService {


    @Override
    public List<Content> SelectByAuthorId(int authorId) {

        HashMap<String,Object> tempMap=new HashMap<>();
        tempMap.put("author_id",authorId);//进行author_id的查找 并建图
        return listByMap(tempMap);
    }
}

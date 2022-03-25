package com.sherlockqwq.weibo;

import com.sherlockqwq.weibo.domain.Content;
import com.sherlockqwq.weibo.service.ContentService;
import com.sherlockqwq.weibo.tools.LIstTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WeiboApplicationTests {
    private LIstTool<Content> lIstTool;
    private List<Content> list1,list2;
    @Autowired
    private ContentService contentService;

    @Test
    void contextLoads() {


    }

}

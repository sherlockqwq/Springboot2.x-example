package com.sherlockqwq.weibo.domain;


import lombok.Data;

import java.sql.Date;

@Data
public class Content {
    private long id;
    private int authorId;
    private String content;
    private Date date;


}

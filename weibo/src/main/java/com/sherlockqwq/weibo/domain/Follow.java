package com.sherlockqwq.weibo.domain;

import lombok.Data;

@Data

public class Follow {
    private int id;
    private int userId;
    private int followedId;
}

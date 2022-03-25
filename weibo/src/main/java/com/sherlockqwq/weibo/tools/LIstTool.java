package com.sherlockqwq.weibo.tools;

import java.util.List;
import java.util.ArrayList;
public class LIstTool<T> {
    public List<T> union (List <T> a, List <T> b) {
        List<T> list = new  ArrayList<T>();
        list.addAll(a);
        list.removeAll(b);
        list.addAll(b);
        return list;
    }
}

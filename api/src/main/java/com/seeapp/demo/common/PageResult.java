package com.seeapp.demo.common;

import java.util.List;

/**
 * 分页结果
 *
 * @author kangkai
 */
public class PageResult<T> {

    private List<T> list;

    private int count;

    public PageResult() {
    }

    public PageResult(int count, List<T> list) {
        this.list = list;
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

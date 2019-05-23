package com.seeapp.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * HTTP返回结果
 *
 * @author zhuhui
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpJsonResult<T> {

    /**
     * errno>0用户级别错误  <br/>
     * errno<0 系统级别错误  <br/>
     * errno=0无错误
     */
    public int errno;

    /**
     * errno!=0时的错误消息
     */
    public String errmsg;

    /**
     * errno=0时的结果
     */
    public T data;

    @SuppressWarnings("rawtypes")
    public static final HttpJsonResult OK = new HttpJsonResult();

    public HttpJsonResult() {
    }

    public HttpJsonResult(T data) {
        this.data = data;
    }

    public HttpJsonResult(int errno, String errmsg) {
        this.errno = errno;
        this.errmsg = errmsg;
    }

    public HttpJsonResult(int errno, String errmsg, T data) {
        this.errno = errno;
        this.errmsg = errmsg;
        this.data = data;
    }
}

package com.seeapp;

import com.github.mydog.common.json.JsonUtil;
import com.seeapp.base.BaseSpringBootTest;
import com.seeapp.common.PageResult;
import com.seeapp.component.service.DemoService;
import com.seeapp.entity.Demo;
import com.seeapp.model.request.DemoReq;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoTest extends BaseSpringBootTest {

    @Autowired
    DemoService demoService;

    @Test
    public void page() {

        DemoReq req = new DemoReq();
        req.setAccountId(1);
        PageResult<Demo> result = demoService.page(req);
        System.out.println(JsonUtil.writeValueAsString(result));
    }
}

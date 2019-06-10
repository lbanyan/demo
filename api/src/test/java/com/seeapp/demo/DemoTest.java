package com.seeapp.demo;

import com.github.mydog.common.json.JsonUtil;
import com.seeapp.demo.base.BaseSpringBootTest;
import com.seeapp.demo.common.PageResult;
import com.seeapp.demo.component.service.DemoService;
import com.seeapp.demo.entity.Demo;
import com.seeapp.demo.model.request.DemoReq;
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

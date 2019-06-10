package com.seeapp.demo.component.service;

import com.github.mydog.common.reflect.FastBeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.seeapp.demo.common.PageResult;
import com.seeapp.demo.entity.Demo;
import com.seeapp.demo.mapper.DemoMapper;
import com.seeapp.demo.model.request.DemoReq;
import com.seeapp.demo.model.response.DemoResp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService extends BaseService {

    @Resource
    DemoMapper demoMapper;

    /**
     * 通过hibernate保存
     * TODO 这里强制加事务
     * TODO hibernate user 整数
     */
    @Transactional(rollbackFor = Exception.class)
    public void add() {

        Demo demo = new Demo();
        demo.setAccountId(1);
        demo.setBillNo("111");
        demo.setType("ok");
        demo.setCpType("ok");
        demo.setStatus("ok");
        demo.setPeriod("2019-01");

        mysqlClient.save("-1", demo);
    }

    /**
     * 使用hibernate，通过主键查询
     *
     * @return
     */
    public DemoResp get() {

        Demo demo = mysqlClient.get(1, Demo.class);
        DemoResp resp = new DemoResp();
        FastBeanUtil.copy(demo, resp);
        return resp;
    }

    /**
     * 使用hibernate，查询所有list
     *
     * @return
     */
    public List<Demo> list() {

        return mysqlClient.getHibernateTemplate().loadAll(Demo.class);
    }

    /**
     * 使用hibernate，根据条件查询list
     *
     * @return
     */
    public List<Demo> list1() {

        Demo demo = new Demo();
        demo.setAccountId(2);
        return mysqlClient.getHibernateTemplate().findByExample(demo);
    }

    /**
     * 借助mybatis，使用sql查询list
     *
     * @return
     */
    public List<Demo> list2() {

        return demoMapper.list(1);
    }

    /**
     * 使用hibernate，修改数据
     */
    @Transactional(rollbackFor = Exception.class)
    public void update() {

        Demo demo = mysqlClient.get(1, Demo.class);
        demo.setErrmsg("this is test");

        mysqlClient.update("101", demo);
    }

    /**
     * 借助mybatis sql 分页
     *
     * @return
     */
    public PageResult<Demo> page(DemoReq req) {

        Page<Demo> page = PageHelper.startPage(req.getPage(), req.getPageSize());
        List<Demo> list = demoMapper.list(req.getAccountId());
        return new PageResult((int) page.getTotal(), list);
    }
}

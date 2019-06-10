package com.seeapp.demo.mapper;

import com.seeapp.demo.entity.Demo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemoMapper {

    List<Demo> list(@Param("accountId") Integer accountId);
}
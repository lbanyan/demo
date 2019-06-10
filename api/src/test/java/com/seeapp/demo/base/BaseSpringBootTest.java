package com.seeapp.demo.base;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NoWebApplicationConfiguration.class, webEnvironment = WebEnvironment.NONE)
public class BaseSpringBootTest {

}

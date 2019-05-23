package com.seeapp.component.controller;

import com.seeapp.common.HttpJsonResult;
import com.seeapp.common.PageResult;
import com.seeapp.component.service.DemoService;
import com.seeapp.entity.Demo;
import com.seeapp.model.request.DemoReq;
import com.seeapp.model.response.DemoResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

	@Autowired
	DemoService demoService;

	@PostMapping(value = "/add")
	public Object add() {

		demoService.add();
		return HttpJsonResult.OK;
	}

	@GetMapping(value = "/get")
	public Object get() {

		DemoResp result = demoService.get();
		return new HttpJsonResult<>(result);
	}

	@GetMapping(value = "/list")
	public Object list() {

		List<Demo> result = demoService.list();
		return new HttpJsonResult<>(result);
	}

	@GetMapping(value = "/list1")
	public Object list1() {

		List<Demo> result = demoService.list1();
		return new HttpJsonResult<>(result);
	}

	@GetMapping(value = "/list2")
	public Object list2() {

		List<Demo> result = demoService.list2();
		return new HttpJsonResult<>(result);
	}

	@PostMapping(value = "/update")
	public Object update() {

		demoService.update();
		return HttpJsonResult.OK;
	}

	@GetMapping(value = "/page")
	public Object page(DemoReq req) {

		PageResult<Demo> result = demoService.page(req);
		return new HttpJsonResult<>(result);
	}
}

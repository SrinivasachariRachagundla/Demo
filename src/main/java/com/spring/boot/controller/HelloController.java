package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dao.SpringDAO;

@RestController
public class HelloController {

	@Autowired
	SpringDAO dao;

	@RequestMapping("/hello")
	public String sayHi() {
		return "hi";
	}

	@RequestMapping("/count")
	public int getcount() {
		return dao.select();
	}
}

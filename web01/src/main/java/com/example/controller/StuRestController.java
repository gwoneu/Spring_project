package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.StuDAO;
import com.example.domain.QueryVO;

import java.util.*;

@RestController //데이터가 리턴
@RequestMapping("/stu")
public class StuRestController {
	@Autowired
	StuDAO dao;
	
	@GetMapping("/list.json") //StuController에서 list랑 패스가 중복되어서 json으로 받는다.
	public List<HashMap<String, Object>> list(QueryVO vo){
		return dao.list(vo);
	}
	
	@GetMapping("/total")
	public int total(QueryVO vo) {
		return dao.total(vo);
	}
	
	@GetMapping("/read.json")
	public HashMap<String, Object> read(String scode){
		return dao.read(scode);
	}
	
	@GetMapping("/enroll.json")
	public List<HashMap<String, Object>> enroll(String scode){
		return dao.enroll(scode);
	}
}
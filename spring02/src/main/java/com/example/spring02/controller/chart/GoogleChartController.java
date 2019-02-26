package com.example.spring02.controller.chart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.member.dto.MemberDTO;
import com.example.spring02.model.shop.dto.ProductDTO;

//@RestController
@Controller
@RequestMapping("chart/*")
public class GoogleChartController {
	
	@ResponseBody
	@RequestMapping("chart1.do")
	public ModelAndView chart1() {
		return new ModelAndView("chart/chart01");
	} 
	
	@ResponseBody
	@RequestMapping("chart2.do")
	public ModelAndView chart2() {
		return null;
	}
	
	/*
	@RequestMapping("chart1.do")
	public ModelAndView chart1() {
		return new ModelAndView("chart/chart01");
	} */
	
	
	
}

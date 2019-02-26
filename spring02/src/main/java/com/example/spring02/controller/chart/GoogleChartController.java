package com.example.spring02.controller.chart;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.member.dto.MemberDTO;
import com.example.spring02.model.shop.dto.ProductDTO;
import com.example.spring02.service.chart.GoogleChartService;

//@RestController
@Controller
@RequestMapping("chart/*")
public class GoogleChartController {
	
	@Inject
	GoogleChartService googleChartService;
	
	@ResponseBody
	@RequestMapping("chart1.do")
	public ModelAndView chart1() {
		return new ModelAndView("chart/chart01");
	} 
	
	@ResponseBody
	@RequestMapping("chart2.do")
	public ModelAndView chart2() {
		return new ModelAndView("chart/chart02");
	}
	
	// view(chart2)로 넘어가지 않고 호출한 곳에 jsonobject 객체를 넘겨줌(리턴)
	@ResponseBody
	@RequestMapping("cart_money_list.do")
	public JSONObject cart_money_list() {
		return googleChartService.getChartData();
	}
	
	/*
	@RequestMapping("chart1.do")
	public ModelAndView chart1() {
		return new ModelAndView("chart/chart01");
	} */
	
	
	
}

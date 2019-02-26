package com.example.spring02.service.chart;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.example.spring02.model.shop.dto.CartDTO;
import com.example.spring02.service.shop.CartService;
 
 

@Service
public class GoogleChartServiceImpl implements GoogleChartService {
	@Inject
	CartService cartService;      
	
	@Override
	public JSONObject getChartData() {
		//ArrayList -> json 객체로 
		List<CartDTO> items = cartService.cartMoney();
		//리턴할 최종 json 객체
		JSONObject data= new JSONObject();
		//column을 정의할 json 객체
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		JSONArray title = new JSONArray();
		
		col1.put("label", "상품명");
		col1.put("type", "string");
		col2.put("label", "금액");
		col2.put("type", "number");
		//json 배열에 json 객체 추가
		title.add(col1);
		title.add(col2);
		data.put("cols", title);
		
		//row를 정의할  json 객체
		JSONArray body = new JSONArray();
		for(CartDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getProduct_name());
			JSONObject money = new JSONObject();
			money.put("v", dto.getMoney());
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(money);
			JSONObject cel1 = new JSONObject();
			cel1.put("c", row);
			body.add(cel1);
		}
		
		data.put("rows", body);
		
		return data;
	}

}

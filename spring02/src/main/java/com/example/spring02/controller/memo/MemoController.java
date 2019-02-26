package com.example.spring02.controller.memo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.memo.dto.MemoDTO;
import com.example.spring02.service.memo.MemoService;

@Controller
@RequestMapping("memo/*") //공통적인 url patter
public class MemoController {
	
	@Inject
	MemoService memoService;
	
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		List<MemoDTO> items = memoService.list();
		mav.setViewName("memo/memo_list");
		mav.addObject("list", items);
		return mav;
		
	}
	
/*	@RequestMapping("list.do")
	public ModelAndView list() { //Map test @ModelAttribute MemoDTO model
		//Map<String, Object> items = new HashMap<>();
		//items.put("list", new MemoDTO(model.getWriter(), model.getMemo()));
		List<MemoDTO> items = memoService.list();
		return new ModelAndView("memo/memo_list", "list", items);
	}*/
	
	@RequestMapping("insert.do")
	public String inssert(@ModelAttribute MemoDTO dto) {
		memoService.insert(dto);
		return "redirect:/memo/list.do";
	}
	
	// 글번호가 pathvariable로 url에 포함되어 전달됨.
	@RequestMapping("view/{idx}") 
	public ModelAndView view(@PathVariable int idx, ModelAndView mav) {
		mav.setViewName("memo/view"); 
		mav.addObject("dto", memoService.memo_view(idx));
		return mav;
	}
	
	@RequestMapping("update/{idx}")
	public String update(@PathVariable int idx, @ModelAttribute MemoDTO dto) {
		memoService.update(dto);
		return "redirect:/memo/list.do";
	}
	
	@RequestMapping("delete/{idx}")
	public String delete(@PathVariable int idx) {
		memoService.delete(idx);
		return "redirect:/memo/list.do";
	}
	
	
		
}

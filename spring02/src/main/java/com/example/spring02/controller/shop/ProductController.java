package com.example.spring02.controller.shop;

import java.io.File;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.shop.dto.ProductDTO;
import com.example.spring02.service.shop.ProductService;

@Controller
@RequestMapping("shop/product/*")
public class ProductController {
	
	@Inject
	ProductService productService;
	
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/shop/product_list");
		mav.addObject("list", productService.listProduct());
		return mav;
	}
	
	@RequestMapping("detail/{product_id}")
	public ModelAndView detail(@PathVariable int product_id, ModelAndView mav) {
		mav.setViewName("/shop/product_detail");
		mav.addObject("dto", productService.deatilProduct(product_id));
		return mav;
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "shop/product_write";
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute ProductDTO dto) {
		String filename = "-";
		if(!dto.getFile1().isEmpty()) {
			// 첨부 파일의 파일의 이름
			filename = dto.getFile1().getOriginalFilename();
			try {
				// 업로드 할 디렉토리
				//String path = "D:\\work\\spring02\\src\\main\\webapp\\WEB-INF\\views\\images\\";
				String path = "D:\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\WEB-INF\\views\\images\\";
				new File(path).mkdir();
				    
				dto.getFile1().transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		dto.setPicture_url(filename);
		productService.insertProduct(dto);
		return "redirect:/shop/product/list.do";
	}
	
	@RequestMapping("edit/{product_id}")
	public ModelAndView edit(@PathVariable("product_id") int product_id, 
							ModelAndView mav) {
		mav.setViewName("shop/product_edit");
		mav.addObject("dto", productService.deatilProduct(product_id));
		return mav;
	}
	
	@RequestMapping("update.do")
	public String update(ProductDTO dto) {
		String filename = "-";
		if(!dto.getFile1().isEmpty()) {
			//새로운 첨부 파일이 있으면
			filename = dto.getFile1().getOriginalFilename();
			try {
				// 업로드 할 디렉토리
				//String path = "D:\\work\\spring02\\src\\main\\webapp\\WEB-INF\\views\\images\\";
				String path = "D:\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\WEB-INF\\views\\images\\";
				new File(path).mkdir();
				    
				dto.getFile1().transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setPicture_url(filename);
			
		} else {
			ProductDTO dto2 = productService.deatilProduct(dto.getProduct_id());
			dto.setPicture_url(dto2.getPicture_url());
		}
		
		productService.updateProduct(dto);
		return "redirect:/shop/product/list.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(int  product_id) {
		//첨부 파일 삭제
		String filename = productService.fileInfo(product_id);
		if (filename != null && !filename.equals("-")) {
			String path = "D:\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring02\\WEB-INF\\views\\images\\";
			File f = new File(path + filename);
			if (f.exists()) { 
				f.delete();
			}
		}
		
		//레코드 삭제.
		productService.deleteProduct(product_id);
		
		// 화면 이동
		return "redirect:/shop/product/list.do";
	}
	
}

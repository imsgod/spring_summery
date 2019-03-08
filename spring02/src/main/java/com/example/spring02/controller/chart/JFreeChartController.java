package com.example.spring02.controller.chart;

import java.io.FileOutputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.service.chart.JFreeChartService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
@RequestMapping("jchart/*")
public class JFreeChartController {
	
	@Inject
	JFreeChartService jFreeChartService;
	
	@RequestMapping("jchart1.do")
	public ModelAndView CreateChart1(HttpServletResponse response, 
										HttpSession session,ModelAndView mav) {
		if (session.getAttribute("admin_userid") == null) {
			mav.setViewName("redirect:/admin/login.do"); 
		} else {
			try {
				JFreeChart chart = jFreeChartService.createChart();
				// writeChartAsPNG(출력 스트림, 차트객체, 가로,세로)
				ChartUtilities.writeChartAsPNG(response.getOutputStream(),chart, 900, 550);

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		 
		return mav;
	}
	
	@RequestMapping("jchart2.do")
	public ModelAndView createChart2 (HttpServletResponse response, 
			HttpSession session,ModelAndView mav) {
		
		if(session.getAttribute("admin_userid") == null) {
			mav.setViewName("redirect:/admin/login.do"); 
		} else {
		
			String msg = "";
			try {
				//차트 객체 리턴
				JFreeChart chart = jFreeChartService.createChart();
				// pdf 문서 객체
				Document document = new Document();
				// pdf 생성 객체
				PdfWriter.getInstance(document, new FileOutputStream("d:/work/test.pdf"));
				document.open();
				// 차트를 itextpdf lib에서 지원하는 이미 형식으로 formatting.
				Image png = Image.getInstance(ChartUtilities.encodeAsPNG(chart.createBufferedImage(500, 500)));
				// pdf 문서에 이미지를 추가
				document.add(png);
				// pdf 문서가 저장
				document.close();
				msg = "pdf 파일이 생성 되었습니다.";
			} catch (Exception e) {
				msg ="pdf 파일 생성 실패...";
				e.printStackTrace();
			}
			return new ModelAndView("jchart/jchart2","msg", msg);
		}
		 
		return mav;
	}
	
}

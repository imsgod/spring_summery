package com.example.spring02.service.chart;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.inject.Inject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Service;

import com.example.spring02.model.shop.dao.CartDAO;
import com.example.spring02.model.shop.dto.CartDTO;


@Service
public class JFreeChartServiceImpl implements JFreeChartService {
	
	@Inject
	CartDAO cartDao;
	
	@Override
	public JFreeChart createChart() {
		List<CartDTO> list = cartDao.cartMoney();
		
		//  createBarChart, createLineChart 만들시에 사용코드 파이차트와 다른 코드다.
		/* DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (CartDTO dto : list) {
			dataset.setValue(dto.getMoney(), "과일", dto.getProduct_name());
		}
		*/
		
		// pieChart
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for (CartDTO dto : list) {
			dataset.setValue(dto.getProduct_name(), dto.getMoney());
		}
		
		JFreeChart chart = null;
		String title = "장바구니 통계";
		try {
			// createBarChart(제목, "x축 라벨", "y축 라벨", 데이터 셋, 
			// 그래프방향,범례(그래프 오른쪽 상단에 표신된제목),툴팁,url);
		/*	chart = ChartFactory.createBarChart(title, "상품명", "금액", dataset,
												PlotOrientation.VERTICAL,true,true,false);*/
			
			// createLineChart
			/*chart = ChartFactory.createLineChart(title, "상품명", "금액", dataset,
						PlotOrientation.VERTICAL,true,true,false);*/
			
			//pieChart
			chart = ChartFactory.createPieChart(title, dataset,
												true,true,false);
			//java.awt.Font ; 한글이 들어가기 때문에 세부 조정한다.
			chart.getTitle().setFont(new Font("돋음",Font.BOLD,15));
			//범례
			chart.getLegend().setItemFont(new Font("돋음", Font.PLAIN, 10));
			
			Font font = new Font("돋음",Font.PLAIN,12);
			Color color = new Color(0,0,0);
			StandardChartTheme chartTheme =
					(StandardChartTheme)StandardChartTheme.createJFreeTheme();
			chartTheme.setExtraLargeFont(font);
			chartTheme.setLargeFont(font);
			chartTheme.setRegularFont(font);
			chartTheme.setSmallFont(font);
			chartTheme.setAxisLabelPaint(color);
			chartTheme.setLegendItemPaint(color);
			chartTheme.setItemLabelPaint(color);
			chartTheme.apply(chart);
			
		} catch(Exception e)  {
			e.printStackTrace();
		}
		return chart;
	}

}

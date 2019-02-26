package com.example.spring02.model.shop.dao;

import java.util.List;

import com.example.spring02.model.shop.dto.ProductDTO;

public interface ProductDAO {
	public List<ProductDTO> listProduct();
	public void insertProduct(ProductDTO dto);
	public ProductDTO detailProduct(int product_id);
	public void deleteProduct(int product_id);
	public void updateProduct(ProductDTO dto);
	public String fileInfo(int product_id);
}

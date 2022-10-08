package com.simplilearn.estore.admin.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.simplilearn.estore.admin.dao.AdminsDAO;
import com.simplilearn.estore.admin.dao.ProductsDAO;
import com.simplilearn.estore.admin.dto.ResponseDTO;
import com.simplilearn.estore.admin.model.Admins;
import com.simplilearn.estore.admin.model.Products;

@WebServlet("/products")
public class ProductCrudController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// map products dao
	ProductsDAO productDAO = new ProductsDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		// map admins object list
		List<Products> productList = new ArrayList<Products>();

		if (id != null) {
			Products product = productDAO.getOne(Long.parseLong(id));
			productList.add(product);
		} else {
			productList = productDAO.getAll();
		}
		String jsonResponse = new Gson().toJson(productList);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// create repones data
		ResponseDTO dto = new ResponseDTO();
		try {
			// map product object fields with request parameters
			Products product = new Products();
			
			product.setProductTitle(request.getParameter("productTitle"));
			product.setProductDescription(request.getParameter("productDescription"));
			product.setPrice(Integer.parseInt(request.getParameter("price")));
			product.setProductCode(request.getParameter("productCode"));
			product.setRating(Integer.parseInt(request.getParameter("rating")));
//			product.setThumnailImage(Integer.parseInt(request.getParameter("tumnailImage")));

			// create product
			productDAO.save(product);
			dto.setMessage("Product is added successfully!");
		} catch (Exception e) {
			dto.setMessage("Failed add product data");
			dto.setError(e.toString());
		}

		String jsonResponse = new Gson().toJson(dto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// create repones data
		ResponseDTO dto = new ResponseDTO();
		try {
			// map product object fields with request parameters
			Products product = new Products();
			
			product.setProductId(Integer.parseInt(request.getParameter("productId")));
			product.setProductTitle(request.getParameter("productTitle"));
			product.setProductDescription(request.getParameter("productDescription"));
			product.setPrice(Integer.parseInt(request.getParameter("price")));
			product.setProductCode(request.getParameter("productCode"));
			product.setRating(Integer.parseInt(request.getParameter("rating")));
			product.setThumnailImage(Integer.parseInt(request.getParameter("tumnailImage")));
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
			Date addedOnDate = format.parse(request.getParameter("addedOn"));
			product.setAddedOn(addedOnDate);
			// update product
			productDAO.update(product);
			dto.setMessage("Product is updated successfully!");
		} catch (Exception e) {
			dto.setMessage("Failed update product data");
			dto.setError(e.toString());
		}

		String jsonResponse = new Gson().toJson(dto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		// create repones data
		ResponseDTO dto = new ResponseDTO();

		try {
			productDAO.delete(Integer.parseInt(id));
			dto.setMessage("Product is deleted successfully!");
		} catch (Exception e) {
			dto.setMessage("Failed deletion of a product");
			dto.setError(e.toString());
		}

		String jsonResponse = new Gson().toJson(dto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
}

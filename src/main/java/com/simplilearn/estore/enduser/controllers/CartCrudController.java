package com.simplilearn.estore.enduser.controllers;

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
import com.simplilearn.estore.admin.dao.CategoriesDAO;
import com.simplilearn.estore.admin.dto.ResponseDTO;
import com.simplilearn.estore.admin.model.Categories;
import com.simplilearn.estore.enduser.dao.CartDAO;
import com.simplilearn.estore.enduser.model.Cart;

@WebServlet("/carts")
public class CartCrudController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CartDAO cartDAO =  new CartDAO();

	/**
	 * Get All OR get One Carts.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String userId = request.getParameter("userId");
		List<Cart> cartList = new ArrayList<Cart>();

		if (id != null) {
			Cart cart = cartDAO.getOne(Long.parseLong(id));
			cartList.add(cart);
		}else if (userId != null) {
			Cart cart = cartDAO.getOneByUserId(Long.parseLong(userId));
			cartList.add(cart);
		} else {
			cartList = cartDAO.getAll();
		}
		String jsonResponse = new Gson().toJson(cartList);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}

	/**
	 * Create a Cart.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// create repones data
		ResponseDTO dto = new ResponseDTO();

		try {
			Cart cart = new Cart();
			cart.setProductId(Integer.parseInt(request.getParameter("productId")));
			cart.setUserId(Integer.parseInt(request.getParameter("userId")));
			cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			cartDAO.save(cart);
			dto.setMessage("Cart is created successfully!");
		} catch (Exception e) {
			dto.setMessage("Failed create Cart data");
			dto.setError(e.toString());
		}
		
		String jsonResponse = new Gson().toJson(dto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
	
	/**
	 * Update a Cart.
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// create repones data
		ResponseDTO dto = new ResponseDTO();

		try {
			Cart cart = new Cart();
			cart.setCartId(Integer.parseInt(request.getParameter("cartId")));
			cart.setProductId(Integer.parseInt(request.getParameter("productId")));
			cart.setUserId(Integer.parseInt(request.getParameter("userId")));
			cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			cartDAO.update(cart);
			dto.setMessage("Cart is updated successfully!");
		} catch (Exception e) {
			dto.setMessage("Failed update Cart data");
			dto.setError(e.toString());
		}
		
		String jsonResponse = new Gson().toJson(dto);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}
	
	/**
	 * Delete a cart
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		// create repones data
		ResponseDTO dto = new ResponseDTO();

		try {
			cartDAO.delete(Integer.parseInt(id));
			dto.setMessage("Cart is deleted successfully!");
		} catch (Exception e) {
			dto.setMessage("Failed deletion of a cart");
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

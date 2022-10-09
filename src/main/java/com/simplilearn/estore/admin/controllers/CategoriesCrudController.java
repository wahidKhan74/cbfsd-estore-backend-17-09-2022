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
import com.simplilearn.estore.admin.dao.CategoriesDAO;
import com.simplilearn.estore.admin.dto.ResponseDTO;
import com.simplilearn.estore.admin.model.Categories;

@WebServlet("/categories")
public class CategoriesCrudController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CategoriesDAO categoriesDAO = new CategoriesDAO();

	/**
	 * Get All OR get One Categories.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		List<Categories> categoriesList = new ArrayList<Categories>();

		if (id != null) {
			Categories category = categoriesDAO.getOne(Long.parseLong(id));
			categoriesList.add(category);
		} else {
			categoriesList = categoriesDAO.getAll();
		}
		String jsonResponse = new Gson().toJson(categoriesList);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}

	/**
	 * Create a Category.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// create repones data
		ResponseDTO dto = new ResponseDTO();

		try {
			Categories category = new Categories();
			category.setCategoryName(request.getParameter("categoryName"));
			category.setCategoryDescription(request.getParameter("categoryDescription"));
			category.setActive(Integer.parseInt(request.getParameter("active")));
			category.setCategoryImageUrl(request.getParameter("catgeoryImageUrl"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date addedOnDate = format.parse(request.getParameter("addedOn"));
			category.setAddedOn(addedOnDate);
			
			categoriesDAO.save(category);
			dto.setMessage("Categrory is created successfully!");
		} catch (Exception e) {
			dto.setMessage("Failed create categrory data");
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
	 * Update a Category.
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// create repones data
		ResponseDTO dto = new ResponseDTO();

		try {
			Categories category = new Categories();
			category.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			category.setCategoryName(request.getParameter("categoryName"));
			category.setCategoryDescription(request.getParameter("categoryDescription"));
			category.setCategoryImageUrl(request.getParameter("catgeoryImageUrl"));
			category.setActive(Integer.parseInt(request.getParameter("active")));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date addedOnDate = format.parse(request.getParameter("addedOn"));
			category.setAddedOn(addedOnDate);
			
			categoriesDAO.update(category);
			dto.setMessage("Categrory is updated successfully!");
		} catch (Exception e) {
			dto.setMessage("Failed updated categrory data");
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
	 * Delete a category
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		// create repones data
		ResponseDTO dto = new ResponseDTO();

		try {
			categoriesDAO.delete(Integer.parseInt(id));
			dto.setMessage("Category is deleted successfully!");
		} catch (Exception e) {
			dto.setMessage("Failed deletion of a category");
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

package com.simplilearn.estore.admin.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.simplilearn.estore.admin.dto.ResponseDTO;
import com.simplilearn.estore.admin.model.Admins;

@WebServlet("/admins")
public class AdminCrudController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// map admin dao to call login
	AdminsDAO adminDAO = new AdminsDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		// map admins object list
		List<Admins> adminList = new ArrayList<Admins>();

		if (id != null) {
			Admins admin = adminDAO.getOne(Long.parseLong(id));
			adminList.add(admin);
		} else {
			adminList = adminDAO.getAll();
		}
		String jsonResponse = new Gson().toJson(adminList);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonResponse);
		out.flush();
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// map admin object fields with request parameters
		Admins admin = new Admins();
		admin.setAdminId(Integer.parseInt(request.getParameter("adminId")));
		admin.setEmail(request.getParameter("email"));
		admin.setPassword(request.getParameter("password"));
		admin.setAddedOn(new Date());
		admin.setLoginType(2);
		admin.setFullName(request.getParameter("fullName"));

		// create repones data
		ResponseDTO dto = new ResponseDTO();

		try {
			adminDAO.update(admin);
			dto.setMessage("Admin user is updated successfully!");
		} catch (Exception e) {
			dto.setMessage("Failed updated an admin user ");
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
		
		String id = request.getParameter("adminId");
		// create repones data
		ResponseDTO dto = new ResponseDTO();

		try {
			adminDAO.delete(Integer.parseInt(id));
			dto.setMessage("Admin user is deleted successfully!");
		} catch (Exception e) {
			dto.setMessage("Failed deletion of an admin user ");
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

package com.jsp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.BankManagerService;

@WebServlet("/del")
public class BankManagerDelete extends HttpServlet {

    BankManagerService bankManagerService = new BankManagerService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String id = req.getParameter("id");
    	
    	int idNo = Integer.parseInt(id);
    	
    	boolean result = bankManagerService.deleteBankManagerById(idNo);
    	
    	if(result == true) {
    		RequestDispatcher requestDispatcher = req.getRequestDispatcher("allManagers.jsp");
    		requestDispatcher.forward(req, resp);
    	}
    	else {
    		RequestDispatcher requestDispatcher = req.getRequestDispatcher("deleteManager.jsp");
    		requestDispatcher.include(req, resp);
    	}
    }
    
    
	}
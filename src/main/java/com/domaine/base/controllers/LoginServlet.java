package com.domaine.base.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import com.domaine.base.dto.UserAccountDto;
import com.domaine.base.services.IUserAccountService;
import com.domaine.base.services.UserAccountService;

import ch.qos.logback.classic.Logger;

@WebServlet( name = "login", value = "/login")
public class LoginServlet extends HttpServlet{
	
	private Logger logger = (Logger) LoggerFactory.getLogger(LoginServlet.class) ;
	private IUserAccountService accountService = new UserAccountService() ;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email") ;
		String password = req.getParameter("password") ;
		
		
		logger.info("----------------Email : {}   et password : {}", email, password);
		Optional<UserAccountDto> userDto = accountService.login(email, password) ;
		if ( userDto.isPresent()) {
			req.getSession().setAttribute("username", email);
			resp.sendRedirect("welcom");
		} else {
			req.setAttribute("errorMessage", "Email ou mot de passe incorrect.");
            resp.sendRedirect("login");
		}
	}
}

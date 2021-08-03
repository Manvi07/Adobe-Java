package com.adobe.prj.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.adobe.prj.dao.DaoException;
import com.adobe.prj.dao.ProductDao;
import com.adobe.prj.dao.ProductDaoJdbcImpl;
import com.adobe.prj.entity.Product;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDao productDao = new ProductDaoJdbcImpl();
		String uri = request.getRequestURI();
//		Cookie cookie = new Cookie("uri", uri);
//		response.addCookie(cookie);

		if (uri.endsWith("addProduct.do")) {
			try {
				Product p = new Product();
				p.setName(request.getParameter("name"));
				p.setPrice(Double.parseDouble(request.getParameter("price")));
				p.setCategory(request.getParameter("category"));
				productDao.addProduct(p);
				// client side redirection
				response.sendRedirect("index.html");
			} catch (DaoException e) {
				response.sendRedirect("error.jsp?msg=" + e.getMessage());
			}
		} else if (uri.endsWith("getProducts.do")) {
			try {
				List<Product> products = productDao.getProducts();
				request.setAttribute("products", products);
				// server side redirection
				request.getRequestDispatcher("print.jsp").forward(request, response);
			} catch (DaoException e) {
				response.sendRedirect("error.jsp?msg=" + e.getMessage());
			}
		} else if (uri.endsWith("login.do")) {
			// logic to check if user exists
			// if user exist then create a session
			HttpSession ses = request.getSession(); // create a session if not exist else get existing session
			ses.setAttribute("user", request.getParameter("email"));
			String uriLoc = "index.html";
			Cookie[] cookies = request.getCookies();
			for (Cookie c : cookies) {
				if (c.getName().equals("uri")) {
					uriLoc = c.getValue();
				}
			}
			response.sendRedirect(uriLoc);

		} else if (uri.endsWith("logout.do")) {
			// get session if exist
			HttpSession ses = request.getSession(false);
			if (ses != null) {
				ses.invalidate(); // terminates the session
			}
			response.sendRedirect("login.jsp");
		} else if (uri.endsWith("chat.do")) {
			ServletContext ctx = request.getServletContext();
			HttpSession ses = request.getSession();
			String user = (String) ses.getAttribute("user");

			String msg = "joined";
			if (request.getParameter("message") != null) {
				msg = request.getParameter("message");
			}
			msg = user + " : " + msg;

			List<String> msgs = (List<String>) ctx.getAttribute("messages");
			if (msgs == null) {
				msgs = new ArrayList<>();
			}
			msgs.add(msg);
			ctx.setAttribute("messages", msgs);
			response.sendRedirect("chat.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

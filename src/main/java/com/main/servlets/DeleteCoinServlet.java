package com.main.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.dao.CoinDAO;

/**
 * Servlet implementation class DeleteCoinServlet
 */
@WebServlet("/DeleteCoinServlet")
public class DeleteCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteCoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			int coinId = Integer.parseInt(request.getParameter("coinId"));
			CoinDAO coinDAO=new CoinDAO();
			if(coinDAO.deleteCoin(coinId)>0){
				
				out.println("<html><head><title>Deleting coin</title></head><body>");
				out.println("<h1 style='color:green'>Coin Deleted Successfully </h1>");
				out.println("<a href='MainPage.html'>Add Another Coin</a>");
				out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
				out.println("</body></html>");
//				response.sendRedirect("/ManageCoinCollection/DisplayAllCoins");
			}
			else {
				out.println("<html><head><title>Deleting coin</title></head><body>");
				out.println("<h1 style='color:red'>Error while Deleteing the Coin</h1>");
				out.println("<a href='MainPage.html'>BACK TO HOME</a>");
				out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
				out.println("</body></html>");
			}
		} catch (NumberFormatException e) {
			out.println("<html><head><title>Displaying coin</title></head><body>");
			out.println("<h1 style='color:red'>Error while Deleteing the Coin</h1>");
			out.println("<a href='MainPage.html'>BACK TO HOME</a>");
			out.println("<p> ERROR:"+ e.getMessage()+"</p>");
			out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
			out.println("</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

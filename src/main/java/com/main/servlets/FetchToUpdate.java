package com.main.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.dao.CoinDAO;
import com.main.model.Coin;

/**
 * Servlet implementation class FetchToUpdate
 */
@WebServlet("/FetchToUpdate")
public class FetchToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchToUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			int coinId = Integer.parseInt(request.getParameter("coinId"));
			CoinDAO coinDAO=new CoinDAO();
			Coin coinToUpdate=coinDAO.getById(coinId);
			
			out.println("<html><head><title>FetchToUpdate coin</title></head><body>");
			out.println("<h2 style='color:blue'>Update Coin Details </h2>");
			if(coinToUpdate!=null){
				out.println("<form action='UpdateCoinServlet' method='post'>");
				out.println("<table>");
				out.println("<tr>");
				out.println("<td><lable>Coin ID </lable></td>");
				out.println("<td><input type='hidden' name='id' value="+coinToUpdate.getCoinId()+"></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><lable>Country</lable></td>");
				out.println("<td><input type='text' name='country' value="+coinToUpdate.getCountry()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><lable>Denomination</lable></td>");
				out.println("<td><input type='text' name='denomination' value="+coinToUpdate.getDenomination()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><lable>Year Of Minting </lable></td>");
				out.println("<td><input type='number' name='yearOfMinting' value="+coinToUpdate.getYearOfMinting()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><lable>Current Value</lable></td>");
				out.println("<td><input type='text' name='currentValue' value="+coinToUpdate.getCurrentValue()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><lable>Acquired Date </lable></td>");
				out.println("<td><input type='date' name='acquiredDate' value="+coinToUpdate.getAcquriedDate()+" required></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td><input type='submit' value='Update Coin'></td>");
				out.println("<td><a href='MainPage.html'>Back To Home</a></td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</form>");
				
			}else {
				out.println("<h1 style='color:red'>Error while Fetching To Update a Coin</h1>");
				
			}
		} catch (NumberFormatException e) {
			out.println("<h1 style='color:red'>Error while Fetching To Update a Coin</h1>");
			out.println("<p> ERROR:"+ e.getMessage()+"</p>");
			
		}
		out.println("<a href='MainPage.html'>BACK TO HOME</a>");
		out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

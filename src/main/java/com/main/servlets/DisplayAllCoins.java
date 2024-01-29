package com.main.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.dao.CoinDAO;
import com.main.model.Coin;

/**
 * Servlet implementation class DisplayAllCoins
 */
@WebServlet("/DisplayAllCoins")
public class DisplayAllCoins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllCoins() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			//retrieve all coins
			CoinDAO coinDAO=new CoinDAO();
			List<Coin> allCoin=coinDAO.getAllCoins();
			
			//HTML response
			out.println("<html><head><title>Display Coins</title></head><body>");
			out.println("<h1>All Coins Collection Data</h1>");
			out.println("<table border='1'>");
			out.println("<thead><tr><th> COIN ID </th><th> COUNTRY </th><th> DENOMINATION </th><th> YEAR OF MINTING </th><th> CURRENT VALUE </th><th> ACQUIRED DATE </th><th> UPDATE </th><th> REMOVE </th></tr>");
			
			for(Coin coin : allCoin) {
				out.println("<tr>");
				out.println("<td>"+ coin.getCoinId()+"</td>");
				out.println("<td>"+ coin.getCountry()+"</td>");
				out.println("<td>"+ coin.getDenomination()+"</td>");
				out.println("<td>"+ coin.getYearOfMinting()+"</td>");
				out.println("<td>"+ coin.getCurrentValue()+"</td>");
				out.println("<td>"+ coin.getAcquriedDate()+"</td>");
				out.println("<td><a href='FetchToUpdate?coinId="+coin.getCoinId()+"'>EDIT</a></td>");
				out.println("<td><a href='DeleteCoinServlet?coinId="+coin.getCoinId()+"'>DELETE</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<br><br>");
			out.println("<a href='MainPage.html'>BACK TO HOME</a>");
			out.println("</body></html>");
			
		} catch (Exception e) {
			out.println("<html><head><title>Displaying coin</title></head><body>");
			out.println("<h1 style='color:red'>Error while Retrieving the Coins list</h1>");
			out.println("<a href='MainPage.html'>BACK TO HOME</a>");
			out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
			out.println("<p> ERROR:"+ e.getMessage()+"</p>");
			out.println("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

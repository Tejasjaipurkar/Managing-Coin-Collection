package com.main.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.main.constant.GenericConstants;
import com.main.dao.CoinDAO;
import com.main.model.Coin;

/**
 * Servlet implementation class UpdateCoinServlet
 */
@WebServlet("/UpdateCoinServlet")
public class UpdateCoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateCoinServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter(); 
		try {
			//response html type
			response.setContentType("text/html");
			//IO stream create
			
			int id=Integer.parseInt(request.getParameter("id"));
			String country=request.getParameter("country");
			String denomination=request.getParameter("denomination");
			int yearOfMinting=Integer.parseInt(request.getParameter("yearOfMinting")) ;
			@SuppressWarnings("removal")
			Double currentvalue= new Double(request.getParameter("currentValue"));
			Date acquiredDate=new Date(); 
				acquiredDate=new SimpleDateFormat(GenericConstants.requiredDateFormate).parse(request.getParameter("acquiredDate"));
			Coin coin=new Coin(id,country, denomination, yearOfMinting, currentvalue, acquiredDate); 
			CoinDAO coinDAO =new CoinDAO();
			if(coinDAO.updateCoin(coin)>0) {
				
				 //success
				out.println("<html><head><title>Updating coin</title></head><body>");
				out.println("<h1 style='color:green'>Coin updated Successfully </h1>");
//				out.println("<p> Coin ID :"+ coin.getCoinId()+"</p>");
				out.println("<p> Coin Country :"+ coin.getCountry()+"</p>");
				out.println("<p> Coin Denomination :"+ coin.getDenomination()+"</p>");
				out.println("<p> Year Of Minting :"+ coin.getYearOfMinting()+"</p>");
				out.println("<p> Coin Current Value :"+ coin.getCurrentValue()+"</p>");
				out.println("<p> Coin Acquired Date :"+ coin.getAcquriedDate()+"</p>");
				out.println("<a href='MainPage.html'>BACK TO HOME</a>");
				out.println("<a href='/ManageCoinCollection/DisplayAllCoins'>See Coin Collection</a>");
				out.println("</body></html>");
			} else {
				//failed
				out.println("<html><head><title>Updating coin</title></head><body>");
				out.println("<h1 style='color:red'>Coin NOT Updated Successfully </h1>");
				out.println("<a href='MainPage.html'>BACK TO HOME</a>");
				out.println("</body></html>");
			}
		} catch (ParseException | NumberFormatException e) {
			
			e.printStackTrace();
			out.println("<html><head><title>Updating coin</title></head><body>");
			out.println("<h1 style='color:red'>Error while Updating Coin</h1>");
			out.println("<a href='MainPage.html'>BACK TO HOME</a>");
			out.println("<p> ERROR :"+ e.getMessage()+"</p>");
			out.println("</body></html>");
		}
	}

}

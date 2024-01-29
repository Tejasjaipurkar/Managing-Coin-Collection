package com.main.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.model.Coin;
import com.main.utils.ConnectionUtils;

public class CoinDAO {
	
	//get all coins 
	public List<Coin> getAllCoins(){
		
		List<Coin> coins=new ArrayList<>();
		
		try(Connection connection=ConnectionUtils.getConnection()) {
			
			String selectQuery="select * from coin_collection";
			PreparedStatement statement=connection.prepareStatement(selectQuery);
			ResultSet resultSet = statement.executeQuery(selectQuery);
			while(resultSet.next()) {
				Coin coin = new Coin(
						resultSet.getInt("id"),
						resultSet.getNString("country"),
						resultSet.getNString("denomination"),
						resultSet.getInt("year_of_minting"),
						resultSet.getDouble("current_value"),
						resultSet.getDate("acquired_date"));
				 
				coins.add(coin);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return coins; 
	}
	
	//get by id
	public Coin getById(int coinId){
			
		Coin coin=new Coin();
			try(Connection connection=ConnectionUtils.getConnection()) {
	
				String selectQuery="select * from coin_collection where id=?";
				PreparedStatement preparedStatement=connection.prepareStatement(selectQuery);
				preparedStatement.setInt(1, coinId);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					coin.setCoinId(resultSet.getInt("id"));
					coin.setCountry(resultSet.getNString("country"));
					coin.setDenomination(resultSet.getNString("denomination"));
					coin.setYearOfMinting(resultSet.getInt("year_of_minting"));
					coin.setCurrentValue(resultSet.getDouble("current_value"));
					coin.setAcquriedDate(resultSet.getDate("acquired_date"));				 	
				}
				
		 	} catch (SQLException e) {
				e.printStackTrace();
				coin=null;
			}
			return coin; 
	}
	
	//add coin in the database
	public int  addCoin(Coin coin) {
		
		try (Connection connection=ConnectionUtils.getConnection()){
			
			String insertQuery="insert into coin_collection (country,denomination,year_of_minting,current_value,acquired_date)  values (?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
				preparedStatement.setString(1, coin.getCountry());
				preparedStatement.setString(2, coin.getDenomination());
				preparedStatement.setInt(3, coin.getYearOfMinting());
				preparedStatement.setDouble(4, coin.getCurrentValue());
				preparedStatement.setDate(5, new Date(coin.getAcquriedDate().getTime()));
				
				return preparedStatement.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	//update
	public int updateCoin(Coin coin) {
		int updatedRows=0;
		try (Connection connection=ConnectionUtils.getConnection()){
			
			String insertQuery="update coin_collection set country=?,denomination=?,year_of_minting=?,current_value=?,acquired_date=? where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
				preparedStatement.setString(1, coin.getCountry());
				preparedStatement.setString(2, coin.getDenomination());
				preparedStatement.setInt(3, coin.getYearOfMinting());
				preparedStatement.setDouble(4, coin.getCurrentValue());
				preparedStatement.setDate(5, new Date(coin.getAcquriedDate().getTime()));
				preparedStatement.setInt(6, coin.getCoinId());
				updatedRows=preparedStatement.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

		return updatedRows;
	}
	
	public int deleteCoin(int coinId) {
		int updatedRows=0;
		try (Connection connection=ConnectionUtils.getConnection()){
			
			String insertQuery="delete from coin_collection where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
				
				preparedStatement.setInt(1, coinId);
				updatedRows=preparedStatement.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

		return updatedRows;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

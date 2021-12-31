package com.askme.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.askme.model.Category;
import com.controller.CategoryName;



public class CategoryDao {
	public void insertCategory(Category category) {
		//Query-insert User
		String insertQuery ="insert into category_detail(category_name) values(?)";
	   //DB connection 
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst = null;
		//Get all values
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1,category.getCategoryName());
			pst.executeUpdate();
			System.out.println("Category inserted");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted ");
		}
		
	}
	//Update user-password
	public void update(String categoryName,int id){
		String updateQuery="update category_detail set category_name=?  where category_id=?";
		//get connection
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("Connection successfully");		
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, categoryName);
			pstmt.setInt(2, id);		
			int i=pstmt.executeUpdate();
			System.out.println(i+"row updated");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//Delete user details
	public void deletedetails(String delete) {
		String deleteQuery="delete from category_detail where category_name=?";
		//get connection
		Connection con=ConnectionUtil.getDbConnection();
		System.out.println("Connection successfully");
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setString(1, delete);
			int i=pstmt.executeUpdate();
			System.out.println("Your selected Category deleted");
			pstmt.close();
			con.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
     
	//Find User
	public static int findCategoryId(String categoryName)
	{
		String findUserId="select category_id from category_detail where category_name='"+categoryName+"'";
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		int categoryId=0;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(findUserId);
			if(rs.next())
			{
			categoryId=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryId;
		
	}
	//List of User
	public static List<Category> showAllCategory()
	{
		List<Category> categoryList=new ArrayList<Category>();
		
		String selectQuery="select * from category_detail";
		
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				categoryList.add(new Category(rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return categoryList;
	}
	
	
	
	
	 
	
		 

}

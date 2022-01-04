package com.askme.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.askme.model.Comment;
import com.askme.util.ConnectionUtil;



public class CommentDAOImpl {
	public static void insertComment(Comment comment) {
		//Query-insert User
		String insertQuery ="insert into comment_by_user(user_id,category_id,section_id,comments) values(?,?,?,?)";
	   //DB connection 
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst = null;
		//Get all values
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setInt(1, comment.getUserId());
			pst.setInt(2, comment.getCategoryId());
			pst.setInt(3, comment.getSectionId());	
			pst.setString(4, comment.getComments());	
			pst.executeUpdate();
			System.out.println("Your comments received successfully!!\t Reply Shortly");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Fill it");
		}
	}
	//List of User
		public  ResultSet showAllComment()
		{			
			String selectQuery="select * from comment_by_user";
			
			ConnectionUtil conUtil = new ConnectionUtil();
			Connection con = conUtil.getDbConnection();
			ResultSet rs=null;
			Statement stmt;
			try {
				stmt = con.createStatement();
				 rs=stmt.executeQuery(selectQuery);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			return rs;
		}
		
}

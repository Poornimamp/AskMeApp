package com.askme.impl;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.askme.dao.AskmeDAOInterface;
import com.askme.model.AskMe;
import com.askme.util.ConnectionUtil;



public class AskmeDAOImpl implements AskmeDAOInterface {
	
	
		public  void askmequestions(AskMe askMe) {
			String insertQuery ="insert into ask_me_questions(user_id,category_id,section_id,question_id) values(?,?,?,?)";
			   //DB connection 
				ConnectionUtil conUtil = new ConnectionUtil();
				Connection con = conUtil.getDbConnection();
				PreparedStatement pst = null;
				//Get all values
				try {
					pst = con.prepareStatement(insertQuery);				
					pst.setInt(1,askMe.getUserId());	
					pst.setInt(2, askMe.getCategoryId());
					pst.setInt(3, askMe.getSectionId());
					pst.setInt(4, askMe.getQuestionId());
					pst.executeUpdate();
					System.out.println("Thank you for your intention to ask a question. However, you have asked any question. Please ask and we will be happy to support you.");
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Value not inserted ");
				}
				
			}
		public void deletedetails(int userId) {
			String deleteQuery="delete from ask_me_questions where user_id=?";
			//get connection
			Connection con=ConnectionUtil.getDbConnection();
			System.out.println("Connection successfully");
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(deleteQuery);
				pstmt.setInt(1, userId);
				int i=pstmt.executeUpdate();
				System.out.println("Deleted successfully");
				pstmt.close();
				con.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public  List<AskMe> showAllAskme()
		{
			List<AskMe> askMeList=new ArrayList<AskMe>();
			
			String selectQuery="select * from ask_me_questions";
			
			ConnectionUtil conUtil = new ConnectionUtil();
			Connection con = conUtil.getDbConnection();
			Statement stmt;
			try {
				stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery(selectQuery);
				while(rs.next())
				{
					askMeList.add(new AskMe(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			return askMeList;
		}
		
		
		
}
	


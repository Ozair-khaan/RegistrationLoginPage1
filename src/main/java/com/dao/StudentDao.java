package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.bean.student;
import com.connection.DbConnection;

public class StudentDao {

	public int insert(student st) {
		int insert = 0;
		try {
			Connection con = null;
			con = DbConnection.get_connection();
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, st.getFirstname());
			ps.setString(2, st.getMiddlename());
			ps.setString(3, st.getLastname());
			ps.setString(4, st.getMobileno());
			ps.setString(5, st.getEmail());
			ps.setString(6, st.getAddress());
			ps.setString(7, st.getUsername());
			ps.setString(8, st.getPassword());
			ps.setString(9, st.getRetypepsw());

			insert = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return insert;

	}

	public boolean validateStudent(student st) {
		// TODO Auto-generated method stub
         boolean isTrue=false;
		int insert = 0;
		try {
			Connection con = null;
			con = DbConnection.get_connection();
			PreparedStatement ps = con.prepareStatement("select * from student where user_name=? and password=?");
			ps.setString(1, st.getUsername());
			ps.setString(2, st.getPassword());

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				
				isTrue=true;

			}
      

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isTrue;
	}
	
	public student getValues(student  st) {
		student st2 = new student();
		
		try {
			Connection con = null;
			con = DbConnection.get_connection();
			PreparedStatement ps = con.prepareStatement("select * from student where user_name=? and password=?");
			ps.setString(1, st.getUsername());
			ps.setString(2, st.getPassword());

			ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()) {
			st2.setFirstname(rs.getString("first_name"));
			st2.setMiddlename(rs.getString("middle_name"));
			st2.setLastname(rs.getString("last_name"));
			st2.setMobileno(rs.getString("mobile_no"));
			st2.setEmail(rs.getString("email"));
			st2.setAddress(rs.getString("address"));
			st2.setUsername(rs.getString("user_name"));
			st2.setPassword(rs.getString("password"));
			st2.setRetypepsw(rs.getString("Re_type_password"));
		
			
			
		}
		}
	
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return st2;
		
	}

}

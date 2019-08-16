package com.org.model;

import java.sql.PreparedStatement;
import java.sql.*;
import com.sun.jdi.connect.spi.Connection;

public class RegistrationDao {
	public String registerUser(Registration register) {
		String firstname = register.getFirstname();
		String lastname = register.getLastname();
		String email = register.getEmail();
		String password = register.getPassword();
		String address1 = register.getAddress();
		String address2 = register.getAddress2();
		String state = register.getState();
		String city = register.getCity();
		String zip = register.getZip();
		java.sql.Connection con=null;
		PreparedStatement prepared=null;
		try {
			con=DBconnection.createConnection();
			String query="insert into user (firstname,lastname,email,password,address,address1,city,state,zip )  values(?,?,?,?,?,?,?,?,?)";
			prepared=con.prepareStatement(query);
			prepared.setString(1, firstname);
			prepared.setString(2, lastname);
			prepared.setString(3, email);
			prepared.setString(4, password);
			prepared.setString(5, address1);
			prepared.setString(6, address2);
			prepared.setString(7, state);
			prepared.setString(8, city);
			prepared.setString(9, zip);
			int i=prepared.executeUpdate();
			if(i!=0)
			{
				return "success";
			}

		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return "oppss some thing wrong";

	}
}

package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chainsys.modal.Login;

public class LoginDAO {
	public boolean validator(Login login) throws SQLException {
		boolean result = false;
		Connection connection = ConnectionUtil.getConnection();
		String sql = "select email,password from student_login where name=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, login.getEmail());
		preparedStatement.setString(2, login.getPassword());
		ResultSet resultSet = preparedStatement.executeQuery();
		result = resultSet.next();
		System.out.println(result);
		return result;
	}
}

package com.clinica.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sqlite {

	public static Connection connect() {

		String url = "jdbc:sqlite:F:\\xampp\\htdocs\\CLS_puente_PHP\\test.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static Boolean existeDocumento(int idDocumento) {
		String sql = "SELECT count(*) as cantidad FROM file_ where NAME=" + idDocumento + "";
		Boolean existe = false;
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			if (rs.getInt("cantidad") > 0) {
				existe = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return existe;
	}

	public void insert(String name, double capacity) {
		String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setDouble(2, capacity);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}

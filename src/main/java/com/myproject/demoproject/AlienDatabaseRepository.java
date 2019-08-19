package com.myproject.demoproject;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class AlienDatabaseRepository {

	Connection con = null;

	public AlienDatabaseRepository() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://192.168.43.132:3306/restdb", "aman", "aman@123");

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Aliens> getAliens() {
		List<Aliens> aliens = new ArrayList<>();
		String query = "Select * from alien";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Aliens a = new Aliens();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));

				aliens.add(a);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return aliens;
	}

	public Aliens getAlien(int id) {

		Aliens a = new Aliens();

		String query = "Select * from alien where id = " + id;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {

				a.setId(rs.getInt("id"));
				a.setName(rs.getString("name"));
				a.setPoints(rs.getInt("points"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;

	}

	public void create(Aliens a1) {

		String query = "insert into alien values (?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, a1.getId());
			stmt.setString(2, a1.getName());
			stmt.setInt(3, a1.getPoints());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(Aliens a1) {

		String query = "Update alien set name = ? , points = ? where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, a1.getName());
			stmt.setInt(2, a1.getPoints());
			stmt.setInt(3, a1.getId());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(int id) {

		String query = "Delete from alien where id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setInt(1, id);

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

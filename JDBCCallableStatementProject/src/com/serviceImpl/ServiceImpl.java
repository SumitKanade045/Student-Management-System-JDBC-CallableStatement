package com.serviceImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.serviceI.Requirement;

public class ServiceImpl implements Requirement {

	Scanner sc = new Scanner(System.in);

	@Override
	public void createTable() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/callablestatement", "root",
					"root");

			String query = "call createtableandsdesctable()";

			CallableStatement cs = con.prepareCall(query);

			System.out.println("Table created successfully ");
			System.out.println("-----------------------------");

			ResultSet set = cs.executeQuery();

			while (set.next()) {

				System.out.println("Field   : " + set.getString("Field"));
				System.out.println("Type    : " + set.getString("Type"));
				System.out.println("Null    : " + set.getString("Null"));
				System.out.println("Key     : " + set.getString("Key"));
				System.out.println("Default : " + set.getString("Default"));
				System.out.println("Extra   : " + set.getString("Extra"));

				System.out.println("-----------------------------");

			}

			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void insertData() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/callablestatement", "root",
					"root");

			String query = "call insetandselect(?,?,?,?)";

			CallableStatement cs = con.prepareCall(query);

			System.out.println("Enter Roll Number:");
			cs.setInt(1, sc.nextInt());

			System.out.println("Enter Name: ");
			cs.setString(2, sc.next());

			System.out.println("Enter City: ");
			cs.setString(3, sc.next());

			System.out.println("Enter Email Id: ");
			cs.setString(4, sc.next());

			ResultSet set = cs.executeQuery();

			System.out.println("Check Your Details !\n");
			while (set.next()) {

				System.out.println("RollNumber :" + set.getInt(1));
				System.out.println("Name       :" + set.getString(2));
				System.out.println("City       :" + set.getString(3));
				System.out.println("Email Id   :" + set.getString(4));

				System.out.println("---------------------");

			}

			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void updateData() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/callablestatement", "root",
					"root");

			String query = "call upadteshow(?, ?)";

			CallableStatement cs = con.prepareCall(query);

			System.out.println("Enter Name: ");
			cs.setString(1, sc.next());

			System.out.println("Enter Roll Number to make changes: ");
			cs.setInt(2, sc.nextInt());

			ResultSet set = cs.executeQuery();

			System.out.println("Updated Name: \n");
			while (set.next()) {

				System.out.println("Roll Number :" + set.getInt(2));
				System.out.println("Name        :" + set.getString(1));
				System.out.println("\n----------------------------------------\n");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Override
	public void getAllData() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/callablestatement", "root",
					"root");

			String query = "call getalldatanadshowtables()";

			CallableStatement cs = con.prepareCall(query);

			boolean result = cs.execute();

			if (result) {

				ResultSet set = cs.getResultSet();

				System.out.println("---------- TABLES ----------");

				while (set.next()) {

					System.out.println(set.getString(1));
				}
			}

			if (cs.getMoreResults()) {

				ResultSet set = cs.getResultSet();

				System.out.println("\n---------- STUDENT DATA ----------");

				while (set.next()) {

					System.out.println("RollNumber :" + set.getInt(1));
					System.out.println("Name       :" + set.getString(2));
					System.out.println("City       :" + set.getString(3));
					System.out.println("Email Id   :" + set.getString(4));
					System.out.println("\n--------------------------------\n");
				}
			}

			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteData() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/callablestatement", "root",
					"root");

			String query = "call deleteandshowrollno(?)";

			CallableStatement cs = con.prepareCall(query);

			System.out.println("Enter Roll Number to delete Records:");
			cs.setInt(1, sc.nextInt());

			ResultSet set = cs.executeQuery();

			while (set.next()) {

				System.out.println("Roll Number: " + set.getInt(1));

			}

			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void deleteTable() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/callablestatement", "root",
					"root");

			String query = "Drop table student";

			Statement s = con.createStatement();

			s.execute(query);

			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}

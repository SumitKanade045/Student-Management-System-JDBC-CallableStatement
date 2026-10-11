package com.client;

import com.serviceI.Requirement;
import com.serviceImpl.*;
import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Requirement r = new ServiceImpl();

		while (true) {

			System.out.println("1.Create Table." + "\n2.Insert Data." + "\n3.Update Data." + "\n4.View Data."
					+ "\n5.Delete Data." + "\n6.Delete Table.\n");

			System.out.println("Enter Your Choise:");
			int n = sc.nextInt();
			System.out.println();

			switch (n) {

			case 1:

				r.createTable();
				break;

			case 2:

				r.insertData();
				break;

			case 3:

				r.updateData();
				break;

			case 4:

				r.getAllData();
				break;

			case 5:

				r.deleteData();
				break;

			case 6:

				r.deleteTable();
				break;

			default:

				System.out.println("Enter Valid Choise !");

				sc.close();
			}
		}
	}
}

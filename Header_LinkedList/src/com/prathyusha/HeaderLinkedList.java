package com.prathyusha;

import java.util.Scanner;

public class HeaderLinkedList {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of linkedList */
		LinkedList list = new LinkedList();

		while (true) {
			System.out.println("\nCircular Singly Linked List Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. Delete");
			System.out.println("3. Exit");

			System.out.println("\n Enter your choice");
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				list.insert(scan.nextInt());
				break;
			case 2:
				System.out.println("After Deleting the element");
				list.delete();
				break;
			case 3:
				System.out.println("Exiting....");
				System.exit(0);
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			list.display();
		}
		

	}


}

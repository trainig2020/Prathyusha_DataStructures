package com.prathyusha;

import java.util.NoSuchElementException;
import java.util.Scanner;


class LinkedQueue{
protected Node front, rear;
public int size;

/* Constructor */
public LinkedQueue()
{
    front = null;
    rear = null;
    size = 0;
}    
/*  Function to check if queue is empty */
public boolean isEmpty()
{
    return front == null;
}    
/*  Function to get the size of the queue */
public int getSize()
{
    return size;
}    
/*  Function to insert an element to the queue */
public void insert(int data)
{
    Node nptr = new Node(data, null);
    if (rear == null)
    {
        front = nptr;
        rear = nptr;
        nptr.next=front;
    }
    else
    {
        rear.setNext(nptr);
        rear = rear.getNext();
        rear.next=front;
    }
    size++ ;
}    
/*  Function to remove front element from the queue */
public int remove()
{
    if (isEmpty() )
        throw new NoSuchElementException("Underflow Exception");
    Node ptr = front;
    front = ptr.getNext(); 
    rear.next=front;
    System.out.println("Current front Value is : "+front.data);
    if (front == null)
        rear = null;
    size-- ;       
    
    return ptr.getData();
}    
/*  Function to check the front element of the queue */
public int peek()
{
    if (isEmpty() )
        throw new NoSuchElementException("Underflow Exception");
    return front.getData();
}    
/*  Function to display the status of the queue */
public void display()
{
	Node ptr = front;
    System.out.print("\nQueue = ");
    if (size == 0)
    {
        System.out.print("Empty\n");
        return ;
    }
    
    
    if (front.getNext() == front) 
    {
        System.out.println(front.getData()+ "->"+ptr.getData()+ "\n" );
        return;
    }
    
    System.out.print(front.getData()+ " -> ");
    ptr = front.getNext();
    while (ptr.getNext() != front)
    {
        System.out.print(ptr.getData()+ " -> ");
        ptr = ptr.getNext();
    }
    System.out.print(ptr.getData()+ " -> ");
    ptr = ptr.getNext();
    System.out.print(ptr.getData()+ "\n");     
}
}

public class QueueCircularLinkedList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/* Creating object of class linkedQueue */
		LinkedQueue lq = new LinkedQueue();
		/* Perform Queue Operations */
		System.out.println("Linked Queue Test\n");

		while (true) {
			System.out.println("\nQueue Operations");
			System.out.println("1. insert");
			System.out.println("2. remove");
			System.out.println("3. peek");
			System.out.println("4. check empty");
			System.out.println("5. size");
			System.out.println("6. Exit");

			System.out.println("\n Enter your choice : ");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter integer element to insert");
				lq.insert(scan.nextInt());
				break;
			case 2:
				try {
					System.out.println("Removed Element = " + lq.remove());
				} catch (Exception e) {
					System.out.println("Error : " + e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println("Peek Element = " + lq.peek());
				} catch (Exception e) {
					System.out.println("Error : " + e.getMessage());
				}
				break;
			case 4:
				System.out.println("Empty status = " + lq.isEmpty());
				break;

			case 5:
				System.out.println("Size = " + lq.getSize());
				break;

			case 6:
				System.out.println("Exiting....");
				System.exit(0);
			default:
				System.out.println("Wrong Entry \n ");
				break;
			}
			/* display queue */
			lq.display();

		}
	}
}
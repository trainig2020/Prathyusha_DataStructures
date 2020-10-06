package com.prathyusha;

import java.util.Scanner;

public class DoubleLinkedList {
	
	protected Node start;
    protected Node end ;
    public int size;
    
    public class Node {
    	
    	protected int data;
    	protected Node next;
    	protected Node prev;
    	
    	
    	
    	public Node(int data, Node next, Node prev) {
    		super();
    		this.data = data;
    		this.next = next;
    		this.prev = prev;
    	}


    	public int getData() {
    		return data;
    	}
    	public void setData(int data) {
    		this.data = data;
    	}
    	public Node getNext() {
    		return next;
    	}
    	public void setNext(Node next) {
    		this.next = next;
    	}
    	public Node getPrev() {
    		return prev;
    	}
    	public void setPrev(Node prev) {
    		this.prev = prev;
    	}
    }
    /* Constructor */
    public DoubleLinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /* Function to check if list is empty */
    public boolean isEmpty()
    {
        return start == null;
    }
    /* Function to get size of list */
    public int getSize()
    {
        return size;
    }
    /* Function to insert element at begining */
    public void insertAtStart(int val)
    {
        Node nptr = new Node(val, null, null);        
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            start.setPrev(nptr);
            nptr.setNext(start);
            start = nptr;
        }
        size++;
    }
    /* Function to insert element at end */
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val, null, null);        
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            nptr.setPrev(end);
            end.setNext(nptr);
            end = nptr;
        }
        size++;
    }
    /* Function to insert element at position */
    public void insertAtPos(int val , int pos)
    {
        Node nptr = new Node(val, null, null);    
        if (pos == 1)
        {
            insertAtStart(val);
            return;
        }            
        Node ptr = start;
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node tmp = ptr.getNext();
                ptr.setNext(nptr);
                nptr.setPrev(ptr);
                nptr.setNext(tmp);
                tmp.setPrev(nptr);
            }
            ptr = ptr.getNext();            
        }
        size++ ;
    }
    /* Function to delete node at position */
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            if (size == 1)
            {
                start = null;
                end = null;
                size = 0;
                return; 
            }
            start = start.getNext();
            start.setPrev(null);
            size--; 
            return ;
        }
        if (pos == size)
        {
            end = end.getPrev();
            end.setNext(null);
            size-- ;
        }
        Node ptr = start.getNext();
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node p = ptr.getPrev();
                Node n = ptr.getNext();
 
                p.setNext(n);
                n.setPrev(p);
                size-- ;
                return;
            }
            ptr = ptr.getNext();
        }        
    } 
    
    public void updateNode(int data) {
		Node current = start;

		while (current != null) {
			if (current.data == data) {
				System.out.println("Enter the new element  : ");
				Scanner sc = new Scanner(System.in);
				int updatedElement = sc.nextInt();
				current.data = updatedElement;

			}

			current = current.next;

		}

	}
    
    //Reverse the list
    public void reverse() { 
        Node temp = null; 
        Node current = start; 
  
        /* swap next and prev for all nodes of  
         doubly linked list */
        while (current != null) { 
            temp = current.prev; 
            current.prev = current.next; 
            current.next = temp; 
            current = current.prev; 
        } 
  
        /* Before changing head, check for the cases like empty  
         list and list with only one node */
        if (temp != null) { 
            start = temp.prev; 
        } 
    } 
    /* Function to display status of list */
    public void display()
    {
        System.out.print("\nDoubly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getNext() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ " -> ");
        ptr = start.getNext();
        while (ptr.getNext() != null)
        {
            System.out.print(ptr.getData()+ " -> ");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData()+ "\n");
    }

}


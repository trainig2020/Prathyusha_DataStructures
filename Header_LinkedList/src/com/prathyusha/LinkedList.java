package com.prathyusha;

public class LinkedList {
	
	public Node header ;
	 public int size =0 ;
	protected Node end;

	public void insert(int data) {
		Node nptr = new Node(data, null);
		if (header == null) {
			header = new Node();
			header.next = nptr;
			//end = header;
		} else {
			Node node = header;
			while (node.next != null) {
				node = node.next;
			}
			node.next = nptr;
			//end = header;
		}
		size++;
		header.setData(size);
	}
	
	public void delete() {
		
		Node t= header.getNext();
		Node s=header.getNext();
		while(s.getNext()!=null) {
			t=s;
			s=s.getNext();
			
		} 
		t.setNext(null);
		
		 size--;
		 header.setData(size);
		}
	

	public void display() {

		System.out.print("\n Header Circular Singly Linked List = ");
		Node ptr = header;
		ptr = header.getNext();
		
		
		while (ptr != null) {
			System.out.print(ptr.getData() + " ");
			ptr = ptr.getNext();
		}
		System.out.println("\n Count is : "+header.getData());
       System.out.print( "\n");
	}



}

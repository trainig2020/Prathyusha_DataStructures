package com.prathyusha;

public class FindAndRemoveLoop {
	
	class ListNode {
		  int data;
		  ListNode next;

		  ListNode(int x) {
		    data = x;
		    next = null;
		  }
		}
	
	public void removeLoop(ListNode head) {
	    
	    ListNode ptr1 = head;
	    ListNode ptr2 = head;
	    
	    boolean flag = false;
	    // Traverse the list until ptr2 or ptr2.next becomes null.
	    while (ptr2 != null && ptr2.next != null) {
	      // Move forward ptr1 by one node.
	      ptr1 = ptr1.next;
	      // Move forward ptr2 by two nodes.
	      ptr2 = ptr2.next.next;
	      // Check if ptr1 and ptr2 meet at some node, then there is a loop in the Linked
	      
	      if (ptr1 == ptr2) {
	        flag = true;
	        break;
	      }
	    }
	    // When there is a loop in the Linked List.
	    if (flag) {
	      // Assign head to ptr1.
	      ptr1 = head;
	      // Loop until next of ptr1 and ptr2 are not equal.
	      while (ptr1.next != ptr2.next) {
	        ptr1 = ptr1.next;
	        ptr2 = ptr2.next;
	      }
	      // Make next of ptr2 that is last node of Linked List NULL.
	      ptr2.next = null;
	    }

	  }

	
	public static void main(String[] args) {
		 FindAndRemoveLoop loop = new FindAndRemoveLoop();
		 
		 
		ListNode head = loop.new ListNode(1);
		
	    ListNode l1 = loop.new ListNode(2);
	    head.next = l1;
	    
	    ListNode l2 = loop.new ListNode(3);   
	    l1.next = l2;
	    
	    ListNode l3 = loop.new ListNode(4);
	    l2.next = l3;
	    
	    ListNode l4 = loop.new ListNode(5);
	    l3.next = l4;
	    
	    l4.next = l2;

	   
	    
	    loop.removeLoop(head);
	    System.out.println("Linked List after removing loop: ");
	    while (head != null) {
	      System.out.print(head.data + " ");
	      head = head.next;
	    }
	    System.out.println("NULL");
       
        

	}

 
}


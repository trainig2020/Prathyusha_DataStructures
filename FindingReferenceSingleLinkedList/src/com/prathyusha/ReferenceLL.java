package com.prathyusha;

public class ReferenceLL {
	
	class Node{  
        int data;  
        Node next;  
        public Node(int data) {  
            this.data = data;  
            this.next = null;  
        }  
    }  
	
	public Node head = null;  
    public Node tail = null;  
    
	
    
    public Node findReference(Node head,Node node) {
    	Node current = head;
    	if(node == head) {
			System.out.println("No reference for head node");
		}
    	while(current.next !=null) {
    		
    		if(current.next == node ) {
    			System.out.println("Reference of given node is : "+current.data);
    			return current;
    		}
    		else {
    			current = current.next;
    		}
    	}
    	
		return null;
		
    	
    }
    
    public static void main(String[] args) {

    
    ReferenceLL list = new ReferenceLL();
	
	Node head = list.new Node(10);
	 Node first = list.new Node(20);
	 Node second = list.new Node(30);
	 Node third = list.new Node(40);
   
	 head.next=first;
	 first.next=second;
	 second.next=third;
	
	
	list.findReference(head,first);
	//list.findReference(head,second);
	//list.findReference(head,third);
	

}





}

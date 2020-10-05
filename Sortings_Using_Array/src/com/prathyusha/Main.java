package com.prathyusha;

import java.util.Scanner;

import com.prathyusha.Sorting.BST;

public class Main {
	public static void main(String args[]) {
		
		Sorting sort = new Sorting();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of elements in an array:");
        int n = scanner.nextInt();
        int ar[] = new int[n];
        
		while (true) {
			
			
			System.out.println("\n");
			System.out.println("******Sorting Techniques For Array******");
			System.out.println("1. Selection Sort");
			System.out.println("2. Bubble Sort");
			System.out.println("3. Insertion Sort");
			System.out.println("4. Shell Sort");
			System.out.println("5. Merge Sort ");
			System.out.println("6. Quick Sort");
			System.out.println("7. Binary Tree Sort");
			System.out.println("8. Heap Sort");
			System.out.println("9. Radix Sort");
			System.out.println("10. Exit");
			
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			
			case 1:
				System.out.println("Enter " + ar.length+" elements :");
				for(int i = 0; i < ar.length; i++)
		        {
		            ar[i] = scanner.nextInt();
		        }
				System.out.println("Before Sorting:");
				sort.display(ar);
				sort.selectionSort(ar);
				System.out.println("\n After Selection Sort :");
				sort.display(ar);
				break;
			
			case 2:
				System.out.println("Enter " + ar.length+" elements :");
				for(int i = 0; i < ar.length; i++)
		        {
		            ar[i] = scanner.nextInt();
		        }
				System.out.println("Before Sorting:");
				sort.display(ar);
				sort.bubbleSort(ar);
				System.out.println("\n After Bubble Sort :");
				sort.display(ar);
				break;
				
			
			case 3:
				System.out.println("Enter " + ar.length+" elements :");
				for(int i = 0; i < ar.length; i++)
		        {
		            ar[i] = scanner.nextInt();
		        }
				System.out.println("Before Sorting:");
				sort.display(ar);
				sort.InsertionSort(ar);
				System.out.println("\n After Insertion Sort :");
				sort.display(ar);
				break;
				
			case 4:
				System.out.println("Enter " + ar.length+" elements :");
				for(int i = 0; i < ar.length; i++)
		        {
		            ar[i] = scanner.nextInt();
		        }
				System.out.println("Before Sorting:");
				sort.display(ar);
				sort.shellSort(ar, ar.length);
				System.out.println("\n After Shell Sort :");
				sort.display(ar);
				break;
				
			case 5:
				System.out.println("Enter " + ar.length+" elements :");
				for(int i = 0; i < ar.length; i++)
		        {
		            ar[i] = scanner.nextInt();
		        }
				System.out.println("Before Sorting:");
				sort.display(ar);
				sort.sort(ar, 0, ar.length-1);
				System.out.println("\n After Merge Sort :");
				sort.display(ar);
				break;
				
			case 6:
				System.out.println("Enter " + ar.length+" elements :");
				for(int i = 0; i < ar.length; i++)
		        {
		            ar[i] = scanner.nextInt();
		        }
				System.out.println("Before Sorting:");
				sort.display(ar);
				sort.quickSort(ar, 0, ar.length-1);
				System.out.println("\n After Quick Sort :");
				sort.display(ar);
				break;
				
			case 7:
				System.out.println("Enter " + ar.length+" elements :");
				for(int i = 0; i < ar.length; i++)
		        {
		            ar[i] = scanner.nextInt();
		        }
				System.out.println("Before Sorting:");
				sort.display(ar);
				BST bst = sort.new BST(ar[0]);
			    for(int num : ar){
			      bst.insert(bst.node, num);
			    }
			    System.out.print("\n After Binary Tree sort");
			    bst.inOrder(bst.node);
		        break;
			
			case 8:
				System.out.println("Enter " + ar.length+" elements :");
				for(int i = 0; i < ar.length; i++)
		        {
		            ar[i] = scanner.nextInt();
		        }
				System.out.println("Before Sorting:");
				sort.display(ar);
				sort.heapSort(ar);
				System.out.println("\n After Heap Sort :");
				sort.display(ar);
				break;
				
			case 9:
				System.out.println("Enter " + ar.length+" elements :");
				for(int i = 0; i < ar.length; i++)
		        {
		            ar[i] = scanner.nextInt();
		        }
				System.out.println("Before Sorting:");
				sort.display(ar);
				sort.radixSort(ar, ar.length);
				System.out.println("\n After Radix Sort :");
				sort.display(ar);
				break;
			
			case 10:
				System.out.println("Exiting......");
				System.exit(0);
				
			 default : 
	                System.out.println("Wrong Entry \n ");
	                break; 
				
			}
	}

}
}

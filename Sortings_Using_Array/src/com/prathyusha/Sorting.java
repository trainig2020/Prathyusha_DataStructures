package com.prathyusha;

public class Sorting {
	
	
	//****SELECTION SORT**** 

	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;// searching for lowest index
				}
			}
			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
		}
	}
	
	
	//**** BUBBLE SORT**** 

		public void bubbleSort(int[] arr) {
			int n = arr.length;
			int temp = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < (n - i); j++) {
					if (arr[j - 1] > arr[j]) {
						// swap elements
						temp = arr[j - 1];
						arr[j - 1] = arr[j];
						arr[j] = temp;
					}

				}
			}
		}
	
	
	//****INSERTION SORT**** 

	
	public void InsertionSort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	//****SHELL SORT**** 
	
		void shellSort(int array[], int n) {
			  for (int interval = n / 2; interval > 0; interval /= 2) {
			    for (int i = interval; i < n; i += 1) {
			    int temp = array[i];
			    int j;
			    for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
			      array[j] = array[j - interval];
			    }
			    array[j] = temp;
			    }
			  }
			  }
		
	
	
	//****MERGE SORT**** 

	void merge(int arr[], int beg, int mid, int end) {

		int l = mid - beg + 1;
		int r = end - mid;

		int LeftArray[] = new int[l];
		int RightArray[] = new int[r];

		for (int i = 0; i < l; ++i)
			LeftArray[i] = arr[beg + i];

		for (int j = 0; j < r; ++j)
			RightArray[j] = arr[mid + 1 + j];

		int i = 0, j = 0;
		int k = beg;
		while (i < l && j < r) {
			if (LeftArray[i] <= RightArray[j]) {
				arr[k] = LeftArray[i];
				i++;
			} else {
				arr[k] = RightArray[j];
				j++;
			}
			k++;
		}
		while (i < l) {
			arr[k] = LeftArray[i];
			i++;
			k++;
		}

		while (j < r) {
			arr[k] = RightArray[j];
			j++;
			k++;
		}
	}

	void sort(int arr[], int beg, int end) {
		if (beg < end) {
			int mid = (beg + end) / 2;
			sort(arr, beg, mid);
			sort(arr, mid + 1, end);
			merge(arr, beg, mid, end);
		}
	}
	

	//****QUICK SORT**** 

	int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than the pivot
			if (arr[j] < pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	
	void quickSort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}
	
	 //****BINARY TREE SORT**** 
    
    class Node{
  	  int value;
  	  Node left;
  	  Node right;
  	  Node(int value){
  	    this.value = value;
  	    left = null;
  	    right = null;        
  	  }
  	}
    
    class BST{
  	  Node node;
  	  BST(int value){
  	    node = new Node(value);
  	  }
  	  public Node insert(Node node, int value){
  	    if(node == null){
  	      return new Node(value);
  	    }
  	    // Move to left for value less than parent node
  	    if(value < node.value){
  	      node.left = insert(node.left, value);
  	    }
  	    // Move to right for value greater than parent node
  	    else if(value > node.value){
  	      node.right = insert(node.right, value);
  	    }
  	    return node;
  	  }
  	    
  	  // For traversing in order
  	  public void inOrder(Node node){
  	    if(node != null){
  	      // recursively traverse left subtree
  	      inOrder(node.left);
  	      System.out.print(node.value + " ");
  	      // recursively traverse right subtree
  	      inOrder(node.right);
  	    }
  	  }
  	}
    
	
	
	//****HEAP SORT**** 
	
	public void heapSort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i=n-1; i>0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
    } 
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 
    
    
  //****RADIX SORT**** 
    
    void countingSort(int array[], int size, int place) {
        int[] output = new int[size + 1];
        int max = array[0];
        for (int i = 1; i < size; i++) {
          if (array[i] > max)
            max = array[i];
        }
        int[] count = new int[max + 1];

        for (int i = 0; i < max; ++i)
          count[i] = 0;

        // Calculate count of elements
        for (int i = 0; i < size; i++)
          count[(array[i] / place) % 10]++;

        // Calculate cummulative count
        for (int i = 1; i < 10; i++)
          count[i] += count[i - 1];

        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
          output[count[(array[i] / place) % 10] - 1] = array[i];
          count[(array[i] / place) % 10]--;
        }

        for (int i = 0; i < size; i++)
          array[i] = output[i];
      }

      // Function to get the largest element from an array
      int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++)
          if (array[i] > max)
            max = array[i];
        return max;
      }

     
      void radixSort(int array[], int size) {
       int max = getMax(array, size);

        // Apply counting sort to sort elements based on place value.
        for (int place = 1; max / place > 0; place *= 10)
          countingSort(array, size, place);
      }
      
   
    //****DISPLAY THE ARRAY ELEMENTS**** 

	public void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

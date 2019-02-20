public class Heapsort{

	int heap_size = 0;	

	void maxHeapify(int[] arr, int root){
		int left = 2*root+1;
		int right = 2*root+2;
		int largest = root;	

		if(left < heap_size && arr[left] > arr[root]){
			largest = left;
		}
		else{
			largest = root;
		}

		if(right < heap_size && arr[right] > arr[largest]){
			largest = right;
		}

		if(largest != root){
			int temp = arr[root];
			arr[root] = arr[largest];
			arr[largest] = temp;
			maxHeapify(arr,largest);
		}
	}

	void buildMaxHeap(int[] arr){
		heap_size = arr.length;
		for(int i= (int)java.lang.Math.floor(arr.length/2);i>=0;i--){
			maxHeapify(arr,i);
		}
	}

	void heapsort(int[] arr){
		buildMaxHeap(arr);
		for(int i=arr.length-1;i>0;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heap_size -- ;
			maxHeapify(arr,0);
		}
	}
	
	void print(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args){

		int[] arr = new int[]{4,2,1,3,5,6};

		Heapsort sort = new Heapsort();
		sort.heapsort(arr);
		sort.print(arr);
	}
}

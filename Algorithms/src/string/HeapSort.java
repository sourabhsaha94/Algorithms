package string;

public class HeapSort {
	int[] array = {10,5,6,9,11,12,2};
	int heap_size;

	public HeapSort(){
		heap_size = array.length;
	}

	public void max_heapify(int root){

		int left_child = 2*root+1;
		int right_child = 2*root+2;
		int largest = 0;
		int temp;

		if(left_child<heap_size && array[left_child]>array[root]){
			largest = left_child;
		}
		else{
			largest = root;
		}

		if(right_child<heap_size && array[right_child]>array[largest]){
			largest = right_child;
		}

		if(largest!=root){
			temp = array[largest];
			array[largest] = array[root];
			array[root] = temp;

			max_heapify(largest);
		}
	}

	public void build_max_heap(){
		for(int i=array.length/2;i>=0;i--){
			max_heapify(i);
		}
	}

	public void min_heapify(int root){

		int left_child = 2*root+1;
		int right_child = 2*root+2;
		int smallest = 0;
		int temp;

		if(left_child<heap_size && array[left_child]<array[root]){
			smallest = left_child;
		}
		else{
			smallest = root;
		}

		if(right_child<heap_size && array[right_child]<array[smallest]){
			smallest = right_child;
		}

		if(smallest!=root){
			temp = array[smallest];
			array[smallest] = array[root];
			array[root] = temp;

			min_heapify(smallest);
		}
	}

	public void build_min_heap(){
		for(int i=array.length/2;i>=0;i--){
			min_heapify(i);
		}
	}

	public void heap_sort(String type){
		int temp;

		if(type=="max")
			for(int i=array.length-1;i>=0;i--){
				temp = array[0];
				array[0] = array[i];
				array[i] = temp;

				heap_size-=1;

				max_heapify(0);
			}
		else
			for(int i=array.length-1;i>=0;i--){
				temp = array[0];
				array[0] = array[i];
				array[i] = temp;

				heap_size-=1;

				min_heapify(0);
			}


	}

	public void display_array(){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}

	public static void main(String args[]){
		HeapSort heap = new HeapSort();

		heap.display_array();
		System.out.println(heap.array.length/2);
		heap.build_max_heap();

		heap.display_array();

		heap.heap_sort("max");

		heap.display_array();
		
		heap.heap_size = heap.array.length;
		
		heap.heap_sort("min");

		heap.display_array();
	}

}

public class Heap{

	int heap_size;
	int[] heap;

	Heap(int size){
		this.heap_size = 0;
		heap = new int[size+1];
	}

	void insert(int data){
		if(heap_size == heap.length-1){
			System.out.println("Heap is full, cannot add "+data);
			return;
		}
	
		int pos = heap_size;//element inserted at the end

		heap_size = heap_size+1;//heap size is incremented

		while(pos > 0 && data > heap[pos/2]){
			heap[pos] = heap [pos/2];
			pos = pos/2;
		}

		heap[pos] = data;
	}

	int deleteMax(){
		int max = heap[0];

		heap[0] = heap[heap_size-1];
		
		heap_size--;
		int pos = 0;
		while(pos<heap_size){
			int left = 2*pos + 1;
			int right = 2*pos + 2;
			int largestIndex = pos;
			if(left< heap_size && heap[left] > heap[pos])
				largestIndex = left;
			if(right< heap_size && heap[right] > heap[largestIndex])
				largestIndex = right;

			if(largestIndex==pos)
				break;

			int temp = heap[pos];
			heap[pos] = heap[largestIndex];
			heap[largestIndex] = heap[pos];

			pos = largestIndex;
		}
		return max;
	}	
	
	public static void main(String[] args){
		Heap heap = new Heap(5);
		heap.insert(1);
		heap.insert(12);
		heap.insert(20);
		heap.insert(6);
		heap.insert(7);
		heap.insert(10);
		System.out.println(heap.deleteMax());
	}
}

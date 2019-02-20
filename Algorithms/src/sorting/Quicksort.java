public class Quicksort{
	
	void quicksort(int[] arr, int low, int high){
		if(low<high){
			int p = partition(arr,low,high);
			quicksort(arr, low, p-1);
			quicksort(arr, p+1, high);
		}
	}

	int partition(int[] arr, int low, int high){
	
		int pivot = arr[high];

		int i=low-1;

		for(int j=low;j<high;j++){

			if(arr[j]<=pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[high];
		arr[high] = arr[i+1];
		arr[i+1] = temp;
		
		return i+1;
	}

	void print(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void main (String[] args){
		Quicksort qsort = new Quicksort();
		
		int[] arr = new int[]{4,3,1,2,5,6};

		qsort.quicksort(arr,0,arr.length-1);
		
		qsort.print(arr);
	}
}	 

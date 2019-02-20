public class Mergesort{
	
	void mergesort(int[] arr, int low, int high){
	
		if(low<high){
			int mid = (low+high)/2;
			mergesort(arr,low,mid);
			mergesort(arr,mid+1, high);
			merge(arr,low,mid,high);
		}
	}

	void merge(int[] arr, int low, int mid, int high){
	
		int sizeLeft = mid-low+1;
		int sizeRight = high - mid;

		int[] left = new int[sizeLeft];
		int[] right = new int[sizeRight];

		for(int i=0;i<sizeLeft;i++){
			left[i] = arr[low+i];
		}
		
		for(int i=0;i<sizeRight;i++){
			right[i] = arr[mid+i+1];
		}

		int i=0,j=0,k=low;

		while(i<sizeLeft && j<sizeRight){

			if(left[i] <= right[j]){
				arr[k] = left[i];
				i++;
			}
			else{
				arr[k] = right[j];
				j++;
			}
			k++;
		}


		while(i<sizeLeft){
			arr[k] = left[i];
			i++;k++;
		}
		while(j<sizeRight){
			arr[k] = right[j];
			j++;k++;
		}
	}

	void print(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){

		Mergesort sort = new Mergesort();

		int[] arr = new int[]{6,4,2,1,3,5};

		sort.mergesort(arr,0,arr.length-1);

		sort.print(arr);
	
	}
}

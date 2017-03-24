package string;

public class QuickSort {
	int[] array = {12,9,6,5,13,1,7};
	
	public int partition(int low,int high){
		
		int pivot = high;
		int i=low;
		
		for(int j=low;j<high;j++){
			if(array[j]<=array[pivot]){
				swap(array,j,i);
				i=i+1;
			}
		}
		
		swap(array,i,pivot);
		
		return i;
	}
	
	public void quick_sort(int low,int high){
		int pivot=0;
		if(low<high){
			pivot = partition(low,high);
			quick_sort(low,pivot-1);
			quick_sort(pivot+1,high);
		}
	}
	
	public void swap(int[] t_array,int i,int j){
		int temp = t_array[i];
		t_array[i] = t_array[j];
		t_array[j] = temp;
	}
	
	public void display_array(){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		QuickSort q = new QuickSort();
		q.display_array();
		q.quick_sort(0, q.array.length-1);
		q.display_array();
	}
}

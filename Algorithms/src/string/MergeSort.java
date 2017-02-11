package string;

public class MergeSort {
	int[] arr;
	MergeSort(){
		arr = new int[10];
	}
	
	void merge_sort(int[] arr,int low, int high){
		int mid=0;
		if(low<high){
			mid = (low+high)/2;
			
			System.out.println("(Before calling sort)low: "+low+" high: "+high);
			for(int i=low;i<=high;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
			
			merge_sort(arr,low,mid);
			
			System.out.println("(After calling first sort)low: "+low+" high: "+high);
			for(int i=low;i<=high;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
			
			merge_sort(arr,mid+1,high);
			
			System.out.println("(After calling second sort)low: "+low+" high: "+high);
			for(int i=low;i<=high;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
			
			merge(arr,low,mid,high);
			
			System.out.println("(After calling merge)low: "+low+" high: "+high);
			for(int i=low;i<=high;i++)
				System.out.print(arr[i]+" ");
			System.out.println();
		}
	}

	void merge(int[] arr,int low,int mid,int high) {
		int[] temp = new int[arr.length];
		for(int i=low;i<=high;i++){
			temp[i] = arr[i];
		}
		int i=low,j=mid+1,k=low;
		while(i<=mid && j<=high){
			if(temp[i]<=temp[j]){
				arr[k]=temp[i];
				i++;
			}
			else{
				arr[k]=temp[j];
				j++;
			}
			k++;
		}
		while(i<=mid){
			arr[k++]=temp[i++];
		}
		while(j<=high){
			arr[k++]=temp[j++];
		}
	}
	
	public static void main(String args[]){
		MergeSort m = new MergeSort();
		
		System.out.println("Input");
		for(int i=0;i<10;i++){
			m.arr[i] = m.arr.length-i;
		}
		
		for(int i=0;i<m.arr.length;i++)
			System.out.print(m.arr[i]+" ");
		
		System.out.println();
		m.merge_sort(m.arr, 0, 9);
		
		System.out.println("Output");
		for(int i=0;i<m.arr.length;i++)
			System.out.print(m.arr[i]+" ");
	}
}

/*Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]*/

/*Reverse the 0->n-k part, then reverse the k->n part, then reverse the whole array 
 * Time is O(n), space is O(1)*/

package string;

public class RotateArray {
	public static void main(String args[]){
		
	}
	public static void rotate(int[] array,int steps){
		
		int a = array.length - steps;	//get the end of the first part
		
		reverse(array,0,a-1);
		reverse(array,a,array.length-1);
		reverse(array,0,array.length-1);
	}
	public static void reverse(int[] array,int low,int high){
		int left = low;
		int right = high;
		int temp=0;
		while(left<=right){
			temp=array[left];
			array[left]=array[right];
			array[right]=temp;
			left++;
			right--;
		}
	}
}

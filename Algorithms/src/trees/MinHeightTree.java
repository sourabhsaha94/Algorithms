/* Given a sorted array, create a binary tree with minimum height*/

class Node{
	int data;
	Node left;
	Node right;
	public Node(int _data){
		data = _data;
	}
}

public class MinHeightTree{

	public static Node createMinTree(int[] arr, int low, int high){
		if(low< high){
			int mid = (high + low) / 2;
			Node root = new Node(arr[mid]);
			root.left = createMinTree(arr,low,mid-1);
			root.right = createMinTree(arr,mid+1,high);
			return root;
		}
		else if(low==high){
			return new Node(arr[low]);
		}
		
		return null;
	}
			
	public static void inorder(Node root){
		if(root!=null){
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}

	public static void main(String args[]){
		int[] arr = new int[]{1,2,3,6,7,8,101};
		
		Node root = createMinTree(arr,0,arr.length-1);

		inorder(root);
	}
}

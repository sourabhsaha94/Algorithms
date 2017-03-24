package graphtheory;

import java.util.Random;

public class MatrixChainMemo {
	int minMultMatrix[][];
	int kStorageMatrix[][];
	int n;
	int num_mults = 0;
	int num_rec = 0;
	int inputDimensions[];
	
	public MatrixChainMemo(int[] inputDimensions){
		this.inputDimensions = inputDimensions;
		this.n = inputDimensions.length-1;
		minMultMatrix = new int[n+1][n+1];
		kStorageMatrix = new int[n+1][n+1];
		
		for(int i=0;i<n+1;i++){
			for(int j=0;j<n+1;j++){
				minMultMatrix[i][j] = Integer.MAX_VALUE;
			}
		}
		
		num_rec++;
		
		final double start = System.nanoTime();
		
		System.out.println("Min multiplications to be done:"+matrixChainMultRecursive(inputDimensions, 1, n));
		
		final double runtime = System.nanoTime() - start;
		System.out.println("Run time:"+runtime/1000000);//milliseconds
		
	}
	
	public static void main(String args[]){
		/*int n = 15;
		Random r = new Random();
		int[] p = new int[n];

		for(int i=0;i<n;i++){
			p[i] = r.nextInt(10)+1;
		}
		*/
		
		int[] p = {8,4,10,10,7,3,5,9,7,4,4,7,10,6,8};
		
		System.out.println("Input given");
	
		for(int i=0;i<p.length;i++){
			System.out.print(p[i]+" ");
		}
		System.out.println();
		
		MatrixChainMemo matrix = new MatrixChainMemo(p);
		
		matrix.display();
	}
	
	public void display(){
		System.out.println("Number of scalar multiplications:"+num_mults);
		System.out.println("Number of recursive calls: "+num_rec);
	}

	public int matrixChainMultRecursive(int[] inputDimensions, int i, int j) {
		
		num_rec++;
		
		if(minMultMatrix[i][j]!=Integer.MAX_VALUE){
			return minMultMatrix[i][j];
		}
		
		if (i == j)
			minMultMatrix[i][i] = 0;

		else {
			minMultMatrix[i][j] = Integer.MAX_VALUE;
			for (int k = i; k < j; k++) {
				int cost = matrixChainMultRecursive(inputDimensions, i, k)
						+ matrixChainMultRecursive(inputDimensions, k + 1, j)
						+ inputDimensions[i - 1] * inputDimensions[k] * inputDimensions[j];

				num_mults += 2;

				if (cost < minMultMatrix[i][j]) {
					minMultMatrix[i][j] = cost;
				}
			}
		}

		return minMultMatrix[i][j];
	}
	
	
}

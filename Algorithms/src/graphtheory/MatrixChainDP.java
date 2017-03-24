package graphtheory;

import java.util.Random;

/**
 *
 * @author sssaha2
 */
public class MatrixChainDP { //dynamic programming version

	int minMultMatrix[][];
	int kStorageMatrix[][];
	int n;
	int num_mults=0;

	public static void main (String[] args) 
	{

		MatrixChainDP matrixChain=new MatrixChainDP();

		final double start = System.nanoTime();
		Random r = new Random();

		int n = 55;

		int[] p = new int[n];

		for(int i=0;i<n;i++){
			p[i] = r.nextInt(10)+1;
		}

		System.out.println("Input given");

		for(int i=0;i<n;i++){
			System.out.print(p[i]+" ");
		}

		System.out.println();
		
		//int[] p = {5,6,1,9,7,1,6,3,10,4};

		matrixChain.matrixChainMultDP(p);

		final double runtime = System.nanoTime()- start;
		System.out.println("Run time:"+runtime/1000000);//milliseconds
	}

	public void matrixChainMultDP(int[] inputDimensions)
	{
		n=inputDimensions.length-1;
		minMultMatrix=new int[n+1][n+1];
		kStorageMatrix=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			minMultMatrix[i][i] = 0;
		}
		for(int l=2;l <= n;l++)
		{
			for(int i=1;i<=n-l+1;i++)
			{
				int j = i + l - 1;
				minMultMatrix[i][j] = Integer.MAX_VALUE;
				for(int k=i;k<j;k++)
				{
					int q = minMultMatrix[i][k] + minMultMatrix[k+1][j] + inputDimensions[i-1]*inputDimensions[k]*inputDimensions[j];
					num_mults+=2;//two multiplications performed
					if(q < minMultMatrix[i][j])
					{
						minMultMatrix[i][j] = q;
						kStorageMatrix[i][j] = k;
					}

				}

			}
		}
		System.out.println("Min multiplications to be done:"+minMultMatrix[1][n]);
		System.out.println("Number of scalar multiplications:"+num_mults);
	}

}

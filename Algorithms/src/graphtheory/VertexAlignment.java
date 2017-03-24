package graphtheory;



public class VertexAlignment {

	int vCost[][];
	int position[];

	public VertexAlignment(int n,int m){
		vCost = new int[n+1][m+1];
		position = new int[n+1];
	}

	public static void main(String[] args) {
		
		VertexAlignment va= new VertexAlignment(3,5); 

		va.vCost[1][1] = 21;
		va.vCost[1][2] = 10;
		va.vCost[1][3] = 5;
		va.vCost[2][2] = 5;
		va.vCost[2][3] = 5;
		va.vCost[2][4] = 9;
		va.vCost[3][3] = 5;
		va.vCost[3][4] = 6;
		va.vCost[3][5] = 13;

		va.position[0] = 0;

		//int count = va.calculateRecursive(3,5);
		int count = va.calculateDP(3,5);
		System.out.println(count);

	}

	int calculateRecursive(int j,int k){

		int prevCost=0;

		if(j>1){
			prevCost = calculateRecursive(j-1,k-1);
		}

		int min = Integer.MAX_VALUE;

		for(int i=position[j-1]+1;i<=k;i++){
			if(vCost[j][i]<min){
				min = vCost[j][i];
				position[j]=i;
			}
		}

		return prevCost+min;

	}

	int calculateDP(int n,int m){

		int min=Integer.MAX_VALUE;
		int[][] c = new int[n+1][m+1];

		int i,j;

		c[0][m-n] = 0;
		position[1]=1;

		for(i=1;i<=n;i++){

			min = Integer.MAX_VALUE;

			for(j=position[i-1]+1;j<=m-n+i;j++){
				 
				if(vCost[i][j]<min){
					min = vCost[i][j];
					position[i]=j;
				}
			}
			j--;
			c[i][j] = min+c[i-1][j-1];
		}

		return c[n][m];
	}

}


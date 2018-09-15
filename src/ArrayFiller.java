
public class ArrayFiller {
	public static void Fill(int k, int m, int[][] m1, int[][] m2) {
		for (int i=0 ; i<m; i++) {
	        for (int j=0 ; j<m; j++) {
	            if (k%2==0)
	               m1[i][j] = -k;
	            else
	               m1[i][j] = k;
	        }
	        k++;
	    }
	    k=1;
	    for (int j=0 ; j<m; j++) {
	        for (int i=0 ; i<m; i++) {
	            if (k%2==0)
	               m2[i][j] = -k;
	            else
	               m2[i][j] = k;
	        }
	        k++;
	    }
	}
	
	public static void Check(int m, int[][] mres, int k) {
		 for (int i=0 ; i<m; i++) {
		        k = m*(i+1);
		        for (int j=0 ; j<m; j++) {
		            int k_col = k*(j+1);
		            if (i % 2 ==0) {
		               if (j % 2 == 0) {
		                  if (mres[i][j]!=k_col)
		                     System.exit(1);
		               }
		               else {
		                  if (mres[i][j]!=-k_col)
		                     System.exit(1);
		               }
		            }
		            else {
		               if (j % 2 == 0) {
		                  if (mres[i][j]!=-k_col)
		                     System.exit(1);
		               }
		               else {
		                  if (mres[i][j]!=k_col)
		                     System.exit(1);
		               }
		            }
		        } 
		    }
	}
}

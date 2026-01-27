package review.P15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class six {
	public static void main(String[] args) throws IOException {
		StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		int n=(int)st.nval;
		int m=(int)st.nval;
		int q=(int)st.nval;
		int[][]adj=new int[n+1][n+1];
		for (int i = 0; i <= n ; i++) {
			for (int j = 0; j <= n; j++) {
				if(i!=j) {
					adj[i][j]=Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			st.nextToken();
			int ai=(int)st.nval;
			st.nextToken();
			int bi=(int)st.nval;
			adj[ai][bi]=1;
			adj[bi][ai]=1;
		}
		int[][]dis=new int[n+1][n+1];
		// 初始化距离
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i!=j) {
					dis[i][j]=Integer.MAX_VALUE;
				}
			}
		}
		floyd(adj,dis,n);
		long count=0;
		for (int i = 0; i < q; i++) {
			st.nextToken();
			int xi=(int)st.nval;
			st.nextToken();
			int yi=(int)st.nval;
			for (int j = 1; j < dis.length; j++) {
				if (dis[xi][j]<=yi) {
					count++;
				}
			}
		}
		double result=count/q;
		System.out.printf("%.2f",result);
	}

	private static void floyd(int[][] adj,int[][]dis,int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (adj[j][i]!=Integer.MAX_VALUE && adj[i][k]!=Integer.MAX_VALUE
							&& adj[j][i]+adj[i][k]<dis[j][k]) {
						dis[j][k]=adj[j][i]+adj[i][k];
					}
				}
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11722 : 가장 긴 감소하는 부분 수열
public class BOJ_11722 {
	public static void main(String[] args) throws Exception { 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for (int i = 0 ; i < N ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] memo = new int[N][N];
		
		for (int i = 0 ; i < N-1 ; i++) {
			int axis = A[i];
			
			for (int j = i+1 ; j < N ; j++) {
				if (axis > A[j]) {
					memo[i][j] = axis - A[j];
				}
			}
		}
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				System.out.print(memo[i][j] + " ");
			}
			System.out.println();
		}
		
		int[] cnt = new int[N];
		
		for (int i = 0 ; i < N ; i++) {
			int axis = 0;
			
			for (int j = 0 ; j < N ; j++) {
				if (memo[i][j] != 0) {
					
				}
			}
		}
	}
}

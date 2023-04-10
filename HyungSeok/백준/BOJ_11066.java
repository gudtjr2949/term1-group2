import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11066 : 파일 합치기
public class BOJ_11066 {
	
	static int K;
	static int[] C;
	static int[][] memo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int Test = Integer.parseInt(bf.readLine());
		
		for (int T = 0 ; T < Test ; T++) {
			K = Integer.parseInt(bf.readLine());
			
			C = new int[K];
			memo = new int[K][K];
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			for (int i = 0 ; i < K ; i++) {
				C[i] = Integer.parseInt(st.nextToken());
			}
			
			solve();
			
		}
	}

	private static void solve() {
		for (int i = 1 ; i < K ; i++) { // 범위 길이
			
			for (int j = 0 ; j <= K - i ; j++) { // 시작 점
				
				for (int q = j ; q <= i+j ; q++) {
					memo[j][i + j] = Math.min(j, q);
				}
			}
		}
	}
}

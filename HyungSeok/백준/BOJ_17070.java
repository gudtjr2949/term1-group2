import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 17070 : 파이프 옮기기 1
public class BOJ_17070 {
	
	static int[][] dx = {{1, 1}, {0, 1}, {1, 0, 1}};
	static int[][] dy = {{0, 1}, {1, 1}, {0, 1, 1}};

	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		
		for (int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		dfs(0, 0, 0, 1, new int[N]);
	}

	private static void dfs(int idx, int dir, int x, int y, int[] input) {
		if (idx == N) {
			return;
		}
		
		
		for (int i = 0 ; i < dx[dir].length ; i++) {
			int nx = x + dx[dir][i];
			int ny = y + dy[dir][i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (y != ny && x != nx) { 
					
				} else {
					
				}
			}
		}
	}
}

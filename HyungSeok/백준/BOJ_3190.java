import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 3190 : 뱀
public class BOJ_3190 {
	
	static int N, K, L;
	static char[][] map;
	static Move[] move;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		K = Integer.parseInt(bf.readLine());
		
		map = new char[N+1][N+1];
		
		for (int i = 0 ; i < K ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[y][x] = 'A';
		}
		
		L = Integer.parseInt(bf.readLine());
		move = new Move[L];
		
		for (int i = 0 ; i < L ; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			move[i] = new Move(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
		
		for (int i = 1 ; i <= N ; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	
	static class Move {
		int time;
		char dir;
		
		public Move(int time, char dir) {
			super();
			this.time = time;
			this.dir = dir;
		}
	}
}

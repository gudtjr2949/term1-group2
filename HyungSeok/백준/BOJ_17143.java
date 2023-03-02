import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 백준 17143 : 낚시왕
public class BOJ_17143 {
	
	static Shark[][] map;
	static int R, C, M;
	static int[] nx = {0, 0, 0, 1, -1};
	static int[] ny = {0, -1, 1, 0, 0};
	static HashMap<Integer, Integer> dir;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dir = new HashMap<>();
		
		dir.put(1, 2);
		dir.put(2, 1);
		dir.put(3, 4);
		dir.put(4, 3);
		
		map = new Shark[R][C];
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			map[y-1][x-1] = new Shark(s, d, z);
		}
		
		for (int i = 0 ; i < R ; i++) {
			for (int j = 0 ; j < C ; j++) {
				if (map[i][j] != null) {
					move(j, i);
				}
			}
		}
	}
	
	private static void move(int x, int y) {
		
		int dx = x;
		int dy = y;
		
		for (int i = 0 ; i < map[y][x].s ; i++) {
			if (!(dx+nx[map[y][x].d] >= C || dx+nx[map[y][x].d] < 0 || dy+ny[map[y][x].d] >= R || dy+ny[map[y][x].d] < 0)) {
				dx += nx[map[y][x].d];
				dy += ny[map[y][x].d];
			}
			else {
				map[y][x].d = dir.get(map[y][x].d);
				dx += nx[map[y][x].d];
				dy += ny[map[y][x].d];
			}
		}
		
		map[dy][dx] = map[y][x];
		
		map[y][x] = null;
	}

	
	static class Shark {
		int s, d, z;

		public Shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}

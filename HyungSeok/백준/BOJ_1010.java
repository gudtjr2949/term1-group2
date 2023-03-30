import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1010 : 다리 놓기
public class BOJ_1010 {

	static int N, M, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());

		for (int Test = 0; Test < T; Test++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());

			answer = 0;

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			dfs(0, 0, new int[N]);

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int idx, int cur, int[] input) {
		if (idx == input.length) {
//			System.out.println(Arrays.toString(input));
			answer++;
			return;
		}
		
		

		for (int i = cur; i < M; i++) {
			input[idx] = i;
			dfs(idx + 1, i + 1, input);
		}
	}
}

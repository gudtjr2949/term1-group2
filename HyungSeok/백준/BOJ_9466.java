package coding_test.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 9466 : 텀 프로젝트
public class BOJ_9466 {

    static int N;
    static int[] arr;
    static boolean[] V;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int Test = Integer.parseInt(bf.readLine());

        for (int T = 0 ; T < Test ; T++) {
            N = Integer.parseInt(bf.readLine());
            arr = new int[N+1];
            V = new boolean[N+1];
            int cnt = 0;

            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

            for (int i = 1 ; i < N+1 ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1 ; i < N+1 ; i++) {
                if (!V[i]) {
                    int[] input = new int[N];
                    input[0] = i;
                    dfs(arr[i], 1, input, new boolean[N + 1]);
                }
            }

            cnt = count();

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    // dfs 돌렸을 때, 자기 자신에게 돌아와야 함
    private static void dfs(int cur, int idx, int[] input, boolean[] visited) {
        if (idx == input.length) {
            return;
        }

        if (!visited[cur]) {
            input[idx] = cur;
            visited[cur] = true;

            if (check(input, idx)) {
                visitedCheck(input, idx);
                return;
            }

            dfs(arr[cur], idx+1, input, visited);
        }

    }

    // 싸이클 도는지 확인 -> 처음과 끝이 같으면?
    private static boolean check(int[] input, int idx) {
        if (input[0] == input[idx]) {
            return true;
        }
        else {
            return false;
        }
    }

    private static void visitedCheck(int[] input, int idx) {
        for (int i = 0 ; i <= idx ; i++) {
            V[input[i]] = true;
        }
    }

    // 선택받지 못한 학생 수
    private static int count() {
        int cnt = 0;

        for (int i = 1 ; i < N+1 ; i++) {
            if (!V[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}

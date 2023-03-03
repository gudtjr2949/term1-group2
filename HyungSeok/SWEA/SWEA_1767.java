package coding_test.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// SWEA 1767 : 프로세서 연결하기
public class SWEA_1767 {

    static int N;
    static int[][] map;
    static boolean[][] connected;
    static int connected_cnt, connected_line;
    static ArrayList<Point> cpu;
    static int[] nx = {0, 1, 0, -1};
    static int[] ny = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int Test = Integer.parseInt(bf.readLine());

        for (int T = 0 ; T < Test ; T++) {
            N = Integer.parseInt(bf.readLine());

            connected_cnt = Integer.MIN_VALUE;
            connected_line = Integer.MAX_VALUE;
            connected = new boolean[N][N];

            map = new int[N][N];

            int[][] copy_map = new int[N][N];
            cpu = new ArrayList<>();

            for (int i = 0 ; i < N ; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
                for (int j = 0 ; j < N ; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    copy_map[i][j] = map[i][j];
                    if (map[i][j] == 1 && (i > 0 && i < N-1) && (j > 0 && j < N-1)) {
                        cpu.add(new Point(j, i));
                    }
                    else if (map[i][j] == 1) {
                        connected[i][j] = true;
                    }
                }
            }

            solve(0);

            sb.append("#").append(T+1).append(" ").append(connected_line).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int idx) {
        if (idx == cpu.size()) {
            connected_Cnt();
            return;
        }

        for (int i = 0 ; i < 4 ; i++) {
            if (lineCheck(cpu.get(idx), i)) {
                solve(idx + 1);
                restoration(cpu.get(idx), i);
            }
        }
    }

    private static void connected_Cnt() {

        int cnt = 0;

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (connected[i][j]){
                    cnt++;
                }
            }
        }

        connected_cnt = Math.max(connected_cnt, cnt);

        // 라인 수 세아리기
        if (cnt == connected_cnt) {
            int line_cnt = 0;

            for (int i = 0 ; i < N ; i++) {
                for (int j = 0 ; j < N ; j++) {
                    if (map[i][j] == -1) {
                        line_cnt++;
                    }
                }
            }

            connected_line = Math.min(connected_line, line_cnt);
        }
    }

    private static void restoration(Point p, int dir) {
        int dx = p.x;
        int dy = p.y;

        for (int i = 0 ; i < N ; i++) {
            dx += nx[dir];
            dy += ny[dir];

            if (dx >= N || dx < 0 || dy >= N || dy < 0 || map[dy][dx] == 1) {
                break;
            }

            map[dy][dx] = 0;
        }
    }

    private static void print() {
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 해당 열이나 행에 라인을 설치할 수 있는지 확인
    private static boolean lineCheck(Point p, int dir) {
        int dx = p.x;
        int dy = p.y;

        connected[p.y][p.x] = false;

        for (int i = 0 ; i < N ; i++) {
            dx += nx[dir];
            dy += ny[dir];

            // 끄트머리에 잘 도달한 경우
            if ((dx >= N || dx < 0 || dy >= N || dy < 0)) {
                printLine(p, dir);
                connected[p.y][p.x] = true;
                return true;
            }

            if (map[dy][dx] != 0) {
                break;
            }
        }

        // 여기까지 내려왔다는 건 연결가능한 경로를 찾지 못한것
        connected[p.y][p.x] = false;
        return false;
    }

    private static void printLine(Point p, int dir) {
        int dx = p.x;
        int dy = p.y;

        for (int i = 0 ; i < N ; i++) {
            dx += nx[dir];
            dy += ny[dir];

            if (dx >= N || dx < 0 || dy >= N || dy < 0 || map[dy][dx] == 1 || map[dy][dx] == -1) {
                break;
            }

            map[dy][dx] = -1;
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
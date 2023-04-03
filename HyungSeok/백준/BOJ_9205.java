package coding_test.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 9205 : 맥주 마시면서 걸어가기
public class BOJ_9205 {

    static int N;
    static Point home, festival;
    static Point[] con; // 편의점
    static int[][] map;
    static String answer;
    static int max_x, max_y, min_x, min_y;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int Test  = Integer.parseInt(bf.readLine());

        for (int T = 0 ; T < Test ; T++) {
            N = Integer.parseInt(bf.readLine());

            con = new Point[N];

            StringTokenizer st = new StringTokenizer(bf.readLine());

            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            max_x = home.x;
            max_y = home.y;
            min_x = home.x;
            min_y = home.y;

            for (int i = 0 ; i < N ; i++) {
                st = new StringTokenizer(bf.readLine());
                con[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

                max_x = Math.max(max_x, con[i].x);
                max_y = Math.max(max_y, con[i].y);
                min_x = Math.min(min_x, con[i].x);
                min_y = Math.min(min_y, con[i].y);
            }

            st = new StringTokenizer(bf.readLine());

            festival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            max_x = Math.max(max_x, festival.x);
            max_y = Math.max(max_y, festival.y);
            min_x = Math.min(min_x, festival.x);
            min_y = Math.min(min_y, festival.y);;

            answer = "sad";

            bfs();

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static int[] nx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] ny = {-1, -1, 0, 1, 1, 1, 0, -1};

    private static void bfs() {
        Queue<Point> Q = new LinkedList<>();

        boolean[][] vistied = new boolean[max_y+1][max_x+1];

        map = new int[max_y+1][max_x+1];

        for (int i = 0 ; i < N ; i++) {
            map[con[i].y][con[i].x] = 1;
        }

        Q.add(new Point(home.x, home.y, 0, 20, 0));

        while(!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0 ; i < size ; i++) {
                Point p = Q.poll();

                int y = p.y;
                int x = p.x;
                int d = p.d;
                int full_beer = p.full_beer;
                int empty_beer = p.empty_beer;

                if (x == festival.x-1 && y == festival.y-1) {
                    answer = "happy";
                    return;
                }

                if (map[y][x] == 1) { // 편의점에 들렸을 때,
                    full_beer = 20;
                    empty_beer = 0;
                }

                if (full_beer >= 0) { // 상자에 새 맥주병이 있을 때,
                    vistied[y][x] = true;

                    for (int j = 0; j < 8; j++) {
                        int dx = x + nx[j];
                        int dy = y + ny[j];

                        if (dx >= min_x && dx < max_x && dy >= min_y && dy < max_y && !vistied[dy][dx]) {
                            vistied[dy][dx] = true;

                            if ((d + 1) % 50 == 0) { // 50m 이동했을 때
                                Q.add(new Point(dx, dy, d + 1, full_beer-1, empty_beer+1));
                            }
                            else {
                                Q.add(new Point(dx, dy, d + 1, full_beer, empty_beer));
                            }
                        }
                    }
                }
            }
        }
    }

    static class Point {
        int x, y, d, full_beer, empty_beer;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int d, int full_beer, int empty_beer) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.full_beer = full_beer;
            this.empty_beer = empty_beer;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    ", full_beer=" + full_beer +
                    ", empty_beer=" + empty_beer +
                    '}';
        }
    }
}

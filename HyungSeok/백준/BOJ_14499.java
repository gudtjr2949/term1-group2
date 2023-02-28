package coding_test.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 백준 14499 : 주사위 굴리기
public class BOJ_14499 {

    static Deque<Integer> side = new ArrayDeque<>();
    static Deque<Integer> face = new ArrayDeque<>();
    static int[][] map;
    static int[] order;
    static int start_x, start_y;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s1 = bf.readLine();
        String[] s1_arr = s1.split(" ");

        map = new int[Integer.parseInt(s1_arr[0])][Integer.parseInt(s1_arr[1])];
        start_x = Integer.parseInt(s1_arr[2]);
        start_y = Integer.parseInt(s1_arr[3]);
        order = new int[Integer.parseInt(s1_arr[4])];

        for (int i = 0 ; i < map.length ; i++) {
            String s2 = bf.readLine();
            String[] s2_arr = s2.split(" ");
            for (int j = 0 ; j < map[0].length ; j++) {
                map[i][j] = Integer.parseInt(s2_arr[j]);
            }
        }

        String s3 = bf.readLine();
        String[] s3_arr = s3.split(" ");
        for (int i = 0 ; i < order.length ; i++) {
            order[i] = Integer.parseInt(s3_arr[i]);
        }
    }

    private static void solve() {

    }
}

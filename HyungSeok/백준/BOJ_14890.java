package coding_test.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 14890 : 경사로
public class BOJ_14890 {

    static int N, L;
    static int[][] map;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 이동할 방향으로의 높이가 같거나, 현재위치보다 1이 작은데 그 높이가 L 칸 만큼 연속되면 이동 가능
//        countSameheight();

        makeBridge();

        System.out.println(answer);
    }

    private static void countSameheight() {

        // 같은 높이가 연속으로 되어있는지 확인
        for (int i = 0 ; i < N ; i++) {
            boolean sign = true;

            for (int j = 0 ; j < N-1 ; j++) {
                if (map[i][j] != map[i][j+1]) {
                    sign = false;
                    break;
                }
            }

            if (sign) {
                answer++;
            }
        }

        for (int i = 0 ; i < N ; i++) {
            boolean sign = true;

            for (int j = 0 ; j < N-1 ; j++) {
                if (map[j][i] != map[j+1][i]) {
                    sign = false;
                    break;
                }
            }

            if (sign) {
                answer++;
            }
        }
    }
    
    // 높이가 1씩 차이나는 길 찾기
    private static void makeBridge() {
        for (int i = 0 ; i < N ; i++) {
            int j = 0;

            boolean sign = true;

            Loop:
            while(j < N-L){
                if (map[i][j] == map[i][j+1]+1) { // 다리를 지을 수 있을 경우
                    for (int q = j ; q < j+L ; q++) {
                        if (map[i][j+1] != map[i][q]) {
                            sign = false;
                            break Loop;
                        }
                    }
                    j += L;
                }
                else if (map[i][j] < map[i][j+1]){
                    sign = false;
                    break;
                }
                else {
                    j++;
                }
            }

            if (sign) {
                answer++;
            }
        }

        for (int i = 0 ; i < N ; i++) {
            int j = N-1;

            boolean sign = true;

            Loop:
            while(j-L >= 0){
                if (map[i][j] == map[i][j-1]+1) { // 다리를 지을 수 있을 경우
                    for (int q = j ; q >= j-L ; q--) {
                        if (map[i][j-1] != map[i][q]) {
                            sign = false;
                            break Loop;
                        }
                    }
                    j -= L;
                }
                else if (map[i][j] < map[i][j-1]){
                    sign = false;
                    break;
                }
                else {
                    j--;
                }
            }

            if (sign) {
                answer++;
            }
        }

        for (int i = 0 ; i < N ; i++) {
            int j = 0;

            boolean sign = true;

            Loop:
            while(j < N-L){
                if (map[j][i] == map[j+1][i]+1) { // 다리를 지을 수 있을 경우
                    for (int q = j ; q < j+L ; q++) {
                        if (map[j+1][i] != map[q][i]) {
                            sign = false;
                            break Loop;
                        }
                    }
                    j += L;
                }
                else if (map[j][i] < map[j+1][i]){
                    sign = false;
                    break;
                }
                else {
                    j++;
                }
            }

            if (sign) {
                answer++;
            }
        }

        for (int i = 0 ; i < N ; i++) {
            int j = N-1;

            boolean sign = true;

            Loop:
            while(j-L >= 0){
                if (map[j][i] == map[j-1][i]+1) { // 다리를 지을 수 있을 경우
                    for (int q = j ; q >= j-L ; q--) {
                        if (map[j-1][i] != map[q][i]) {
                            sign = false;
                            break Loop;
                        }
                    }
                    j -= L;
                }
                else if (map[j][i] < map[j-1][i]){
                    sign = false;
                    break;
                }
                else {
                    j--;
                }
            }

            if (sign) {
                answer++;
            }
        }
    }
}

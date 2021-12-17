package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3085_AC{
    static int N, max;
    static char[][] map;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

    static void check() {
        // 행 체크
        for(int i=0; i<N; i++) {
            int cnt = 1;
            for(int j=0; j<N-1; j++) {
                if(map[i][j] == map[i][j+1]) cnt++;
                else cnt = 1;

                max = Math.max(max, cnt);
            }
        }

        //열 체크
        for(int i=0; i<N; i++) {
            int cnt = 1;
            for(int j=0; j<N-1; j++) {
                if(map[j][i] == map[j+1][i]) cnt++;
                else cnt = 1;

                max = Math.max(max, cnt);
            }
        }

    }
    static void rightSwap(int x, int y) {
        char tmp = map[x][y];
        map[x][y] = map[x][y+1];
        map[x][y+1] = tmp;
    }

    static void downSwap(int x, int y) {
        char tmp = map[x][y];
        map[x][y] = map[x+1][y];
        map[x+1][y] = tmp;
    }

    public static void main(String[] args) throws IOException {
        input();

        // 오른쪽으로 교환
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++){
                rightSwap(i, j);
                check();
                rightSwap(i, j);
            }
        }

        // 아래로 교환
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++){
                downSwap(j, i);
                check();
                downSwap(j, i);
            }
        }

        System.out.println(max);
    }
}

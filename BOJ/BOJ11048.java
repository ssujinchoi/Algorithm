package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11048 {
    static int N, M;
    static int[][] dp, map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];

        // 미로 정보 입력받기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(j-1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j] ,  dp[i][j-1]);
                }
                if(i-1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
                dp[i][j] += map[i][j];
            }
        }

        System.out.println(dp[N-1][M-1]);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

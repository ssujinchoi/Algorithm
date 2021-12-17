package BOJ;

import java.io.*;
import java.util.*;

public class BOJ17070 {
//    f(i, j, k) = 타일의 i, j칸을 마지막으로 두는 경우의 수
//    f(i, j, 0) = f(i, j-1, 0) + f(i, j-1, 2); // 가로
//    f(i, j, 1) = f(i-1, j, 1) + f(i-1, j, 2) // 세로
//    f(i, j, 2) = f(i-1, j-1, 0) + f(i-1, j-1, 1) + f(i-1, j-1, 2)// 대각선
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = stoi(br.readLine()); // N입력
        map = new int[n][n];
        dp = new int[n][n][3];

        for(int i=0; i<n; i++) { // 격자판 입력
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }
        dp[0][1][0] = 1;

        for(int i=0; i<n; i++) {
            for(int j=2; j<n; j++) {
                if(map[i][j] == 1) continue;
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2]; // 가로
                if(i > 0) {
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]; // 세로
                    if(map[i-1][j] == 1 || map[i][j-1] == 1) continue;
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1]+ dp[i-1][j-1][2]; // 대각선
                }
            }
        }
        System.out.println(dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2]);
    }





    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

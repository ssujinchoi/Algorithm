package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        int[][] arr = new int[n+1][m+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++) {
                arr[i][j] = stoi(st.nextToken());
            }
        }


        int k = stoi(br.readLine());
        for(int t=0; t<k; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = stoi(st.nextToken());
            int y1 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken());
            int y2 = stoi(st.nextToken());

            int sum = 0;
            for(int i=x1; i<=x2; i++) {
                for(int j=y1; j<=y2; j++) {
                    sum += arr[i][j];
                }
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

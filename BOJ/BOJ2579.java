package BOJ;

import java.io.*;

public class BOJ2579 {
    static int[] st; // 계단점수
    static int[] max; // 최대값 - 메모이제이션
    static int N = 0;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st = new int[N+1];
        max = new int[N+1];

        for(int i=1; i<=N; i++) { // 계단 만들기
            st[i] = Integer.parseInt(br.readLine());
        }
    }
    public static void dp(int N) {
        max[1] = st[1];
        if(N>=2) max[2] = st[1] + st[2]; // 예외처리
        for(int i=3; i<=N; i++) {
            max[i] = Math.max(max[i-2], max[i-3] + st[i-1]) + st[i];
        }

        System.out.println(max[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        dp(N);
    }
}

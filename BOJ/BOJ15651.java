package BOJ;

import java.util.Scanner;

public class BOJ15651 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M + 1];
    }


    static void rec_func(int k) {
        if(k == M + 1) { // 다 골랐다!
            for(int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            for(int cand=1; cand<=N; cand++) {
                selected[k] = cand;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }
    public static void main(String[] args) {
        // 입력을 받는 함수와 문제를 푸는 함수로 나누자!!
        input();

        rec_func(1);
        System.out.println(sb.toString());
    }
}

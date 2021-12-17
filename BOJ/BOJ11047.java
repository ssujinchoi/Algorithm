package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// BOJ11047_AC - 동전 0
public class BOJ11047_AC {
    static int[] coins;
    static int K = 0;
    static int N = 0;

    public static void input(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        coins = new int[N];

        for(int i=0; i<N; i++)
            coins[i] = sc.nextInt();
    }

    public static int minNum() {
        int minCnt = 0;
        int mod = K;

        for(int i=N-1; i>=0; i--) {
            if(coins[i] < K) {
                minCnt += mod / coins[i];
                mod = mod % coins[i];
            }
        }
        return minCnt;
    }
    public static void main(String[] args) {
        input();
        System.out.println(minNum());
    }
}

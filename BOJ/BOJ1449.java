package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1449_AC {
    static int[] hole;
    static int N = 0, L = 0;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        hole = new int[N];

        for(int i= 0 ; i < N; i++) {
            hole[i] = sc.nextInt();
        }
        Arrays.sort(hole);
    }

    public static int min() {
        int minCnt = 1;
        int start = hole[0];
        for(int i=0; i<N; i++) {
            if(start+(L-1) < hole[i]) {
                start = hole[i];
                minCnt++;
            }

        }
        return minCnt;
    }
    public static void main(String[] args) {
        input();
        System.out.println(min());
    }
}

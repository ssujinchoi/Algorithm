package BOJ;

import java.util.Scanner;

public class BOJ11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numarr = new int[N+1];
        numarr[0] = 0;

        for (int i = 1; i < numarr.length; i++) numarr[i] = numarr[i-1] + sc.nextInt();

        StringBuilder sb = new StringBuilder();

        while(M-- > 0) {
            int front = sc.nextInt();
            int behind = sc.nextInt();
            int result = numarr[behind] - numarr[front-1];
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}

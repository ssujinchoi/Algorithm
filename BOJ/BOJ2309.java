package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309_AC {
    static int[] height = new int[9];
    static int[] check = new int[7];
    static boolean flag = false;

    static StringBuilder sb = new StringBuilder();
    public static void input() {

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < height.length; i++) height[i] = sc.nextInt();
    }

    public static void combination(int start, int cnt) {
        if(flag) return;
        if(cnt == 7) {
            int sum = 0;
            for(int i = 0; i < check.length; i++) sum += check[i];

            if(sum == 100) {
                Arrays.sort(check);
                for(int i = 0; i < check.length; i++) {
                    sb.append(check[i] + "\n");
                }
                flag = true;
            }
            return;
        }

        for(int i = start; i < height.length; i++) {
            check[cnt] = height[i];
            combination(start+1, cnt+1);
        }
    }
    public static void main(String[] args) {
        input();
        combination(0, 0);
        System.out.println(sb);
    }
}

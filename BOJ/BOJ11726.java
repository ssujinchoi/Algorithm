package BOJ;

import java.util.*;

// 백준 11726 : 2xn 크기의 직사각형을 1x2, 2x1타일로 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
// d[n] = d[n-1] + d[n-2]
public class BOJ11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] d = new int[10001];
        d[1] = 1;
        d[2] = 2;

        // bottom-up
        for(int i=3 ;i<=N; i++) {
            d[i] = (d[i-1] + d[i-2]) % 10007;
        }
        System.out.println(d[N]);
    }
}

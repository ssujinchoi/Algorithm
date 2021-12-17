package BOJ;

import java.math.BigInteger;
import java.util.Scanner;
// 소수?? 로 다시 풀어보기
public class BOJ1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger fac = new BigInteger("1");
        int count = 0;

        for(int i=1; i<=N; i++) {
            fac = fac.multiply(BigInteger.valueOf(i));
        }

        char[] str = (String.valueOf(fac)).toCharArray();
        for(int i=str.length-1; i>=0; i--) {
            if(str[i] == '0') count++;
            else break;
        }
        System.out.println(count);
    }
}

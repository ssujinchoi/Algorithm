package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int reverseA = 0, reverseB = 0;

        int a = Integer.parseInt(str[0]);
        while(a != 0) {
            int digit = a % 10;
            reverseA = reverseA * 10 + digit;
            a = a/10;
        }
        int b = Integer.parseInt(str[1]);
        while(b != 0) {
            int digit = b % 10;
            reverseB = reverseB * 10 + digit;
            b = b/10;
        }
        System.out.println(Math.max(reverseA, reverseB));
    }
}

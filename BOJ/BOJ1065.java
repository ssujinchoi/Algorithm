package BOJ;

import java.util.Scanner;

// 백준 - 한수 : 각 자리가 등차수열인지 판단하는 문제!! ex) n이 102이면, 1~99까지는 무조건 등차수열이고, 1/0/0 은 등차수열 아님 1/0/1도 등차수열아님
public class BOJ1065 {
    public static int arithmetic_sequence(int number) {
        int cnt = 0;

        if(number <= 99) {
            return number;
        } else {
            cnt = 99;
            if(number == 1000) number = 999;
            for(int i=100; i<=number; i++) {
                int hun = i/100;
                int ten = (i/10) % 10;
                int one = i%10;

                if((hun - ten) == (ten - one)) cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(arithmetic_sequence(n));
    }
}

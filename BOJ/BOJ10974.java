package BOJ;

import java.io.*;

// TODO 10974 - 모든순열 (그림으로 그려보자)
public class BOJ10974 {
    static int[] perArr;
    static boolean[] perCheck;
    static int n;
    static StringBuilder sb = new StringBuilder();

    static void permutation(int r) {
        if(r == n) { // 기저조건
            for(int x : perArr) {
                sb.append(x + " ");
            }
            sb.append("\n");
        } else {
            for(int i=0; i<n; i++) {
                if(!perCheck[i]){
                    perArr[r] = i+1;
                    perCheck[i] = true;
                    permutation(r+1);
                    perCheck[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        perArr = new int[n];
        perCheck = new boolean[n];

        permutation(0);
        System.out.println(sb);
    }
}
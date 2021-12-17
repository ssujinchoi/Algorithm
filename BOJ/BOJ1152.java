package BOJ;

import java.io.*;
//TODO: 2021.10.31. split()사용시 에러에 대한 포스팅 https://st-lab.tistory.com/65
public class BOJ1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");

        System.out.println(str.length);

    }
}
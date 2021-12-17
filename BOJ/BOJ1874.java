package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1874 {
    static String str = "";
    static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tmp = Integer.parseInt(br.readLine());

        for(int i=0; i<tmp; i++) {
            str += br.readLine();
        }
        System.out.println(str);
        return tmp;
    }
    static void stack(int n) {

    }
    public static void main(String[] args) throws IOException {
        int n = input();
        stack(n);
    }
}

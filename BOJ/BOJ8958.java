package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        char[] numbers;

        for(int i=0; i<T; i++) {
            int cnt = 0, sum = 0;
            numbers = br.readLine().toCharArray();
            for(int j=0; j<numbers.length; j++) {
                if(numbers[j] == 'O') {
                    cnt++;
                } else if(numbers[j] == 'X') {
                    cnt = 0;
                }
                sum += cnt;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}

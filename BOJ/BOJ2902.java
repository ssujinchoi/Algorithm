package BOJ;

import java.io.*;

public class BOJ2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isUpperCase(c)) {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
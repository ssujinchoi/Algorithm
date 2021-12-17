package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[26];
        String word = br.readLine().toUpperCase();


        for(int i=0; i<word.length(); i++) {
            alphabet[word.charAt(i) - 65]++;
        }

        int max = -1;
        char ch = '?';
        for(int i=0; i<alphabet.length; i++) {
            if(max < alphabet[i]) {
                max = alphabet[i];
                ch = (char) (i + 65);
            } else if(max == alphabet[i]) {
                ch = '?';
            }
        }
        System.out.println(ch);

    }
}

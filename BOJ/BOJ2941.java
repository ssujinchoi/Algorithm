package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TODO: 2021.11.01. 다시 한번 더 보고 다른 풀이법 찾아보기
public class BOJ2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;

        for(int i=0; i<str.length(); i++) {
            char x  = str.charAt(i);

            if(x == 'c') {
                if(i<str.length()-1 && str.charAt(i+1) == '=') i++;
                else if(i<str.length()-1 && str.charAt(i+1) == '-') i++;
            } else if(x == 'd') {
                if( i<str.length()-2 && str.charAt(i+1) == 'z' && str.charAt(i+2) =='=') i += 2;
                else if(i<str.length()-1 && str.charAt(i+1) == '-') i++;
            } else if(x == 'l' || x == 'n') {
                if(i<str.length()-1 && str.charAt(i+1) == 'j') i++;
            } else if(x == 's' || x == 'z') {
                if(i<str.length()-1 && str.charAt(i+1) == '=') i++;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}

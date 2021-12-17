package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> standard = new ArrayList<>();
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        String tmp = br.readLine();



        int t = n-1;
        while(t -- > 0) {
            for(int i=0; i<tmp.length(); i++) standard.add(tmp.charAt(i));
            int cnt = 0;
            String str = br.readLine();
            for(int i=0; i<str.length(); i++) {
                Character c = str.charAt(i);
                if(standard.contains(c)) {
                    standard.remove(c);
                } else {
                    cnt++;
                }
            }
            if(tmp.length() == str.length()) {
                if(cnt == 0) answer++;
                else if(cnt == 1) answer++;
            } else if(tmp.length() + 1 == str.length()) {
                if(cnt == 1) answer++;
            } else if(tmp.length() == str.length() + 1) {
                if(standard.size() == 1) answer++;
            }
            standard.clear();
        }

        System.out.println(answer);


    }
}


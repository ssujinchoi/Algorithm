package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Stack<Character> st;
        int cnt = 0;

        while(t-- > 0) {
            String str = br.readLine();
            st = new Stack<Character>();
            if(str.length() % 2 != 0) continue;

            for(char x : str.toCharArray()) {
                if(st.isEmpty()) st.push(x);
                else {
                    if(st.peek() == x) st.pop();
                    else if(st.peek() != x) st.push(x);
                }
            }
            if(st.isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String str = br.readLine();
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> st = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char x = str.charAt(i);
            if(Character.isLetterOrDigit(x)) {
                st.push((double)nums[x - 65]);
            } else {
                double b = st.pop();
                double a = st.pop();

                if(x == '+') st.push(a + b);
                else if(x == '-') st.push(a - b);
                else if(x == '/') st.push(a / b);
                else if(x == '*') st.push(a * b);
            }
        }
        System.out.println(String.format("%.2f", st.peek()));
    }
}

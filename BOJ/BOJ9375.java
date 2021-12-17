package BOJ;

import java.util.*;
import java.io.*;

public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> kindsmap;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- >0) {
            kindsmap = new HashMap<String, Integer>(); // [옷종류, 개수]
            int N = Integer.parseInt(br.readLine());

            for(int i=0; i<N; i++) { // 맵에 값을 넣어줌
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
                kindsmap.put(kind, kindsmap.getOrDefault(kind, 0) + 1);
            }
            System.out.println(kindsmap);

            int result = 1;
            for(int value : kindsmap.values()) {
               result *= (value + 1);

            }
            sb.append(result-1 + "\n");
        }
        System.out.println(sb);

    }
}

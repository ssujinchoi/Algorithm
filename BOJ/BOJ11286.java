package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        PriorityQueue<Integer> prque = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2) return o1 > o2 ? 1 : -1;
            return abs1 - abs2;
        });

        while(N-- >0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) { // 출력 및 삭제
                if(prque.isEmpty()) sb.append("0\n");
                else sb.append(prque.poll() + "\n");
            } else { // 값 추가
                prque.add(num);
            }
        }
        System.out.println(sb);
    }
}

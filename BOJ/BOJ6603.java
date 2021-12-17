package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
    static int N;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());
            if(N == 0) break; // 종료

            visited = new boolean[N+1];
            arr = new int[N+1];

            // 입력받은 배열 생성
            for(int i=1; i<=N; i++) {
                arr[i] = stoi(st.nextToken());
            }

            combination(1, 6);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void combination(int start, int depth) {
        if(depth == 0) {
            for(int i=1; i<=N; i++) {
                if(visited[i]) sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++) {
            visited[i] = true;
            combination(i+1, depth-1);
            visited[i] = false;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

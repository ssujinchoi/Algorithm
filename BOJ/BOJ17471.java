package BOJ;

import java.io.*;
import java.util.*;

public class BOJ17471 {
    static int n = 0, answer = 1000;
    static int[] persons;
    static boolean[] visited, chk;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> red;
    static ArrayList<Integer> blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = stoi(br.readLine());
        persons = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        // 지역별 인구수 입력
        for(int i=0; i<n; i++) {
            persons[i] = stoi(st.nextToken());
        }

        graph = new ArrayList<ArrayList<Integer>>();
        // 연결 지역 인접리스트 만들기
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<Integer>() );

            st = new StringTokenizer(br.readLine());
            int m = stoi(st.nextToken());
            for(int j=0; j<m; j++) {
                graph.get(i).add(stoi(st.nextToken())-1);
            }
        }

        // 1~(n/2)까지의 조합 구하기
        for(int i=1; i<(n/2)+1; i++) {
            combi(0, i);
        }

        if(answer == 1000) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    public static void combi(int start, int r) {
        if(r == 0) {
            red = new ArrayList<Integer>();
            blue = new ArrayList<Integer>();

            for(int i=0; i<n; i++) {
                if(visited[i] == true) red.add(i);
                else blue.add(i);
            }
            if(isPossible()) {
                int redsum = 0, bluesum = 0;
                for(int i=0; i<red.size(); i++) redsum += persons[red.get(i)];
                for(int i=0; i<blue.size(); i++) bluesum += persons[blue.get(i)];

                answer = Math.min(answer, Math.abs(redsum - bluesum));
            }
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combi(i+1, r-1);
            visited[i] = false;
        }
    }

    public static void dfs(int now, ArrayList<Integer> list) {
        for(int nxt : graph.get(now)) {
            if(!chk[nxt] && list.contains(nxt)) {
                chk[nxt] = true;
                dfs(nxt, list);
            }
        }
    }

    public static boolean isPossible() {
        chk = new boolean[n];

        chk[red.get(0)] = true;
        dfs(red.get(0), red);

        chk[blue.get(0)] = true;
        dfs(blue.get(0), blue);

        for(boolean x : chk) {
            if(x == false) return false;
        }
        return true;
    }
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

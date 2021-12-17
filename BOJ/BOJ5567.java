package BOJ;

import java.io.*;
import java.util.*;

public class BOJ5567 {
    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        int M = stoi(br.readLine());
        visited = new boolean[N];
        friends = new ArrayList[N];

        // 양방향 인접리스트 생성
        for(int i=0; i<N; i++) {
            friends[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            friends[a-1].add(b-1);
            friends[b-1].add(a-1);
        }

        bfs();
    }

    public static void bfs() {
        int answer = 0;
        Queue<Fi> que = new LinkedList<>();
        que.add(new Fi(0, 0));
        visited[0] = true;

        while(!que.isEmpty()) {
            Fi now = que.poll();
            int cn = now.node;
            int cd = now.depth;

            if(now.depth < 2) {
                int nd = cd + 1;
                for(int i=0; i<friends[cn].size(); i++) {
                    int nxt = friends[cn].get(i);
                    if(!visited[nxt]) {
                        visited[nxt] = true;
                        que.add(new Fi(nxt, nd));
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

class Fi {
    int node, depth;

    Fi(int node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

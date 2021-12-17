package BOJ;

import java.io.*;
import java.util.*;

public class BOJ14503 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int sy = stoi(st.nextToken());
        int sx = stoi(st.nextToken());
        int sd = stoi(st.nextToken());
        Now robot = new Now(sy, sx, sd); // 로봇시작 위치

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        int answer = bfs(robot);
        System.out.println(answer);
    }

    public static int bfs(Now robot) {
        int cnt = 0;

        Queue<Now> que = new LinkedList<>();
        que.add(robot);

        while(!que.isEmpty()) {

            Now now = que.poll();

            if(map[now.y][now.x] == 0) {
                map[now.y][now.x] = 2; // 1. 현재위치를 청소한다.
                cnt++;
            }

            boolean flag = false; // 사방이 막혔을 때 후진여부

            // 0 - 북, 1 - 동, 2 - 남, 3 - 서
            for(int i=0; i<4; i++) { // 2. 왼쪽부터 탐색한다.

                int nd = (now.d + 3) % 4;
                int ny = now.y + dy[nd];
                int nx = now.x + dx[nd];

                now.d = nd;

                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                if(map[ny][nx] == 0) {
                    que.add(new Now(ny, nx, nd));
                    flag = true;
                    break;
                }
            }

            // 3. 이동할 곳이 없다면 뒤로 후진
            if(!flag) {
                int backd = (now.d + 2) % 4;
                int backy = now.y + dy[backd];
                int backx = now.x + dx[backd];

                if(backy < 0 || backy >= N || backx < 0 || backx >= M) break;

                if(map[backy][backx] != 1) {
                    que.add(new Now(backy, backx, now.d));
                }
            }
        }

        return cnt;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

class Now {
    int y, x;
    int d;

    Now(int y, int x, int d) {
        this.y = y;
        this.x = x;
        this.d = d;
    }
}

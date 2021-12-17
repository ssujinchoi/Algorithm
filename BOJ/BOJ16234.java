package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ16234 {
    static int N, L, R;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static ArrayList<Pair> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = stoi(str[0]);
        L = stoi(str[1]);
        R = stoi(str[2]);

        map = new int[N][N];

        // 인구입력받기
        for(int i=0; i<N; i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                map[i][j] = stoi(tmp[j]);
            }
        }

        int answer = 0;
        // 업데이트가 있는동안 계속
        while(true) {
            boolean isUpdated = false;
            boolean[][] visited = new boolean[N][N]; // 방문 배열은 업데이트마다 초기화
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(move(i, j, visited)) isUpdated = true;
                }
            }
            if(!isUpdated) break;
            answer++;
        }

        System.out.println(answer);
    }

    public static boolean move(int y, int x, boolean[][] visited) {
        Queue<Pair> que = new LinkedList<>();
        list = new ArrayList<>(); // 국경이 열린 연합나라의 좌표와 갯수
        int sum = 0; // 연합나라의 인구합

        que.add(new Pair(y, x));

        while(!que.isEmpty()) {
            Pair now = que.poll();
            int cy = now.y;
            int cx = now.x;

            if(visited[cy][cx]) continue; // 이미 방문했던 곳이면 pass해야 메모리 초과가 안난다.

            visited[cy][cx] = true;
            list.add(now);
            sum += map[cy][cx];


            for(int i=0; i<4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue; // 범위밖이면 pass
                if(visited[ny][nx]) continue; // 이미 방문했던 곳이면 pass

                int diff = Math.abs(map[cy][cx] - map[ny][nx]);

                if(diff >= L && diff <= R)
                    que.add(new Pair(ny, nx));
            }
        }

        if(list.size() <= 1) return false;
        // 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)
        int tmp = sum / list.size();
        while(!list.isEmpty()) {
            Pair cur = list.remove(0);
            map[cur.y][cur.x] = tmp;
        }
        return true;
   }
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

class Pair {
    int y, x;

    Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
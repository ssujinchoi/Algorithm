package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14500 {
    static int N, M; // 세로 가로
    static int max = 0; // 최댓값
    static int[][] paper; // 종이
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        paper = new int[N][M];
        visited = new boolean[N][M];

        // 종이판 입력받기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                paper[i][j] = stoi(st.nextToken());
            }
        }

        // 0, 0좌표 부터 종이판 전체 탐색
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, paper[i][j]);
                exception(i, j);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    public static void dfs(int y, int x, int depth, int sum) {
        if(depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(!valCheck(ny, nx) || visited[ny][nx]) continue; // 종이 범위 밖일 때

            visited[ny][nx] = true;
            dfs(ny, nx, depth+1, sum+paper[ny][nx]);
            visited[ny][nx] = false;
        }
    }

    public static void exception(int y, int x) {
        int wing = 4;    // 가운데에서의 상하좌우 날개
        int min = Integer.MAX_VALUE;
        int sum = paper[y][x];

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (wing <= 2)
                return;

            if (!valCheck(ny, nx)) {
                wing--;
                continue;
            }
            min = Math.min(min, paper[ny][nx]);
            sum = sum + paper[ny][nx];
        }
        //날개가 4개일때 가장 작은 날개를 없애야 ㅗ,ㅏ,ㅓ,ㅜ 모양이 나온다.
        if (wing == 4) {
            sum = sum - min;
        }
        max = Math.max(max, sum);
    }

    public static boolean valCheck(int ny, int nx) {
        if(ny < 0 || ny >= N || nx < 0 || nx >= M) return false;
        return true;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}


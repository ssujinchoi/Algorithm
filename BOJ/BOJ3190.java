package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3190 {
    static int[][] map;
    static int N, K, L;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static ArrayList<int[]> snake;
    static HashMap<Integer, String> command = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());
        K = stoi(br.readLine()); // 사과의 개수

        map = new int[N+1][N+1];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = stoi(st.nextToken());
            int x = stoi(st.nextToken());
            map[y][x] = 1;
        }

        L = stoi(br.readLine());
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            command.put(stoi(st.nextToken()), st.nextToken());
        }

        int answer = move(1, 1);
        System.out.println(answer);
    }

    public static int move(int y, int x) {
        snake = new ArrayList<>();
        snake.add(new int[]{y, x});

        int time = 0;
        int d = 0; // 0 - 오, 1-아래, 2-왼, 3-위

        map[y][x] = 2;

        while(true) {
            time++;
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(!valCheck(ny, nx)) break;

            if(map[ny][nx] == 1) { // 사과가 있으면
                map[ny][nx] = 2;
                snake.add(new int[]{ny, nx});
            } else {
                map[ny][nx] = 2;
                snake.add(new int[]{ny, nx});
                map[snake.get(0)[0]][snake.get(0)[1]] = 0;
                snake.remove(snake.get(0));

            }

            y = ny;
            x = nx;

            if(command.containsKey(time)) {
                if(command.get(time).equals("D")) { // 오른쪽으로 90도
                    d = (d+1) % 4;
                } else if(command.get(time).equals("L")) { // 왼쪽으로 90도
                    d = (d+3) % 4;
                }
            }
        }

        return time;
    }

    public static boolean valCheck(int ny, int nx) {
        if(ny < 1 || ny > N || nx < 1 || nx > N) return false;
        if(map[ny][nx] == 2) return false;
        return true;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {
    static int N, M, K;
    static int[][] map;
    static int[] dy = {0, 0, 0, -1, 1};
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dice = new int[7]; // 1상, 2뒤, 3오, 4왼, 5앞, 6하
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        int y = stoi(st.nextToken());
        int x = stoi(st.nextToken());
        K = stoi(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while(K-- > 0) {
            int d = stoi(st.nextToken());
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue; // 범위 밖이면 pass
            roll(d); // 주사위 굴리기

            // 이동한 칸이 0이면 주사위바닥값 -> 칸으로 복사
            if(map[ny][nx] == 0) map[ny][nx] = dice[6];
            // 이동한 칸이 0이아니면 칸의값 -> 주사위 바닥으로 복사
            else if(map[ny][nx] != 0) {
                dice[6] = map[ny][nx];
                map[ny][nx] = 0 ;
            }
            y = ny;
            x = nx;

            sb.append(dice[1]).append("\n");
        }

        System.out.println(sb);

    }

    // 주사위 굴리기
    public static void roll(int d) {
        int[] tmp = dice.clone();

        switch(d) {
            case 1:
                dice[1] = tmp[4];
                dice[3] = tmp[1];
                dice[4] = tmp[6];
                dice[6] = tmp[3];
                break;
            case 2:
                dice[1] = tmp[3];
                dice[3] = tmp[6];
                dice[4] = tmp[1];
                dice[6] = tmp[4];
                break;
            case 3:
                dice[1] = tmp[5];
                dice[2] = tmp[1];
                dice[5] = tmp[6];
                dice[6] = tmp[2];
                break;
            case 4:
                dice[1] = tmp[2];
                dice[2] = tmp[6];
                dice[5] = tmp[1];
                dice[6] = tmp[5];
                break;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

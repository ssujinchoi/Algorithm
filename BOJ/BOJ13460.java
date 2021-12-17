package BOJ;

import java.io.*;
import java.util.*;

public class BOJ13460 {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int holeY, holeX;
    static Ball red, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = stoi(str[0]);
        M = stoi(str[1]);
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        // 보드 입력받기
        for(int i=0; i<N; i++) {
            String tmp = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = tmp.charAt(j);
                if(board[i][j] == 'O') {
                    holeY = i;
                    holeX = j;
                } else if(board[i][j] == 'R') {
                    red = new Ball(i, j, 0, 0, 0);
                } else if(board[i][j] == 'B') {
                    blue = new Ball(0, 0, i, j, 0);
                }
            }
        }

        int answer = bfs();
        System.out.println(answer);
    }

    public static int bfs() {
        Ball ball = new Ball(red.ry, red.rx, blue.by, blue.bx, 1); // 홀에 빠지면 count 할수없으므로 움직일때부터 count해야함.

        Queue<Ball> que = new LinkedList<>();
        que.add(ball);
        visited[ball.ry][ball.rx][ball.by][ball.bx] = true;

        while(!que.isEmpty()) {

            Ball now = que.poll();

            int nowRy = now.ry;
            int nowRx = now.rx;
            int nowBy = now.by;
            int nowBx = now.bx;
            int nowCnt = now.cnt;

            if(nowCnt > 10) return -1; // 이동횟수가 10 초과시 실패

            for(int i=0; i<4; i++) {
                int nxtRy = nowRy;
                int nxtRx = nowRx;
                int nxtBy = nowBy;
                int nxtBx = nowBx;

                boolean isRed = false, isBlue = false;

                while(board[nxtRy + dy[i]][nxtRx + dx[i]]  != '#') { // 빨간공 # 만날때까지 이동
                    nxtRy += dy[i];
                    nxtRx += dx[i];

                    if(nxtRy == holeY && nxtRx == holeX) { // 빨간공이 구멍에 빠지는지 확인
                        isRed = true;
                        break;
                    }
                }

                while(board[nxtBy + dy[i]][nxtBx + dx[i]] != '#') { // 파란공 # 만날때까지 이동
                    nxtBy += dy[i];
                    nxtBx += dx[i];

                    if(nxtBy == holeY && nxtBx == holeX) { // 파란공이 구멍에 빠지는지 확인
                        isBlue = true;
                        break;
                    }
                }

                if(isBlue) continue; // 파란공이 빠지면 실패지만 다른 경로도 있을 수 있으므로 계속 탐색해본다.
                if(isRed && !isBlue) return nowCnt; // 빨간공만 빠지면 무조건 성공이다.

                if(nxtRy == nxtBy && nxtRx == nxtBx) { // 같은 위치로 이동할 때 좌표(r, b자리) 조정
                    if(i == 0) {
                        if(nowRy > nowBy) nxtRy += 1;
                        else nxtBy += 1;
                    } else if(i == 1) {
                        if(nowRx > nowBx) nxtRx += 1;
                        else nxtBx += 1;
                    } else if(i == 2) {
                        if(nowRy > nowBy) nxtBy -= 1;
                        else nxtRy -= 1;
                    } else if(i == 3) {
                        if(nowRx > nowBx) nxtBx -= 1;
                        else nxtRx -= 1;
                    }
                }

                if(!visited[nxtRy][nxtRx][nxtBy][nxtBx]) {
                    visited[nxtRy][nxtRx][nxtBy][nxtBx] = true;
                    que.add(new Ball(nxtRy, nxtRx, nxtBy, nxtBx, nowCnt+1));
                }

            }

        }

        return -1;
    }
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

class Ball {
    int ry, rx;
    int by, bx;
    int cnt;

    Ball(int ry, int rx, int by, int bx, int cnt) {
        this.ry = ry;
        this.rx = rx;
        this.by = by;
        this.bx = bx;
        this.cnt = cnt;

    }
}
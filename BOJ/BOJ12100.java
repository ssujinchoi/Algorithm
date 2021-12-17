package BOJ;

import java.io.*;
import java.util.*;

public class BOJ12100 {
    static int N, max = Integer.MIN_VALUE;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][] board, copyBoard;
    static int[] permu = new int[5];
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); // 보드크기
        board = new int[N][N];

        // 1. 보드 입력받기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = stoi(st.nextToken());

            }
        }

        permutation(0, 5);

        System.out.println(max);

    }

    // 2. 방향순열 설정
    public static void permutation(int depth, int r) {
        if(depth == r) {
            direction();
            return;
        }

        for(int i=0; i<4; i++) {
            permu[depth] = i;
            permutation(depth+1, 5);
        }
    }

    public static void direction() {
        copyBoard = new int[N][N]; // 복사판 생성
        for(int i=0; i<N; i++) {
            copyBoard[i] = board[i].clone();
        }

        for(int k=0; k<permu.length; k++) {
            visited = new boolean[N][N]; // 합쳐진 여부 확인
            int x = permu[k];

            switch(x) {
                case 0: // 상 - 위쪽부터 위로
                    for(int i=0; i<N; i++) {
                        for(int j=0; j<N; j++) {
                            if(copyBoard[i][j] != 0) move(i, j, 0);
                        }
                    }
                    break;
                case 1: // 좌 - 왼쪽부터 왼쪽으로
                    for(int i=0; i<N; i++) {
                        for(int j=0; j<N; j++) {
                            if(copyBoard[j][i] != 0) move(j, i, 1);
                        }
                    }
                    break;
                case 2: // 하 - 아래부터 아래쪽으로
                    for(int i=N-1; i>=0; i--) {
                        for(int j=0; j<N; j++) {
                            if(copyBoard[i][j] != 0) move(i, j, 2);
                        }
                    }
                    break;
                case 3: // 우 - 오른쪽부터 오른쪽으로
                    for(int i=N-1; i>=0; i--) {
                        for(int j=0; j<N; j++) {
                            if(copyBoard[j][i] != 0) move(j, i, 3);
                        }
                    }
                    break;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                max = Math.max(max, copyBoard[i][j]);
            }
        }
    }

    public static void move(int y, int x, int d) {
        while(true) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny < 0 || ny >= N || nx < 0 || nx >= N) return; // 범위밖이면 종료

            if(visited[ny][nx]) return; // 이미 합쳐진 숫자라면 종료

            if(copyBoard[ny][nx] != 0) {
                if(copyBoard[y][x] == copyBoard[ny][nx]) { // 숫자가 같으면
                    visited[ny][nx] = true; // 합쳐짐 표시
                    copyBoard[ny][nx] *= 2;
                    copyBoard[y][x] = 0;
                }
                return;
            }

            copyBoard[ny][nx] = copyBoard[y][x];
            copyBoard[y][x] = 0;
            y = ny;
            x = nx;
        }
    }
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
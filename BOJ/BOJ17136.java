package BOJ;

import java.io.*;
import java.util.*;

public class BOJ17136 {
    static int[][] map;
    static int paperState[] = { 0, 5, 5, 5, 5, 5}; // 색종이 총 다섯 종류 , 각 5개씩 몇 개 사용했나...
    static int n = 10, answer = 26, oneCnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 1이 적힌 칸
                if (map[i][j] == 1) oneCnt++;
            }
        }

        go(0, 0);

        System.out.println(answer == 26 ? -1 : answer);
    }

    private static void go(int idx, int paperCnt) {
        // 색종이를 최소로 사용한 경우보다 많이 사용한 경우 return
        if (answer <= paperCnt) return;
        // 모두 탐색이 끝났을 때
        if (idx == n * n) {
            // 모든 1을 못 덮었다면
            if (oneCnt != 0) return;
            // 모든 1을 덮었다면
            // 사용한 색종이의 최소 개수 갱신
            answer = Math.min(answer, paperCnt);
            return;
        }

        int r = idx / n;
        int c = idx % n;

        // 색종이를 붙일수 있는 칸이면
        if (map[r][c] == 1) {
            // 다섯 종류의 색종이를 붙여보자
            for (int p = 5; p >= 1; p--) {
                // 해당 크기 색종이를 모두 사용했으면 pass
                if (paperState[p] == 0) continue;
                // 해당 크기 색종이로 붙일 수 있나 확인
                if (check(r, c, p)) {
                    // 붙일 수 있다면 붙이고(oneCnt 감소)
                    setPaper(r, c, p, true);
                    paperState[p]--;

                    // 다음 위치로
                    go(idx + 1, paperCnt + 1);

                    // 돌아오면 다시 스티꺼 떼어내기(oneCnt 증가)
                    setPaper(r, c, p, false);
                    paperState[p]++;
                }
            }
        } else {
            // 색종이를 붙일 수 없는 경우
            go(idx + 1, paperCnt);
        }

    }

    private static void setPaper(int r, int c, int p, boolean isPut) {

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < p; j++) {
                // 스티커를 붙일 경우
                if (isPut) {
                    // 색종이를 붙이고
                    map[r + i][c + j] = 0;
                    // 전체 1 개수 감소
                    oneCnt--;
                } else {
                    // 색종이를 떼어내고
                    map[r + i][c + j] = 1;
                    // 전체 1 개수 다시 증가
                    oneCnt++;
                }
            }
        }

    }
    private static boolean check(int r, int c, int p) {

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < p; j++) {
                // 범위를 벗어날 경우
                if (r + i >= n || c + j >= n) return false;
                // 붙일 자리에 1이 없다면 붙일 수 없음
                if (map[r + i][c + j] != 1) return false;
            }
        }

        return true;
    }

}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: 체스판 다시 칠하기
public class BOJ1018 {
    static char[][] board; // 입력되는 N*M의 보드판 w , b
    static int min = 64; // 8 * 8
    static final char[][] w_start = { // (0,0)이 W일 때 규칙
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };

    static final char[][] b_start = { // (0,0)이 B일 때 규칙
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for(int i=0; i<n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int n_row = n - 7;
        int m_col = m - 7;

        for(int i=0; i<n_row; i++) {
            for(int j=0; j<m_col; j++) {
                chess(i, j);
            }
        }
        System.out.println(min);
    }

    static void chess(int x, int y) {
        int end_x = x + 7;
        int end_y = y + 7;
        int cnt = 0;

        for(int i=0; i<=end_x; i++) { // 8 * 8체스판 비교
            for(int j=0; j<=end_y; j++) {

            }
       }
    }
}

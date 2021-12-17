package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14890 {
    static int N, L;
    static int[][] map;
    static int answer = 0;
    static Stack<Stair> row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        L = stoi(st.nextToken());
        map = new int[N][N];


        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        row = new Stack<>();
        col = new Stack<>();

        for(int i=0; i<N; i++) {
            row.push(new Stair(map[i][0], 1));
            col.push(new Stair(map[0][i], 1));
            for(int j=1; j<N; j++) {
                Stair stair = row.peek();
                if(stair.height == map[i][j]) stair.cnt++;
                else row.push(new Stair(map[i][j], 1));

                stair = col.peek();
                if(stair.height == map[j][i]) stair.cnt++;
                else col.push(new Stair(map[j][i], 1));
            }

            if(check(row)) answer++;
            if(check(col)) answer++;

            row.clear();
            col.clear();
        }

        System.out.println(answer);
    }

    public static boolean check(Stack<Stair> stack) {

        while(stack.size() > 1) {
            Stair cur = stack.pop();
            Stair nxt = stack.peek();

            if(cur.height > nxt.height) { // 현재 길보다 다음 길이 낮을때
                if(nxt.cnt < L || cur.height - nxt.height > 1) { // 경사로 길이보다 개수가 적거나, 높이차이가 1을 넘으면 경사로를 놓을 수 없다.
                    return false;
                } else {
                    nxt.cnt -= L;
                }
            } else { // 현재길보다 다음길이 높을 때
                if(cur.cnt < L || nxt.height - cur.height > 1) return false;
            }
        }
        return true;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

class Stair {
    int height, cnt;

    Stair(int height, int cnt) {
        this.height = height;
        this.cnt = cnt;
    }
}
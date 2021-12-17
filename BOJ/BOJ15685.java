package BOJ;

import java.io.*;
import java.util.*;

public class BOJ15685 {
    static int N; // 드래곤 커브의 개수
    static int[][] map = new int[101][101];
    static ArrayList<Integer> list;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());

        StringTokenizer st;
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            int d = stoi(st.nextToken());
            int g = stoi(st.nextToken());

            drawCurve(x, y, d, g);
        }


        int answer = search();
        System.out.println(answer);
    }

    // 드래곤커브 그리기
    public static void drawCurve(int x, int y, int d, int g) {
        list = new ArrayList<>();
        list.add(d);

        for(int i=1; i<=g; i++) {
            for(int j=list.size()-1; j>=0; j--) {
                int end = list.get(j);
                list.add((end+1) % 4);
            }
        }

        map[y][x] = 1;
        for(Integer nxt : list) {
            x += dx[nxt];
            y += dy[nxt];
            map[y][x] = 1;
        }
    }

    // 네 꼭지점 표시된 정사각형 찾기
    public static int search() {
        int cnt = 0;
        for(int i=0; i<101; i++) {
            for(int j=0; j<101; j++) {
                if(map[i][j] == 1 && map[i][j+1] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

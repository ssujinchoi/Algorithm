package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15683 {
    static int N, M, blind = 0, cnt = 0;
    static int answer = Integer.MAX_VALUE;
    static int[][] map, copyMap;
    static int[] permu;
    static ArrayList<CCTV> list = new ArrayList<CCTV>();
    static int[] dy = {-1, 0, 1, 0}; // 상 좌 하 우 cctv 회전방향
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); // 세로
        M = stoi(st.nextToken()); // 가로
        map = new int[N][M];

        // 1. 맵 입력 및 cctv리스트 받기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = stoi(st.nextToken());

                if(map[i][j] >= 1 && map[i][j] <= 5) {
                    list.add(new CCTV(i, j, map[i][j]));
                    blind++;
                } else if(map[i][j] == 6) blind++;
            }
        }

        permu = new int[list.size()]; // 순열
        permutation(0, list.size());

        System.out.println(answer);
    }

    // 2. cctv의 4가지 방향 중 cctv개수인 r만큼을 뽑는 순열
    public static void permutation(int depth, int r) {
        if(depth == r) { // cctv개수만큼 순열을 뽑았을 때

            // copy map

            copyMap = new int[N][M];
            for(int i=0; i<map.length; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, map[i].length);
            }
            cnt = 0;

            int tmp = direction();
            answer = Math.min(answer, (N*M) - tmp);
            return;
        }

        CCTV now = list.get(depth);

        // 0-상, 1-좌, 2-하, 3-우 cctv 회전방향
        if(now.kind == 2) {
            for(int i=0; i<2; i++) {
                permu[depth] = i;
                permutation(depth+1, r);
            }
        } else if(now.kind == 5) {
            permu[depth] = 0;
            permutation(depth+1, r);
        } else {
            for(int i=0; i<4; i++) {
                permu[depth] = i;
                permutation(depth+1, r);
            }
        }
    }

    // 3. 순열에 따른 감시 방향 설정
    public static int direction() {
        for(int i=0; i<list.size(); i++) {
            int type = list.get(i).kind;

            switch(type) {
                case 1:
                    check(list.get(i), permu[i]);
                    break;
                case 2:
                    if(permu[i] == 0) {
                        check(list.get(i), 0);
                        check(list.get(i), 2);
                    } else if(permu[i] == 1) {
                        check(list.get(i), 1);
                        check(list.get(i), 3);
                    }
                    break;
                case 3:
                    check(list.get(i), permu[i]);
                    check(list.get(i), (permu[i] + 3) % 4);
                    break;
                case 4:
                    check(list.get(i), permu[i]);
                    check(list.get(i), (permu[i] + 3) % 4);
                    check(list.get(i), (permu[i] + 1) % 4);
                    break;
                case 5:
                    check(list.get(i), 0);
                    check(list.get(i), 1);
                    check(list.get(i), 2);
                    check(list.get(i), 3);
                    break;
            }
        }
        return blind+cnt;
    }

    // 4. 감시방향 표시 및 사각지대 체크
    public static void check(CCTV cctv, int d) {
        int ny = cctv.y;
        int nx = cctv.x;

        while(ny >= 0 && nx >=0 && ny < N && nx < M) { // 범위안일때만 체크
            if(copyMap[ny][nx] == 0) {
                copyMap[ny][nx] = cctv.kind;
                cnt++;
            } else if(copyMap[ny][nx] == 6) { // 벽을 만나면 cctv체크범위 종료
                break;
            }

            ny = ny + dy[d];
            nx = nx + dx[d];
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

class CCTV {
    int y, x; // 좌표값
    int kind; // 종류

    CCTV(int y, int x, int kind) {
        this.y = y;
        this.x = x;
        this.kind = kind;
    }
}

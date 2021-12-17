package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236 {
    static int n, time = 0, eat = 0, size = 2;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static Fish babyShark;
    static ArrayList<Fish> fishList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        // 1. 상어위치 입력받기
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = stoi(st.nextToken());
                if(map[i][j] == 9) {
                    babyShark = new Fish(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        move();
        System.out.println(time);
    }

    public static void move() {
        while(true) {
            fishList = new ArrayList<>();
            visited = new boolean[n][n];
            Queue<Fish> que = new LinkedList<>();
            que.add(babyShark);

            while(!que.isEmpty()) {
                Fish shark = que.poll();

                int cy = shark.y;
                int cx = shark.x;
                int cd = shark.dis;

                for(int i=0; i<4; i++) { // 상하좌우를 탐색하면서 먹을 수 있는 물고기의 위치와 거리를 구한다.
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];

                    if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue; // 범위밖이면 pass
                    if(visited[ny][nx]) continue; // 방문한 곳이면 pass
                    if(map[ny][nx] > size) continue; // 아기상어 자신보다 큰 물고기 칸은 지나갈 수 없으므로 pass

                    if(map[ny][nx] == 0 || map[ny][nx] == size) { // 0이거나 크기가 같아서 지나갈 수 만 있는 곳
                        que.add(new Fish(ny, nx, cd + 1)); // 상어 위치를 갱신
                        visited[ny][nx] = true;
                    } else if(1 <= map[ny][nx] && map[ny][nx] < size) { // 1이상이면서 상어보다 작은 물고기만 먹을 수 있다.
                        que.add(new Fish(ny, nx, cd + 1));
                        fishList.add(new Fish(ny, nx, cd + 1));
                        visited[ny][nx] = true;
                    }
                }
            }

            if(fishList.size() == 0) { // fishList가 0 이면 먹을 수 있는 물고기가 더이상 없다는 뜻.
                return;
            }

            // 먹을 물고기가 있을 때
            Fish okFish = fishList.get(0);
            for(int i=1; i<fishList.size(); i++) {
                if(okFish.dis > fishList.get(i).dis) { // 거리가 제일 가까운 물고기 고르기
                    okFish = fishList.get(i);
                } else if(okFish.dis == fishList.get(i).dis) { // 거리가 같다면 제일 위쪽이자 왼쪽의 물고기 고르기
                    if(okFish.y > fishList.get(i).y) okFish = fishList.get(i);
                    else if(okFish.y == fishList.get(i).y) {
                        if(okFish.x > fishList.get(i).x) okFish = fishList.get(i);
                    }
                }
            }

            time += okFish.dis;
            eat++;
            map[okFish.y][okFish.x] = 0;

            if(eat == size) {
                size++; // 먹은 횟수와 상어의 크기가 같으면 사이즈+1
                eat = 0;
            }

            babyShark = new Fish(okFish.y, okFish.x, 0);
        }

    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

class Fish {
    int y, x, dis;

    Fish(int y, int x, int dis) {
        this.y = y;
        this.x = x;
        this.dis = dis;
    }
}

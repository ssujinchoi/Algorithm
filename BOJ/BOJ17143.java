//package BOJ;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class BOJ17143 {
//    static int r, c, m;
//    static Shark[][] sea;
//    static int[] dy = {-1, 0, 1, 0}; // 원래는 1234(상하우좌)이지만 계산을 편하게 하기위해
//    static int[] dx = {0, -1, 0, 1 }; // 0123(상좌하우)로 변경
//    static ArrayList<Shark> sharkList = new ArrayList<>();
//    static int answer;
//    static int cnt = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        r = stoi(st.nextToken());
//        c = stoi(st.nextToken());
//        m = stoi(st.nextToken());
//
//        sea = new Shark[r+1][c+1];
//
//        // 1. 상어정보 담기
//        for(int i=0; i<m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int y = stoi(st.nextToken());
//            int x = stoi(st.nextToken());
//            int s = stoi(st.nextToken());
//            int d = stoi(st.nextToken());
//            int z = stoi(st.nextToken());
//
//            // 0123(상좌하우)로 변경
//            if(d == 1) d = 0;
//            else if(d == 4) d = 1;
//
//            if(d == 0 || d == 2) {
//                s %= (r-1) * 2;
//            } else if(d == 1 || d == 3) {
//                s %= (c-1) * 2;
//            }
//
////            System.out.println("속:" + s + "방:" + d);
//            sea[y][x] = new Shark(y, x, s, d, z);
//        }
//
//        for(int i=1; i<=c; i++) {
//            fishing(i);
//            sharkMove();
//        }
//        System.out.println(answer);
//    }
//
//    // 2. 가장 가까운 물고기 낚시하기
//    public static void fishing(int x) {
//        for(int y=1; y<=r; y++) {
//            if(sea[y][x] != null) {
//                answer += sea[y][x].z;
//                sea[y][x] = null;
//                break;
//            }
//        }
//    }
//
//    public static void sharkMove() {
//        // 낚시 후 남아있는 물고기를 list에 담는다.
//        for(int i=1; i<=r; i++) {
//            for(int j=1; j<=c; j++) {
//                if(sea[i][j] != null)
//                    sharkList.add(new Shark(i, j, sea[i][j].s, sea[i][j].d, sea[i][j].z));
//            }
//        }
//
//        sea = new Shark[r+1][c+1]; // 상어맵을 초기화 - 같은 크기의 상어를 잡어먹기 쉽게 하기 위해
//
//        // 3. 상어 이동시키기
//        for(int i=sharkList.size(); i>0; i--) {
//            Shark cur = sharkList.remove(0);
//
//            for(int sp=0; sp<cur.s; sp++) {
//                int ny = cur.y + dy[cur.d];
//                int nx = cur.x + dx[cur.d];
//
//                if(ny < 1 || ny >= r+1 || nx < 1 || nx >= c+1) { // 상어가 경계에 부딪히면...
//                    cur.y -= dy[cur.d];
//                    cur.x -= dx[cur.d];
//                    cur.d = (cur.d + 2) % 4; // 방향 반대로 바꾸기
//                    continue;
//                }
//
//                cur.y = ny;
//                cur.x = nx;
//
//            }
//
//            if(sea[cur.y][cur.x] == null) { // 이동한 위치에 어떤 상어도 없으면
//                sea[cur.y][cur.x] = new Shark(cur.y, cur.x, cur.s, cur.d, cur.z);
//            } else { // 이동한 위치에 다른 상어가 있다면
//                if(sea[cur.y][cur.x].z < cur.z) {
//                    sea[cur.y][cur.x] = new Shark(cur.y, cur.x, cur.s, cur.d, cur.z);
//                }
//            }
//        }
//
//
//    }
//
//    public static int stoi(String s) {
//        return Integer.parseInt(s);
//    }
//}
//
//class Shark {
//    int y, x;
//    int s, d, z;
//
//    Shark(int y, int x, int s, int d, int z) {
//        this.y = y;
//        this.x = x;
//        this.s = s;
//        this.d = d;
//        this.z = z;
//    }
//}

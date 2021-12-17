package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 백준 숨바꼭질
public class BOJ1697 {
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        if(N == K) System.out.println(0);
        else System.out.println(bfs(N, K));
    }

    public static int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int minTime=0;
        q.offer(n);
        visited[n] = true;

        while(!q.isEmpty()) {
            if(visited[k]) break; // 동생에게 도착하면...
            int qsize = q.size();
            minTime++;

            for(int i=0; i<qsize; i++) {
                int now = q.poll();
                if(now-1 >= 0 && !visited[now-1]) {
                    q.offer(now-1);
                    visited[now-1] = true;
                }
                if(now+1 <= 100000 && !visited[now+1]) {
                    q.offer(now+1);
                    visited[now+1] = true;
                }
                if(now*2 <= 100000 && !visited[now*2]) {
                    q.offer(now * 2);
                    visited[now * 2] = true;
                }
            }
        }


        return minTime;
    }
}

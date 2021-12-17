package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 뱀과사다리게임. 최소 몇번만에 갈 수 있는가? -> BFS
// 사다리와 뱀을 만났을 경우 +인지 -인지는 중요하지 않다. 왜냐면, 이미 이동번호가 나와있으므로 from->to 어디로 가는지만 중요함
// 큐에 넣다뺐다 하는것을 잘 이해하자!!
public class BOJ16928 {
    static boolean[] visited = new boolean[101]; // 게임판
    static int[] fromTo = new int[101]; // 사다리와 뱀의 자리
    static int[] count = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사다리 수 (현 숫자보다 올라간다)
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수 (현 숫자보다 내려간다)

        for(int i=1; i<=N+M; i++) { // 배열에 사다리와 뱀의 이동경로를 담아준다.
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            fromTo[from] = to;
        }
        bfs();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1); // 큐에 1을 넣는다.
        visited[1] = true; // 1번방문


        while(!q.isEmpty()) { // 큐가 비어있지않을 동안
            int element = q.poll();
            if(element == 100) { // 100번째면 끝
                System.out.println(count[element]);
                return;
            }

            for(int i=1; i<=6; i++) { // 주사위 던진다.
                int x = element + i; // 현재 값 + 주사위 값
                if(x>100) continue;
                if(visited[x]) continue;
                visited[x] = true;

                if(fromTo[x] != 0) { // 사다리 또는 뱀의 위치일때
                    if(!visited[fromTo[x]]) {
                        q.offer(fromTo[x]);
                        visited[fromTo[x]] = true;
                        count[fromTo[x]] = count[element] + 1;
                    }
                } else { // 아무것도 없을 때 = 그냥 칸
                    q.offer(x);
                    count[x] = count[element] + 1;
                }
            }
        }
    }
}


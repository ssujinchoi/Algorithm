package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1107 {
    static boolean[] broken = new boolean[10]; // 번호 고장 여부 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int m = stoi(br.readLine());

        StringTokenizer st;
        if(m != 0) {
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<m; i++) {
                int x = stoi(st.nextToken());
                broken[x] = true; // 고장난 번호 저장
            }
        }

        int answer = Math.abs(n - 100); // +, -로만 움직였을 때, 기본 최솟값 설정

        // 0~999999까지 모든 채널을 돌면서 가장 적게 버튼을 눌러 n으로 이동할 수 있는 채널을 찾는다.
        for(int i=0; i<1000000; i++) {
            int len = isPossible(String.valueOf(i)); // 현재 번호를 만들 수 있는 버튼이 고장났는지 확인
            if(len > 0) { // len이 0이상이면 len의 값이 i번호를 만들기 위한 버튼 횟수
                int cnt = Math.abs(n - i) + len; // 목표번호에서 i번호를 뺀값(+,-로 움직임) + i번호의 길이
                answer = Math.min(answer, cnt); // +, -만 누른것과 i번호를 누른 후 +,- 한 것중 최솟값을 반환
            }
        }

        System.out.println(answer);
    }

    public static int isPossible(String channel) {
        int len = channel.length(); // 만약 105번을 검사한다면 105의 길이는 3 == 버튼을 3번 눌렀다.
        boolean ok = true;
        for(int i=0; i<len; i++) {
            if(broken[channel.charAt(i) - '0']) { // broken에서 1, 0, 5가 고장나지 않았는지 확인
                ok = false;
                return 0; // 고장 났다면 탐색종료
            }
        }
        return len;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

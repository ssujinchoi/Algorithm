package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 백준 비밀번호 찾기
// N만큼 사이트 주소와 비밀번호를 받아서 공백을 기준으로 Key, value 나눠서 맵에 담아준다.
// M만큼 반복문을 돌면서 찾고자 하는 사이트(key)정보로 맵에서 비밀번호(value) 출력
public class BOJ17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> pwmap = new HashMap<String, String>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pwmap.put(st.nextToken(), st.nextToken());
        }

        while(M-- >0) {
            sb.append(pwmap.get(br.readLine()) + "\n");
        }
        System.out.println(sb);
    }
}

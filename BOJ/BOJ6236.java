package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6236 {
    static int N, M;
    static int left = Integer.MIN_VALUE, right = 0, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        arr = new int[N];

        // 입력받기
        for(int i=0; i<N; i++) {
            arr[i] = stoi(br.readLine());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }
        answer = right;
        binary_search();
    }

    // 이분탐색
    public static void binary_search() {
        int mid = 0;

        while(left <= right) {
            mid = (left + right) / 2;
            if(check(mid) <= M) {
                answer = Math.min(answer, mid);
                right = mid-1;
            } else if(check(mid) > M){
                left = mid+1;
            }
        }

        System.out.println(answer);
    }

    // 금액에 따른 인출횟수 구하기
    public static int check(int m) {
        int cnt = 1, money = m;
        for(int i=0; i<arr.length; i++) {
            if(money < arr[i]) {
                money = m;
                cnt+=1;
            }
            money -= arr[i];
        }
        return cnt;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

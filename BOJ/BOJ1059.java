package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1059 {
    public static void main(String[] args) throws IOException {
        // 입력부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int L = stoi(br.readLine()); // 집합의 크기
        int[] arr = new int[L]; // 집합을 담은 배열

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++) {
            arr[i] = stoi(st.nextToken());
        }

        int N = stoi(br.readLine()); // n을 포함하는지 확인
        Arrays.sort(arr); // 혹시모를 정렬...필요

        int left = -1; // 왼쪽 // 0으로 설정하면 예를 들어 집합이 4 13 14이고 n이 2이면 left가 0이라서 조건문에 걸리는 것이없다. 그래서 첨부터0으로 잡아놓으면 for문을 빠져나갈 방법이 없다.
        int right = 1001; // 오른쪽
        for(int i=0; i<arr.length; i++) {
            if(arr[i] < N) {
                left = arr[i];
            } else if(arr[i] > N) {
                if(right > arr[i]) right = arr[i];
            } else { // 이미 배열에 있다면 0출력
                System.out.println(0);
                return;
            }
            if(left != -1 && right != 1001) break; // 2개의 값이 모두 설정되면 바로 반복문을 나가야함.
        }

        if(left == -1) left = 0;

        int count = 0;
        for(int i=left+1; i<=N; i++) {
            for(int j=N; j<=right-1; j++) {
                if(i == j) continue;

                count++;
            }
        }
        sb.append(count);

        System.out.println(sb);
    }
    
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

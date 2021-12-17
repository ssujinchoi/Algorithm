package BOJ;

import java.io.*;
import java. util.*;

public class BOJ2512 {
    static int[] arr;
    static int n, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = stoi(br.readLine());
        arr =  new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = stoi(st.nextToken());
        }
        target = stoi(br.readLine());

        Arrays.sort(arr);
        int answer = binarySearch();
        System.out.println(answer);
    }

    public static int binarySearch() {
        int left = 1;
        int right = arr[n-1];
        int mid = 0, answer = 0;

        while(left <= right) {
            mid = (left+right) / 2;
            if(isPossible(mid)) {
                left = mid+1;
                answer = mid;
            } else {
                right = mid-1;
            }
        }
        return answer;
    }

    public static boolean isPossible(int m) {
        int sum = 0;
        for(int x : arr) {
            sum += Math.min(m, x);
        }

        if(sum <= target) return true;
        return false;
    }

    public static int stoi(String s ) {
        return Integer.parseInt(s);
    }
}

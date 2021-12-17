package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10815 {
    static int n, m;
    static int cards[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = stoi(br.readLine());
        cards = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<cards.length; i++) {
            cards[i] = stoi(st.nextToken());
        }
        Arrays.sort(cards);

        m = stoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int target = stoi(st.nextToken());
            if(check(target)) {
                sb.append("1" + " ");
            } else {
                sb.append("0" + " ");
            }
        }
        System.out.println(sb);
    }

    public static boolean check(int t) {
        int left = 0;
        int right = n-1;
        int mid = 0;

        while(left<=right) {
            mid = (left + right) / 2;
            if(t > cards[mid]) {
                left = mid + 1;
            } else if(t < cards[mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

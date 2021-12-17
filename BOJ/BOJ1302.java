package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ1302 {
    static int n;
    static HashMap<String, Integer> map = new HashMap<String, Integer>();

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }

    public static String search() {
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        String bookName = "";

        for(String key : map.keySet()) {
            int val = map.get(key);

            if(max < val) {
                max = val;
                bookName = key;
            } else if(max == val && bookName.compareTo(key) > 0){ // str1.compareTo(str2) str1 > str2 -> 1, str1 < str2 -> -1
                max = val;
                bookName = key;
            }
        }

        return bookName;
    }
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(search());
    }
}

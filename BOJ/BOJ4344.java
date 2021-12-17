package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String[] nums;

        for(int i=0; i<T; i++) {
            double avg;
            int sum = 0;
            nums = br.readLine().split(" ");

            for(int j=1; j<nums.length; j++) {
                sum += Integer.parseInt(nums[j]);
            }

            avg = sum/Integer.parseInt(nums[0]);
            int cnt = 0;

            for(int j=1; j<nums.length; j++) {
                if(Integer.parseInt(nums[j]) > avg) cnt++;
            }

            double result =  cnt/Double.parseDouble(nums[0]) * 100;
            sb.append(String.format("%.3f",result)).append("%").append("\n");
        }
        System.out.println(sb);
    }
}

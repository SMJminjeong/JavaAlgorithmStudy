package boj.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합0의개수_2004 {
    public static void main(String[] args) throws IOException {
        //팩토리얼 이용
        //팩토리얼은 2와 5의 기준으로 구하면 된다.
        //2와 5는 0의 기준이므로 2와 5의 개수에 따라 0의 개수도 변한다고 보면 된다.
        //팩토리얼 블로그 https://st-lab.tistory.com/165

        //이번문제는 10C2 방법으로 접근
        //10C2 = 10! - 2!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        // 각각의 승수를 구해준다.
        long count5 = five_power_n(N) - five_power_n(N - M) - five_power_n(M);
        long count2 = two_power_n(N) - two_power_n(N - M) - two_power_n(M);
        System.out.println(Math.min(count5, count2));
    }

    // 5의 승수를 구하는 함수
    static long five_power_n(long num) {
        int count = 0;

        while (num >= 5) {
            count += (num / 5);
            num /= 5;
        }
        return count;
    }

    // 2의 승수를 구하는 함수
    static long two_power_n(long num) {
        int count = 0;

        while (num >= 2) {
            count += (num / 2);
            num /= 2;
        }
        return count;
    }
}

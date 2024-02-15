package boj.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수최소공배수_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = getGCD(Math.max(a, b), Math.min(a, b));

        // LCM(a,b)×GCD(a,b)=a×b
        int lcm = (a * b) / gcd;

        System.out.println(gcd);
        System.out.println(lcm);

    }

    private static int getGCD (int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

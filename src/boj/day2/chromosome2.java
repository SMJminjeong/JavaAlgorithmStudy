package boj.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chromosome2 {

    // ^ : 정규표현식 시작
    // $ : 정규표현식 끝
    // [A-F] : A,B,C,D,E,F
    // ? : 0번 또는 1번
    // + : 그 전 문자가 1개 이상

    private static final String REGEX = "^[A-F]?A+F+C+[A-F]?$";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-->0) {
            sb.append(br.readLine().matches(REGEX)?"Infected!\n":"Good\n");
        }
        System.out.print(sb);
    }
}

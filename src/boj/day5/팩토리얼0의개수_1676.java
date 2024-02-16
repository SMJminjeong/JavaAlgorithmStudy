package boj.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class 팩토리얼0의개수_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        //입력값이 커질수록 팩토리얼 결과값이 커지니 BigInteger 사용
        //곱셈을 진행해야 하니 "1" 로 선언
        BigInteger bigInteger = new BigInteger("1");
        for (int i = 1; i <= N; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i)); //multiply 를 사용하여 곱셈 진행
        }

        //문자열로 변환
        String S = bigInteger.toString();
        //문자열의 뒷부분부터 반복하며 0이 몇개인지 체크
        for (int i = S.length() -1; i > 1; i--) {
            if (S.charAt(i) - '0' == 0) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}

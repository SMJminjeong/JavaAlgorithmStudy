package boj.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수팰린드롬_1747 {
    //소수를 먼저 구하고
    //팰린드롬 수를 구하고
    //제외하고 제일 작은 수를 구한다.

    private static boolean[] primeArr = new boolean[1004001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        checkPrimeNumber();

        int result = 0;

        for (int i = N; i <= 1004000; i++) {
            if (i < 10 && primeArr[i]) {
                result = i;
                break;
            } else {
                if (checkPelin(Integer.toString(i)) && primeArr[i]) {
                    result = i;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    static void checkPrimeNumber() {
        for (int i = 2; i<=1004000; i++) {
            primeArr[i] = true;
        }

        int num = (int)Math.sqrt(1004000);

        for (int i = 2; i<=num; i++) {
            if(primeArr[i]) {
                for (int j = i; i*j <= 1004000; j++) {
                    primeArr[i*j] = false;
                }
            }
        }
    }

    static boolean checkPelin(String num) {
        int start = 0;
        int end = num.length()-1;

        while (start <= end) {
            if (num.charAt(start) != num.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

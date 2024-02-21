package boj.day6;

import java.io.*;

public class 골드바흐의추측_6588 {
    //백만까지이므로 크기가 1000001인 배열을 static으로 생성
    final static int MAX = 1000000;
    static boolean[] primeNumber = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        //4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타냄
        //8은 3+5 (홀수)+(홀수)
        //20 = 3+17 = 7+13, 42 = 5+37 = 11+31 = 13+29 = 19+23
        //n = a + b
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] result;
        //소수를 찾는 메소드 실행
        findPrimeNumber(primeNumber);
        //num이 0이 나올때까지 반복
        while (num != 0) {
            result = new int[2];
            //num이하인 경우
            for (int i = num; i >= 0; i--) {
                //i와 num-i가 소수일 떄 출력
                //num-i의 차이가 최대여야 하므로 break
                if (primeNumber[i] && primeNumber[num - i]) {
                    result[0] = num - i;
                    result[1] = i;
                    bw.write(num + " = " + result[0] + " + " + result[1] + "\n");
                    break;
                }
            }
            //result의 원소가 0일 때는 문제에 해당하는 경우가 없다
            if (result[0] == 0) {
                bw.write("Goldbach's conjecture is wrong." + "\n");
            }
            num = Integer.parseInt(br.readLine());
        }
        bw.close();
    }

    //매개변수로 주어진 배열에서 소수인 원소를 체크하여 반환하는 메소드
    static boolean[] findPrimeNumber(boolean[] arr) {
        int count;
        for (int i = 2; i < arr.length; i++) {
            count = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                arr[i] = true;
            }
        }
        return arr;
    }
}

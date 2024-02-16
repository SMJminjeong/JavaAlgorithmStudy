package boj.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에라토스테네스의체_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        primeNumber(N, K);
    }

    static void primeNumber (int N, int K) {
        int[] intArr = new int[N+1];
        // 배열 초기화
        for (int i = 2; i <= N; i++) {
            intArr[i] = i;
        }

        for (int i = 2; i <= N; i++) {
            if (intArr[i] == 0) continue; //이미 지워진 수인지 체크 (지워진 수 라면 건너뛰기)
            //2부터 N까지 i의 배수 지우기
            for (int j = i; j <= N; j+=i) {
                if (intArr[j] != 0) { //0 (이미 지워진) 이 아니면
                    intArr[j] = 0; //0으로 값을 넣어주고
                    K--; //K값을 -해줌
                    if (K == 0) { //K값이 0이면
                        System.out.println(j); //j값을 출력
                        return;
                    }
                }
            }
        }
    }


}

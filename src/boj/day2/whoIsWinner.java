package boj.day2;
import java.io.*;
public class whoIsWinner {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        int sum = 0;
        String str = br.readLine();

        int[] strToIntArr = new int[str.length()]; //str 크기의 배열 생성
        // 문자열 str을 순회하면서 각 문자에 해당하는 획수를 strToIntArr 배열에 저장
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            strToIntArr[i] = arr[c - 'A']; // 'A'부터 시작하는 알파벳의 획수를 가져와 저장
        }

        // 처음부터 끝까지 다 더해주면 된다. (토너먼트식)
        for (int value : strToIntArr) {
            sum += value;
            sum %= 10;
        }

        if (sum % 2 == 0) {
            System.out.println("You're the winner?");
        } else {
            System.out.println("I'm a winner!");
        }
    }
}


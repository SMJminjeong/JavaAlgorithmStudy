package boj.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 그룹단어체커_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //입력받을 단어 개수
        int count = 0;

        for (int i = 0; i < N; i++) {
            String targetWord = br.readLine().trim(); //입력받는 단어
            Set<Character> charSet = new HashSet<>();
            boolean isGroupWord = true;

            for (int j = 0; j < targetWord.length(); j++) {
                char currentChar = targetWord.charAt(j);

                if ((j > 0) && (currentChar != targetWord.charAt(j-1)) && (charSet.contains(currentChar))) {
                    isGroupWord = false;
                    break;
                }

                charSet.add(currentChar);
            }

            if (isGroupWord) {
                count++;
            }
        }

        System.out.println(count);

    }
}

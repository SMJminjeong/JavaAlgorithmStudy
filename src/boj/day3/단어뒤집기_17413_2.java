package boj.day3;

import java.io.*;
import java.util.Stack;

public class 단어뒤집기_17413_2 {
    static Stack<Character> stack = new Stack<>();
    static Stack<Character> tagChecker = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        char[] inputArr = input.toCharArray();

        for (int i = 0; i < inputArr.length; i++) {

            // 태그인지 여부를 판단하는 메서드
            if (isTag()) {
                // 태그 내부인 경우
                bw.write(inputArr[i]);

                // '>' 인 경우 스택에서 '<'를 제거하여 태그 외부 상태로 전환
                if (inputArr[i] == '>' && isTag()) {
                    tagChecker.pop();
                }
            } else if (!isTag()) {
                // 태그 외부인 경우

                // '<' 만나면 태그 내부로 전환
                if (inputArr[i] == '<') {
                    tagChecker.push('<');

                    // 스택이 비어있을 때까지 스택의 모든 문자를 꺼내고 '<' 쓰기
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write('<');
                    continue;
                }

                // 공백인 경우 스택의 모든 문자를 꺼내고 공백 쓰기
                if (inputArr[i] == ' ') {
                    while (!stack.isEmpty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(inputArr[i]);
                }

                // 공백이 아닌 경우 스택에 문자 넣기 (뒤집어야 하므로)
                if (inputArr[i] != ' ') {
                    stack.push(inputArr[i]);
                }
            }
        }

        // 남은 스택의 문자들을 모두 출력
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }

        bw.flush();
        bw.close();
    }

    // 태그 내부 여부를 판단하는 메서드
    public static boolean isTag() {
        return !tagChecker.isEmpty(); // tagChecker에 값이 남아있을 때 == '<,>' 안에 있을 때
    }
}

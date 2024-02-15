package boj.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 단어뒤집기_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        boolean isInTag = false;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(S.charAt(i));
                isInTag = true;
            }
            else if (S.charAt(i) == '>') {
                sb.append(S.charAt(i));
                isInTag = false;
            }
            else if (isInTag) {
                sb.append(S.charAt(i));
            }
            else if (!isInTag) {
                if (S.charAt(i) == ' ') {
                    while(!stack.empty()){
                        sb.append(stack.pop());
                    }
                    sb.append(S.charAt(i));
                }
                else {
                    stack.push(S.charAt(i));
                }
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}

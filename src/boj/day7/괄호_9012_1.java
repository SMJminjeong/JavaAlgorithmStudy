package boj.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_9012_1 {
    //괄호
    //괄호 문자열 ps 는 '(' ')' 만으로 구성되어있는 문자열
    //괄호 문자열 (VPS)
    //"(())()" "((()))" "(()(" "(())()))" "(()"
    //YES NO
    public static void main(String[] args) throws IOException {
        //stack을 이용하여 '('일때는 push ')'일때는 pop
        //stack size 가 0 일 때 ')' 이면 "NO"
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < T; i++) {
            String[] stringArr = br.readLine().split("");
            for (int j = 0; j < stringArr.length-1; j++) {
                if (stringArr[i].equals("(")) {
                    stack.push(stringArr[i]);
                } else {
                    int size = stack.size();
                    if (size == 0) {
                        stack.push(stringArr[i]);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        stack.clear();
    }
}

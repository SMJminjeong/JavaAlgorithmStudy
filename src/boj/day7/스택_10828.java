package boj.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택_10828 {
    public static void main(String[] args) throws IOException {
        //정수를 저장하는 스택 구현
        //push X : 정수 X 를 스택에 넣는 연산
        //pop : 스택에서 가장 위에 있는 정수를 빼고, 그 수 출력 & 스택에 들어있는 정수가 없는 경우에는 -1 출력
        //size : 스택에 들어있는 정수의 개수 출력
        //empty : 스택이 비어있으면 1, 아니면 0 출력
        //top : 스택의 가장 위에 있는 정수 출력 , 만약 스택에 들어있는 정수가 없는 경우 -1 출력

        //첫째 줄에 주어지는 명령의 수 int
        //둘째 줄부터 N 개의 줄에는 명령이 하나씩
        //주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>(); // 스택 선언
        StringBuilder sb = new StringBuilder();

        int num  = Integer.parseInt(br.readLine()); // br을 받을 int 선언

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()); // Stack에 문자와 숫자를 나눠주어야 하기 때문
            String str = st.nextToken();

            if (str.equals("push")) { // push를 입력받는다면
                stack.push(Integer.parseInt(st.nextToken()));
            }
            if (str.equals("pop")) { // pop를 입력받는다면
                if (stack.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(stack.pop() + "\n");
                }
            }
            if (str.equals("size")) { // size를 입력받는다면
                sb.append(stack.size() + "\n");
            }
            if (str.equals("empty")) { // empty를 입력받는다면
                if (stack.isEmpty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            }
            if (str.equals("top")) { // top를 입력받는다면
                if (stack.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(stack.peek() + "\n");
                }
            }
        }
        System.out.println(sb);

    }
}

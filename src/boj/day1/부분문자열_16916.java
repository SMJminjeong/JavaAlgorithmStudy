package boj.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분문자열_16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();
        int j = 0;
        int[] pi = new int[P.length()];
        for (int i = 1; i < P.length(); i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (P.charAt(i) == P.charAt(j)) {
                pi[i] = j += 1;
            }
        }

        j = 0;
        for (int i = 0; i < S.length(); i++){
            while (j > 0 && S.charAt(i) != P.charAt(j)) {
                j = pi[j - 1];
            }
            if (S.charAt(i) == P.charAt(j)) {
                if(j == P.length() - 1) {
                    System.out.println(1);
                    System.exit(0);
                } else {
                    j++;
                }
            }
        }

        System.out.println(0);

    }
}

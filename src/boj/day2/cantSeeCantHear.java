package boj.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cantSeeCantHear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        Set<String> unHeardSet = new HashSet<>();
        for(int i = 0; i < N; i++) {
            unHeardSet.add(br.readLine());
        }

        ArrayList<String> interSectionArr = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String name = br.readLine();
            if(unHeardSet.contains(name)) {
                interSectionArr.add(name);
            }
        }

        Collections.sort(interSectionArr);

        System.out.println(interSectionArr.size());
        for (String name : interSectionArr) {
            System.out.println(name);
        }

    }
}

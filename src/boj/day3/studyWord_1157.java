package boj.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

public class studyWord_1157 {
    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();

        Map<Character, Long> frequencyMap = word.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        char maxChar = frequencyMap.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .orElseThrow()
            .getKey();

        long maxCount = frequencyMap.get(maxChar);

        if (frequencyMap.values().stream().filter(count -> count == maxCount).count() > 1) {
            System.out.println("?");
        } else {
            System.out.println(maxChar);
        }
    }
}

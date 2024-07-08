//Spuda checker duplih rijeci
package com.Spuda;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
class test {

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter words with space");
            String stringInput = input.nextLine().toLowerCase();
            String[] words = stringInput.split("\\s+");

            String duplicates = findDuplicates(words);
            String nonDuplicates = findNonDuplicates(words);

            System.out.println("Duplicate words: " + duplicates);
            System.out.println("Non-duplicate words: " + nonDuplicates);

            if (shouldExit(input)) {
                System.out.println("Turning program off in 3 seconds! BYE! Author: Marin Spudic");
                TimeUnit.SECONDS.sleep(3);
                break;
            }
        }
    }

    private static String findDuplicates(String[] words) {
        Set<String> uniqueWords = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (String word : words) {
            if (!uniqueWords.add(word)) {
                duplicates.add(word);
            }
        }

        return String.join(" ", duplicates);
    }

    private static String findNonDuplicates(String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<String> nonDuplicates = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                nonDuplicates.add(entry.getKey());
            }
        }

        return String.join(" ", nonDuplicates);
    }

    private static boolean shouldExit(Scanner input) {
        System.out.println("\nWant to turn off program? Type: 1");
        try {
            int exit = input.nextInt();
            input.nextLine();
            return exit == 1;
        } catch (InputMismatchException exception) {
            System.out.println("This is not an integer");
            input.nextLine();
            return false;
        }
    }

}


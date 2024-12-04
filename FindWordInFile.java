import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindWordInFile {

    public static void searchWordInFile(String word, String filename) {
        Scanner scanner = null; 
        try {
            scanner = new Scanner(new File(filename));
            boolean foundTheWord = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] sentences = line.split("(?<=\\.|!|\\?)\\s*");

                for (String sentence : sentences) {
                    if (sentence.contains(word)) {
                        System.out.println(sentence);
                        foundTheWord = true;
                    }
                }

                // if (line.contains(word)) {
                //     System.out.println(line); 
                //     foundTheWord = true;
                // }
            }

            if (!foundTheWord) {
                System.out.println("This file does not contain any sentences with the word: " + word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Not enough arguments.");
        }

        String word = args[0];
        String filename = args[1];

        searchWordInFile(word, filename);
    }
}

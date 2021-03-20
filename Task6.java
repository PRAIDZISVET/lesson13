package by.itacademy.lesson13;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Task6 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("resources", "temp", "words.txt");
        Path filePathToWrite = Paths.get("resources", "temp", "words_swap.txt");
        try (Scanner scanner = new Scanner(new FileInputStream(path.toFile()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePathToWrite.toFile()))) {
            while (scanner.hasNextLine()) {
//                String [] words = scanner.nextLine().split(" ");
//                String temp = words[0];
//                words[0] = words[words.length-1];
//                words[words.length-1] = temp;
                List<String> words = Arrays.asList(scanner.nextLine().split(" "));
                Collections.swap(words, 0, words.size() - 1);

                bufferedWriter.append(String.join(" ", words));
                bufferedWriter.newLine();
            }
        }
    }
}

package by.itacademy.lesson13.util;

import by.itacademy.lesson13.model.Student;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StudentUtil {

    public static List<Student> extractFrom(Path path) throws FileNotFoundException {
        List<Student> students = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(path.toFile())))) {
            while (scanner.hasNextLine()) {
                String[] studentWithMarks = scanner.nextLine().split(" ");

                String studentName = studentWithMarks[0];
                List<Integer> marks = Arrays.stream(studentWithMarks)
                        .skip(1L)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());

                students.add(new Student(studentName, marks));
            }
        }

        return students;
    }
}

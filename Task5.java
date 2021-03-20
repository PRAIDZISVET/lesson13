package by.itacademy.lesson13;

import by.itacademy.lesson13.model.Student;
import by.itacademy.lesson13.util.StudentUtil;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    private static final int MARK_TRESHHOLD = 7;

    public static void main(String[] args) throws FileNotFoundException {
        //test();
        Path path = Paths.get("resources","temp", "students.txt");
        List<Student> students = StudentUtil.extractFrom(path);

        students.stream()
                .filter(student -> student.getMarks().stream()
                        .mapToInt(Integer::intValue)
                        .average().orElse(0.0) >= MARK_TRESHHOLD)
                .forEach(System.out::println);
    }

    private static void test() {
        Path path = Paths.get("resources","temp", "students.txt");
        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(path.toFile())))){
            while (scanner.hasNextLine()) {
                String studentWithMarks = scanner.nextLine();
                String[] values = studentWithMarks.split(" ");
                String studentName = values[0];
                int sumMarks = 0;
                for (int i = 1; i < values.length ; i++) {
                    sumMarks += Integer.valueOf(values[i]);
                }
                if (sumMarks/(values.length - 1) >= MARK_TRESHHOLD) {
                    System.out.println(studentName);
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

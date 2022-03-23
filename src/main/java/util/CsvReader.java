package util;

import entity.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private static String path = "src/main/resources/students.csv";
    private static String splitBy = ",";

    public static List<Student> readFromCsv(String path) {
        List<Student> students = new ArrayList<>();

        try (Reader reader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            bufferedReader.readLine();
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] attributes = line.split(splitBy);
                Student student = createStudent(attributes);
                students.add(student);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    private static Student createStudent(String[] metadata) {
        long id = Long.parseLong(metadata[0]);
        String name = metadata[1];
        List<Long> attendedLessons = new ArrayList<>();
//        attendedLessons.add(metadata[2]);

        return new Student(id, name, attendedLessons);
    }
}

package util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import entity.Student;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentJsonReader {
//    private final Path path = Path.of("src/main/resources/students.json");

    public List<Student> parseStudentsJson(Path path) throws IOException {
        System.out.println(path);
        String json = Files.readString(path, StandardCharsets.UTF_8);

        JsonFactory jFactory = new JsonFactory();
        JsonParser jParser = jFactory.createParser(json);

        long id = -1L;
        String name = null;
        List<Long> attendedLessons = new LinkedList<>();
        List<Student> students = new ArrayList<>();

        while (jParser.nextToken() != JsonToken.END_ARRAY) {
            String fieldname = jParser.getCurrentName();
            if ("id".equals(fieldname)) {
                jParser.nextToken();
                id = jParser.getLongValue();
                System.out.println("id: " + id);
            }

            if ("name".equals(fieldname)) {
                jParser.nextToken();
                name = jParser.getText();
                System.out.println("name: " + name + "\n");
            }

            if ("attendedLessons".equals(fieldname)) {
                jParser.nextToken();
                while (jParser.nextToken() != JsonToken.END_ARRAY) {
                    attendedLessons.add(jParser.getLongValue());
                }
            }
            if (id != -1L && name != null && !attendedLessons.isEmpty()) {
                students.add(createStudent(id, name, attendedLessons));
                id = -1L;
                name = null;
                attendedLessons = new ArrayList<>();
            }
        }
        jParser.close();
        return students;
    }

    private static Student createStudent(long id, String name,
                                         List<Long> attendedLessons) {
        return new Student(id, name, attendedLessons);
    }
}


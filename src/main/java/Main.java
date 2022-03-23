import entity.Student;
import util.StudentJsonReader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {

    private static final Path PATH = Path.of("src/main/resources/students.json");

    public static void main(String[] args) throws IOException {

        StudentJsonReader studentJsonReader = new StudentJsonReader();
        List<Student> students = studentJsonReader.parseStudentsJson(PATH);

        System.out.println(students);
    }
}

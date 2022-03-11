package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Student {

    private long id;
    private String name;
    private List<Lesson> attendedLessons;

    public void attendLesson(Lesson lesson){

    }

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

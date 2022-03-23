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
public class Lesson {

    private long id;
    private String lessonTitle;
    private List<Long> visitingStudents;

}

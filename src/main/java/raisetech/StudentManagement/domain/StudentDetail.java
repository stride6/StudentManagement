package raisetech.StudentManagement.domain;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
import raisetech.StudentManagement.service.StudentService;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StudentDetail {
    private Student student;
    private List<StudentCourse> studentCourseList;



}

package raisetech.StudentManagement.controller.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
import raisetech.StudentManagement.domain.StudentDetail;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentConverterTest {

private StudentConverter sut;

@BeforeEach
 void before(){
 sut = new StudentConverter();
}

@Test
    void 受講生のリストと受講生コース情報のリストを渡して受講生詳細のリストが作成できること() {
    Student student = new Student();
    student.setId("7");
    student.setName("平田知基");
    student.setKanaName("ヒラタトモキ");
    student.setNickname("ヒラタ");
    student.setEmail("test@example.com");
    student.setArea("福岡");
    student.setSex("男性");
    student.setRemark("");
    student.setDeleted(false);

    StudentCourse studentCourse = new StudentCourse();
    studentCourse.setId("7");
    studentCourse.setStudentId("7");
studentCourse.setCourseName("Javaコース");
studentCourse.setCourseStartAt(LocalDateTime.now());
studentCourse.setCourseEndAt(LocalDateTime.now().plusYears(1));

    List<Student> studentList = List.of(student);
    List<StudentCourse> studentCourseList = List.of(studentCourse);

    List<StudentDetail> actual = sut.convertStudentDetails(studentList, studentCourseList);
}
}
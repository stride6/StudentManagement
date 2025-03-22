package raisetech.StudentManagement.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.repositry.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

 @Mock
 private StudentRepository repository;

 @Mock
 private StudentConverter converter;

@Test
void 受講生詳細の一覧検索_リポジトリとコンバーターの処理が適切に呼び出せていること(){
StudentService sut = new StudentService(repository, converter);
List<Student> studentList = new ArrayList<>();
List<StudentCourse> studentCourseList = new ArrayList<>();

when(repository.search()).thenReturn(studentList);

    List<StudentDetail> actual = sut.searchStudentList();

    Mockito.verify(repository, Mockito.times(1)).search();
    Mockito.verify(repository, Mockito.times(1)).searchStudentCoursesList();
    Mockito.verify(converter, Mockito.times(1)).convertStudentDetails();
}
}
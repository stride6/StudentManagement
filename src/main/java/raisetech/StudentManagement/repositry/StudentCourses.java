package raisetech.StudentManagement.repositry;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.StudentsCourses;

@Mapper
public interface StudentRepository {

@Select("SELECT * FROM students")
List<Students> search();

@Select("SELECT * FROM students_courses")
List<StudentsCourses> searchStudentsCourses();
}

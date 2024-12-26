package raisetech.StudentManagement.repositry;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;

import java.util.List;


@Mapper
public interface StudentRepository {


//    @Select("SELECT * FROM student WHERE name = #{name}")
//    Student searchByName(String name);

//    @Insert("INSERT student values(#｛name｝, #｛age｝)")
//    void registerStudent(String name, int age);

//    @Update("UPDATE student SET age = #{age} WHERE name = #{name}")
//    void updateStudent(String name, int age);

    //    @Delete("DELETE FROM student WHERE name =#{name} ")
//    void deleteStudent(String name);
    @Select("SELECT * FROM students_courses")
    List<StudentCourses> searchStudentsCourses();

    //    @Select("students")
    @Select("SELECT * FROM students")
    List<Student> search();

    @Insert("INSERT INTO students(name,kana_name,nickname,email,area,age,sex,remark,is_deleted) " +
            "VALUES(#{name}, #{kanaName}, #{nickname},#{email}, #{area},#{age},#{sex},#{remark},false)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudent(Student student);

    @Insert("INSERT INTO students_courses(student_id,course_name,course_start_at,course_end_at) "
            + "VALUES(#{studentId}, #{courseName},#{courseStartAt},#{courseEndAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudentsCourses(StudentCourses studentCourses);
}

package raisetech.StudentManagement.repositry;

import org.apache.ibatis.annotations.*;
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
    @Select("SELECT * FROM students_courses ")
    List<StudentCourses> searchStudentsCourses();

    //    @Select("students")
    @Select("SELECT * FROM students where is_deleted is false")
    List<Student> search();

    @Select("SELECT * FROM students WHERE id = #{id}")
    Student searchStudent(String id);

    @Select("SELECT * FROM students_courses")
    List<StudentCourses> searchStudentCoursesList();

    @Select("SELECT * FROM students_courses WHERE student_id = #{studentId}")
    List<StudentCourses> searchStudentCourses(String studentId);

    @Insert("INSERT INTO students(name,kana_name,nickname,email,area,age,sex,remark,is_deleted) " +
            "VALUES(#{name}, #{kanaName}, #{nickname},#{email}, #{area},#{age},#{sex},#{remark},false)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudent(Student student);

    @Insert("INSERT INTO students_courses(student_id,course_name,course_start_at,course_end_at) "
            + "VALUES(#{studentId}, #{courseName},#{courseStartAt},#{courseEndAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudentsCourses(StudentCourses studentCourses);


    @Update("UPDATE students SET name = #{name}, kana_name= #{kanaName}, nickname = #{nickname},"
            + "email = #{email}, area = #{area},age = #{age},sex = #{sex},remark = #{remark},is_deleted = #{isDeleted} WHERE id = #{id}")
    void updateStudent(Student student);

    @Update("UPDATE students_courses SET course_name =#{courseName} WHERE id = #{id}")
    void updateStudentsCourses(StudentCourses studentCourses);
}

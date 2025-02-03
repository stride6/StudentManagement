package raisetech.StudentManagement.repositry;

import org.apache.ibatis.annotations.*;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;

import java.util.List;

/**
 * 受講生テーブルと受講生コース情報テーブルと紐付くRepositoryです。
 */
@Mapper
public interface StudentRepository {

    /**
     * 受講生の全件検索を行います。
     *
     * @return　受講生一覧(全件)
     */

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

    /**
     * 受講生の検索を行います。
     *
     * @param id　受講生ID
     * @return 受講生
     */
    @Select("SELECT * FROM students WHERE id = #{id}")
    Student searchStudent(String id);

    /**
     * 受講生のコース情報の全件検索を行います。
     *
     * @return　受講生のコース情報(全件)
     */
    @Select("SELECT * FROM students_courses")
    List<StudentCourses> searchStudentCoursesList();

    /**
     * 受講生IDに紐付く受講生コース情報を検索します。
     *
     * @param studentId　受講生ID
     * @return 受講生IDに紐付く受講生コース情報
     */
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

    @Update("UPDATE students_courses SET course_name =#{courseName}) WHERE id = #{id}")
    void updateStudentsCourses(StudentCourses studentCourses);
}

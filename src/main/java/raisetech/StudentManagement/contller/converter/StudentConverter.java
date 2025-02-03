package raisetech.StudentManagement.contller.converter;


import org.springframework.stereotype.Component;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviceから取得したオブジェクトをControllerにとって必要な形に変換するコンバーターです。
 */
@Component
public class StudentConverter {

    /**
     * 受講生に紐付く受講生コース情報をマッピングする。
     * 受講生コース情報は受講生に対して複数存在するのでループを回して受講生詳細情報を組み立てる。
     *
     * @param students　受講生一覧
     * @param studentsCourses　受講生コース情報のリスト
     * @return　受講生詳細情報のリスト
     */
    public List<StudentDetail> convertStudentDetails(List<Student> students,
                                                     List<StudentCourses> studentsCourses) {
        List<StudentDetail> studentDetails = new ArrayList<>();
        students.forEach(student -> {
            StudentDetail studentDetail = new StudentDetail();
            studentDetail.setStudent(student);

            List<StudentCourses> convertStudentCourses =  studentsCourses.stream()
                    .filter(StudentCourse -> student.getId().equals(studentsCourses.getStudentId()))
                    .collect(Collectors.toList());
            {
                {
                }

                studentDetail.setStudentCourses(convertStudentCourses);
                studentDetails.add(studentDetail);

            }
        });
        return studentDetails;
    }

}

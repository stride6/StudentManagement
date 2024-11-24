package raisetech.StudentManagement.contller.converter;


import org.springframework.stereotype.Component;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;

import java.util.ArrayList;
import java.util.List;

@Component
public class Studentconverter {

    public List<StudentDetail> convertStudentDetails(List<Student> students, List<StudentCourses> studentsCourses) {
        List<StudentDetail> studentDetails = new ArrayList<>();
        students.forEach(student -> {
            StudentDetail studentDetail = new StudentDetail();
            studentDetail.setStudent(student);

            List<StudentCourses> convertStudentCourses = new ArrayList<>();
            for (StudentCourses studentCourses : studentsCourses) {
                if (student.getId().equals(studentCourses.getStudentId())) {
                    convertStudentCourses.add(studentCourses);
                }

                studentDetail.setStudentCourses(convertStudentCourses);
                studentDetails.add(studentDetail);

            }
        });
        return studentDetails;
    }

}

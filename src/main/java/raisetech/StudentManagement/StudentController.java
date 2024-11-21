package raisetech.StudentManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
private StudentService service;

@Autowired
public  StudentController(StudentService service) {
this.service.searchStudentList();
}

@GetMapping("/studentList")
public List<StudentDetail> getStudentList() {
    List<Student> students = service.searchStudentList();
    service.searchStudentCourseList();

    List<StudentDetail> studentDetails = new ArrayList<>();
    for(Student student :students) {
StudentDetail studentDetail = new StudentDetail();
StudentDetail.setStudent(student);

List<StudentCourses> convertStudentCourses = new ArrayList<>();
for(StudentsCourses StudentsCourses : studentsCourses)　{
            if(student.getId().equals(studentCourse.getStudentId())) {
                convertStudentCourses.add(studentCourse);

            }
}
        studentDetails.setStudentsCourses(convertStudentCourses);
    }

    return


}


@GetMapping("/studentsCourseList")
public List<StudentsCourses> getStudentsCourseList()　{
return service.searchStudentCourseList();
}
}

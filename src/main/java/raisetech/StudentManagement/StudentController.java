package raisetech.StudentManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

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
    return
}

@GetMapping("/studentsCourseList")
public List<StudentsCourses> getStudentsCourseList()　{
return service.searchStudentCourseList();
}
}

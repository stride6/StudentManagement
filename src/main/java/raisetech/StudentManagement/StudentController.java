package raisetech.StudentManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
//import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.data.StudentService;



import java.util.List;

@RestController
public class StudentController {
private StudentService service;

@Autowired
public  StudentController(StudentService service) {
this.service = service;
}

@GetMapping("/studentList")
public List<Student> getStudentList() {
return service.searchStudentList();
}


@GetMapping("/studentsCourseList")
public List<StudentCourses> getStudentsCourseList(){
return service.searchStudentList();
}
}

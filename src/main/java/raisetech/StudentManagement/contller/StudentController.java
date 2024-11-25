package raisetech.StudentManagement.contller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.contller.converter.Studentconverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.service.StudentService;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;
//import raisetech.StudentManagement.domain.StudentDetail;


import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private StudentService service;
    private Studentconverter converter;

    @Autowired
    public StudentController(StudentService service, Studentconverter converter) {

        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/studentList")
    public List<StudentDetail> getStudentList() {
//    public class MyClass{
//        private int id;
//    }
//    public int getid(){
//        return this.id;
//    }
        List<Student> students = service.searchStudentList();
        List<StudentCourses> studentsCourses = service.searchStudentsCourseList();

//    List<StudentDetail> studentDetails = StudentDetail(students, studentsCourses);


        return converter.convertStudentDetails(students, studentsCourses);
    }

    @GetMapping("/studentsCourseList")
    public List<StudentCourses> getStudentsCourseList() {
        return service.searchStudentsCourseList();
    }
}

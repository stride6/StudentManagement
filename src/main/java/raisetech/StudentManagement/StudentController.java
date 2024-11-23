package raisetech.StudentManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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

@Autowired
public  StudentController(StudentService service) {
this.service = service;
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

    List<StudentDetail> studentDetails = convertStudentDetails(students, studentsCourses);


    return studentDetails;
}

    private  List<StudentDetail> convertStudentDetails(List<Student> students, List<StudentCourses> studentsCourses) {
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

    @GetMapping("/studentsCourseList")
public List<StudentCourses> getStudentsCourseList(){
    return service.searchStudentsCourseList();
}
}

package raisetech.StudentManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.service.StudentService;

@RestController
public class StudentController {
private StudentService service;

@Autowired
public  StudentController()
}

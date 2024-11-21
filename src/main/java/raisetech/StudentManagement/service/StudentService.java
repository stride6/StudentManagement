package raisetech.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.StudentCourses;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository){
this.repository = repository;
    }
    public List<Student> searchStudentList(){
        return repositry.search();

    }

public List<StudentCourses>searchStudentsCourseList(){
return repository.searchStudentsCourses();
}
}

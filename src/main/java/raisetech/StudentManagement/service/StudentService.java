package raisetech.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repositry.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

   public List<Student> searchStudentList(){
        return repository.search();

       public List<StudentsCourses> searchStudentList(){
           return repository.searchStudentsCourses();

       }

    }
}




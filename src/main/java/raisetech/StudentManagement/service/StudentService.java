package raisetech.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.repositry.StudentRepository;

import java.util.List;


@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> searchStudentList() {
        return repository.search();


    }

    public List<StudentCourses> searchStudentsCourseList() {
        return repository.searchStudentsCourses();
        //ローカル変数　studentCourse を作成
        //String repository = "https://github.com/example/repository";
        //System.out.println(repository);
    }
}



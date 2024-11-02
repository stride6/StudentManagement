package raisetech.StudentManagement;

//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import org.apache.ibatis.annotations.Select;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

    @Autowired
    private StudentRepository repository;

    public static void main(String[] args) {

        SpringApplication.run(StudentManagementApplication.class, args);
    }

//test


    @GetMapping("/student")
    public List<String> getStudentList() {
    }
}
{"name":"山田太郎","age":25},
        {"name":"鈴木一郎","age":30},
        {"name":"田中花子","age":22},
        {"name":"佐藤良子","age":28},
        {"name":"伊藤悠","age":35},
//	public String getStudent() {
//
//		Student student = repository.searchByName("TanakaTarou");
        return repository.search();
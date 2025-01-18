package raisetech.StudentManagement;

//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;

//import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.*;

//import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	@Autowired
	private StudentRepository repository;

	public static void main(String[] args) {

    @GetMapping("/studentList")
    public List<Student> getStudentList () {
        return repository.search();
    }
}

	@PostMapping("/student")
	public void registerStudent(String name, int age) {
		repository.registerStudent(name, age);
		
	}

	@PatchMapping("/Student")
			public void updateStudent(String name, int age){
		repository.updateStudent(name, age);
	}


	@DeleteMapping("/student")
	public void deleteStudent(String name){
		repository.deleteStudent(name);
	}
}
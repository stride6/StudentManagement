package raisetech.StudentManagement;

import ch.qos.logback.core.model.Model;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
//import org.apache.ibatis.annotations.Select;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentManagementApplication.class, args);
	}

//test

	private String name = "Enami Kouji";
	private String age = "37";


	@GetMapping("/studentInfo")
	public String getStudentInfo() {
		return name + " " + age + "歳";
	}

	@PostMapping("/studentInfo")
	public void setStudentInfo(String name, String age){
		this.name = name;
		this.age = age;
	}
}
package raisetech.StudentManagement;

import ch.qos.logback.core.model.Model;

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

	@GetMapping("/hello")
	public String hello() {
		return "Hello, World!";
	}







//	private String name = "Enami Kouji";
//	private String age = "37";
//
//
//	@GetMapping("/studentInfo")
//	public String getStudentInfo() {
//		return name + " " + age;
//
//	}


//	@GetMapping("/newStudent")
//	public String newStudent(Model model){
//	model.addattribute(attributeName:"studentDetail, new StudentDetail"());
//	return "registerStudent";
//	}
//
//	@PostMapping("registStudent")
//public String registeStudent(@ModelAttribute StudentDetil, BindingResultresult)　{
//	if (result.hasErrors()){
//		return "registerStudent";
//		}
//		}
//
//	//①新規受講生情報を登録する処理を実装する。

//		//②コース情報も一緒に登録でいるようにする。コースは単体で良い。
//return "redirect:/student";

}


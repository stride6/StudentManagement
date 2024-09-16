package raisetech.StudentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.apache.ibatis.annotations.Select;

@SpringBootApplication
@RestController
public class Application {

private String name = "Enami Kouji";
private String age = "37";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/studentInfo")
	public String getStudentInfo() {
		return name + "　" + age + "歳";
	}


@PostMapping("/studentInfo")
public void setStudentInfo(String name, String age){
		this.name = name;
		this.age = age;
}

@PostMapping("/studentName")
public void updateStudent(String name){
	this.name = name;
}




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


package raisetech.StudentManagement;

//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import raisetech.StudentManagement.repositry.StudentRepository;
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
//	public String getStudent(@RequestParam String name) {
	public String getStudent() {
//		Student student = repository.searchByName("KoujiEnami");
//		Student student = repository.searchByName(name);
//		return student.getName() + " " + student.getAge() + "歳";
		SpringApplication.run(ApplicationArguments.class, args);
	}

	@PostMapping("/student")
	public void registerStudent(String name, int age) {
		repository.registerStudent(name, age);
		
	}

//	@PatchMapping("/Student")
//			public void updateStudent(String name, int age){
//		repository.updateStudent(name, age);
	}


//	@DeleteMapping("/student")
//	public void deleteStudent(String name){
//		repository.deleteStudent(name);
//	}

@GetMapping("studentList")
public List<student>　getStudentsList(){
return repositry.search();
}

    @GetMapping("/studentsCourseList")
    public List<StudentsCourse> getstudentsCourseList(){
        return repositry.searchStudentsCourses();
    }
}
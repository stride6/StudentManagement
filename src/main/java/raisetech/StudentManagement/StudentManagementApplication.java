package raisetech.StudentManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;


import java.util.List;

@SpringBootApplication

public class StudentManagementApplication {


    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);

    }
}




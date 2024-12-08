package raisetech.StudentManagement.contller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import raisetech.StudentManagement.contller.converter.Studentconverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    private StudentService service;
    private Studentconverter converter;

    @Autowired
    public StudentController(StudentService service, Studentconverter converter) {

        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/studentList")
    public String getStudentList(Model model) {
        StudentCourses data = new StudentCourses();
        List<Student> students = service.searchStudentList();
//        List<StudentCourses> studentsCourses = service.searchStudentsCourseList();
        List<StudentCourses> studentsCourses = new ArrayList<>();
        studentsCourses.add(data);
//    List<StudentDetail> studentDetails = StudentDetail(students, studentsCourses);

        model.addAttribute("studentList", converter.convertStudentDetails(students, studentsCourses));
        return "studentList";
    }

    @GetMapping("/studentsCourseList")
    public List<StudentCourses> getStudentsCourseList() {
        return service.searchStudentsCourseList();
    }

    @GetMapping("/newStudent")
    public String newStudent(Model model) {
        model.addAttribute("studentDetail", new StudentDetail());
        return "registerStudent";
    }

    @PostMapping("/registerStudent")
    public String registerStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result) {
        if (result.hasErrors()) {
            return "registerStudent";
        }
//System.out.println(studentDetail.getStudent().getName() + "さんが新規受講生として登録されました。");
        return "redirect:/studentList";
    }
}

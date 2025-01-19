package raisetech.StudentManagement.contller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import raisetech.StudentManagement.contller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {
    private StudentService service;
    private StudentConverter converter;

    @Autowired
    public StudentController(StudentService service, StudentConverter converter) {

        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/studentList")
    public List<StudentDetail> getStudentList() {
        // StudentCourses data = new StudentCourses();
        List<Student> students = service.searchStudentList();
        List<StudentCourses> studentsCourses = service.searchStudentsCourseList();
        // List<StudentCourses> studentsCourses = service.searchStudentsCourseList();
        // studentsCourses.add(data);
        // List<StudentDetail> studentDetails = StudentDetail(students, studentsCourses);
        return converter.convertStudentDetails(students, studentsCourses);
    }

    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable String id) {
        StudentDetail studentDetail = service.searchStudent(id);
        return "updateStudent";
    }


    @GetMapping("/newStudent")
    public String newStudent(Model model) {
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setStudentCourses(Arrays.asList(new StudentCourses()));
        model.addAttribute("studentDetail", studentDetail);
        return "registerStudent";
    }

    @PostMapping("/registerStudent")
    public String registerStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result) {
        if (result.hasErrors()) {
            return "registerStudent";
        }
        service.registerStudent(studentDetail);
//System.out.println(studentDetail.getStudent().getName() + "さんが新規受講生として登録されました。");
        return "redirect:/studentList";
    }


    @PostMapping("/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestBody StudentDetail studentDetail) {

        service.updateStudent(studentDetail);
//System.out.println(studentDetail.getStudent().getName() + "さんが新規受講生として登録されました。");
        return ResponseEntity.ok("更新処理が成功しました。");
    }
}

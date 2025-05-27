package raisetech.StudentManagement.controller;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import raisetech.StudentManagement.ExceptionHandler.TestException;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.service.StudentService;

import java.util.List;

/**
 * 受講生の検索や登録、更新などを行うREST　APIとして受け付けるControllerです。
 */
@Validated
@RestController
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    /**
     * 受講生詳細の一覧検索です。
     * 全件検索を行うので、条件指定は行いません。
     *
     * @return 受講生詳細一覧(全件)
     */
    @Operation(summary = "一覧検索", description = "受講生の一覧を検索します。")
    @GetMapping("/studentList")
    public List<StudentDetail> getStudentList() {
        //リクエストの処理
        return service.searchStudentList();
    }

    /**
     * 受講生詳細の検索です。
     * IDに紐付く任意の受講生の情報を取得します。
     *
     * @param id 受講生ID
     * @return 受講生
     */
    @GetMapping("/student/{id}")
    public StudentDetail getStudent(
            @PathVariable @NotBlank @Pattern(regexp = "^\\d+$") String id) {
        return service.searchStudent(id);
    }

    /**
     * 受講生詳細の登録を行います。
     *
     * @param studentDetail 受講生詳細
     * @return　実行結果
     */
    @Operation(summary = "受講生登録", description = "受講生を登録します。")
    @PostMapping("/registerStudent")
    public ResponseEntity<StudentDetail> registerStudent(@RequestBody StudentDetail studentDetail) {
        StudentDetail responseStudentDetail = service.registerStudent(studentDetail);
//System.out.println(studentDetail.getStudent().getName() + "さんが新規受講生として登録されました。");
        return ResponseEntity.ok(responseStudentDetail);
    }

    /**
     * 受講生詳細の更新を行います。キャンセルフラグの更新もここで行います。(論理削除)
     *
     * @param studentDetail 　受講生詳細
     * @return　実行結果
     */
    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestBody StudentDetail studentDetail) {

        service.updateStudent(studentDetail);

        return ResponseEntity.ok("更新処理が成功しました。");
    }


    @ExceptionHandler(TestException.class)
    public ResponseEntity<String> handleTestException(TestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}

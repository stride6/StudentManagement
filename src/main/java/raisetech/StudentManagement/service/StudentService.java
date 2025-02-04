package raisetech.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.repositry.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 受講生情報を取り扱うサービスです。
 * 受講生の検索や登録・更新処理を行います。
 */
@Service
public class StudentService {

    private StudentRepository repository;
    private StudentConverter converter;

    @Autowired
    public StudentService(StudentRepository repository, StudentConverter converter) {

        this.repository = repository;
        this.converter = converter;
    }

    /**
     * 受講生の一覧検索を行います。
     * 全件検索を行うので、条件指定は行いません。
     *
     * @return　受講生一覧(全件)
     */
    public List<StudentDetail> searchStudentList() {
        List<Student> studentList = repository.search();
        List<StudentCourses> studentsCoursesList = repository.searchStudentCoursesList();
        return converter.convertStudentDetails(studentList, studentsCoursesList);


    }

    /**
     * 受講生検索です。
     * IDに紐付く受講生情報を取得したあと、その受講生に紐付く受講生コース情報を取得して設定します。
     *
     * @param id 　受講生ID
     * @return 受講生
     */
    public StudentDetail searchStudent(String id) {
        Student student = repository.searchStudent(id);
        List<StudentCourses> studentsCourses = repository.searchStudentCourses(student.getId());
        return new StudentDetail(student, studentsCourses);
    }


    //ローカル変数　studentCourse を作成
    //String repository = "https://github.com/example/repository";
    //System.out.println(repository);
}

@Transactional
public StudentDetail registerStudent(StudentDetail studentDetail) {
    repository.registerStudent(studentDetail.getStudent());
    for (StudentCourses studentCourses : studentDetail.getStudentCourses()) {
        studentCourses.setStudentId(studentDetail.getStudent().getId());

            studentCourses.setCourseStartAt(LocalDateTime.now());

        studentCourses.setCourseEndAt(LocalDateTime.now().plusYears(1));
        repository.registerStudentsCourses(studentCourses);
    }
    return studentDetail;
}

    @Transactional
    public void updateStudent(StudentDetail studentDetail) {
        repository.updateStudent(studentDetail.getStudent());
        for (StudentCourses studentCourses : studentDetail.getStudentCourses()) {
            repository.updateStudentsCourses(studentCourses);
        }

}



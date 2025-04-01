package raisetech.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.StudentManagement.controller.converter.StudentConverter;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
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
     * 受講生詳細の一覧検索を行います。
     * 全件検索を行うので、条件指定は行いません。
     *
     * @return　受講生詳細一覧(全件)
     */
    public List<StudentDetail> searchStudentList() {
      List<Student> studentList = repository.search();
        List<StudentCourse> studentsCoursesList = repository.searchStudentCoursesList();
        return converter.convertStudentDetails(studentList,studentsCoursesList);


    }

    /**
     * 受講生詳細検索です。
     * IDに紐付く受講生情報を取得したあと、その受講生に紐付く受講生コース情報を取得して設定します。
     *
     * @param id　受講生ID
     * @return 受講生詳細
     */
    public StudentDetail searchStudent(String id) {
        Student student = repository.searchStudent(id);
        List<StudentCourse> studentCourse = repository.searchStudentCourse(student.getId());
        return new StudentDetail(student,studentCourse);
    }


        //ローカル変数　studentCourse を作成
        //String repository = "https://github.com/example/repository";
        //System.out.println(repository);

    /**
     *受講生と受講生コース情報を個別に登録し、受講生コース情報には受講生情報を紐づける値とコース開始日、コース終了日を設定します。
     *
     * @param studentDetail　受講生詳細
     * @return　登録情報を付与した受講生詳細
     */
    @Transactional
    public StudentDetail registerStudent(StudentDetail studentDetail) {
        Student student = studentDetail.getStudent();
        repository.registerStudent(student);
        List<StudentCourse> courses = studentDetail.getStudentCourseList();
        for (int i = 0, coursesSize = courses.size(); i < coursesSize; i++) {
            StudentCourse studentCourses = courses.get(i);
            intStudentsCourse(studentDetail, studentCourses);
            repository.registerStudentCourse(studentCourses);
        }
        return studentDetail;
    }

    /**
     *受講生コース情報を登録する際の初期情報を設定する。
     *
     * @param studentDetail　受講生
     * @param studentCourses　受講生コース情報
     */
    private static void intStudentsCourse(StudentDetail studentDetail, StudentCourse studentCourses) {
        LocalDateTime now = LocalDateTime.now();
        studentCourses.setStudentId(studentDetail.getStudent().getId());


        studentCourses.setCourseStartAt(now);

        studentCourses.setCourseEndAt(now.plusYears(1));
    }

    /**
     * 受講生詳細の更新を行います。受講生と受講生コース情報をそれぞれ更新します。
     *
     * @param studentDetail　受講生詳細
     */
    @Transactional
    public void updateStudent(StudentDetail studentDetail) {
        repository.updateStudent(studentDetail.getStudent());
        studentDetail.getStudentCourseList()
                .forEach(studentCourses -> repository.updateStudentCourse(studentCourses));

    }

    public void initStudentcoursse(StudentCourse studentCourse, String id) {
    }
}

package raisetech.StudentManagement.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.service.StudentService;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(StudentController.class)
    class StudentControllerTest{
        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private StudentService service;

        private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();



        @Test
        void 受講生詳細の一覧検索が実行できて空のリストが返ってくること(String value) throws Exception {
           System.out.println(value);
            mockMvc.perform(get("/studentList"))
                    .andExpect(status().isOk())
                    .andExpect(content().json("[]"));
            verify(service, times(1)).searchStudentList();
        }

    @Test
    void 受講生詳細の一覧検索が実行できて空で返ってくること() throws Exception {
String id = "999";
        mockMvc.perform(get("/student/{id}",id))
                .andExpect(status().isOk());

        verify(service, times(1)).searchStudent(id);
    }

        @Test
        void 受講生詳細の登録が実行できて空で返ってくること() throws Exception {
            //リクエストデータは適切に構築して入力チェックの検証も兼ねている。
            //本来であれば返りは登録されたデータが入るが、モック化すると意味がないため、レスポンスは作らない。
            mockMvc.perform(post("/registerStudent").contentType(MediaType.APPLICATION_JSON).content(
                            """
                                     {
                                     "student": {
                                         "name" : "平田知基",
                                         "kanaName" : "ヒラタジン",
                                      "nickname" : "トキ",
                                      "email" : "test@example.com",
                                      "area" : "福岡",
                                      "age" : "17",
                                      "sex" : "男性",
                                      "remark" : "実家暮らし"
                                     },
                                     "studentCourseList" : [
                                         {
                                             "courseName" : "Javaコース"
                                         }
                                     ]
                                     }
                                    """
                    ))
                    .andExpect(status().isOk());
            verify(service, times(1)).registerStudent(any());
        }

        @Test
        void 受講生詳細の更新が実行できて空で返ってくること() throws Exception {
// リクエストデータは適切に構築して入力チェックの検証も兼ねている。
            mockMvc.perform(put("/updateStudent").contentType(MediaType.APPLICATION_JSON).content(
                            """
                                    {
                                        "student": {
                                            "id": "7",
                                            "name": "平田知基",
                                            "kanaName": "ヒラタトモキ",
                                            "nickname": "トキ",
                                            "email": "test@example.com",
                                            "area": "福岡",
                                            "age": 28,
                                            "sex": "男性",
                                            "remark": "実家暮らし",
                                            "deleted": false
                                        },
                                        "studentCourseList": [
                                            {
                                                "id": "21",
                                                "studentId": "7",
                                                "courseName": "Javaコース",
                                                "courseStartAt": "2024-12-26T14:52:04",
                                                "courseEndAt": "2025-12-26T14:52:04"
                                            }
                                        ]
                                    }
                                    """
                    ))
                    .andExpect(status().isOk());

            verify(service, times(1)).updateStudent(any());
        }




        @Test
        void 受講生詳細の例外APIが実行できてステータスが400で返ってくること() throws Exception {
            mockMvc.perform(get("/exception"))
                    .andExpect(status().is4xxClientError())
                    .andExpect(content().string("このAPIは現在利用できません。古いURLとなっています。"));
        }

        @Test
        void 受講生詳細の受講生で適切な値を入力したときに入力チェックに異常が発生しないこと() {
            Student student = new Student();
            student.setId("7");
            student.setName("平田知基");
            student.setKanaName("ヒラタトモキ");
            student.setNickname("ヒラタ");
            student.setEmail("test@example.com");
            student.setArea("福岡");
            student.setSex("男性");

            Set<ConstraintViolation<Student>> violations = validator.validate(student);

            assertThat(violations.size()).isEqualTo(0);

        }


        @Test
        void 受講生詳細の受講生でIDに数字以外を用いた時に入力チェックに掛かること() {
            Student student = new Student();
            student.setId("テストです。");
            student.setName("平田知基");
            student.setKanaName("ヒラタトモキ");
            student.setNickname("ヒラタ");
            student.setEmail("test@example.com");
            student.setArea("福岡");
            student.setSex("男性");

            Set<ConstraintViolation<Student>> violations = validate(student);

            assertThat(violations.size()).isEqualTo(1);
            assertThat(violations).extracting("message")
                    .containsOnly("数字のみ入力するようにしてください。");
        }

        private Set<ConstraintViolation<Student>> validate(Student student) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            return validator.validate(student);
        }
    }



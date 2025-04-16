package raisetech.StudentManagement.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultMatcher;
import raisetech.StudentManagement.service.StudentService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


    @WebMvcTest(StudentController.class)
    class StudentControllerTest{
        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private StudentService service;

        @Test
        void 受講生詳細の一覧検索が実行できて空のリストが返ってくること() throws Exception {

            mockMvc.perform(get("/studentList"))
                    .andExpect(status().isOk())
                    .andExpect(content().json("{}"));
verify(service, times(1)).searchStudentList();
        }

    }



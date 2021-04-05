package com.example.demo.api;

import com.example.demo.common.entity.Gender;
import com.example.demo.infrastructure.persistence.entity.StudentPo;
import com.example.demo.infrastructure.persistence.repository.JpaStudentRepository;
import com.example.demo.presentation.vo.CreateStudentCommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentApiTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private JpaStudentRepository jpaStudentRepository;

    @BeforeEach
    public void setup() {
        jpaStudentRepository.deleteAll();
        StudentPo student1 = StudentPo.builder().name("s").age(18).gender(Gender.FEMALE).phoneNumber("11111111112")
                .build();
        jpaStudentRepository.save(student1);
        StudentPo student = StudentPo.builder().name("sy").age(18).gender(Gender.FEMALE).phoneNumber("11111111113")
                .build();
        jpaStudentRepository.save(student);
    }

    @Test
    @Order(1)
    public void should_create_student_success() throws Exception {
        CreateStudentCommand command = CreateStudentCommand.builder()
                .name("syc")
                .phoneNumber("11111111111")
                .age(19)
                .gender(Gender.FEMALE)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(command);

        mockMvc.perform(post("/students").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(2)
    public void should_get_students_success() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)));
    }
}

package com.example.demo.api;

import com.example.demo.common.entity.Gender;
import com.example.demo.presentation.vo.CreateStudentCommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentApiTest {
    @Autowired
    MockMvc mockMvc;

    @Test
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
}

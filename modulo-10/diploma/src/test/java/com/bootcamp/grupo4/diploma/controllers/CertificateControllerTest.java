package com.bootcamp.grupo4.diploma.controllers;

import static org.mockito.ArgumentMatchers.any;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bootcamp.grupo4.diploma.dtos.CertificateDTO;
import com.bootcamp.grupo4.diploma.dtos.StudentDTO;
import com.bootcamp.grupo4.diploma.dtos.SubjectDTO;
import com.bootcamp.grupo4.diploma.entities.Student;
import com.bootcamp.grupo4.diploma.services.CertificateService;
import com.bootcamp.grupo4.diploma.services.CertificateServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class CertificateControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldAnalyzeNotes() throws Exception {
        StudentDTO studentDTO = new StudentDTO("Lucas", List.of(
                new SubjectDTO("Física", 10),
                new SubjectDTO("História", 9),
                new SubjectDTO("Geografia", 9)));

        String payload = mapper.writeValueAsString(studentDTO);

        double expectedAverage = 9.3;
        String expectedMessage = "Sua média foi de 9.3. Aprovado. Parabéns!";

        mvc.perform(post("/analyzeNotes")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value(expectedMessage))
                .andExpect(jsonPath("$.average").value(expectedAverage));
    }

    @Test
    public void shouldAnalyzeNotesAndWriteReprovedDiploma() throws Exception {
        StudentDTO studentDTO = new StudentDTO("Lucas", List.of(
                new SubjectDTO("Física", 6),
                new SubjectDTO("História", 6),
                new SubjectDTO("Geografia", 6)));

        String payload = mapper.writeValueAsString(studentDTO);

        double expectedAverage = 6.0;
        String expectedMessage = "Sua média foi de 6.0. Reprovado.";

        mvc.perform(post("/analyzeNotes")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value(expectedMessage))
                .andExpect(jsonPath("$.average").value(expectedAverage));
    }

    @Test
    public void shouldNotAnalyzeNotesIfSubjectsIsEmpty() throws Exception {
        StudentDTO studentDTO = new StudentDTO("Lucas", new ArrayList<>());

        String payload = mapper.writeValueAsString(studentDTO);

        String expectedMessage = "Reprovado.";

        mvc.perform(post("/analyzeNotes")
                    .contentType("application/json")
                    .content(payload))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.message").value(expectedMessage))
                    .andExpect(jsonPath("$.student.subjects").isArray())
                    .andExpect(jsonPath("$.student.subjects", Matchers.hasSize(0)));
    }

    @Test
    public void shouldNotAnalyzeNotesWithInvalidParams() throws Exception {
        StudentDTO studentDTO = new StudentDTO("", List.of(
                new SubjectDTO("Física", 10)));

        String payload = mapper.writeValueAsString(studentDTO);

        mvc.perform(post("/analyzeNotes")
                .contentType("application/json")
                .content(payload))
                .andExpect(status().isBadRequest());
    }

}

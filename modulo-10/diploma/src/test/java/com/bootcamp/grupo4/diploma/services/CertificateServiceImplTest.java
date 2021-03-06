package com.bootcamp.grupo4.diploma.services;

import com.bootcamp.grupo4.diploma.dtos.CertificateDTO;
import com.bootcamp.grupo4.diploma.dtos.StudentDTO;
import com.bootcamp.grupo4.diploma.dtos.SubjectDTO;
import com.bootcamp.grupo4.diploma.entities.Student;
import com.bootcamp.grupo4.diploma.entities.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CertificateServiceImplTest {

    private CertificateService certificateService;

    @BeforeEach
    public void init() {
        certificateService = new CertificateServiceImpl();
    }

    @Test
    public void shouldBeAbleToAnalyzeNotes() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>(Arrays.asList(
                new SubjectDTO("Física", 10),
                new SubjectDTO("História", 9),
                new SubjectDTO("Geografia", 9)
        ));

        List<Subject> subjects = SubjectDTO.convert(subjectDTOS);
        Student student = new Student("Lucas", subjects);
        CertificateDTO expected = new CertificateDTO(9.3, student,
                "Sua média foi de 9.3. Aprovado. Parabéns!");

        StudentDTO studentDTO = new StudentDTO("Lucas", subjectDTOS);
        CertificateDTO response = this.certificateService.analyzeNotes(studentDTO);

        assertEquals(expected.toString(), response.toString());
    }

    @Test
    public void shouldNotBeAbleToAnalyzeNotesWithEmptySubjects() {
        CertificateDTO unexpected = new CertificateDTO(9.0, new Student("Lucas", List.of(
                new Subject("Física", 9)
        )), "Sua média foi de 9.0. Aprovado. Parabéns!");

        StudentDTO studentDTO = new StudentDTO("Lucas", new ArrayList<>());
        CertificateDTO response = this.certificateService.analyzeNotes(studentDTO);

        assertNotEquals(unexpected.toString(), response.toString());
    }

    @Test
    public void shouldBeAbleToCalculateAverage() {
        double expected = 7.5;
        List<Subject> subjects = new ArrayList<>(Arrays.asList(
                new Subject("Física", 8),
                new Subject("História", 7)
        ));

        double average = this.certificateService.calculateAverage(subjects);

        assertEquals(expected, average);
    }

    @Test
    public void shouldBeAbleToRoundWhenCalculatingAverage() {
        double unexpected = 6.66;
        List<Subject> subjects = new ArrayList<>(Arrays.asList(
                new Subject("Física", 8),
                new Subject("História", 7),
                new Subject("Geografia", 5)
        ));

        double average = this.certificateService.calculateAverage(subjects);

        assertNotEquals(unexpected, average);
    }

    @Test
    public void shouldBeAbleToWriteADiploma() {
        List<Subject> subjects = new ArrayList<>(Arrays.asList(
                new Subject("Física", 10),
                new Subject("História", 9),
                new Subject("Geografia", 9)
        ));
        Student student = new Student("Lucas", subjects);

        double average = 9.3;
        String message = "Sua média foi de 9.3. Aprovado. Parabéns!";

        CertificateDTO expected = new CertificateDTO(average, student, message);
        CertificateDTO response = this.certificateService.writeDiploma(student, average, message);

        assertEquals(expected.toString(), response.toString());
    }

    @Test
    public void shouldBeAbleToAddHonors() {
        String expected = "Sua média foi de 9.3. Aprovado. Parabéns!";
        List<Subject> subjects = new ArrayList<>(Arrays.asList(
                new Subject("Física", 10),
                new Subject("História", 9),
                new Subject("Geografia", 9)
        ));

        String message = this.certificateService.withHonors(9.3);

        assertEquals(expected, message);
    }

    @Test
    public void shouldNotAddHonorsIfAverageIsLessThan9() {
        String expected = "Sua média foi de 9.0. Aprovado. Parabéns!";
        List<Subject> subjects = new ArrayList<>(Arrays.asList(
                new Subject("Física", 9),
                new Subject("História", 9),
                new Subject("Geografia", 9)
        ));

        String message = this.certificateService.withHonors(9.0);

        assertNotEquals(expected, message);
    }

    @Test
    public void shouldAddReprovedMessageIfAverageIsLessThan7() {
        String expected = "Sua média foi de 6.0. Reprovado.";

        List<Subject> subjects = new ArrayList<>(Arrays.asList(
                new Subject("Física", 6),
                new Subject("História", 6),
                new Subject("Geografia", 6)
        ));

        String message = this.certificateService.withHonors(6.0);

        assertEquals(expected, message);
    }
}

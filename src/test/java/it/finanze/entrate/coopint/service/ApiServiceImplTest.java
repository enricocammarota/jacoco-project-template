package it.finanze.entrate.coopint.service;

import it.finanze.entrate.coopint.entity.Student;
import it.finanze.entrate.coopint.service.impl.ApiServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ApiServiceImplTest {

    @InjectMocks
    private ApiServiceImpl apiService;

    @Test
    void correctlyRetrieveStudentInformation() {
        String studentName = "foo";
        String expectedStudentSurname = "bar";
        Integer expectedStudentAge = 18;

        Optional<Student> student = apiService.getStudentByName(studentName);
        student.ifPresent(s -> {
            assertEquals(expectedStudentSurname, s.getSurname());
            assertEquals(expectedStudentAge, s.getAge());
        });
    }

    @Test
    void returnsEmptyIfStudentDoesNotExist() {
        String studentName = "bar";

        Optional<Student> student = apiService.getStudentByName(studentName);
        assertEquals(Optional.empty(), student);
    }
}

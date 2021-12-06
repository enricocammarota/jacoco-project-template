package it.finanze.entrate.coopint.web;

import it.finanze.entrate.coopint.JacocoProjectTemplateApplication;
import it.finanze.entrate.coopint.entity.Student;
import it.finanze.entrate.coopint.service.IApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = ApiController.class)
@ContextConfiguration(classes = {JacocoProjectTemplateApplication.class})
public class ApiControllerTest {

    private static final String GET_STUDENT_INFO_API_URL = "/student-api";
    private static final String STUDENT_API_URL = "http://foo";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IApiService apiService;

    @Test
    void correctlyRetrieveStudentInformation() throws Exception {
        String studentName = "foo";

        when(apiService.getStudentByName(studentName)).thenReturn(
                Optional.of(new Student("foo", "bar", 16)));

        mockMvc.perform(get(GET_STUDENT_INFO_API_URL + "/" + studentName))
                .andExpect(status().isOk());
    }

    @Test
    void returnsNotFoundIfTheStudentDoesNotExists() throws Exception {
        String studentName = "bar";

        when(apiService.getStudentByName(studentName)).thenReturn(Optional.empty());

        mockMvc.perform(get(GET_STUDENT_INFO_API_URL + "/" + studentName))
                .andExpect(status().isNotFound());
    }

    @Test
    void returnsNotFoundIfTheEndpointDoesNotExists() throws Exception {
        mockMvc.perform(get(STUDENT_API_URL))
                .andExpect(status().isNotFound());
    }
}

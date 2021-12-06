package it.finanze.entrate.coopint.web;

import it.finanze.entrate.coopint.entity.Student;
import it.finanze.entrate.coopint.service.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/student-api")
public class ApiController {

    private final IApiService apiService;

    @Autowired
    public ApiController(IApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/{studentName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> getStudentInformationByName(@PathVariable String studentName) {
        return apiService.getStudentByName(studentName)
                .map(ResponseEntity::ok)
                .orElseGet(() -> notFound().build());
    }

}

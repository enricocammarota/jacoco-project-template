package it.finanze.entrate.coopint.service.impl;

import it.finanze.entrate.coopint.entity.Student;
import it.finanze.entrate.coopint.service.IApiService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApiServiceImpl implements IApiService {

    @Override
    public Optional<Student> getStudentByName(String name) {
        if (name.equals("foo")) {
            Student student = new Student(
                    "foo",
                    "bar",
                    18);
            return Optional.of(student);
        } else {
            return Optional.empty();
        }
    }
}

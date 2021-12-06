package it.finanze.entrate.coopint.service;

import it.finanze.entrate.coopint.entity.Student;

import java.util.Optional;

public interface IApiService {

    Optional<Student> getStudentByName(String name);
}

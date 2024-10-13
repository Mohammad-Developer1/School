package service.impl;

import model.Student;
import repository.BaseRepository;
import repository.StudentRepository;
import service.StudentService;
import util.SecurityContext;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class StudentServiceImpl implements StudentService {


    private StudentRepository sr;

    public StudentServiceImpl(StudentRepository sr) {
        this.sr = sr;
    }

    @Override
    public void printAllList() {
        try {
            List<Student> students = sr.getAll();
            System.out.printf("\u001B[35m" + "%-7s %-13s %-13s %-13s %-17s\n", "id", "first name", "last name", "birth day", "national code");
            for (Student student : students) {
                System.out.printf("%-7s %-13s %-13s %-13s %-17s\n",
                        student.getStudentId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getDob(),
                        student.getNationalCode());
            }

        } catch (SQLException sqlException) {
            System.out.println("there is problem with connecting to database");
        }
        System.out.println("\033[0m");
    }


    @Override
    public boolean add(Student student) throws SQLException {
        if (student == null) {
            throw new IllegalArgumentException("student cannot be null");
        }
        return sr.add(student);
    }

    @Override
    public boolean remove(String nationalCode) throws SQLException {
        Optional<Student> optionalStudents = sr.getByNationalCode(nationalCode);
        return sr.remove(optionalStudents.get());
    }

    @Override
    public boolean update(String nationalCode, Student newStudent) throws SQLException {
        Optional<Student> optionalStudent = sr.getByNationalCode(nationalCode);
        if (optionalStudent.isEmpty() || newStudent == null) {
            throw new IllegalArgumentException("student is null");
        } else {
            return sr.update(newStudent);
        }
    }

    @Override
    public Optional<Student> getNationalCode(String nationalCode) throws SQLException {
        if (sr.getByNationalCode(nationalCode).isEmpty()) {
            throw new IllegalArgumentException("nationalCode does not exists");
        } else {
            return sr.getByNationalCode(nationalCode);
        }
    }

    @Override
    public boolean signInStudent(int studentId, String nationalCode) throws SQLException {
        Optional<Student> optionalStudent = sr.getByNationalCode(nationalCode);
        if (optionalStudent.isPresent()) {
            SecurityContext.student = optionalStudent.get();
            return true;
        }
        return false;
    }
}

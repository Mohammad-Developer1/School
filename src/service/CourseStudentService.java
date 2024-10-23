package service;

import model.dto.CourseDto;
import model.dto.Reportcard;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CourseStudentService {
    List<CourseDto> getCourses()throws SQLException;
    boolean addCourse(String courseTitle) throws SQLException;
    void showMyCourses() ;
    Optional<List<Reportcard>> reportCard()throws SQLException;
    boolean removeCourse(String courseTitle) throws SQLException;
}

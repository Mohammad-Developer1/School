package service;

import model.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;

public interface CourseStudentService {
    List<CourseDto> getCourses()throws SQLException;

}
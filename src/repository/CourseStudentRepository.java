package repository;

import model.dto.CourseDto;
import model.dto.Reportcard;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CourseStudentRepository {

    List<CourseDto> getCourses() throws SQLException;
    boolean addCourse(int courseId,long studentId,String national_code) throws SQLException;
    boolean deleteCourse(int courseId,long studentId,String nationalCode)throws SQLException;
    int getCountCourseStudent(int courseId,long studentId)throws SQLException;
    Optional<List<Reportcard>> reportCard(long studentId)throws SQLException;


}

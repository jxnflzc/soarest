package per.jxnflzc.soarest.service;

import org.springframework.stereotype.Service;
import per.jxnflzc.soarest.domain.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourse();

    public Course getCourseByID(String id);

    public Course getCourseByName(String name);

    public boolean insertCourse(Course course);

    public boolean deleteCourseByID(String id);

    public boolean updateCourse(Course course);
}

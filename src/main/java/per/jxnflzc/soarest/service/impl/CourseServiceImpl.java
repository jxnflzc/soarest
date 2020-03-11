package per.jxnflzc.soarest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.jxnflzc.soarest.domain.Course;
import per.jxnflzc.soarest.persistence.CourseDAO;
import per.jxnflzc.soarest.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDAO courseDAO;

    @Override
    public List<Course> getCourse() {
        return courseDAO.getCourse();
    }

    @Override
    public Course getCourseByID(String id) {
        return courseDAO.getCourseByID(id);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseDAO.getCourseByName(name);
    }

    @Override
    public boolean insertCourse(Course course) {
        return courseDAO.insertCourse(course);
    }

    @Override
    public boolean deleteCourseByID(String id) {
        return courseDAO.deleteCourseByID(id);
    }

    @Override
    public boolean updateCourse(Course course) {
        return courseDAO.updateCourse(course);
    }
}

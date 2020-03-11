package per.jxnflzc.soarest.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import per.jxnflzc.soarest.domain.Course;

import java.util.List;

@Mapper
public interface CourseDAO {
    public List<Course> getCourse();

    public Course getCourseByID(String id);

    public Course getCourseByName(String name);

    public boolean insertCourse(Course course);

    public boolean deleteCourseByID(String id);

    public boolean updateCourse(Course course);
}

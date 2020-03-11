package per.jxnflzc.soarest.controller;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import per.jxnflzc.soarest.domain.Course;
import per.jxnflzc.soarest.service.CourseService;
import net.sf.json.JSONObject;
import net.sf.json.JSON;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "course", method = RequestMethod.GET)
    public List<Course> getCourse(){
        return courseService.getCourse();
    }

    @RequestMapping(value = "course", params = "id", method = RequestMethod.GET)
    public Course getCourseByID(@RequestParam("id") String id){
        return courseService.getCourseByID(id);
    }

    @RequestMapping(value = "course/{id:\\d+}-{name:\\d+}", method = RequestMethod.GET)
    public String getCourseById(@PathVariable(name="id") String id, @PathVariable(name="name") String name){
        return id + "-" + name;
    }

    @RequestMapping(value = "course", params = "name", method = RequestMethod.GET)
    public Course getCourseByName(String name){
        return courseService.getCourseByName(name);
    }

    @RequestMapping(value = "course", method = RequestMethod.POST)
    public JSONObject insertCourse(Course course){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", courseService.insertCourse(course));
        return jsonObject;
    }

    @RequestMapping(value = "course", method = RequestMethod.DELETE)
    public JSONObject deleteCourseByID(String id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", courseService.deleteCourseByID(id));
        return jsonObject;
    }

    @RequestMapping(value = "course", method = RequestMethod.PUT)
    public JSONObject updateCourse(Course course){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", courseService.updateCourse(course));
        return jsonObject;
    }
}

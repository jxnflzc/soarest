package per.jxnflzc.soarest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class APICourseController {
    @RequestMapping(value = "api", method = RequestMethod.GET)
    public String api(){
        return "course/api";
    }
}

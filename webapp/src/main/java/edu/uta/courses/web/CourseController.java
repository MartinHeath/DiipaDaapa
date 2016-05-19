package edu.uta.courses.web;

import edu.uta.courses.repository.domain.Course;
import edu.uta.courses.repository.domain.CourseUi;
import edu.uta.courses.service.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Martin
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    
    @Autowired
    CourseService courseService;
    
    @RequestMapping("/home")
    public String home(Model model){
        String content = courseService.getContent();
        model.addAttribute("content", content);
        return "/course/home";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String editCourseOpen( @ModelAttribute("form") CourseCreateForm form, Model model) {

        return "/course/create";
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String editPersonCommit( @Validated @ModelAttribute("form") CourseCreateForm form, Model model) {
        Course course = new Course();
        
        course.setCourseId(form.getCourseId());
        course.setCourseName(form.getCourseName());
        course.setCourseDescription(form.getCourseDescription());
        
        courseService.create(course);
        model.addAttribute("currentCourse", course);
        return "/course/show";
    }
    
    @RequestMapping(value = "/list")
    public String editCourseOpen(Model model) {
        List<CourseUi> courses = courseService.list();
        model.addAttribute("courses", courses);
        return "/course/list";
    }
    
    @RequestMapping(value = "/delete")
    public String deleteCourse(@RequestParam("courseId") Long id, Model model) {
        CourseUi c= courseService.getCourseById(id);
        courseService.delete(c);
        List<CourseUi> courses = courseService.list();
        model.addAttribute("courses", courses);
        return "redirect:/course/list";
    }
    
    //I use the course creation form, as it is exactly the same as the update form.
    @RequestMapping(value="/update")
    public String updateCourseOpen(@RequestParam("courseId") Long id, @ModelAttribute("form") CourseCreateForm form, Model model) {
        CourseUi c = courseService.getCourseById(id);
        
        form.setCourseId(c.getCourseId());
        form.setCourseName(c.getCourseName());
        form.setCourseDescription(c.getCourseDescription());
        model.addAttribute("id", c.getCourseId());
        return "/course/update";
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public String UpdateCourseCommit(@ModelAttribute("form") CourseCreateForm form, Model model) {
        CourseUi oldCourse = courseService.getCourseById(form.getCourseId());
        CourseUi newCourse = new CourseUi();
        newCourse.setCourseId(oldCourse.getCourseId());
        newCourse.setCourseName(form.getCourseName());
        newCourse.setCourseDescription(form.getCourseDescription());
        
        courseService.update(newCourse);
        model.addAttribute("oldCourse", oldCourse);
        model.addAttribute("newCourse", newCourse);
        return "/course/compare";
    }
    
    @RequestMapping("/hello")
    @ResponseBody
    public List<CourseUi> Course() {
        return courseService.list();
    }
}

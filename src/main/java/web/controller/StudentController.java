package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import web.model.Student;
import web.service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String index(ModelMap model) {
        model.addAttribute("studentForm", new Student());
        List<Student> studentList = studentService.getAll();
        model.addAttribute("students", studentList);
        return "students";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student, Model model) {
        studentService.addStudent(student);
        model.addAttribute("studentForm", new Student());
        model.addAttribute("students", studentService.getAll());
        return "redirect:/";
    }


    @GetMapping("/edit")
    public String updateStudent(@RequestParam("id")@ModelAttribute int id, Model model) {
    model.addAttribute("editStudentForm", new Student());
    model.addAttribute("id", id);
    model.addAttribute("student",studentService.getStudentById(id));
    return "edit";
    }
    @PostMapping("/edited")
    public String postUpdateStudent(@ModelAttribute Student newStudent, @RequestParam("id") int id, Model model) {
        studentService.updateStudentById(id, newStudent.getFirstName(), newStudent.getLastName(), newStudent.getDegree());
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id, Model model) {
        studentService.deleteStudentById(id);
        model.addAttribute("studentForm", new Student());
        model.addAttribute("student", studentService.getAll());
        return "redirect:/";
    }
}

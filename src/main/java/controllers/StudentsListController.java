package controllers;

import entity.Student;
import services.StudentService;
import services.impl.StudentServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by M-Book on 16.05.2015.
 */
public class StudentsListController extends AbstractWebtasksServletHandler {
    @Override
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        StudentService studentService = new StudentServiceImpl();
        List <Student> studentsList = studentService.getStudents();
        request.setAttribute("students", studentsList);
        gotoToJSP("/main/student/studentsList.jsp", request, response);
    }
}

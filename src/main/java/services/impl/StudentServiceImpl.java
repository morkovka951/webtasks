package services.impl;

import entity.Student;
import services.StudentService;

import java.util.List;

/**
 * Created by M-Book on 17.05.2015.
 */
public class StudentServiceImpl implements StudentService {

    private
    @Override
    public boolean studentModifing(int idStudent) {
        return false;
    }

    @Override
    public boolean studentDelete(int idStudent) {
        return false;
    }

    @Override
    public boolean studentAdd(int idStudent) {
        return false;
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }
}

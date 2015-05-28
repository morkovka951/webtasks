package services.impl;

import dao.StudentsDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import services.StudentService;

import java.util.List;

/**
 * Created by M-Book on 17.05.2015.
 */
public class StudentServiceImpl implements StudentService {

    private StudentsDao studentsDao = new StudentDaoImpl();

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
        return studentsDao.getStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }
}

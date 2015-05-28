package dao.impl;

import dao.StudentsDao;
import database.DataService;
import entity.Discipline;
import entity.Student;

import java.util.List;

/**
 * Created by Morkovka on 17.05.2015.
 */
public class StudentDaoImpl implements StudentsDao {

    private DataService dataService = new DataService();

    @Override
    public List<Student> getStudents() {
        return dataService.getStudentsList();
    }

    @Override
    public Student getById(int id) {
        return null;
    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public boolean deletee(int id) {
        return false;
    }

    @Override
    public boolean insert(Discipline discipline) {
        return false;
    }
}

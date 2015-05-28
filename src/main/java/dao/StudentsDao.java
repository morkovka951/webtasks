package dao;

import entity.Discipline;
import entity.Student;

import java.util.List;

/**
 * Created by Morkovka on 17.05.2015.
 */
public interface StudentsDao {


        List<Student> getStudents();

        Student getById(int id);

        boolean update(int id);

        boolean deletee(int id);

        boolean insert(Discipline discipline);




}

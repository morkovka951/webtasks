package services.impl;

import dao.DisciplineDao;
import dao.impl.DisciplineDaoImpl;
import entity.Discipline;
import services.DisciplineServise;

import java.util.List;

/**
 * Created by Skenalard on 21.04.2015.
 */
public class DisciplineServiceImpl implements DisciplineServise {

    private DisciplineDao disciplineDao = new DisciplineDaoImpl();

    @Override
    public boolean modifing(int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {

              return disciplineDao.deletee(id);
    }

    @Override
    public boolean add(Discipline discipline) {

        //Что делать если нет дисциплины?

        return disciplineDao.insert(discipline);
    }

    @Override
    public List<Discipline> getDisciplines() {
        // Логика проверки на null, варианты предоставление информации
        return disciplineDao.getDisciplines();
    }

    @Override
    public Discipline getById(int id) {
        //Что делать если список пуст?
        return disciplineDao.getById(id);
    }
}

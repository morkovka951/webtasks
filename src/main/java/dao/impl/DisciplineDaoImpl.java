package dao.impl;

import dao.DisciplineDao;
import database.DataService;
import entity.Discipline;

import java.util.List;

/**
 * Created by Skenalard on 21.04.2015.
 */
public class DisciplineDaoImpl implements DisciplineDao {
    private DataService dataService = new DataService();

    @Override
    public List<Discipline> getDisciplines() {

        //MySQL or PSQL
        return dataService.getListDisciplines();
    }

    @Override
    public Discipline getById(int id) {

        return dataService.selectDisciplinesById(id);
    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public boolean deletee(int id) {

        return  (dataService.deleteDisciplinesById(id)> 0) ? true : false;
    }

    @Override
    public boolean insert(Discipline discipline) {

        return (dataService.insetrDisciplines(discipline) > 0) ? true : false;
    }
}

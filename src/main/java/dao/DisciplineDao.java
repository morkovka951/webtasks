package dao;

import entity.Discipline;

import java.util.List;

public interface DisciplineDao {

	List<Discipline> getDisciplines();

	Discipline getById(int id);

	boolean update(int id);

	boolean deletee(int id);

    boolean insert(Discipline discipline);

}

package services;

import entity.Discipline;

import java.util.List;

public interface DisciplineServise {

	boolean modifing(int id);

	boolean delete(int id);

	boolean add(Discipline discipline);

	List<Discipline> getDisciplines();

	Discipline getById(int id);


}

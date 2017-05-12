package task.from.intelligence.dao;

import java.util.List;

import task.from.intelligence.entity.Cat;


public interface CatDAO {

	public Cat insertCat(Cat cat);

	public Cat findCat(int id);

	public List<Cat> findAllCat();

	public void removeCat(int id);

}

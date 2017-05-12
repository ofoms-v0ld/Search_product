package task.from.intelligence.service;

import java.util.List;

import task.from.intelligence.entity.Cat;


public interface CatService {
	
	public Cat insertCat(Cat cat);

	public Cat findCat(int id);

	public List<Cat> findAllCat();

	public void removeCat(int id);
}

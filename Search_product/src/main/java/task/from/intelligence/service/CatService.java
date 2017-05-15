package task.from.intelligence.service;

import java.util.List;

import task.from.intelligence.entity.Cat;
import task.from.intelligence.pojo.Prod_pojo;


public interface CatService {
	
	public Cat insertCat(Cat cat);

	public Cat findCat(int id);

	public List<Cat> findAllCat();

	public void removeCat(int id);
	
	public List<Prod_pojo> getAll_criteria();
	
	public List<Prod_pojo> seacrh(Prod_pojo p);
}

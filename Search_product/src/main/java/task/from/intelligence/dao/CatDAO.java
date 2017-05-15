package task.from.intelligence.dao;

import java.util.List;

import task.from.intelligence.entity.Cat;
import task.from.intelligence.pojo.Prod_pojo;


public interface CatDAO {

	public Cat insertCat(Cat cat);

	public Cat findCat(int id);

	public List<Cat> findAllCat();

	public void removeCat(int id);
	
	public List<Prod_pojo> search(Prod_pojo prod_pojo);
	
	public List<Prod_pojo> getAll();
	

}

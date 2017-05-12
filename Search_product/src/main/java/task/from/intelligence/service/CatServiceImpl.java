package task.from.intelligence.service;

import java.util.List;

import task.from.intelligence.dao.CatDAOImpl;
import task.from.intelligence.entity.Cat;


public class CatServiceImpl implements CatService {

	private CatDAOImpl catDAOImpl;

	public CatServiceImpl() {
		
		this.catDAOImpl = new CatDAOImpl();
	}

	@Override
	public Cat insertCat(Cat cat) {
		return catDAOImpl.insertCat(cat);
	}

	@Override
	public Cat findCat(int id) {
		return catDAOImpl.findCat(id);
	}

	@Override
	public List<Cat> findAllCat() {
		return catDAOImpl.findAllCat();

	}

	@Override
	public void removeCat(int id) {
		// TODO Auto-generated method stub
		
	}

}

package task.from.intelligence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import task.from.intelligence.entity.Cat;
import task.from.intelligence.listener.LocalEntityManagerFactory;


public class CatDAOImpl implements CatDAO {

	public CatDAOImpl() {
	}

	EntityManager entityManager = LocalEntityManagerFactory.createEntityManager();
	
	@Override
	public Cat insertCat(Cat cat) {
		entityManager.getTransaction().begin();
		entityManager.persist(cat);
		entityManager.getTransaction().commit();
		return cat;
	}

	@Override
	public Cat findCat(int id) {
		return entityManager.find(Cat.class, id);
	}

	@Override
	public List<Cat> findAllCat() {
		TypedQuery<Cat> query = entityManager.createQuery("Select e from Cat e", Cat.class);
		return query.getResultList();

	}

	@Override
	public void removeCat(int id) {
		Cat cat = findCat(id);
		if (cat != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(cat);
			entityManager.getTransaction().commit();
		}
	}
}

package task.from.intelligence.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import task.from.intelligence.entity.Cat;
import task.from.intelligence.entity.Prod;
import task.from.intelligence.listener.LocalEntityManagerFactory;
import task.from.intelligence.pojo.Prod_pojo;


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
	
	
	/*
	 * Useful blog 
	 * http://nsinfra.blogspot.ru/2013/03/jpa-20-criteria-query-with-hibernate.html
	 * 
	 * 
	 */	
	@Override
	public List<Prod_pojo> search(Prod_pojo prod_pojo){
		
	  // Get the criteria builder instance from entity manager
      final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
      // Create criteria query and pass the value object which needs to be populated as result
      final CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Prod_pojo.class);
      // Tell to criteria query which tables/entities you want to fetch
      // To join the City and State tables, we need to write below code
      final Root catRoot = criteriaQuery.from(Cat.class);
      final Root productRoot = criteriaQuery.from(Prod.class);
      
      List criteriaList = new ArrayList();

      
      // condition: catId = prodId
	    Predicate predicate1 = criteriaBuilder.equal(productRoot.get("cat_id").get("id"),catRoot.get("id"));
	    criteriaList.add(predicate1);
	    
	    if(prod_pojo.getProdname() != null && prod_pojo.getProdname().length() > 0){
	    	Predicate predicate3 = criteriaBuilder.like(criteriaBuilder.upper(productRoot.get("name")),new String("%"+prod_pojo.getProdname()+"%").toUpperCase());
	    	criteriaList.add(predicate3); 
	    }
	    if(prod_pojo.getPrice_min() != null && prod_pojo.getPrice_min().length() > 0){
	    	Predicate predicate5 = criteriaBuilder.ge(productRoot.get("price"), Double.valueOf(prod_pojo.getPrice_min()));
	    	criteriaList.add(predicate5);
	    }	
	    if(prod_pojo.getPrice_max() != null && prod_pojo.getPrice_max().length() > 0){
	    	Predicate predicate6 = criteriaBuilder.le(productRoot.get("price"), Double.valueOf(prod_pojo.getPrice_max()));
	    	criteriaList.add(predicate6); 
	    }
	    
	    if(prod_pojo.getCatname() != null && prod_pojo.getCatname().length() > 0){
	    	Predicate predicate4 = criteriaBuilder.like(criteriaBuilder.upper(productRoot.get("cat_id").get("name")),new String("%"+prod_pojo.getCatname()+"%").toUpperCase());
	    	criteriaList.add(predicate4); 
	    }
	    
	  // This statement maps your Prod_pojo with result data
      criteriaQuery.select(criteriaBuilder.construct(Prod_pojo.class,productRoot.get("id"),productRoot.get("cat_id").get("name"),productRoot.get("name"),productRoot.get("price")));
      
      
      criteriaQuery.where(criteriaBuilder.and((Predicate[]) criteriaList.toArray(new Predicate[0])));
      
      final TypedQuery query = entityManager.createQuery(criteriaQuery);

      return query.getResultList();
	}
	
	@Override
	public List<Prod_pojo> getAll(){
		
		// Get the criteria builder instance from entity manager
	      final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	      // Create criteria query and pass the value object which needs to be populated as result
	      final CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Prod_pojo.class);
	      // Tell to criteria query which tables/entities you want to fetch
	      // To join the City and State tables, we need to write below code
	      final Root catRoot = criteriaQuery.from(Cat.class);
	      final Root productRoot = criteriaQuery.from(Prod.class);
	      
	      List criteriaList = new ArrayList();

	      
	      // condition: catId = prodId
		    Predicate predicate1 = criteriaBuilder.equal(productRoot.get("cat_id").get("id"),catRoot.get("id"));
		    criteriaList.add(predicate1);
		    
		 // This statement maps your Prod_pojo with result data
		 criteriaQuery.select(criteriaBuilder.construct(Prod_pojo.class,productRoot.get("id"),productRoot.get("cat_id").get("name"),productRoot.get("name"),productRoot.get("price")));
        
		 criteriaQuery.where(criteriaBuilder.and((Predicate[]) criteriaList.toArray(new Predicate[0])));
	      
	      final TypedQuery query = entityManager.createQuery(criteriaQuery);

	      return query.getResultList();
			
		
	}
	
	
	
}

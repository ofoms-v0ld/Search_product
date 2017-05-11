
import org.junit.Before;
import org.junit.Test;

import task.from.intelligence.entity.Prod;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdTest {

	 private EntityManagerFactory entityManagerFactory;

	    @Before
	    public void setUp() throws Exception {
	        Prod productJpa = new Prod();
	       // productJpa.setCat_id(1);
	        productJpa.setName("Test1");
	        productJpa.setPrice(99.99);

	        Prod productHibernate = new Prod();
	        //productJpa.setCat_id(2);
	        productJpa.setName("Test2");
	        productJpa.setPrice(9.99);

	        entityManagerFactory = Persistence.createEntityManagerFactory("default");
	        EntityManager em = entityManagerFactory.createEntityManager();
	        em.getTransaction().begin();
	        em.persist(productJpa);
	        em.persist(productHibernate);
	        em.getTransaction().commit();
	        em.close();
	    }

	    @Test
	    public void testProd() {
	        EntityManager em = entityManagerFactory.createEntityManager();
	        em.getTransaction().begin();
	        em.createQuery("from Prod", Prod.class)
	                .getResultList()
	                .forEach(g -> System.out.println(String.format("%s, %s!", g.getId(), g.getName(), g.getPrice())));
	        em.getTransaction().commit();
	        em.close();
	    }
}

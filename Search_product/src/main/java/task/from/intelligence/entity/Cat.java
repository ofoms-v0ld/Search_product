package task.from.intelligence.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;



@Entity
@NamedQuery(name = "Cat.getAll", query = "SELECT c from Cat c")
public class Cat implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public Cat() {}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
    private Integer id;
    private String name;
    @OneToMany(mappedBy="cat_id", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Prod> products;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Prod> getProducts() {
		return products;
	}
	public void setProducts(Set<Prod> products) {
		this.products = products;
	}


}

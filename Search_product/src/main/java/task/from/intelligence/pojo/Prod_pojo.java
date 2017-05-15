package task.from.intelligence.pojo;


public class Prod_pojo {

    public Prod_pojo() {
		
	}
    
    public Prod_pojo(Integer prodid, String catname, String prodname, Double prodprice) {
		this.prodid = prodid;
		this.catname = catname;
		this.prodname = prodname;
		this.prodprice = prodprice;
		
		
	}
    
	private Integer prodid;
	//private Cat cat_id;
	private String catname;
    private String prodname;
    private Double prodprice;
    private String price_min;
    private String price_max;
    
	public Integer getProdid() {
		return prodid;
		
	}
	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}
	
	

	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public Double getProdprice() {
		return prodprice;
	}
	public void setProdprice(Double prodprice) {
		this.prodprice = prodprice;
	}

	

	public String getPrice_min() {
		return price_min;
	}

	public void setPrice_min(String price_min) {
		this.price_min = price_min;
	}

	public String getPrice_max() {
		return price_max;
	}

	public void setPrice_max(String price_max) {
		this.price_max = price_max;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	@Override
	public String toString() {
		return "Prod_pojo [prodid=" + prodid + ", catname=" + catname + ", prodname=" + prodname + ", prodprice="
				+ prodprice + "]";
	}

	
    
		
}

package com.example.demo.model;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="CategoryRelation")
public class Category {
	@Id
	@GeneratedValue
	private int categoryid;
	private String categoryname;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="categorycode")
	private List<Product> prodlist;
	
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public List<Product> getProdlist() {
		return prodlist;
	}
	public void setProdlist(List<Product> prodlist) {
		this.prodlist = prodlist;
	}
}

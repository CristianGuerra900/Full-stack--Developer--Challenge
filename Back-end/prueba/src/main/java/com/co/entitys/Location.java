package com.co.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Cristian Guerra
 * @version 1.0
 * @since 1.0
*/
@Entity
@Table(name="locations")
public class Location {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 30)
	private String name;
	
	@Column(name = "area_m2", nullable = false, length = 30)
	private float area_m2;
	
	@Column(name="parentLoc", nullable = true)
	private Long parentLoc;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getArea_m2() {
		return area_m2;
	}
	public void setArea_m2(float area_m2) {
		this.area_m2 = area_m2;
	}
	public Long getParentLoc() {
		return parentLoc;
	}
	public void setParentLoc(Long parentLoc) {
		this.parentLoc = parentLoc;
	}
	
}

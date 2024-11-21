package com.sr;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class tb {
	@Id
	@GeneratedValue
	private Integer id;
	
	
private String name;
private double amount;
private String rel;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getRel() {
	return rel;
}
public void setRel(String rel) {
	this.rel = rel;
}
	
	

}

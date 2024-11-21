package com.sr;

import java.time.LocalDate;
import java.util.Date;

public class Purchase {

private Date date;

private String dl1;
private double da1;
private String dl2;

public Purchase(Date date, String dl1, double da1, String dl2, double da2) {
	super();
	this.date = date;
	this.dl1 = dl1;
	this.da1 = da1;
	this.dl2 = dl2;
	this.da2 = da2;
}
private double da2;
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

public String getDl1() {
	return dl1;
}
public void setDl1(String dl1) {
	this.dl1 = dl1;
}
public String getDl2() {
	return dl2;
}
public void setDl2(String dl2) {
	this.dl2 = dl2;
}
public double getDa1() {
	return da1;
}
public void setDa1(double da1) {
	this.da1 = da1;
}
public double getDa2() {
	return da2;
}
public void setDa2(double da2) {
	this.da2 = da2;
}

}

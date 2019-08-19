package com.myproject.demoproject;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Aliens
{
	private String name ; 
	private int points ;
	private int id ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Aliens [name=" + name + ", points=" + points + ", id=" + id + "]";
	}

	
	
}

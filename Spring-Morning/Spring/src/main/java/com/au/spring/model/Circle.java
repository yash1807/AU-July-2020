package com.au.spring.model;

public class Circle implements Shape{
	private String type;
	private Point center;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	Circle(Point center, String type)
	{
		this.center = center;
		this.type = type;
	}
	
	public Double area(double r)
	{
		return 3.14*r*r;
	}
	
	public void draw() {
		System.out.println("Inside Circle type : " + this.type);
		System.out.println( "center : " + this.getCenter().getX() + " " + this.getCenter().getY());
	}
}

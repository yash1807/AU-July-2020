package com.au.spring.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Required;


public class Triangle implements Shape{
	
	private String type;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private Map<Character, Point> pointMap;
	
	public Map<Character, Point> getPointMap() {
		return pointMap;
	}

	public void setPointMap(Map<Character, Point> pointMap) {
		this.pointMap = pointMap;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public String getType() {
		return type;
	}

	@Required
	public void setType(String type) {
		this.type = type;
	}

	public Double area()
	{
		int x1 = this.pointA.getX();
		int y1 = this.pointA.getY();
		int x2 = this.pointB.getX();
		int y2 = this.pointB.getY();
		int x3 = this.pointC.getX();
		int y3 = this.pointC.getY();
		
		return 0.5*(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2));	
	}
	
	public void draw() {
		System.out.println("Inside Triangle type : " + this.type);
		System.out.println( "Coordinates of triangle are : A(" + this.pointA.getX() + "," + this.pointA.getY() + ") " + "B(" + this.pointB.getX() + "," + this.pointB.getY() + ") " + "C(" + this.pointC.getX() + "," + this.pointC.getY() + ")");
	}
	
}

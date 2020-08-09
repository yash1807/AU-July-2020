package com.soap.AU.model;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = -5577579081118070434L;	
	private int rollno;	
	private String name;
	private int age;
	
	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString(){
		return "Rollno : "+rollno+", Name : "+name+", Age : "+age;
	}
}

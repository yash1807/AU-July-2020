package com.au.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.au.spring.model.Circle;
import com.au.spring.model.Triangle;

public class SpringMain {
	
	public static void main(String[] args){
	@SuppressWarnings("resource")
	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	Triangle triangle = context.getBean(Triangle.class);
	triangle.draw();
	System.out.println("Area of triangle is : " + triangle.area());
	
	Circle circle = context.getBean(Circle.class);
	circle.draw();
	System.out.println("Area of circle is : " + circle.area(5));
	
	
	}
	
}

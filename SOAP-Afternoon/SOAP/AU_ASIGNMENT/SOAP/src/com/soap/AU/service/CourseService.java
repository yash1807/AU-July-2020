package com.soap.AU.service;

import com.soap.AU.model.Course;

public interface CourseService {

	public boolean addCourse(Course s);
	
	public boolean deleteCourse(int id);
	
	public Course getCourse(int id);
	
	public Course[] getAllCourses();
	
}

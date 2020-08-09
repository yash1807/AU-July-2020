package com.soap.AU.service;

import com.soap.AU.model.Course;
import com.soap.AU.model.Student;
import com.soap.AU.model.Student_course;

public interface StudentCourseService {

	public boolean assignCourseToStudent(int rollno,int courseid);
	
	public boolean deleteCourseToStudent(int rollno,int courseid);
	
	public Student_course[] getAllStudentWithCourses();
	
	public Course[] getCourseOfStudent(int rollno);
	
	public Student[] getStudentOfCourse(int courseId);
}

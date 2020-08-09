/**
 * StudentCourseServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.soap.au.service.impl;

public interface StudentCourseServiceImpl extends java.rmi.Remote {
    public com.soap.au.model.Course[] getCourseOfStudent(int rollno) throws java.rmi.RemoteException;
    public com.soap.au.model.Student[] getStudentOfCourse(int courseId) throws java.rmi.RemoteException;
    public int getStudentCoursesId(int rollno, int courseid) throws java.rmi.RemoteException;
    public com.soap.au.model.Student_course[] getAllStudentWithCourses() throws java.rmi.RemoteException;
    public boolean deleteCourseToStudent(int rollno, int courseid) throws java.rmi.RemoteException;
    public boolean assignCourseToStudent(int rollno, int courseid) throws java.rmi.RemoteException;
}

/**
 * StudentServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.soap.au.service.impl;

public interface StudentServiceImpl extends java.rmi.Remote {
    public boolean deleteStudent(int rollno) throws java.rmi.RemoteException;
    public com.soap.au.model.Student[] getAllStudents() throws java.rmi.RemoteException;
    public boolean addStudent(com.soap.au.model.Student s) throws java.rmi.RemoteException;
    public com.soap.au.model.Student getStudent(int rollno) throws java.rmi.RemoteException;
    public boolean changeAge(int rollno, int age) throws java.rmi.RemoteException;
}

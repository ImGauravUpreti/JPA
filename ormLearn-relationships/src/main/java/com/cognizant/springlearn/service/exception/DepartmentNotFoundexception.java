package com.cognizant.springlearn.service.exception;

@SuppressWarnings("serial")
public class DepartmentNotFoundexception extends Exception {
	
	public DepartmentNotFoundexception()
	{
		super();
	}
	
	public DepartmentNotFoundexception(String msg)
	{
		super(msg);
	}
	

}

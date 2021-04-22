package com.te.springboot.excep;

public class EmployeeExp extends RuntimeException {

	public EmployeeExp(String msg) {
		super(msg);
	}

}// end of EmployeeExp
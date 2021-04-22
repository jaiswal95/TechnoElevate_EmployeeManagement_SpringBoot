package com.te.springboot.dao;

import java.util.List;

import com.te.springboot.bean.EmployeeBean;


public interface EmployeeDAO {

	public EmployeeBean authenticate(int id, String pwd);

	public EmployeeBean getEmployee(int id);

	public boolean delEmpData(int id);

	public List<EmployeeBean> getAllEmp();

	public boolean addEmployee(EmployeeBean bean);

	public boolean UpdateEmployee(EmployeeBean bean);

}// end of interface
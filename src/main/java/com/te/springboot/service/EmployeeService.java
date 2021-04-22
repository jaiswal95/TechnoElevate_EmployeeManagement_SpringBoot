package com.te.springboot.service;

import java.util.List;

import com.te.springboot.bean.EmployeeBean;

public interface EmployeeService {

	public EmployeeBean authenticate(int id, String pwd);

	public EmployeeBean getEmployee(int id);

	public boolean delEmpData(int id);

	public List<EmployeeBean> getAllEmp();

	public boolean addEmployee(EmployeeBean bean);

	public boolean updateEmployee(EmployeeBean bean);

}
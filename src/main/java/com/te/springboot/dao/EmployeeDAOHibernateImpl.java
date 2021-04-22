package com.te.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springboot.bean.EmployeeBean;
import com.te.springboot.excep.EmployeeExp;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public EmployeeBean authenticate(int id, String pwd) {

		EntityManager manager = null;

		try {

			manager = factory.createEntityManager();

			EmployeeBean bean = manager.find(EmployeeBean.class, id);

			if (bean != null) {
				if (bean.getPassword().equals(pwd)) {
					System.out.println("Login Sucess");
					return bean;
				} else {
					System.out.println("Invalid Credentails");
					return null;
				}
			} else {
				System.out.println("User Not Found");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			if (manager != null) {
				manager.close();
			}
		}

	}// end of authenticate

	@Override
	public EmployeeBean getEmployee(int id) {

		EntityManager manager = null;

		try {

			manager = factory.createEntityManager();

			EmployeeBean bean = manager.find(EmployeeBean.class, id);

			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			if (manager != null) {
				manager.close();
			}
		}

	}// end of getEmployee

	@Override
	public boolean delEmpData(int id) {

		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

			transaction.begin();

			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			if (bean != null) {
				manager.remove(bean);
				transaction.commit();
				return true;
			} else {

				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

			if (manager != null) {
				manager.close();
			}
		}

	}// end of delEmpData

	@Override
	public List<EmployeeBean> getAllEmp() {

		EntityManager manager = null;

		try {

			manager = factory.createEntityManager();

			String data = "from EmployeeBean";

			Query query = manager.createQuery(data);

			List<EmployeeBean> empBeans = query.getResultList();

			if (empBeans != null) {
				return empBeans;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {

			if (manager != null) {
				manager.close();
			}
		}

	}// end of getAllEmp

	@Override
	public boolean addEmployee(EmployeeBean bean) {

		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

			transaction.begin();

			manager.persist(bean);

			transaction.commit();
			return true;

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}
			throw new EmployeeExp("Data is already present");
		} finally {

			if (manager != null) {
				manager.close();
			}
		}
	}// end of addEmployee

	@Override
	public boolean UpdateEmployee(EmployeeBean bean) {

		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {

			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			EmployeeBean info = manager.find(EmployeeBean.class, bean.getEmpid());

			if (bean.getFirstName() != null && bean.getFirstName() != "") {
				info.setFirstName(bean.getFirstName());
			}
			if (bean.getLastName() != null && bean.getLastName() != "") {
				info.setLastName(bean.getLastName());
			}
			if (bean.getPassword() != null && bean.getPassword() != "") {
				info.setPassword(bean.getPassword());
			}
			if (bean.getDob() != null) {
				info.setDob(bean.getDob());
			}
			transaction.commit();
			return true;

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;

		} finally {
			if (manager != null) {
				manager.close();
			}
		}

	}// end of UpdateEmployee

}// end of class

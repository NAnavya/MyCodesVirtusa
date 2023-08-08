package org.virtusa.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.virtusa.aop.dao.CustomerDao;
import org.virtusa.aop.dao.EmpDao;
import org.virtusa.aop.entities.Emp;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopDemo1Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(AopDemo1Application.class, args);
		CustomerDao cdao=context.getBean("customerDao",CustomerDao.class);
		EmpDao dao=context.getBean("empDao", EmpDao.class);
		dao.insertEmployee(new Emp(),true);
		dao.setAddress("chennai");
		dao.getAddress();
		cdao.insertCustomer();
		dao.getEmployees();
	}
}

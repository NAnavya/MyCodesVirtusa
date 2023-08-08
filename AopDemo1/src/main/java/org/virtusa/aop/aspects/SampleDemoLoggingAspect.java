package org.virtusa.aop.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.virtusa.aop.entities.Emp;


//About AspectOrientedProgramming --AOP
//Aspect -- It is a service (That we printed before bussiness logic)
//Advice -- It is used to Provide service/Aspect
//PointCut -- It is the condition for the service
//Advicer -- It is the combination of Advice and Pointcut
//Proxy/weaving -- It is the combination of service and bussiness logic


@Aspect
@Component
public class SampleDemoLoggingAspect {
	
	@Pointcut("execution(* org.virtusa.aop.dao.*.*(..))")
	public void forDaoPackage() {

	}
	//create a point cut for getter methods
	@Pointcut("execution(* org.virtusa.aop.dao.*.get*(..))")
	public void getter() {
		
	}
	@Pointcut("execution(* org.virtusa.aop.dao.*.set*(..))")
	public void setter() {
		
	}
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageExceptGetterAndSetters() {
		
	}
	@Before("forDaoPackageExceptGetterAndSetters()")
	public void beforeInsertEmployee() {
		System.out.println("Before advice");
	}
	
	
	/*
	 * //matching insert method with any parameter
	 */
	  @Before("execution(* insert*(..))") public void beforeInsertingEmployee() {
	   System.out.print("Executed before advice on method" +"\t");
	   System.out.println("Log before any insertion method");}
	 
	
	@Before("execution(public void insertCustomer() )")
	public void log() {
		System.out.println("Log before customers insertion Successfully");
	}
	@Before("execution(* org.virtusa.aop.dao.*.get*(..))")
	public void beforeInsertEmployee2() {
		System.out.println("Before advice" +"\t"+ "Before any dao getter method");
	}
	@Before("execution(* org.virtusa.aop.dao.*.*(..))")
	public void beforeInsertEmployee1() {
		System.out.println("Before advice ---"+"\t"+"Before any method in Dao class");
	}
		
	
	//Afer Aspect
	
	@After("execution(* org.virtusa.aop.dao.EmpDao.insert*(..))")
	//By using this JoinPoint we can get the method for which this advice is used
	public void afterInsertEmployee(JoinPoint joinPoint) {
		String method=joinPoint.getSignature().toShortString();
		System.out.println("Executed after finally on "+method);
		}
	
	//AfterThrowing is used to get the advice if it throws any exception on the particular method where the advice is thrown and we get that exception also 
	@AfterThrowing(pointcut="execution(* org.virtusa.aop.dao.EmpDao.insert*(..))",throwing="ex")
	public void afterThrowingInsertEmployee(JoinPoint joinPoint,Throwable ex) {
		String method=joinPoint.getSignature().toShortString();
		System.out.println("Executing after throwing an Exception on"+method);
		System.out.println("The Exception is"+ex);
	}
		  //AfterReturning advice is used for the method which is returning something in orderto get that value we use this advice
		@AfterReturning(pointcut="execution(* org.virtusa.aop.dao.EmpDao.getEmployees(..))",returning="employees")
		public void afterReturningAdvice(JoinPoint joinPoint,List<Emp> employees) {
			String method=joinPoint.getSignature().toShortString();
			System.out.println("After returning advice on"+method);
			employees.forEach(emp->System.out.println(emp.getEno()+"\t"+emp.getName()+"\t"+emp.getAddress()));
			
		}
		
		//Around advice is used/executed before after the execution of method
		@Around("execution(* org.virtusa.aop.dao.EmpDao.getEmployees(..))")
		public Object aroundGetEmployees(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
			String method=proceedingJoinPoint.getSignature().toShortString();
			System.out.println("Executing around method"+method);
			long startTime=System.currentTimeMillis();
			Object res=proceedingJoinPoint.proceed();
			long endTime=System.currentTimeMillis();
			long duration=endTime-startTime;
			System.out.println(duration+" "+startTime+ " "+endTime );
			System.out.println(res);
			
			return res;
			
			
			
			
			
		}
		
		
	}
	
	


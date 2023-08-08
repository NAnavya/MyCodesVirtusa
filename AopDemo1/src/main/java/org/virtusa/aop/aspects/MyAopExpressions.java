package org.virtusa.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAopExpressions {
    @Pointcut("execution(* org.virtusa.aop.dao.*.*(..))")
    public void forDaoPackage() {
    	
    }
    //create a pointcut for getter methods
    @Pointcut("execution(* org.virtusa.aop.dao.*.get*(..))")
    public void getter() {
    	
    }
    
    //create a pointcut for setter method
    @Pointcut("execution( * org.virtusa.aop.dao.*.get*(..))")
    public void setter() {
    	
    }
    
    //Pointcut for the methods i dao except getter ams setter methods for these we must have getter and setter used defined method as mentioned above
    @Pointcut("fordaoPackage() && !(getter()||setter())")
    public void forDaoPackageExceptGetterAndSetter() {
    	
    }
}

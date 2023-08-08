package org.virtusa.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//Analytics means the no/of request that ha been applied to the particular method those data/logic can be achieved by CROSSCUTTING concepts 
@Component
@Aspect
@Order(1)
public class PerformAnalytics {
	  @Before("org.virtusa.aop.aspects.SampleDemoLoggingAspect.forDaoPackageExceptGetterAndSetters()")
	  public void performAnalytics() {
		  System.out.println("Perform api analytics");
	  }

}

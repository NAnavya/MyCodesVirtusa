package com.hiringandtracking;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiringandtracking.exceptions.RecordNotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class LoggingAdvice {
    Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

   // "execution(* com.hiringandtracking.services.VhitOfferedStudentMasterService.*(..) )"
    @Pointcut(value = "execution(* com.hiringandtracking.services.VhitOfferedStudentMasterService.VhitCollegeMasterService(..) )"
    +"execution(* com.hiringandtracking.services.VhitOfferedStudentMasterService.VhitOfferedStudentMasterService(..) )"
    )
    public void myPointcut(){

    }


    @Around("myPointcut()")
    public Object loggerapp(ProceedingJoinPoint pjp) throws Throwable {

        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();

        log.info("method invoked  {}  methodName {} arguments : {}", className, methodName, mapper.writeValueAsString(array));
        Object object = pjp.proceed();
        log.info("method Excuted {}  methodName {} arguments : {}", className, methodName, mapper.writeValueAsString(object));

        return object;

    }


    @AfterThrowing(value="execution(* com.hiringandtracking.services.*.*(..) )",throwing="ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, RecordNotFoundException ex)
    {
        log.warn("After Throwing exception in method: {}",joinPoint.getSignature());
        log.warn("Exception is: {} ",ex.getMessage());
    }
}


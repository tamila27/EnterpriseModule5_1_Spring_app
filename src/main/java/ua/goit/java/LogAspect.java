package ua.goit.java;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by tamila on 8/3/16.
 */
@Aspect
public class LogAspect {
    public static Logger logger= Logger.getLogger(LogAspect.class);

    public LogAspect() {
    }

    @Around("execution(public ua.goit.gojavaonline.* *(..))")
    //@AfterReturning("execution(public * *(..))")
    public Object onExecute(ProceedingJoinPoint pjp) throws Throwable {
        BasicConfigurator.configure();
        logger.debug("logging : "+pjp.getSignature().toString());
        //System.out.println("logging : "+pjp.getSignature().toString());
        Object result = pjp.proceed();

        return result;
    }
}

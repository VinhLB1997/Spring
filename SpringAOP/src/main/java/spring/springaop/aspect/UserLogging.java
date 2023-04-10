package spring.springaop.aspect;

import java.util.logging.Logger;
import lombok.NoArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@NoArgsConstructor
public class UserLogging {

  private final Logger log = Logger.getLogger(getClass().getName());

  // setup pointcut declarations
  @Pointcut("execution(* spring.springaop.controller.*.*(..))")
  private void forControllerPackage() {}

  // do the same for service and dao
  @Pointcut("execution(* spring.springaop.service.*.*(..))")
  private void forServicePackage() {}

  @Pointcut("execution(* spring.springaop.repository.*.*(..))")
  private void forDaoPackage() {}

  @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
  private void forAppFlow() {}

  // add @Before advice
  @Before("forAppFlow()")
  public void before(JoinPoint theJoinPoint) {

    // display method we are calling
    String theMethod = theJoinPoint.getSignature().toShortString();
    log.info("=====>> in @Before: calling method: " + theMethod);

    // display the arguments to the method

    // get the arguments
    Object[] args = theJoinPoint.getArgs();

    // loop thru and display args
    for (Object tempArg : args) {
      log.info("=====>> argument: " + tempArg);
    }

  }


  // add @AfterReturning advice
  @AfterReturning(
      pointcut="forAppFlow()",
      returning="theResult"
  )
  public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

    // display method we are returning from
    String theMethod = theJoinPoint.getSignature().toShortString();
    log.info("=====>> in @AfterReturning: from method: " + theMethod);

    // display data returned
    log.info("=====>> result: " + theResult);

  }
}

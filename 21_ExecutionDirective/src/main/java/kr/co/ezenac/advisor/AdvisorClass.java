package kr.co.ezenac.advisor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

public class AdvisorClass {
	@Before("execution(* method1()")
	public void beforeMethod() {
		System.out.println("before메서드 호출");
	}

	@After("execution(* method1())")
	public void afterMethod() {
		System.out.println("afterMethod 호출");
	}

	@Around("execution(* method1())")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("aroundMethod 호출");
		Object result = pjp.proceed();
		System.out.println("aroundMethod2 호출");
		return result;
	}

	@AfterReturning(("execution(* method1())"))
	public void afterReturning() {
		System.out.println("afterReturning 호출");
	}

	@AfterThrowing(("execution(* method1())"))
	public void afterThrowingMethod() {
		System.out.println("afterThrowing 호출");
	}

}

package kr.co.ezenac.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdvisorClass {

	public void beforeMethod() {
		System.out.println("beforeMethod 호출");
	}

	public void afterMethod() {
		System.out.println("afterMethod 호출");
	}

	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("aroundMethod 호출1");
		Object obj = pjp.proceed();
		// Object name=pjp.getTarget();
		// System.out.println("name="+name);
		System.out.println("aroundMethod 호출2");
		return obj;
	}

	public void afterReturningMethod() {
		System.out.println("afterReturningMethod 호출");
	}

	public void afterThrowingMethod(Throwable e1) {
		System.out.println("afterThrowingMethod 호출");
		System.out.println(e1);
	}

}

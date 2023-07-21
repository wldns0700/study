package aop2;

import org.aspectj.lang.ProceedingJoinPoint;

public class Advice {
public Advice() {}
	public void before() {
		System.out.println("before");
	}
	public void after() {
		System.out.println("after");
	}
	public void before_returing() {
		System.out.println("before_returing");
	}
	public void after_returing() {
		System.out.println("after_returing");
	}
	public Object around(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("login처리");
		//Aprint.print()함수가 호출되도록 처리
		Object obj = joinpoint.proceed();
		System.out.println("log처리");
		return obj;
	}
}

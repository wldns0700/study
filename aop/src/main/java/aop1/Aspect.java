package aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class Aspect {
	//aprint.print()함수를 호출하면 앞뒤로 붙는 내용을 여기서 구현한다.
	public Object frontEndFunc(ProceedingJoinPoint joinpoint) throws Throwable {
		System.out.println("login처리");
		//Aprint.print()함수가 호출되도록 처리
		Object obj = joinpoint.proceed();
		System.out.println("log처리");
		return obj;
	}
}

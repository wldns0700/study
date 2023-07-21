package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		 final Print p = new Aprint();
		
		Print proxy = (Print)Proxy.newProxyInstance(
				Print.class.getClassLoader(),
				new Class[] {Print.class},
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("start");
						Object resule = method.invoke(p, args);//aprint print1() or print2()
						System.out.println("end");
						return resule;
					}
				});
		
		proxy.print1();

	}

}

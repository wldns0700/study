package aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {

	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("aop2/settings.xml");
		
		Print p = (Print) app.getBean("aprint");
		p.print1();

	}

	}



package scheduled;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop1.Print;

public class Main {

	public static void main(String[] args) {
ApplicationContext app=new ClassPathXmlApplicationContext("scheduled/setting.xml");
		

	}
}

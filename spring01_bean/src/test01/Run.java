package test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		
		//applicationContext 생성방법
		ApplicationContext context
				= new ClassPathXmlApplicationContext("test01/applicationContext.xml");
		
		Address hong = (Address) context.getBean("hong");
		Address lee = (Address) context.getBean("lee");

		System.out.println(hong);
		System.out.println(lee);
		System.out.println((Address)context.getBean("kim"));
	}

}

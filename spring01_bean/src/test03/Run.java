package test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		
		//ApplicationContext에 2021년 10월 9일 날짜를 가지는 java.uti.Date 빈을 등록하고
		//main메서드에 해당 빈을 호출해 toString메서드를 출력하세요.
		ApplicationContext context
				= new ClassPathXmlApplicationContext("test03/applicationContext.xml");
		
		//System.out.println(context.getBean("date",Date.class));
		//System.out.println(context.getBean("score",Score.class));

	}

}

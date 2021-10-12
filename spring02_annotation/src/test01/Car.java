package test01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	//@Autowired : 타입을 기준으로 빈을 찾아서 의존성 주입
	//				해당 타입의 빈이 2개 이상일 경우 빈의 id와 변수명을 기준으로 의존성 주입
	
	@Autowired
	//@Qualifier(value="wheel2")
	private Wheel wheel;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(Wheel wheel) {
		super();
		this.wheel = wheel;
	}

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	@Override
	public String toString() {
		return "Car [wheel=" + wheel + "]";
	}
	
}

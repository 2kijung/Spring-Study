package test03;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BeanTest {
	private Date date;
	private Score score;
	public BeanTest() {
		// TODO Auto-generated constructor stub
	}
	public BeanTest(Date date) {
		this.date = date;
		System.out.println(date+" : 매개변수가 있는 생성자 호출");
		
	}

	public void setScore(Score score){
		this.score = score;
		System.out.println("setScore : "+score);
	}
	public void setBoolean(Boolean flg){
		System.out.println("flg : "+flg);
	}
	public void setNumber(double num){
		System.out.println("num : "+num);
	}
	public void setArray(String[] arr) {
		System.out.println("setArray : "+Arrays.toString(arr));
	}
	public void setList(List<String>list) {
		System.out.println("setList : "+list);
	}
	public void setSet(Set<String>set) {
		System.out.println("set : "+set);
	}
	public void setMap(Map<String,String>map) {
		System.out.println("setMap : "+map);
	}
	public void setProperties(Properties props) {
		System.out.println("set{rops : "+props);
	}
	public void setScoreList(List<Score> score) {
		System.out.println("setScoreList : "+score);
	}
}


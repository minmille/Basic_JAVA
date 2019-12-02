package chapter05;

public class SingletonMain {
	public static void main(String[] args) {
		// SingletonTest st = new SingletonTest();
		SingletonTest st = SingletonTest.getInstance(); 
	
		// 테스트를 위해 아래처럼 출력해보고 결과 값이 같으면 
		// 같은 곳에서 빌려온 것이니까 완성된 것.
		// SingletonTest st1 = SingletonTest.getInstance();
		// SingletonTest st2 = SingletonTest.getInstance();
		// System.out.println(t1 == t2);
		
	
	}

}

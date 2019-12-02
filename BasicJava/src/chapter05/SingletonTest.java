package chapter05;

// 싱글톤패턴
// 객체생성은 1회만 하고 생성된 인스턴스를 빌려서 사용하는 방법
public class SingletonTest {
	// 객체생성 1회 진행 => instance
	// 앞으로 객체생성을 하지 않고 instance 를 빌려서 사용하게 만듦
	private static SingletonTest instance = new SingletonTest();
	
	// 1번. 생성자를 private로 선언하여 외부에서 객체생성 불가
	private SingletonTest() {}
	
	// 3번. 생성된 instance를 return으로 빌려서 사용할 수 있게 static 메서드 생성
	public static SingletonTest getInstance() {
		if(instance == null) {	// if문은 없어도 되나 보안강화를 위해 씀
			instance = new SingletonTest();
		}
		return instance;
	}

}

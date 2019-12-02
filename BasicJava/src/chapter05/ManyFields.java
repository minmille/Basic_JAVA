package chapter05;

	// Java에서 사용하는 다양한 변수들
	//전역변수, 지역변수, 멤버변수, 인스턴스변수, 클래스변수, static변수, 필드, 매개변수
public class ManyFields {
	int all; // 필드(멤버변수), 전역변수,
	static String stt; // 필드(멤버변수), 전역변수, static(정적)변수, 클래스변수
	
	public void sum(int a, int b) { // int a, int b 메서드(함수)의 매개가 되는 매개변수(지역변수의 의미도 포함되어 있음)
		int localNum = 30; // 지역변수(value)
	}
	
	public void test() {
		// mf는 인스턴스
		ManyFields mf = new ManyFields();
		mf.all = 5; // all은 인스턴스 변수(인스턴스로 호출한 변수) - 클래스 바로 아래의 all도 인스턴스변수로 볼 수도 있다.
	}
}
// 전역변수는 선언만 가능(자바가 자동 default값으로 초기화 해줌)
// 지역변수는 반드시 초기화 해서 사용해야 한다.

// 기본자료형은 0, 객체 자료형은 null(아무것도 가리키고 있지 않음)로 초기화
// 객체 자료형은 ""로 초기화 해주는 것이 좋다.
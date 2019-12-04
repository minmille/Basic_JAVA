package chapter08;

// 자식 클래스
// : Java는 단일 상속만 가능
public class DmbCellPhone extends CellPhone{
	int channel;
	
	public DmbCellPhone(String model, String color, int channel) {
		// super(); 부모생성자 호출(부모객체생성)/ 맨 윗줄에 써야함
		// 부모객체 생성 후 자식객체가 생성됨
		super(); // 생략 가능. 바꿔 쓰면 CellPhone(); 부모 클래스의 생성자 메서드 호출
		this.model = model;
		this.color = color;		
		this.channel = channel;
	}
	public void turnOnDmb() {
		System.out.println("채널 " + channel + " DMB 방송 수신을 시작합니다.");
	}
	public void ChangeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널 " + channel + " 번으로 변경합니다.");
	}
	public void TurnOffDmb() {
		System.out.println("방송 수신을 멈춥니다.");
		
		
	}
}

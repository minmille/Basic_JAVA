package problem.Bank;

import java.sql.Date;

public class BankDTO {
	private int bno;
	private String bname;
	private String pw;
	private int money;
	private Date regdate;
	
	public BankDTO() {}

	public BankDTO(int bno, String bname, String pw, int money, Date regdate) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.pw = pw;
		this.money = money;
		this.regdate = regdate;
	}
	
	public BankDTO(String bname, String pw, int money) {
		super();
		this.bname = bname;
		this.pw = pw;
		this.money = money;
	}

	
	public BankDTO(String bname, Date regdate) {
		super();
		this.bname = bname;
		this.regdate = regdate;
	}

	public BankDTO(int bno, String bname, Date regdate) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.regdate = regdate;
	}

	
	public BankDTO(String bname, int money) {
		super();
		this.bname = bname;
		this.money = money;
	}

	public BankDTO(String bname) {
		super();
		this.bname = bname;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "BankDTO [bno=" + bno + ", bname=" + bname + ", pw=" + pw + ", money=" + money + ", regdate=" + regdate
				+ "]";
	}
	
	
	
}

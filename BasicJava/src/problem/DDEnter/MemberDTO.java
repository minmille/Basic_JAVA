package problem.DDEnter;

import java.sql.Date;

public class MemberDTO {
	private String ano;
	private String aname;
	private String major;
	private String groupyn;
	private String groupnm;
	private int sal;
	private Date regdate;
	
	public MemberDTO() {}

	public MemberDTO(String ano, String aname, String major, String groupyn, String groupnm, int sal, Date regdate) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
		this.regdate = regdate;
	}

	public MemberDTO(String aname, String major, String groupyn, String groupnm, int sal) {
		super();
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
	}

	public MemberDTO(String ano, String aname, String major, String groupyn, String groupnm, int sal) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGroupyn() {
		return groupyn;
	}

	public void setGroupyn(String groupyn) {
		this.groupyn = groupyn;
	}

	public String getGroupnm() {
		return groupnm;
	}

	public void setGroupnm(String groupnm) {
		this.groupnm = groupnm;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return ano + "\t" + aname + "\t" + major + "\t" + groupyn + "\t" + groupyn + "\t" + groupnm + "\t" + regdate;  
	}
	
	
}

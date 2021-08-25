package kr.ac.kopo.member.vo;

public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String email_id;
	private String emailDomain;
	private String tel1;
	private String tel2;
	private String tel3;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getTel3() {
		return tel3;
	}

	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", email_id=" + email_id
				+ ", emailDomain=" + emailDomain + ", tel1=" + tel1 + ", tel2=" + tel2 + ", tel3=" + tel3 + "]";
	}

	
}

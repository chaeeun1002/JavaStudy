package org.chaeeun.may08;

//DB연동에 사용하는 변수는 은닉필수(private)

public class UserIdPwd {
	private String id;
	private String pwd;
	//은닉된 변수에 데이터를 넣어주는 메서드를 만든다.(setter 메서드)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}

package org.chaeeun.april23;

public class ManagerInfo {
	//변수이름은 테이블의 속성명과 일치해야함.
	private String manager_id;
	private String manager_pwd;
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_pwd() {
		return manager_pwd;
	}
	public void setManager_pwd(String manager_pwd) {
		this.manager_pwd = manager_pwd;
	}
}

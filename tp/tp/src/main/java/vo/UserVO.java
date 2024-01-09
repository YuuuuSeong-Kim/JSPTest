package vo;

import java.util.Date;

public class UserVO {
	private String u_id;
	private String u_pw;
	private String u_name;
	private Date u_birth;
	private String u_phone;
	private String u_addr;
	private String u_interest;
	public UserVO(String u_id, String u_pw, String u_name, Date u_birth, String u_phone, String u_addr,
			String u_interest) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_birth = u_birth;
		this.u_phone = u_phone;
		this.u_addr = u_addr;
		this.u_interest = u_interest;
	}
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public Date getU_birth() {
		return u_birth;
	}
	public void setU_birth(Date u_birth) {
		this.u_birth = u_birth;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_addr() {
		return u_addr;
	}
	public void setU_addr(String u_addr) {
		this.u_addr = u_addr;
	}
	public String getU_interest() {
		return u_interest;
	}
	public void setU_interest(String u_interest) {
		this.u_interest = u_interest;
	}
	
	
}

package vo;

import java.util.Date;

public class StudyVO {

	private int s_id;
	private String s_title;
	private String s_content;
	private Date s_date;
	private boolean s_state;
	private String u_id;
	private int e_id;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_title() {
		return s_title;
	}
	public void setS_title(String s_title) {
		this.s_title = s_title;
	}
	public String getS_content() {
		return s_content;
	}
	public void setS_content(String s_content) {
		this.s_content = s_content;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public boolean isS_state() {
		return s_state;
	}
	public void setS_state(boolean s_state) {
		this.s_state = s_state;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public StudyVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudyVO(int s_id, String s_title, String s_content, Date s_date, boolean s_state, String u_id, int e_id) {
		super();
		this.s_id = s_id;
		this.s_title = s_title;
		this.s_content = s_content;
		this.s_date = s_date;
		this.s_state = s_state;
		this.u_id = u_id;
		this.e_id = e_id;
	}
	
	
}

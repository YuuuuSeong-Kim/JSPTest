package vo;

public class NewVO {
	private int n_id;
	private boolean n_state;
	private String n_msg;
	private String u_id;
	private int i_id;
	private int s_id;
	public int getN_id() {
		return n_id;
	}
	public void setN_id(int n_id) {
		this.n_id = n_id;
	}
	public boolean isN_state() {
		return n_state;
	}
	public void setN_state(boolean n_state) {
		this.n_state = n_state;
	}
	public String getN_msg() {
		return n_msg;
	}
	public void setN_msg(String n_msg) {
		this.n_msg = n_msg;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getI_id() {
		return i_id;
	}
	public void setI_id(int i_id) {
		this.i_id = i_id;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public NewVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewVO(int n_id, boolean n_state, String n_msg, String u_id, int i_id, int s_id) {
		super();
		this.n_id = n_id;
		this.n_state = n_state;
		this.n_msg = n_msg;
		this.u_id = u_id;
		this.i_id = i_id;
		this.s_id = s_id;
	}
	
}

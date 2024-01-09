package vo;

public class WishlistVO {
	private int w_id;
	private String u_id;
	private int c_id;
	public int getW_id() {
		return w_id;
	}
	public void setW_id(int w_id) {
		this.w_id = w_id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public WishlistVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WishlistVO(int w_id, String u_id, int c_id) {
		super();
		this.w_id = w_id;
		this.u_id = u_id;
		this.c_id = c_id;
	}
	
	
}

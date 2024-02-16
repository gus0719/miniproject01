package classes;
public class ShopFrame_UserDTO{
	private String id;
	private String pwd;

	//UserDTO getter / setter / Constructor 작성
	ShopFrame_UserDTO(){}
	ShopFrame_UserDTO(String id, String pwd){
		this.id = id;
		this.pwd = pwd;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}

	public String getPwd(){
		return pwd;
	}
	public void setPwd(String pwd){
		this.pwd = pwd;
	}
}
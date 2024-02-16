package classes;
public class ShopFrame_SignUpDTO{
	private String id;
	private String pwd;
	private String name;
	private String phoneNo;
	private String address;
	
	//SignUpDTO getter / setter / Constructor 작성
	ShopFrame_SignUpDTO(){}
	ShopFrame_SignUpDTO(String id, String pwd, String name, String phoneNo, String address){
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
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
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getPhoneNo(){
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo){
		this.phoneNo = phoneNo;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
}
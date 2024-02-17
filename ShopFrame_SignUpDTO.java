package classes;
public class ShopFrame_SignUpDTO extends ShopFrame_UserDTO{
	private String name;
	private String phoneNo;
	private String address;
	
	//SignUpDTO getter / setter / Constructor 작성
	ShopFrame_SignUpDTO(){}
	ShopFrame_SignUpDTO(String id, String pwd, String name, String phoneNo, String address){
		super(id, pwd);		// id와 pwd를 ShopFrame_UserDTO로 넘겨주기
		this.name = name;
		this.phoneNo = phoneNo;
		this.address = address;
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
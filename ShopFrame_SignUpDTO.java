package classes;
public class ShopFrame_SignUpDTO extends ShopFrame_UserDTO{
	// NAME, IDENTIFY NO, ID, PWD, PHONENO, EMAIL, ADDRESS
	private String name;
	private String identifyNo;
	private String phoneNo;
	private String email;
	private String address;
	private String[] cart;	// 장바구니

	//SignUpDTO getter / setter / Constructor 작성
	ShopFrame_SignUpDTO(){}
	ShopFrame_SignUpDTO(String name, String identifyNo, String id, String pwd, String phoneNo, String email, String address, String[] cart){
		super(id, pwd);		// id와 pwd를 ShopFrame_UserDTO로 넘겨주기
		this.name = name;
		this.identifyNo = identifyNo;
		this.phoneNo = phoneNo;
		this.email = email;
		this.address = address;
		this.cart = cart;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getIdentifyNo(){
		return identifyNo;
	}
	public void setIdentifyNo(String identifyNo){
		this.identifyNo = identifyNo;
	}
	
	public String getPhoneNo(){
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo){
		this.phoneNo = phoneNo;
	}

	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	
	public String[] getCart(){
		return this.cart;
	}
	public void setCart(String[] cart){
		this.cart = cart;
	}
}
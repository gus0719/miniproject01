package classes;
public class ShopFrame_ReviewProductDTO{	// 상품리뷰 DTO
	private String pdName;
	private String user;
	private String userWrite;
	private String writeDate;
	private int starGrade;

	// ReviewProductDTO getter / setter / Constructor 작성
	ShopFrame_ReviewProductDTO(){}	// 기본생성자

	//Constructor (생성자)
	ShopFrame_ReviewProductDTO(String pdName, String user, String userWrite, String writeDate, int starGrade){
		this.pdName = pdName;
		this.user = user;
		this.userWrite = userWrite;
		this.writeDate = writeDate;
		this.starGrade = starGrade;
	}

	//pdName getter
	public String getPdName(){
		return pdName;
	}
	//pdName setter
	public void setPdName(String pdName){
		this.pdName = pdName;
	}

	//user getter
	public String getUser(){
		return user;
	}
	//user setter
	public void setUser(String user){
		this.user = user;
	}

	//userWrite getter
	public String getUserWrite(){
		return userWrite;
	}
	//userWrite setter
	public void setUserWrite(String userWrite){
		this.userWrite = userWrite;
	}

	//writeDate getter
	public String getWriteDate(){
		return writeDate;
	}
	//writeDate setter
	public void setWriteDate(String writeDate){
		this.writeDate = writeDate;
	}

	//starGrade getter
	public int getStarGrade(){
		return starGrade;
	}
	//starGrade setter
	public void setStarGrade(int starGrade){
		this.starGrade = starGrade;
	}
}
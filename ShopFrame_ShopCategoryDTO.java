package classes;
public class ShopFrame_ShopCategoryDTO{	// 카테고리 상품DTO
	private String category;
	private String brand;
	private String productName;
	private String uploadDate;
	private String explain;
	private int price;
	private int pdCnt;
	private int viewCnt;

	//ShopCategoryDTO getter / setter / Constructor 작성
	ShopFrame_ShopCategoryDTO(){}// 기본 생성자
	
	// Constructor (생성자)
	ShopFrame_ShopCategoryDTO(String category, String brand, String productName, String uploadDate, String explain, int price, int pdCnt, int viewCnt){
		this.category = category;
		this.brand = brand;
		this.productName = productName;
		this.uploadDate = uploadDate;
		this.explain = explain;
		this.price = price;
		this.pdCnt = pdCnt;
		this.viewCnt = viewCnt;
	}
	//category getter
	public String getCategory(){
		return category;
	}
	//category setter
	public void setCategory(String category){
		this.category=category;
	}
	//brand getter
	public String getBrand(){
		return brand;
	}
	//brand setter
	public void setBrand(String brand){
		this.brand = brand;
	}
	//productName getter
	public String getProductName(){
		return productName;
	}
	//productName setter
	public void setProductName(String productName){
		this.productName = productName;
	}
	//uploadDate getter
	public String getUploadDate(){
		return uploadDate;
	}
	//uploadDate setter
	public void setUploadDate(String uploadDate){
		this.uploadDate = uploadDate;
	}
	//explain getter
	public String getExplain(){
		return explain;
	}
	//explain setter
	public void setExplain(String explain){
		this.explain = explain;
	}
	//price getter
	public int getPrice(){
		return price;
	}
	//price setter
	public void setPrice(int price){
		this.price = price;
	}
	//pdCnt getter
	public int getPdCnt(){
		return pdCnt;
	}
	//pdCnt setter
	public void setPdCnt(int pdCnt){
		this.pdCnt = pdCnt;
	}
	//viewCnt getter
	public int getViewCnt(){
		return viewCnt;
	}
	//viewCnt setter
	public void setViewCnt(int viewCnt){
		this.viewCnt = viewCnt;
	}	
}
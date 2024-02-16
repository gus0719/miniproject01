package classes;
public class ShopFrame_ShopCategoryDTO{
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
	public String getproductName(){
		return productName;
	}
	//productName setter
	public void setproductName(String productName){
		this.productName = productName;
	}
	//uploadDate getter
	public String getUploadDate(){
		return uploadDate;
	}
	//uploadDate setter
	public void setuploadDate(String uploadDate){
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
	public int getpdCnt(){
		return pdCnt;
	}
	//pdCnt setter
	public void setpdCnt(int pdCnt){
		this.pdCnt = pdCnt;
	}
	//viewCnt getter
	public int getviewCnt(){
		return viewCnt;
	}
	//viewCnt setter
	public void setviewCnt(int viewCnt){
		this.viewCnt = viewCnt;
	}	
}
package classes;

public class ShopFrame_DTOSet{
	ShopFrame_DB shopDB = new ShopFrame_DB();
	// 정보객체
	// 생성----------------------------------------------------------------------------------//
	// 유저 정보 객체 생성
	ShopFrame_SignUpDTO[] userDTO = new ShopFrame_SignUpDTO[shopDB.userDB.length];
	// 회원가입한 정보에서 id와 pwd를 사용하기 위함

	// 회원가입 구현하기 전 로그인 테스트
	ShopFrame_SignUpDTO[] userSet(String[][] userDB) { // 사용자들 끌어오기
		String name;
		String identify;
		String id;
		String pwd;
		String phoneNo;
		String email;
		String address;
		String[] cart;
		for (int idx = 0; idx < userDB.length; idx++) {
			name = userDB[idx][0];
			identify = userDB[idx][1];
			id = userDB[idx][2];
			pwd = userDB[idx][3];
			phoneNo = userDB[idx][4];
			email = userDB[idx][5];
			address = userDB[idx][6];
			cart = shopDB.userCart[idx];
			userDTO[idx] = new ShopFrame_SignUpDTO(name, identify, id, pwd, phoneNo, email, address, cart);
		}
		return userDTO;
	}

	// 상품정보 객체 생성
	ShopFrame_ShopCategoryDTO[] productDTO = new ShopFrame_ShopCategoryDTO[shopDB.productLen];	// 카테고리 통합 상품 DB 정보 객체배열 생성
	ShopFrame_ShopCategoryDTO[] productSet() { // DB에서 받은 배열별로 상품 끌어오기
		String category;
		String brand;
		String productName;
		String uploadDate;
		String explain;
		int price;
		int pdCnt;
		int viewCnt;
		for (int idx = 0; idx < shopDB.productDB.length; idx++) {
			category = shopDB.productDB[idx][0];
			brand = shopDB.productDB[idx][1];
			productName = shopDB.productDB[idx][2];
			uploadDate = shopDB.productDB[idx][3];
			explain = shopDB.productDB[idx][4];
			price = Integer.parseInt(shopDB.productDB[idx][5]);
			pdCnt = Integer.parseInt(shopDB.productDB[idx][6]);
			viewCnt = Integer.parseInt(shopDB.productDB[idx][7]);
			productDTO[idx] = new ShopFrame_ShopCategoryDTO(
					category, brand, productName, uploadDate, explain, price, pdCnt, viewCnt);
		}
		return productDTO;
	}
	void itgProduct() {	// 카테고리 상품 통합 DB
		int cnt = 0;
		for(int i = 0; i < shopDB.funitureDB.length; i++) {
			shopDB.productDB[cnt] = shopDB.funitureDB[i];
			cnt++;
		}
		for(int i = 0; i < shopDB.digitalDB.length; i++) {
			shopDB.productDB[cnt] = shopDB.digitalDB[i];
			cnt++;
		}
		for(int i = 0; i < shopDB.foodDB.length; i++) {
			shopDB.productDB[cnt] = shopDB.foodDB[i];
			cnt++;
		}
		for(int i = 0; i < shopDB.fashionDB.length; i++) {
			shopDB.productDB[cnt] = shopDB.fashionDB[i];
			cnt++;
		}
	}
	// 상품 리뷰 객체 생성
	ShopFrame_ReviewProductDTO[] reviewDTO = new ShopFrame_ReviewProductDTO[shopDB.pdReviewDB.length];

	ShopFrame_ReviewProductDTO[] reviewSet() { // DB에 있는 상품들의 리뷰
		String pdName;
		String user;
		String userWrite;
		String writeDate;
		int starGrade;
		for (int idx = 0; idx < shopDB.pdReviewDB.length; idx++) {
			pdName = shopDB.pdReviewDB[idx][0];
			user = shopDB.pdReviewDB[idx][1];
			userWrite = shopDB.pdReviewDB[idx][2];
			writeDate = shopDB.pdReviewDB[idx][3];
			starGrade = Integer.parseInt(shopDB.pdReviewDB[idx][4]);
			reviewDTO[idx] = new ShopFrame_ReviewProductDTO(pdName, user, userWrite, writeDate, starGrade);
		}
		return reviewDTO;
	}
}
package classes;

public class ShopFrame_DTOSet {
	ShopFrame_DB shopDB = new ShopFrame_DB();
	// 정보객체
	// 생성----------------------------------------------------------------------------------//
	// 유저 정보 객체 생성
	ShopFrame_UserDTO[] userDTO = new ShopFrame_UserDTO[shopDB.userDB.length];

	ShopFrame_UserDTO[] userSet() { // 사용자들 끌어오기
		String id;
		String pwd;
		for (int idx = 0; idx < shopDB.userDB.length; idx++) {
			id = shopDB.userDB[idx][0];
			pwd = shopDB.userDB[idx][1];
			userDTO[idx] = new ShopFrame_UserDTO(id, pwd);
		}
		return userDTO;
	}

	// 상품정보 객체 생성
	ShopFrame_ShopCategoryDTO[] productDTO;

	ShopFrame_ShopCategoryDTO[] productSet(String[][] productArr) { // DB에서 받은 배열별로 상품 끌어오기
		String category;
		String brand;
		String productName;
		String uploadDate;
		String explain;
		int price;
		int pdCnt;
		int viewCnt;
		for (int idx = 0; idx < productArr.length; idx++) {
			category = productArr[idx][0];
			brand = productArr[idx][1];
			productName = productArr[idx][2];
			uploadDate = productArr[idx][3];
			explain = productArr[idx][4];
			price = Integer.parseInt(productArr[idx][5]);
			pdCnt = Integer.parseInt(productArr[idx][6]);
			viewCnt = Integer.parseInt(productArr[idx][7]);
			productDTO[idx] = new ShopFrame_ShopCategoryDTO(category, brand, productName, uploadDate, explain, price,
					pdCnt, viewCnt);
		}
		return productDTO;
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
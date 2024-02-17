package classes;

import java.util.Scanner;
public class ShopFrame_DTOSet {
	ShopFrame_DB shopDB = new ShopFrame_DB();
	Scanner scan = new Scanner(System.in);
	// 정보객체
	// 생성----------------------------------------------------------------------------------//
	// 유저 정보 객체 생성
	ShopFrame_UserDTO[] userDTO = new ShopFrame_SignUpDTO[shopDB.userDB.length];
	// 회원가입한 정보에서 id와 pwd를 사용하기 위함

	// 회원가입 구현하기 전 로그인 테스트
	ShopFrame_UserDTO[] userSet() { // 사용자들 끌어오기
		String id;
		String pwd;
		String name;
		String phoneNo;
		String address;
		for (int idx = 0; idx < shopDB.userDB.length; idx++) {
			id = shopDB.userDB[idx][0];
			pwd = shopDB.userDB[idx][1];
			name = shopDB.userDB[idx][2];
			phoneNo = shopDB.userDB[idx][3];
			address = shopDB.userDB[idx][4];
			userDTO[idx] = new ShopFrame_SignUpDTO(id, pwd, name, phoneNo, address);
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
package classes;
import java.util.Scanner;
public class ShopFrame_DAO{
	UserAPI api = new UserAPI();
	Scanner scan = new Scanner(System.in);
	ShopFrame_DB shopDB = new ShopFrame_DB();
	ShopFrame_DTOSet set = new ShopFrame_DTOSet();
	
	
	/* 정보객체 생성----------------------------------------------------------------------------------/
	/----------------------------------------단계별 메소드 생성*/
	void printCategory() {
		// 카테고리 화면
		while(true) {
			System.out.printf("\t+%1$s+\n\t|\t카테고리\t\t|\n\t+%1$s+\n", api.mLineReturn('-', 23));
			System.out.println("\t1.\t가구\n");// 카테고리 출력
			System.out.println("\t2.\t가전디지털\n");// 카테고리 출력
			System.out.println("\t3.\t식품\n");// 카테고리 출력
			System.out.println("\t4.\t패션\n\n");// 카테고리 출력
			System.out.println("\tQ. 메인 메뉴");
			System.out.printf("\t%s\n", api.mLineReturn('-', 31));
			System.out.print("\t\t상품을 선택하세요 [뒤로가기 : Q] : ");
			String categoryRead = scan.nextLine();
			if(categoryRead.length() == 0) {
				System.out.println("\t^ 메뉴를 선택하세요");
				continue;
			}
			if(categoryRead.equalsIgnoreCase("Q")) {
				System.out.println("메인 메뉴");
				return;
			}
			if(categoryRead.length() >= 1 && (categoryRead.charAt(0) < '1' || categoryRead.charAt(0) > '9')){	// 숫자 이외의 문자 입력
				System.out.println("\t^ 메뉴를 선택하세요");
				continue;
			}
			if(categoryRead.length() > 0 && (Integer.parseInt(categoryRead) >= 1 && Integer.parseInt(categoryRead) <= 4)) {
				// 카테고리 상품메뉴로 이동
				switch(Integer.parseInt(categoryRead)){
					case 1:	// 가구
						set.productDTO = new ShopFrame_ShopCategoryDTO[shopDB.funitureDB.length];	// productDTO 객체를 funitureDB의 길이만큼 생성
						ShopFrame_ShopCategoryDTO[] funitureDTO = set.productSet(shopDB.funitureDB);
						printProduct(funitureDTO);
						break;	//예외발생
					case 2:	// 가전디지털
						set.productDTO = new ShopFrame_ShopCategoryDTO[shopDB.digitalDB.length];	// productDTO 객체를 digitalDB의 길이만큼 생성
						ShopFrame_ShopCategoryDTO[] digitalDTO = set.productSet(shopDB.digitalDB);
						printProduct(digitalDTO);
						break;
					case 3:	// 식품
						set.productDTO = new ShopFrame_ShopCategoryDTO[shopDB.foodDB.length];	// productDTO 객체를 foodDB의 길이만큼 생성
						ShopFrame_ShopCategoryDTO[] foodDTO = set.productSet(shopDB.foodDB);
						printProduct(foodDTO);
						break;
					case 4:	// 패션
						set.productDTO = new ShopFrame_ShopCategoryDTO[shopDB.fashionDB.length];	// productDTO 객체를 fashionDB의 길이만큼 생성
						ShopFrame_ShopCategoryDTO[] fashionDTO = set.productSet(shopDB.fashionDB);
						printProduct(fashionDTO);
						break;
				}
				continue;
			}
		}
	}
	void productExplain(ShopFrame_ShopCategoryDTO productDTOobj){
		// 상품명, 상품설명
		api.mLine('-',80);
		System.out.printf("브랜드 : %s\n", productDTOobj.getBrand());
		System.out.printf("상품명 : %s\n", productDTOobj.getProductName());
		System.out.printf("등록 일자 : %s\n", productDTOobj.getUploadDate());
		System.out.printf("상품 설명\n%s\n", productDTOobj.getExplain());
		api.mLine('-',80);
		System.out.println("-> 1. 구매");
		System.out.println("-> 2. 장바구니");
		System.out.println("-> 3. 리뷰");
		while(true){
			System.out.print("구매, 장바구니, 리뷰를 선택하세요 [뒤로가기 : Q] : ");
			String explainRead = scan.nextLine();
			if(explainRead.length() == 0) {
				System.out.println("\t^ 메뉴를 선택하세요");
				continue;
			}
			if(explainRead.equalsIgnoreCase("Q")) {
				System.out.println("\t← 상품 이동");
				return;
			}
			if(explainRead.length() >= 1 && explainRead.charAt(0) < '1' || explainRead.charAt(0) > '9'){	// 숫자 이외의 문자 입력
				System.out.println("\t^ 메뉴를 선택하세요");
				continue;
			}
			if(Integer.parseInt(explainRead) >= 1 && Integer.parseInt(explainRead) <= 3) {
				switch(Integer.parseInt(explainRead)) {
					case 1:
						if(ShopFrame_Login.loginToken.equals("")){
							System.out.println("로그인 후 구매가 가능합니다.");
							continue;
						}
						System.out.println("\t\t^구매 Algorithm");
						break;
					case 2:
						if(ShopFrame_Login.loginToken.equals("")){
							System.out.println("로그인 후 담아주세요.");
							continue;
						}
						System.out.println("\t\t^ 장바구니 Algorithm");
						break;
					case 3:
						System.out.println("\t\t^ 리뷰 출력 Algorithm");
						break;
				}
			}
		}
	}
	void printProduct(ShopFrame_ShopCategoryDTO[] productDTOobj){
		while(true) {	// 카테고리별로 상품 출력
			System.out.printf("\t+%1$s+\n\t|\t%2$-8s\t|\n\t+%1$s+\n", api.mLineReturn('-', 23), productDTOobj[0].getCategory()); // 카테고리명 출력
			for(int idx = 0; idx < productDTOobj.length; idx++) { // 카테고리별로 상품을 출력하는 알고리즘
				System.out.print(idx+1+". ->");
				System.out.printf("\t브랜드 : %s\n", productDTOobj[idx].getBrand());
				System.out.printf("\t상품명 : %s\n", productDTOobj[idx].getProductName());
				System.out.printf("\t가격 : %,10d\n\n", productDTOobj[idx].getPrice());
			}	// 예외발생
			System.out.println("\n\tQ. <- 카테고리 이동");
			System.out.printf("\t%s\n", api.mLineReturn('-', 31));
			System.out.print("\t\t상품을 선택하세요 [뒤로가기 : Q] : ");
			String productRead = scan.nextLine();
			if(productRead.length() == 0) {
				System.out.println("\t^ 메뉴를 선택하세요");
				continue;
			}
			if(productRead.equalsIgnoreCase("Q")) {
				System.out.println("\t← 카테고리 이동");
				return;
			}
			if(productRead.length() >= 1 && (productRead.charAt(0) < '1' || productRead.charAt(0) > '9')){	// 숫자 이외의 문자 입력
				System.out.println("\t^ 메뉴를 선택하세요");
				continue;
			}
			if(productRead.length() <= productDTOobj.length && 
					(Integer.parseInt(productRead) >= 1 && Integer.parseInt(productRead) <= productDTOobj.length)) {
				// 상품 선택시 상품에 대한 정보 출력과 메뉴창이 출력됨
				System.out.println("\t↙상품 설명 이동");
				productExplain(productDTOobj[Integer.parseInt(productRead)-1]);	// 메소드로 이동 예정
				// 메뉴 이동 알고리즘 추가 예정
				continue;
			}
		}
	}
	void mainMenu() { // 메인 메뉴
		api.mLine('-', 30);
		System.out.println("1. 카테고리");
		System.out.println("2. 내 장바구니");
		System.out.println("3. 내 정보 출력");
		System.out.println("4. 로그인");
		System.out.println("5. 회원가입\n");
		System.out.println("EXIT. 종료");
		api.mLine('-', 30);
		System.out.print("메뉴를 선택하세요 [종료 : EXIT] : ");
	}
	void shopRun() { // 쇼핑몰 실행
		while(true) {
			String user = (ShopFrame_Login.loginToken.equals("")) ? "" : ShopFrame_Login.loginToken + "님 환영합니다.";
			System.out.printf("%1$s\n\t6조 쇼핑몰 프로젝트\t\t%2$s\n%1$s\n", api.mLineReturn('=', 31), user);
			mainMenu();
			String choiceMenu = scan.nextLine();
			if(choiceMenu.length() == 0) {
				System.out.println("\t^ 메뉴를 선택하세요");
				continue;
			}
			if(choiceMenu.equalsIgnoreCase("EXIT")) {
				System.out.println("시스템 종료합니다.");
				System.exit(0);
			}
			if(choiceMenu.length() >= 1 && (choiceMenu.charAt(0) < '1' || choiceMenu.charAt(0) > '9')){	// 숫자 이외의 문자 입력
				System.out.println("\t^ 메뉴를 선택하세요");
				continue;
			}
			if(choiceMenu.length() == 1 && (choiceMenu.charAt(0) >= '1' && choiceMenu.charAt(0) <= '5')) {
				switch(Integer.parseInt(choiceMenu)) {
					case 1:
						System.out.println("\t카테고리 이동↘");
						printCategory();
						break;
					case 2:
						System.out.println("\t내 장바구니 이동 Algorithm↘");
						break;
					case 3:
						System.out.println("내 정보 출력 Algorithm");
						break;
					case 4:
						System.out.println("로그인 Algorithm");
						break;
					case 5:
						System.out.println("회원가입 Algorithm");
						break;
				}
			}
		}
	}
}
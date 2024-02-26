package classes;

import java.util.Scanner;
public class ShopFrame_DAO{
	UserAPI api = new UserAPI();
	Scanner scan = new Scanner(System.in);
	ShopFrame_DB shopDB = new ShopFrame_DB();
	ShopFrame_DTOSet set = new ShopFrame_DTOSet();
	ShopFrame_Login loginObj = new ShopFrame_Login();
	ShopFrame_MyCart cartObj = new ShopFrame_MyCart();
	
	/* 정보객체 생성----------------------------------------------------------------------------------/
	/----------------------------------------단계별 메소드 생성*/
	void printCategory() {
		// 카테고리 화면
		while(true) {
			System.out.printf("\t+%1$s+\n\t|\t카테고리\t|\n\t+%1$s+\n", api.mLineReturn('-', 23));
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
						printProduct("가구", shopDB.funitureDB.length);
						break;	//예외발생
					case 2:	// 가전디지털
						printProduct("가전디지털", shopDB.digitalDB.length);
						break;
					case 3:	// 식품
						printProduct("식품", shopDB.foodDB.length);
						break;
					case 4:	// 패션
						printProduct("패션", shopDB.fashionDB.length);
						break;
				}
				continue;
			}
		}
	}	// printCategory()
	int pickProduct(String ctg){	// 카테고리별로 상품 고르는 알고리즘
		if(ctg.equals("가전디지털")){
			return shopDB.funitureDB.length;
		}
		if(ctg.equals("식품")){
			return shopDB.funitureDB.length + shopDB.digitalDB.length;
		}
		if(ctg.equals("패션")){
			return shopDB.funitureDB.length + shopDB.digitalDB.length + shopDB.foodDB.length;
		}
		return 0;
	}
	void printProduct(String ctg, int ctgLen){	// ctg : 기본키, ctgLen : 카테고리당 상품 개수
		while(true) {	// 카테고리별로 상품 출력
			int cnt = 0;
			int choice = pickProduct(ctg);
			System.out.printf("\t+%1$s+\n\t|\t%2$-8s\t|\n\t+%1$s+\n", api.mLineReturn('-', 23), ctg); // 카테고리명 출력
			for(int idx = 0; idx < set.productDTO.length; idx++) {
				if(ctg.equals(set.productDTO[idx].getCategory())) { // 카테고리별로 상품을 출력하는 알고리즘
					System.out.print(cnt+1+". ->");
					System.out.printf("\t브랜드 : %s\n", set.productDTO[idx].getBrand());
					System.out.printf("\t상품명 : %s\n", set.productDTO[idx].getProductName());
					System.out.printf("\t가격 : %,10d\n\n", set.productDTO[idx].getPrice());
					cnt++;
				}
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
			if(Integer.parseInt(productRead) > ctgLen) {
				System.out.println("\t^ 상품을 선택할 수 없습니다.");
				continue;
			}
			if(productRead.length() <= set.productDTO.length &&
					(Integer.parseInt(productRead) >= 1 && Integer.parseInt(productRead) <= ctgLen)) {
				// 상품 선택시 상품에 대한 정보 출력과 메뉴창이 출력됨
				System.out.println("\t↙상품 설명 이동");
				productExplain(set.productDTO[choice + Integer.parseInt(productRead)-1]);	// 메소드로 이동 예정
				// 메뉴 이동 알고리즘 추가 예정
				continue;
			}
		}
	}	// printProduct()
	void productExplain(ShopFrame_ShopCategoryDTO productDTOobj){
		// 상품명, 상품설명
		api.mLine('-',80);
		System.out.printf("브랜드 : %s\n", productDTOobj.getBrand());
		System.out.printf("상품명 : %s\n", productDTOobj.getProductName());
		System.out.printf("등록 일자 : %s\n", productDTOobj.getUploadDate());
		System.out.printf("상품 설명\n%s\n", productDTOobj.getExplain());
		System.out.printf("가격 : %,d\n", productDTOobj.getPrice());
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
						}else{
							
						}
						break;
					case 3:
						printReview(productDTOobj);
						break;
				}
			}
		}
	}	// productExplain()
	void printReview(ShopFrame_ShopCategoryDTO productDTOobj){		// 상품의 리뷰출력 알고리즘
		ShopFrame_ReviewProductDTO[] reviewDTO = set.reviewSet();
		int flag = 0;
		for (int idx =0;idx<reviewDTO.length ;idx++ )	{		
			if (reviewDTO[idx].getPdName() == productDTOobj.getProductName()){			
				api.mLineReturn('-', 30);			
				System.out.println("               " + reviewDTO[idx].getPdName());
				api.mLine('-', 30);			
				System.out.printf("날짜 : %s\n", reviewDTO[idx].getWriteDate());
				System.out.printf("내용 : %s\n", reviewDTO[idx].getUserWrite());
				flag = 0;
				break;				
			}else{
				flag=1;
			}
		}
		if (flag == 1){
			System.out.println("리뷰 없음");
		}
	}	// productReview()
	void showCart(String[] cart, String user) {
		System.out.printf("%s\n", api.mLineReturn('=', 40));
		System.out.printf("\t%s의 장바구니\n", user);
		System.out.printf("%s\n", api.mLineReturn('=', 40));
		label : for(int i = 0; i < cart.length; i++){
			if(cart[i] == null){	// 장바구니에 상품이 있을때까지 출력
				break;
			}
			for(int j = 0; j < set.productDTO.length; j++){
				if(cart[i].equals(set.productDTO[j].getProductName())){
					System.out.printf("상품번호 : %d\n브랜드 : %s\n", j, set.productDTO[j].getBrand());
					System.out.printf("상품명 : %s\n",set.productDTO[j].getProductName());
					System.out.printf("상품 가격 : %,d\n", set.productDTO[j].getPrice());
					System.out.printf("%s\n", api.mLineReturn('-', 30));
					continue label;
				}
			}
		}
	}
	void myCart(String user){
		String[] myCart = new String[shopDB.userCart[0].length];
		int uIdx = 0;
		set.userSet(shopDB.userDB); // 유저 정보 끌어오기
		for(int i = 0; i < set.userDTO.length; i++){	// 로그인된 계정의 장바구니
			if(user.equals(set.userDTO[i].getId())) {
				myCart = set.userDTO[i].getCart();
				uIdx = i;
				break;
			}
		}
		while(true){
			myCart[0] = "신라면 블랙 멀티팩";
			myCart[1] = "맥북 에어 13";
			showCart(myCart, user);
			System.out.print("상품 번호를 선택하세요[돌아가기 : Q] : ");
			String cartRead = scan.nextLine();
			if(cartRead.length() == 0) {
				System.out.println("\t^ 선택하세요");
				continue;
			}
			if(cartRead.equalsIgnoreCase("Q")) {
				System.out.println("\t^ 메인메뉴 이동");
				set.userDTO[uIdx].setCart(myCart); // 유저의 장바구니 정보 저장
				return;
			}
			if(cartRead.length() >= 1 && (cartRead.charAt(0) < '1' || cartRead.charAt(0) > '9')){	// 숫자 이외의 문자 입력
				System.out.println("\t^ 메뉴를 선택하세요");
				continue;
			}
		}
	}
	void mainMenu() { // 메인 메뉴
		api.mLine('-', 30);
		System.out.println("1. 카테고리");
		if(ShopFrame_Login.loginToken.equals("")){
			System.out.println("2. 로그인");
			System.out.println("3. 회원가입\n");
			
		}else{
			System.out.println("2. 장바구니");
			System.out.println("3. 마이 쇼플");
			System.out.println("4. 로그아웃");
		}
		System.out.println("EXIT. 종료");
		api.mLine('-', 30);
		System.out.print("메뉴를 선택하세요 [종료 : EXIT] : ");
	}	// mainMenu()
	void shopRun() { // 쇼핑몰 실행
		loginObj.shopUserInit();	// 프로그램 실행 시 유저 DB 초기화
		set.itgProduct();	// 카테고리 상품 통합메소드 호출
		set.productSet();	// 상품 갱신
		//System.out.println(Arrays.toString(shopDB.userCart[1]));
		while(true) {
			String user = (ShopFrame_Login.loginToken.equals("")) ? "" : ShopFrame_Login.loginToken + "님 환영합니다.";
			System.out.printf("%1$s\n\t쇼핑 플렉스몰\t\t%2$s\n%1$s\n", api.mLineReturn('=', 31), user);
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
						printCategory();
						break;
					case 2:
						if(ShopFrame_Login.loginToken.equals("")){
							loginObj.login();
						}else{
							myCart(ShopFrame_Login.loginToken);
						}
						break;
					case 3:
						if(ShopFrame_Login.loginToken.equals("")){
							loginObj.signUp();
						}else{
							loginObj.printMyInfo();
						}
						break;
					case 4:
						if(ShopFrame_Login.loginToken.equals("")){	// 로그인상태가 아닐때
							
						}else{	// 로그인 상태일때
							loginObj.logOut();
						}
						break;
				}
			}
		}
	}	// shopRun()
}
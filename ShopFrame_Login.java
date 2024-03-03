package classes;

import java.util.Scanner;

public class ShopFrame_Login{
	static String loginToken; // 유저 로그인 토큰
	static int userToken;	// 유저 토큰(장바구니, 구매내역 용도)
	static int userLen;
	static{
		loginToken = ""; // 실행 시 로그인 토큰 초기화
		userToken = 0;	// 유저 토큰(장바구니, 구매내역 용도)
		userLen = 1;	// 회원가입 할때마다 1씩 증가시켜서 자리 확보
	}
	UserAPI api = new UserAPI();
	Scanner scan = new Scanner(System.in);
	ShopFrame_DTOSet set = new ShopFrame_DTOSet();
	ShopFrame_DB shopDB = new ShopFrame_DB();

	// 프로그램 실행 시 유저 정보 배열 초기화
	void shopUserInit(){
		for(int i = 0; i < shopDB.userDB.length; i++){
			for(int j = 0; j < shopDB.userDB[i].length; j++){
				shopDB.userDB[i][j] = "";
			}
		}
	}
	// 회원가입 Algorithm
	void signUp() { // 회원가입 구현
		String read;
		String[] layer = {"이름", "주민번호", "아이디", "비밀번호", "휴대폰번호", "이메일", "주소"};
		String[] info = new String[7]; // NAME, IDENTIFY NO, ID, PWD, PHONENO, EMAIL, ADDRESS
		String idResult = "";
		for(int idx = 0; idx < info.length; idx++){
			System.out.printf("%6s\t입력[취소 : Q] : ", layer[idx]);
			read = scan.nextLine();
			if(read.equalsIgnoreCase("Q")){
				System.out.println("회원가입을 취소합니다.");
				return;
			}
			info[idx] = read;
		}
		System.out.println("-> ID 중복 검사");
		if(info[2].equalsIgnoreCase("admin")){
			System.out.println("\t^ 가입할 수 없는 아이디 형식입니다.");
			return;
		}
		for(int id = 0; id < shopDB.userDB.length; id++){ // 아이디 중복 검사
			if(info[2].equals(shopDB.userDB[id][2])){
				System.out.println("\t^ 이 아이디는 현재 가입되어있는 아이디입니다.");
				return;
			}
		}
		System.out.println("ID 사용 가능\n주민번호 검사");
		if(info[1].length() < 13){
			System.out.println("주민번호 13자리를 입력하세요.\n");
			return;
		}
		if(info[1].charAt(6) != '-'){	// -로 앞자리와 뒷자리를 구분하지 않았을 때				
			String idNoF = info[1].substring(0, 6);
			String idNoB = info[1].substring(6, info[1].length());
			idResult = idNoF + '-' + idNoB;
		}else{
			idResult = info[1];
		}
		info[1] = idResult;

		shopDB.userDB[ShopFrame_Login.userLen] = info;	// shopDB.userDB[0]번째부터 유저들의 정보를 할당
		ShopFrame_Login.userLen += 1; // 회원가입할 때마다 유저의 수가 늘어남
		// 회원가입 완료
		set.userDTO = set.userSet(shopDB.userDB);	// DTOSet클래스의 userDTO객체에 회원가입할때마다 최근에 가입한 유저들 DB에 갱신 
		System.out.println("회원가입 완료");
		return;
	}
	// 유저 정보 출력
	void printMyInfo(){
		for(int idx = 0; idx < set.userDTO.length; idx++){
			if(ShopFrame_Login.loginToken.equals(set.userDTO[idx].getId())){
				api.mLine('-', 30);
				System.out.printf("ID : \t%s\n", set.userDTO[idx].getId());
				System.out.printf("성명 : \t%s\n", set.userDTO[idx].getName());
				System.out.printf("주민번호 : \t%.8s******\n", set.userDTO[idx].getIdentifyNo());
				System.out.printf("전화번호 : \t%s\n", set.userDTO[idx].getPhoneNo());
				System.out.printf("이메일 : \t%s\n", set.userDTO[idx].getEmail());
				System.out.printf("주소 : \t%s\n", set.userDTO[idx].getAddress());
				api.mLine('-', 30);	
			}
		}
	}	// printMyInfo()
	// 유저 로그인
	void login(){
		// 어드민계정 생성
		shopDB.userDB[0][0] = "Administrator";
		shopDB.userDB[0][1] = "000101-3010402";
		shopDB.userDB[0][2] = "admin";
		shopDB.userDB[0][3] = "1234";
		shopDB.userDB[0][4] = "010-1234-5678";
		shopDB.userDB[0][5] = "ed@test.com";
		shopDB.userDB[0][6] = "서울시 노원구 초안산로";
		// 어드민계정 업로드
		set.userDTO = set.userSet(shopDB.userDB);
		
		System.out.print("\t-> 아이디를 입력해주세요 \t : ");
		String inputId = scan.nextLine();
		if(inputId.equalsIgnoreCase("exit")){
			System.out.println("시스템을 종료합니다.\n");
			System.exit(0);
		}
		if(inputId.length() == 0){
			return;
		}
		System.out.print("\t-> 비밀번호를 입력해주세요 \t : ");
		String inputPwd = scan.nextLine();
		System.out.println();
		boolean idFlag = false;
		if(set.userDTO[0].getId().equals("")){
			System.out.println("고객DB에 정보 없음");
			return;
		}
		for(int i = 0; i < set.userDTO.length; i++){
			if(inputId.equals(set.userDTO[i].getId())){
				if(inputPwd.equals(set.userDTO[i].getPwd())){
					idFlag = true;
					userToken = i;	// <- 유저 인덱스 추출
					loginToken = set.userDTO[i].getId();
					break;
				}else{
					break;
				}
			}else{
				continue;
			}
		}
		String result = (idFlag == true) ? "" : "ID 또는 PWD 오류";
		System.out.println(result);
	}
	// 유저 로그아웃
	void logOut(){
		System.out.printf("%s님 로그아웃\n", loginToken);
		loginToken = "";
		userToken = 0;
	}
}
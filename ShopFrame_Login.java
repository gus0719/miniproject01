package classes;
import java.util.Scanner;
public class ShopFrame_Login{
	static String loginToken;   // 유저 로그인 토큰
	static {
		loginToken = "";	// 실행 시 로그인 토큰 초기화
	}
	
	UserAPI api = new UserAPI();
	Scanner scan = new Scanner(System.in);
	
	ShopFrame_DTOSet set = new ShopFrame_DTOSet();
	ShopFrame_UserDTO[] userDTO = set.userSet();	// 유저 정보 객체배열 생성
	
	/* 회원가입 Algorithm
	ShopFrame_DB shopDB = new ShopFrame_DB();
	void signUp(){	// 회원가입 구현
		String read;
		
		String[] info = new String[5]; // ID, PWD, NAME, PHONENO, ADDRESS
		register : for(int userCnt = 0; userCnt < shopDB.userDB.length; userCnt++){
			if(shopDB.userDB[userCnt][0].equals(null)){	// userDB의 userCnt번째 행이 비어있을때 추가하는 코드
				for(int idx = 0; idx < info.length; idx++) {
					read = scan.nextLine();
					if(read.equalsIgnoreCase("Q")){
						System.out.println("회원가입을 취소합니다.");
						return;
					}
					info[idx] = read;
				}
				System.out.println("-> 휴대폰 번호 중복 검사");
				for(int phone = 0; phone < shopDB.userDB.length; phone++){	// 전화번호 중복 검사
					if(info[4].equals(shopDB.userDB[phone][4])){
						System.out.println("이 전화번호는 현재 가입되어있는 전화번호입니다.")
						return;
					}
				}
				shopDB.userDB[userCnt] = info;
				break register;
			}
		}
	}
	*/
}
package classes;
import java.util.Scanner;
public class ShopFrame_Login{
	UserAPI api = new UserAPI();
	Scanner scan = new Scanner(System.in);
	
	ShopFrame_DAO dao = new ShopFrame_DAO();
	ShopFrame_UserDTO[] userDTO = dao.userSet();	// 유저 정보 객체배열 생성
	
	static String loginToken;   // 유저 로그인 토큰
}
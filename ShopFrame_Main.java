package classes;

public class ShopFrame_Main {
	public static void main(String[] args) {
		ShopFrame_DAO dao = new ShopFrame_DAO();
		//ShopFrame_ShopCategoryDTO[] productDTO = dao.productSet();	// 제품 정보 객체 배열로 생성
		ShopFrame_ReviewProductDTO[] reviewDTO = dao.reviewSet(); // 리뷰 객체 배열 생성

		dao.shopRun();	// 실행
	}
}
package classes;
public class UserAPI{	// 간단한 API
	void mLine(char mark, int length){
		for(int repeat = 0; repeat < length; repeat++){
			System.out.print(mark);
		}
		System.out.println();
	}
	String mLineReturn(char mark, int length){
		//String line = Character.toString(mark);
		String markLine = "";
		for(int repeat = 0; repeat < length; repeat++){
			markLine += mark;
			//markLine += line;
		}
		return markLine;
	}
}
package classes;
public class UserAPI{
	void mLine(char mark, int length){
		for(int repeat = 0; repeat < length; repeat++){
			System.out.print(mark);
		}
		System.out.println();
	}
	String mLineReturn(char mark, int length){
		String line = "";
		for(int repeat = 0; repeat < length; repeat++){
			line += mark;
		}
		return line;
	}
}
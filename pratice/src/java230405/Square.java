package java230405;

public class Square extends Figure {

	

	@Override
	double figureArea() {
		int result =  width * length;
		super.figureArea();
		return result;
	}
	
}

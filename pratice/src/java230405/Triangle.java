package java230405;

public class Triangle extends Figure {

	

	@Override
	double figureArea() {
		int result =  width * length/2;
		super.figureArea();
		return result;
	}
}

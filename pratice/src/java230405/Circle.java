package java230405;

public class Circle extends Figure{

	
	@Override
	double figureArea() {
		
		double result =  radius* radius *Math.PI;
		super.figureArea();
		return result;
		
	}
}

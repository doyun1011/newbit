package java230405;

public class FigureTest {

	public static void main(String[] args) {
		
		Figure[] f = new Figure[3];
		f[0] = new Circle();
		f[1] = new Triangle();
		f[2] = new Square();
		
		for (int i = 0; i < f.length; i++) {
			System.out.println(f[i].figureArea());
			
			Circle circle = new Circle();
			Figure figure = circle;
		}
	}
}

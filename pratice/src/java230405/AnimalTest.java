package java230405;

public class AnimalTest {

	public static void main(String[] args) {
		Animal[] animals = new Animal[5];
		animals[0] = new Animal();
		animals[1] =new Dog();
		animals[2] =new Tiger();
		animals[3] =new Cat();
		animals[4] =new Mouse();
 		for (int i = 0; i < 5; i++) {
 			animals[i].CryingSound();
 			System.out.println(animals[i].name +"ÀÌ ¿ó´Ï´Ù.");
 			System.out.println();
		}
	}
}

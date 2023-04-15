package java230405;

public class Dog extends Animal{
	String name ="°³";
	public Dog() {
	}
	public void CryingSound() {
		System.out.println(name +"°¡ Â¢½À´Ï´Ù. ¸Û¸Û");
		System.out.println(super.name +"°¡ Â¢½À´Ï´Ù. ¸Û¸Û");
		System.out.println(this.name +"°¡ Â¢½À´Ï´Ù. ¸Û¸Û");
	}
}

package java230405;

public class Cat extends Animal {
	String name = "°í¾çÀÌ";
	public Cat() {
		super();
	}
	public void CryingSound() {
		System.out.println(name +"°¡ ¿ó´Ï´Ù. ¾ß¿Ë");
		System.out.println(super.name +"°¡ ¿ó´Ï´Ù. ¾ß¿Ë");
		System.out.println(this.name +"°¡ ¿ó´Ï´Ù. ¾ß¿Ë");
	}

}

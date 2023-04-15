package java230405;

public class Mouse extends Animal {
	
	String name = "Áã";
	public Mouse() {
		
	}
	public void CryingSound() {
		System.out.println(name +"°¡ ÂïÂï°Å¸³´Ï´Ù. ÂïÂï");
		System.out.println(super.name +"°¡ ÂïÂï°Å¸³´Ï´Ù. ÂïÂï");
		System.out.println(this.name +"°¡ ÂïÂï°Å¸³´Ï´Ù. ÂïÂï");
	}
}

package java230406;

public class Man {
	String name;
	public Man(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		String str ="¿Ã∏ß:" + name;
		return str;
	}
	
	
	void rideVehicle(Transportation trans) {
		trans.goGoSeoul();
	}
}

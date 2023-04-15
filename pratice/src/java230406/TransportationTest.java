package java230406;

public class TransportationTest {

	public static void main(String[] args) {
		Man man = new Man("Ã¶¼ö");
		Transportation transBus = new ExpressBus();
		Transportation transKtx = new Ktx();
		
		Ktx ktx = new Ktx();
		System.out.println(man);
		man.rideVehicle(transBus);
		man.rideVehicle(transKtx);
		
	}
	
}

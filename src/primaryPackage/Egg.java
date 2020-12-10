package primaryPackage;

public class Egg implements Comerciable{
	
	private double price;
	private int maxSupported=100;
	private int idGranja;	
	
	
	public Egg(int idGranja) {
		price = 30;
		this.idGranja=idGranja;
	}
		
	public double getPrice() {
		return this.price;
	}

	@Override
	public int getMax() {
		// TODO Auto-generated method stub
		return this.maxSupported;
	}

	
	public int getIdGranja() {
		return idGranja;
	}
}

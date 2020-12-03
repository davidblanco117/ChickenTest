package primaryPackage;

public class Egg implements Comerciable{
	
	private double price;
	private int MAXSUPPORTED=100;
	
	public double getPrice() {
		return this.price;
	}

	@Override
	public int getMax() {
		// TODO Auto-generated method stub
		return this.MAXSUPPORTED;
	}

}

package primaryPackage;

public class Egg implements Comerciable{
	
	private final int DAYSTOBORN=7;
	
	
	private double price;
	private int maxSupported=100;
	private int daysOfLife;
	private boolean isGoingToBorn;
	private int idGranja;	
	
	public Egg() {
		daysOfLife=0;
		isGoingToBorn=false;
		price = 30;
		idGranja=1;
	}
	
	public void goNextDay(Farm farm) {
		
		daysOfLife++;
		if(DAYSTOBORN==daysOfLife) {
			isGoingToBorn=true;
		}			
	}
	
	
	public boolean isGoingToBorn() {
		return isGoingToBorn;
	};
	
	
	public double getPrice() {
		return this.price;
	}

	@Override
	public int getMax() {
		// TODO Auto-generated method stub
		return this.maxSupported;
	}

	public int getDaysToBorn() {
		return this.DAYSTOBORN;
	}
	
	public int getIdGranja() {
		return idGranja;
	}
}

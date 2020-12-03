package primaryPackage;

public class Chicken implements Comerciable{

	
	private final int MAXIMUNDAYSOFLIFE=15;
	private final int CANTDAYSTOPUTANEGG=3;
	private final int CANTEGGS=2;
	
	private final int MAXSUPPORTED=100;
	
	
	private double price;
	private boolean isAlive;
	private int daysOfLife;
	private int daysToPutAnEgg;
	
	
	public Chicken() {
		isAlive=true;
		daysOfLife=0;
		daysToPutAnEgg=CANTDAYSTOPUTANEGG;
	}
	
	public void goNextDay(Farm farm) {
	
		daysOfLife++;
		if(MAXIMUNDAYSOFLIFE==daysOfLife) {
			isAlive=false;
			return;
		}
		daysToPutAnEgg--;
		if(daysToPutAnEgg==0) {
			for(int i=0;i<CANTEGGS;i++)
				farm.addEgg();

			daysToPutAnEgg=CANTDAYSTOPUTANEGG;
		}
			
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}

	@Override
	public int getMax() {
		// TODO Auto-generated method stub
		return this.MAXSUPPORTED;
	}

	public boolean isAlive() {
		return this.isAlive;
	}
	

	


	
}

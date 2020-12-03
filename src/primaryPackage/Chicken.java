package primaryPackage;

public class Chicken{

	
	private final int maximunDaysOfLife=15;
	private final int CANTDAYSTOPUTANEGG=3;
	private final int cantEggs=2;
	
	
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
		if(maximunDaysOfLife==daysOfLife) {
			isAlive=false;
			return;
		}
		daysToPutAnEgg--;
		if(daysToPutAnEgg==0) {
			for(int i=0;i<cantEggs;i++)
				farm.addEgg();

			daysToPutAnEgg=CANTDAYSTOPUTANEGG;
		}
			
	}


	
}

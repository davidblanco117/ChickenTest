package primaryPackage;


public class Chicken implements Comerciable{

	
	private final int MAXIMUNDAYSOFLIFE=100;
	private final int CANTDAYSTOPUTANEGG=10;
	private final int CANTEGGS=3;
	private int idGranja;
	private final int maxSupported=100;
	
	
	private double price;
	private boolean isAlive;
	private int daysOfLife;
	private int daysToPutAnEgg;
	
	
	public Chicken() {
		isAlive=true;
		daysOfLife=0;
		daysToPutAnEgg=CANTDAYSTOPUTANEGG;
		price=100;
		idGranja = 1;
	}
	
	public Chicken(int idGranja) {
		isAlive=true;
		daysOfLife=0;
		daysToPutAnEgg=CANTDAYSTOPUTANEGG;
		price=100;
		this.idGranja= idGranja;
	}
	
	
	public Chicken(double precio, int diasDeVida, int idGranja) {
		isAlive=true;
		daysOfLife=diasDeVida;
		daysToPutAnEgg=CANTDAYSTOPUTANEGG;
		price=precio;
		this.idGranja= idGranja;
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
		return this.maxSupported;
	}

	public boolean isAlive() {
		return this.isAlive;
	}
	
	public int getMaximunDaysOfLife() {
		return this.MAXIMUNDAYSOFLIFE;
	}

	public int getIdGranja() {
		return this.idGranja;
	}

	public int getId() {
		return this.getId();
	}

	
}

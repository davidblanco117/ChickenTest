package primaryPackage;


public class Chicken implements Comerciable{

	
	private int idGranja;
	private final int maxSupported=100;
	
	
	private double price;
	private boolean isAlive;
	private int daysOfLife;
	private int daysToPutAnEgg;
	
	
	public Chicken() {
		isAlive=true;
		daysOfLife=0;
		daysToPutAnEgg=Parametros.cantDiasPonerHuevos;
		price=Parametros.precioPollos;
	}
	
	public Chicken(int idGranja) {
		isAlive=true;
		daysOfLife=0;
		daysToPutAnEgg=Parametros.cantDiasPonerHuevos;
		price=Parametros.precioHuevos;
		this.idGranja= idGranja;
	}
	
	
	public Chicken(double precio, int diasDeVida, int idGranja) {
		isAlive=true;
		daysOfLife=diasDeVida;
		daysToPutAnEgg=Parametros.cantDiasPonerHuevos;
		price=precio;
		this.idGranja= idGranja;
	}
	
	
	
	public void goNextDay(Farm farm) {
	
		daysOfLife++;
		if(Parametros.cantDiasVidaPollo==daysOfLife) {
			isAlive=false;
			return;
		}
		daysToPutAnEgg--;
		if(daysToPutAnEgg==0) {
			for(int i=0;i<Parametros.cantHuevosDeUnPollo;i++)
				farm.addEgg();

			daysToPutAnEgg=Parametros.cantDiasPonerHuevos;
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
	

	public int getIdGranja() {
		return this.idGranja;
	}

	public int getId() {
		return this.getId();
	}
	
	public int getDaysToPutAnEgg() {
		return this.daysToPutAnEgg;
	}
	
	public void setDaysToPutAnEgg(int days) {
		this.daysToPutAnEgg = days;
	}
	
}

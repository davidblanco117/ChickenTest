package primaryPackage;


public class Chicken implements Comerciable{

	
	private int idGranja;
	private final int maxSupported=100;
	
	
	private double price;
	private int daysOfLife;
	private int daysToPutAnEgg;
	

	
	public Chicken(int idGranja) {
		daysOfLife=0;
		daysToPutAnEgg=Parametros.cantDiasPonerHuevos;
		price=Parametros.precioPollos;
		this.idGranja= idGranja;
	}
	
	
	public Chicken(double precio, int diasDeVida, int idGranja) {
		daysOfLife=diasDeVida;
		daysToPutAnEgg=Parametros.cantDiasPonerHuevos;
		price=precio;
		this.idGranja= idGranja;
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

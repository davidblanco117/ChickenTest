package primaryPackage;

import java.util.ArrayList;

public class Farm {

	private double money=0;
	private ArrayList<Chicken> chickens;
	private ArrayList<Egg> eggs;
	
	public Farm() {
		chickens= new ArrayList<Chicken>();
		eggs= new ArrayList<Egg>();
		
	}
	
	public void addEgg() {
		eggs.add(new Egg());
	}
	
	public void goNextDay() {
		for (Chicken chicken : chickens) {
			chicken.goNextDay(this);
		}
	}
	
	public void printReport() {
		System.out.println("Dinero disponible -> " + money);
		System.out.println("Cantidad de pollos -> " + chickens.size());
		System.out.println("Cantidad de huevos -> " + eggs.size());
	}
	
}

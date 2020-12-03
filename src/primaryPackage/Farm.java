package primaryPackage;

import java.util.ArrayList;
import java.util.List;


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
			if(!chicken.isAlive())
				chickens.remove(chicken);
		}
	}
	
	public void printReport() {
		System.out.println("Dinero disponible -> " + money);
		System.out.println("Cantidad de pollos -> " + chickens.size());
		System.out.println("Cantidad de huevos -> " + eggs.size());
	}
	
	@SuppressWarnings("rawtypes")
	public int buy(Comerciable product, int cant, List list) {
		if(list.size()+cant>product.getMax())
			return -2;
		else if(this.money>=product.getPrice()) {
			this.money-=product.getPrice();
			return 0;
		}
		return -1;
			
	}
	
	public int buyChicken(Chicken chicken, int cant) {
		int resp= buy(chicken,cant,this.chickens);
		if (resp==0) {
			for (int i=0;i<cant;i++)
				chickens.add(new Chicken());
		}
		return resp;
	}
	
	public int buyEggs(Egg egg, int cant) {
		int resp = buy(egg,cant,this.eggs);
		if (resp==0) {
			for (int i=0;i<cant;i++)
				eggs.add(new Egg());
		}
		return resp;
	}
	
		
	
	
	
	public double getMoney() {
		return this.money;
	}
	
}

package primaryPackage;

import java.util.ArrayList;
import java.util.List;

public class Farm {

	private int day = 1;

	private double money = 0;
	private ArrayList<Chicken> chickens;
	private ArrayList<Egg> eggs;
	private ArrayList<Object> toRemove;

	public Farm() {
		chickens = new ArrayList<Chicken>();
		eggs = new ArrayList<Egg>();

	}

	public Farm(double money) {
		this.money = money;
		chickens = new ArrayList<Chicken>();
		eggs = new ArrayList<Egg>();

	}

	public void addEgg() {
		eggs.add(new Egg());
	}

	public void goNextDay() {
		toRemove = new ArrayList<Object>();
		for (Chicken chicken : chickens) {
			chicken.goNextDay(this);
			if (!chicken.isAlive())
				toRemove.add(chicken);
			// chickens.remove(chicken);
		}
		chickens.removeAll(toRemove);
		
		toRemove = new ArrayList<Object>();
		for (Egg egg : eggs) {
			egg.goNextDay(this);
			if (egg.isGoingToBorn()) {
				//eggs.remove(egg);
				toRemove.add(egg);
				chickens.add(new Chicken());
			}
		}
		eggs.removeAll(toRemove);
		day++;
	}

	@SuppressWarnings("rawtypes")
	public int buy(Comerciable product, int cant, List list) {
		if (list.size() + cant > product.getMax())
			return -2;
		else if (this.money >= product.getPrice() * cant) {
			this.money -= product.getPrice() * cant;
			return 0;
		}
		return -1;

	}

	public int buyChickens(int cant) {
		int resp = buy(new Chicken(), cant, this.chickens);
		if (resp == 0) {
			for (int i = 0; i < cant; i++)
				chickens.add(new Chicken());
		}
		return resp;
	}

	public int buyEggs(int cant) {
		int resp = buy(new Egg(), cant, this.eggs);
		if (resp == 0) {
			for (int i = 0; i < cant; i++)
				eggs.add(new Egg());
		}
		return resp;
	}

	@SuppressWarnings("rawtypes")
	public int sell(Comerciable product, int cant, List list) {
		if (list.size() - cant < 0)
			return -2;
		this.money += product.getPrice() * cant;
		return 0;

	}

	public int sellChickens(int cant) {
		int resp = sell(new Chicken(), cant, chickens);
		if (resp == 0) {
			for (int i = 0; i < cant; i++) {
				chickens.remove(1);
			}
		}
		return resp;
	}

	public int sellEggs(int cant) {
		int resp = sell(new Egg(), cant, eggs);
		if (resp == 0) {
			for (int i = 0; i < cant; i++) {
				eggs.remove(1);
			}
		}
		return resp;
	}

	public double getMoney() {
		return this.money;
	}

	public int getDay() {
		return day;
	}

	public ArrayList<Chicken> getChickens() {
		return chickens;
	}

	public ArrayList<Egg> getEggs() {
		return eggs;
	}

}

package primaryPackage;

import java.util.ArrayList;
import java.util.List;

import com.fblanco.chickentest.dao.ChickenDao;
import com.fblanco.chickentest.dao.EggDao;
import com.fblanco.chickentest.dao.FarmDao;

public class Farm implements ChickenDao, EggDao,FarmDao {

	private int day = 1;
	private double money = 0;
	private ArrayList<Chicken> chickens;
	private ArrayList<Egg> eggs;
	private ArrayList<Object> toRemove;
	private int id;
	@SuppressWarnings("unused")
	private Parametros params;

	public Farm() {
		chickens = readChickens(id);
		eggs = readEggs(this.id);
		params= new Parametros();
	}

	public Farm(int id, double money) {
		chickens = readChickens(id);
		eggs = readEggs(this.id);
		this.id = id;
		this.money = money;
		params = new Parametros();
	}

	public Farm(double money) {
		this.money = money;
		chickens = readChickens(id);
		eggs = readEggs(this.id);
		params= new Parametros();

	}

	public void addEgg() {
		eggs.add(new Egg());
	}

	public void goNextDay() {
		Parametros.dia++;
		updateNewDay(this);
		
		toRemove = new ArrayList<Object>();
		for (Chicken chicken : chickens) {
			chicken.goNextDay(this);
			if (!chicken.isAlive())
				toRemove.add(chicken);
		}
		chickens.removeAll(toRemove);

		toRemove = new ArrayList<Object>();
		for (Egg egg : eggs) {
			egg.goNextDay(this);
			if (egg.isGoingToBorn()) {
				toRemove.add(egg);
				chickens.add(new Chicken());
			}
		}
		eggs.removeAll(toRemove);
	}

	@SuppressWarnings("rawtypes")
	public int buy(Comerciable product, int cant, List list) {
		if (cant < 0)
			return -3;
		if (list.size() + cant > product.getMax())
			return -2;
		else if (this.money >= product.getPrice() * cant) {
			this.money -= product.getPrice() * cant;
			updateMoney(this, this.money);
			return 0;
		}
		return -1;

	}

	public int buyChickens(int cant) {
		int resp = buy(new Chicken(), cant, readChickens(id));
		if (resp == 0) {
			for (int i = 0; i < cant; i++)
				insertChicken(new Chicken(id));
			// chickens.add(new Chicken());
		}
		return resp;
	}

	public int buyEggs(int cant) {
		int resp = buy(new Egg(), cant, readEggs(this.id));
		if (resp == 0) {
			for (int i = 0; i < cant; i++)
				insertEgg(new Egg());
			// eggs.add(new Egg());
		}
		return resp;
	}

	@SuppressWarnings("rawtypes")
	public int sell(Comerciable product, int cant, List list) {
		if (cant < 0)
			return -3;
		if (list.size() - cant < 0)
			return -2;
		this.money += product.getPrice() * cant;
		updateMoney(this, this.money);
		
		return 0;

	}

	public int sellChickens(int cant) {
		chickens = readChickens(this.id);
		int resp = sell(new Chicken(), cant, chickens);
		if (resp == 0) {
			// for (int i = 0; i < cant; i++) {
			deleteChicken(cant, this.id);
			// chickens.remove(0);
			// }
			chickens = readChickens(this.id);
		}
		return resp;
	}

	public int sellEggs(int cant) {
		eggs = readEggs(this.id);
		int resp = sell(new Egg(), cant, eggs);
		if (resp == 0) {
			// for (int i = 0; i < cant; i++) {
			deleteEggs(cant, this.id);
			eggs = readEggs(this.id);
		}
		
		// eggs.remove(0);
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

	public void getChickensByDB() {
		chickens = readChickens(this.getId());
	}

	public int getId() {
		return this.id;
	}
}

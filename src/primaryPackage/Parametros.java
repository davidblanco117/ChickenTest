package primaryPackage;

import com.fblanco.chickentest.dao.ParametrosDao;

public  class Parametros implements ParametrosDao{

	
	public static int dia;
	public static  double precioPollos;
	public static  double precioHuevos;
	public static  int cantDiasVidaPollo;
	public static  int cantDiasPonerHuevos;
	public static  int cantHuevosDeUnPollo;
	public static  int cantDiasEclosionarHuevos;
	public static  int id;
	
	public Parametros() {
		Parametros param = readParams();
		Parametros.dia=param.getDia();
		Parametros.precioPollos=param.getPrecioPollos();
		Parametros.precioHuevos=param.getPrecioHuevos();
		Parametros.cantDiasVidaPollo=param.getCantDiasVidaPollo();
		Parametros.cantDiasPonerHuevos=param.getCantDiasPonerHuevos();
		Parametros.cantHuevosDeUnPollo=param.getCantHuevosDeUnPollo();
		Parametros.cantDiasEclosionarHuevos=param.getCantDiasEclosionarHuevos();
		Parametros.id=param.getId();
	}
	
	
	
	public Parametros(int dia, double precioPollos, double precioHuevos, int cantDiasVidaPollo, int cantDiasPonerHuevos,
			int cantHuevosDeUnPollo, int cantDiasEclosionarHuevos, int id) {
		super();
		Parametros.dia = dia;
		Parametros.precioPollos = precioPollos;
		Parametros.precioHuevos = precioHuevos;
		Parametros.cantDiasVidaPollo = cantDiasVidaPollo;
		Parametros.cantDiasPonerHuevos = cantDiasPonerHuevos;
		Parametros.cantHuevosDeUnPollo = cantHuevosDeUnPollo;
		Parametros.cantDiasEclosionarHuevos = cantDiasEclosionarHuevos;
		Parametros.id = id;
	}



	public int getDia() {
		return dia;
	}
	public double getPrecioPollos() {
		return precioPollos;
	}
	public double getPrecioHuevos() {
		return precioHuevos;
	}
	public int getCantDiasVidaPollo() {
		return cantDiasVidaPollo;
	}
	public int getCantDiasPonerHuevos() {
		return cantDiasPonerHuevos;
	}
	public int getCantHuevosDeUnPollo() {
		return cantHuevosDeUnPollo;
	}
	public int getCantDiasEclosionarHuevos() {
		return cantDiasEclosionarHuevos;
	}
	public int getId() {
		return id;
	}	
	
	
	
	
	
	
	
	
}

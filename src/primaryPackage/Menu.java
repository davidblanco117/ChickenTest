package primaryPackage;

import java.util.Scanner;
import com.fblanco.chickentest.dao.*;

public class Menu implements FarmDao{

	private Farm farm;
	Scanner sc;

	private void mostrarMenuPrincipal(Farm f) {
		farm = f;
		int resp;
		System.out.println("Bienvenido a su granja");
		do {
			System.out.println();
			System.out.println("**************************************************************");
			System.out.println("*                      DIA : " + String.format("%5d", Parametros.dia)
					+ "                           *");
			System.out.println("**************************************************************");
			System.out.println("\nElija una opcion: ");
			System.out.println("1) Imprimir listado ");
			System.out.println("2) Comprar ");
			System.out.println("3) Vender ");
			System.out.println("4) Avanzar dia ");
			System.out.println("5) Salir");

			resp = 0;
			try {

				resp = Integer.valueOf(sc.nextLine()); // Invocamos un m�todo sobre un objeto Scanner

			} catch (NumberFormatException ex) {
				resp = -1;
			}

			switch (resp) {

			case 1:
				printReport();
				break;

			case 2:
				menuComprar(resp);
				break;

			case 3:
				menuVender(resp);
				break;

			case 4:
				farm.goNextDay();
				break;

			case 5:
				System.out.println("Hasta la proxima");
				sc.close();
				break;

			case -1:
				System.out.println("La opcion ingresada debe ser un numero");
				break;

			default:
				System.out.println("La opcion no es correcta");
			}

		} while (resp != 5);
		sc.close();

	}

	private void printReport() {
		System.out.println(" _______________________________________________________________");
		System.out.println("|");
		// System.out.println("* Dia numero -> " + farm.getDay());
		System.out.println("|  *  Dinero disponible -> " + farm.getMoney());
		System.out.println("|  *  Cantidad de pollos -> " + farm.readChickens(farm.getId()).size());
		System.out.println("|  *  Cantidad de huevos -> " + farm.readEggs(farm.getId()).size());
		System.out.println("|  *  Precio de los pollos -> " + Parametros.precioPollos);
		System.out.println("|  *  Precio de los huevos -> " + Parametros.precioHuevos);
		System.out.println("|  *  Cantidad de dias de vida de un pollo -> " + Parametros.cantDiasVidaPollo);
		System.out.println("|  *  Cantidad de dias que tarda en eclosionar un huevo -> " + Parametros.cantDiasEclosionarHuevos);
		System.out.println("|_______________________________________________________________");

	}

	public void menuLogin() {
		sc = new Scanner(System.in); // Creaci�n de un objeto Scanner
		
		int resp = 0;
		boolean loop = true;
		String user;
		String pass;
		Farm farm;
		System.out.println("Bienvenido");
		do {
			System.out.println("Elija la opcion:");
			System.out.println("1) Iniciar Sesion");
			System.out.println("2) Registrarte");
			System.out.println("3) Salir");
			try {
				resp = Integer.valueOf(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Debes escribir un numero");
			}

			switch (resp) {
			case 1:
				System.out.println("Escribe tu usuario:");
				user = sc.nextLine();
				System.out.println("Escribe tu password:");
				pass = sc.nextLine();
				farm = validateUserPass(user,pass);
				if(farm==null) 
					System.out.println("El usuario o la contrase�a son incorrectos");
				else {
					System.out.println("Usuario ingresado exitosamente");
					loop=false;
					mostrarMenuPrincipal(farm);
				}
				break;
			case 2:
				System.out.println("Escribe tu usuario:");
				user = sc.nextLine();
				
				System.out.println("Escribe tu password:");
				pass = sc.nextLine();
				boolean userExist = validateUser(user);
				if(userExist) 
					System.out.println("El usuario ya existe en la base de datos");
				else {
					
					System.out.println("Usuario registrado exitosamente");
					loop=false;
					Farm newFarm = new Farm(1000.0);
					insertNewUser(newFarm, user, pass);
					farm=readFarm(user, pass);
					mostrarMenuPrincipal(farm);
					
				}

				break;
			default:
				break;
			}

		} while (loop);

	}

	private void menuComprar(int resp) {
		System.out.println("Elija que producto desea comprar:");
		System.out.println("1) Pollos");
		System.out.println("2) Huevos");
		System.out.println("3) Cancelar");
		try {
			resp = Integer.valueOf(sc.nextLine());
			if (resp <= 0 || resp > 3) {
				System.out.println("La opcion ingresada no es correcta, se regresa al menu principal");
				return;
			}

		} catch (NumberFormatException e) {
			System.out.println("La opcion ingresada no es correcta, se regresa al men� principal");
			return;
		}
		switch (resp) {
		case 1:
			System.out.println("Elija la cantidad de pollos que desea comprar: ");
			try {
				resp = Integer.valueOf(sc.nextLine()); // Invocamos un m�todo sobre un objeto Scanner

			} catch (NumberFormatException e) {
				System.out.println("Debes ingresar un numero");
				return;
			}
			if (farm.buyChickens(resp) == 0) {
				System.out.println("La compra ha sido exitosa");
			} else {
				System.out.println("Ocurrio un error durante la compra");
			}

			break;
		case 2:
			System.out.println("Elija la cantidad de huevos que desea comprar: ");
			try {
				resp = Integer.valueOf(sc.nextLine()); // Invocamos un m�todo sobre un objeto Scanner

			} catch (NumberFormatException e) {
				System.out.println("Debes ingresar un numero");
				return;
			}
			if (farm.buyEggs(resp) == 0) {
				System.out.println("La compra ha sido exitosa");
			} else {
				System.out.println("Ocurrio un error durante la compra");
			}
			break;
		case 3:

			break;

		default:
			System.out.println("La opcion ingresada no es correcta, se regresa al men� principal");

			break;
		}

	}

	private void menuVender(int resp) {
		System.out.println("Elija que producto desea vender:");
		System.out.println("1) Pollos");
		System.out.println("2) Huevos");
		System.out.println("3) Cancelar");
		try {
			resp = Integer.valueOf(sc.nextLine());
			if (resp <= 0 || resp > 3) {
				System.out.println("La opcion ingresada no es correcta, se regresa al menu principal");
				return;
			}

		} catch (NumberFormatException e) {
			System.out.println("La opcion ingresada no es correcta, se regresa al men� principal");
		}
		switch (resp) {
		case 1:
			System.out.println("Elija la cantidad de pollos que desea vender: ");

			try {

				resp = Integer.valueOf(sc.nextLine()); // Invocamos un m�todo sobre un objeto Scanner

			} catch (NumberFormatException e) {

				System.out.println("Debes ingresar un numero");

			}

			if (farm.sellChickens(resp) == 0) {
				System.out.println("La venta ha sido exitosa");
			} else {
				System.out.println("Ocurrio un error durante la venta");
			}

			break;
		case 2:
			System.out.println("Elija la cantidad de huevos que desea vender: ");
			try {
				resp = Integer.valueOf(sc.nextLine()); // Invocamos un m�todo sobre un objeto Scanner

			} catch (NumberFormatException e) {
				System.out.println("Debes ingresar un numero");
			}

			if (farm.sellEggs(resp) == 0) {
				System.out.println("La venta ha sido exitosa");
			} else {
				System.out.println("Ocurrio un error durante la venta");
			}
			break;
		case 3:

			break;

		default:
			System.out.println("La opcion ingresada no es correcta, se regresa al men� principal");

			break;
		}

	}

}

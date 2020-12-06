package primaryPackage;

import java.util.Scanner;

public class Menu {

	private Farm farm;
	Scanner sc;

	public void mostrarMenuPrincipal(Farm f) {
		farm = f;
		int resp;
		System.out.println("Bienvenido a su granja");
		sc = new Scanner(System.in); // Creaci�n de un objeto Scanner
		do {
			System.out.println();
			System.out.println("**************************************************************");
			System.out.println("*                      DIA : " + String.format("%5d", farm.getDay())
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
				System.out.println("La opcion ingresada debe ser un numero");
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
		System.out.println("|  *  Cantidad de pollos -> " + farm.getChickens().size());
		System.out.println("|  *  Cantidad de huevos -> " + farm.getEggs().size());
		System.out.println("|  *  Precio de los pollos -> " + new Chicken().getPrice());
		System.out.println("|  *  Precio de los huevos -> " + new Egg().getPrice());
		System.out.println("|  *  Cantidad de dias de vida de un pollo -> " + new Chicken().getMaximunDaysOfLife());
		System.out.println("|  *  Cantidad de dias que tarda en eclosionar un huevo -> " + new Egg().getDaysToBorn());
		System.out.println("|_______________________________________________________________");

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
		}
		switch (resp) {
		case 1:
			System.out.println("Elija la cantidad de pollos que desea comprar: ");
			resp = Integer.valueOf(sc.nextLine()); // Invocamos un m�todo sobre un objeto Scanner
			if (farm.buyChickens(resp) == 0) {
				System.out.println("La compra ha sido exitosa");
			} else {
				System.out.println("Ocurrio un error durante la compra");
			}

			break;
		case 2:
			System.out.println("Elija la cantidad de huevos que desea comprar: ");
			resp = Integer.valueOf(sc.nextLine()); // Invocamos un m�todo sobre un objeto Scanner
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
			resp = Integer.valueOf(sc.nextLine()); // Invocamos un m�todo sobre un objeto Scanner
			if (farm.sellChickens(resp) == 0) {
				System.out.println("La venta ha sido exitosa");
			} else {
				System.out.println("Ocurrio un error durante la venta");
			}

			break;
		case 2:
			System.out.println("Elija la cantidad de huevos que desea vender: ");
			resp = Integer.valueOf(sc.nextLine()); // Invocamos un m�todo sobre un objeto Scanner
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

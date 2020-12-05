package primaryPackage;


import java.util.Scanner;

public class Menu {

	private Farm farm;
	
	public void mostrarMenuPrincipal(Farm f) {
		farm = f;
		int resp;
		int resp2;
		Scanner entradaEscaner;

		System.out.println("Bienvenido a su granja");
		do {
			System.out.println();
			System.out.println("**************************************************************");
			System.out.println("*                      DIA : " + String.format("%5d",farm.getDay()) + "                           *");
			System.out.println("**************************************************************");
			System.out.println("\nElija una opcion: ");
			System.out.println("1) Imprimir listado ");
			System.out.println("2) Vender pollos ");
			System.out.println("3) Vender huevos ");
			System.out.println("4) Comprar pollos ");
			System.out.println("5) Comprar huevos ");
			System.out.println("6) Avanzar dia ");
			System.out.println("7) Salir");

			resp=0;
			entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner
			try {

				resp = Integer.valueOf(entradaEscaner.nextLine()); // Invocamos un método sobre un objeto Scanner

			
			} catch (NumberFormatException ex) {
				System.out.println("La opcion ingresada debe ser un numero");
				resp = -1;
			}

			switch (resp) {
			case 1: {
				printReport();
			}
				break;

			case 2: {
				System.out.println("Elija la cantidad de pollos que desea vender: ");
				resp2 = Integer.valueOf(entradaEscaner.nextLine()); // Invocamos un método sobre un objeto Scanner
				if (farm.sellChickens(resp2) == 0) {
					System.out.println("La venta ha sido exitosa");
				} else {
					System.out.println("Ocurrio un error durante la venta");
				}
			}

				break;
			case 3: {
				System.out.println("Elija la cantidad de huevos que desea vender: ");
				resp2 = Integer.valueOf(entradaEscaner.nextLine()); // Invocamos un método sobre un objeto Scanner
				if (farm.sellEggs(resp2) == 0) {
					System.out.println("La venta ha sido exitosa");
				} else {
					System.out.println("Ocurrio un error durante la venta");
				}
			}

				break;
			case 4: {
				System.out.println("Elija la cantidad de pollos que desea comprar: ");
				resp2 = Integer.valueOf(entradaEscaner.nextLine()); // Invocamos un método sobre un objeto Scanner
				if (farm.buyChickens(resp2) == 0) {
					System.out.println("La compra ha sido exitosa");
				} else {
					System.out.println("Ocurrio un error durante la compra");
				}
			}

				break;
			case 5: {
				System.out.println("Elija la cantidad de huevos que desea comprar: ");
				resp2 = Integer.valueOf(entradaEscaner.nextLine()); // Invocamos un método sobre un objeto Scanner
				if (farm.buyEggs(resp2) == 0) {
					System.out.println("La compra ha sido exitosa");
				} else {
					System.out.println("Ocurrio un error durante la compra");
				}
			}

			case 6: {
				farm.goNextDay();
			}

				break;

			case 7:
				System.out.println("Hasta la proxima");
				break;

			default:
				System.out.println("La opcion no es correcta");
			}

		} while (resp != 7);
		entradaEscaner.close();

	}

	private void printReport() {
		System.out.println(" _______________________________________________________________");
		System.out.println("|");
	//	System.out.println("*  Dia numero -> " + farm.getDay());
		System.out.println("|  *  Dinero disponible -> " + farm.getMoney());
		System.out.println("|  *  Cantidad de pollos -> " + farm.getChickens().size());
		System.out.println("|  *  Cantidad de huevos -> " + farm.getEggs().size());
		System.out.println("|  *  Precio de los pollos -> " + new Chicken().getPrice());
		System.out.println("|  *  Precio de los huevos -> " + new Egg().getPrice());
		System.out.println("|  *  Cantidad de dias de vida de un pollo -> " + new Chicken().getMaximunDaysOfLife());
		System.out.println("|  *  Cantidad de dias que tarda en eclosionar un huevo -> " + new Egg().getDaysToBorn());
		System.out.println("|_______________________________________________________________");

	}

}

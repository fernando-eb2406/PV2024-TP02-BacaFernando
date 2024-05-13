package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.model.Categoria;
import ar.edu.unju.fi.ejercicio05.model.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Producto> productos = new ArrayList<>();
		
		Producto producto = new Producto();
		PagoTarjeta pagoTarjeta = new PagoTarjeta();
		PagoEfectivo pagoEfectivo = new PagoEfectivo();
		
		carga(productos);
		Integer opcion;
		
		do {
			menu();
			opcion = scanner.nextInt();
			switch(opcion) {
			case 1:
				mostrar(productos);
				break;
			case 2:
				int opcion2;
				
				LocalDate hoy = LocalDate.now();
				do {
					menu_2();
					opcion2 = scanner.nextInt();
					
					switch(opcion2){
					case 1:
						System.out.println("Ingrese su tarjeta de credito: ");
						String tarjeta = scanner.next();
						pagoTarjeta.setNroTarjeta(tarjeta);
						pagoTarjeta.setFechapago(hoy);
						String cod_bus;
						System.out.println("Ingrese producto (codigo) que va a desear comprar");
						cod_bus = scanner.next();
						
						boolean aux = false;
						for(Producto p: productos) {
							if (p.getCodigo().equals(cod_bus)){
								pagoTarjeta.setMontoPagado(p.getPrecioUnitario());
								aux = true;
								break;
							}
						}
						
						if(!aux) {
							System.out.println("Elemento no encontrado");
						}else {
							pagoTarjeta.realizarPago(pagoTarjeta.getMontoPagado());
							pagoTarjeta.imprimirRecibo();
							
							productos.removeIf(prod -> prod.getCodigo().equals(cod_bus));
						}
						
						break;
					case 2:
						System.out.println("Ingrese producto (codigo) que va a desear comprar");
						cod_bus = scanner.next();
						pagoEfectivo.setFechaPago(hoy);
						boolean band = false;
						for(Producto p: productos) {
							if(p.getCodigo().equals(cod_bus)) {
								pagoEfectivo.setMontoPagado(p.getPrecioUnitario());
								band = true;
								break;
							}
						}
						
						if(!band) {
							System.out.println("Elemento no encontrado");
						}else {
							pagoEfectivo.realizarPago(pagoEfectivo.getMontoPagado());
							pagoEfectivo.imprimirRecibo();							
							productos.removeIf(prod -> prod.getCodigo().equals(cod_bus));
						}						
						break;
					case 3:
						System.out.println("Fin del menu");
						break;
					default:
						System.out.println("Opcion incorrecta");
					}
				}while(opcion2 != 3);
				break;
			case 3:
				System.out.println("Fin del programa");
				break;
			default:
				System.out.println("Opcion incorrecta");
			}
		}while(opcion != 3);

	}
	
	public static void carga(ArrayList<Producto> productos) {
		Producto prod1 = new Producto("A1A1", "AAA", 1000., OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR,true);
		Producto prod2 = new Producto("B2B2", "BBB", 1020., OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS,true);
		Producto prod3 = new Producto("C3C3", "CCC", 1040., OrigenFabricacion.CHINA, Categoria.INFORMATICA,false);
		Producto prod4 = new Producto("D4D4", "DDD", 1060., OrigenFabricacion.URUGUAY, Categoria.TELEFONIA,false);
		Producto prod5 = new Producto("E6E6", "EEE", 1080., OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR,true);
		Producto prod6 = new Producto("F7F7", "FFF", 1100., OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS,true);
		Producto prod7 = new Producto("G8G8", "GGG", 1120., OrigenFabricacion.CHINA, Categoria.INFORMATICA,false);
		Producto prod8 = new Producto("H9H9", "HHH", 1140., OrigenFabricacion.URUGUAY, Categoria.TELEFONIA,false);
		Producto prod9 = new Producto("J10J10", "JJJ", 1160., OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR,true);
		Producto prod10 = new Producto("K11K11", "KKK", 1180., OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS,true);
		Producto prod11 = new Producto("L12L12", "LLL", 1200., OrigenFabricacion.CHINA, Categoria.INFORMATICA,false);
		Producto prod12 = new Producto("M13M13", "MMM", 1220., OrigenFabricacion.CHINA, Categoria.TELEFONIA,false);
		Producto prod13 = new Producto("N14N14", "NNN", 1240., OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR,true);
		Producto prod14 = new Producto("O15O15", "OOO", 1260., OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS,true);
		Producto prod15 = new Producto("P16P16", "PPP", 1280., OrigenFabricacion.BRASIL, Categoria.INFORMATICA,false);
		
		productos.add(prod1);
		productos.add(prod2);
		productos.add(prod3);
		productos.add(prod4);
		productos.add(prod5);
		productos.add(prod6);
		productos.add(prod7);
		productos.add(prod8);
		productos.add(prod9);
		productos.add(prod10);
		productos.add(prod11);
		productos.add(prod12);
		productos.add(prod13);
		productos.add(prod14);
		productos.add(prod15);
		
	}
	
	public static void menu() {
		System.out.println("1) Mostrar productos");
		System.out.println("2) Realizar compra");
		System.out.println("3) Salir");
		System.out.print("Seleccione opcion: ");
	}
	
	public static void menu_2() {
		System.out.println("1) Pago con tarejeta");
		System.out.println("2) Pago con efectivo	");
		System.out.println("3) Salir del menu");
		System.out.print("Ingrese opcion: ");
		
	}
	
	public static void mostrar(ArrayList<Producto> productos) {
		for(Producto p: productos) {
				System.out.println(p);
		}
	}

}

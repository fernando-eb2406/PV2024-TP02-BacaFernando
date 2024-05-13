package ar.edu.unju.fi.ejercicio07.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio05.model.Categoria;
import ar.edu.unju.fi.ejercicio05.model.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio05.model.Producto;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Producto> productos = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		
		carga(productos);

		int op=0;
		do {
			menu();
			System.out.println("Ingrese opcion");
			op = scanner.nextInt();
			Consumer<Producto> printprod = prod -> System.out.println(prod);
			
			switch(op) {
			case 1:
				Consumer<Producto> printConsumer = producto -> {
				        if (producto.isEstado()) {
				            System.out.println(producto);
				        }
				    };
				    productos.forEach(printConsumer);
				break;
			case 2:
				Predicate<Producto> filtrarausencia = producto -> producto.isEstado() == false;
				
				List<Producto> nroStock = new ArrayList<>();
				
				nroStock = productos.stream().filter(filtrarausencia).collect(Collectors.toList());
				
				nroStock.forEach(printprod);
				
				break;
			case 3:
				
				
				List<Producto> productosIncrementeado = new ArrayList<>();
				
				Function<Producto, Producto> funcionAument = (producto) -> {
					double nuevoPrecio = producto.getPrecioUnitario() * 1.20;
					producto.setPrecioUnitario(nuevoPrecio);
					return producto;
				};
				
				productosIncrementeado = productos.stream().map(funcionAument).collect(Collectors.toList());
				productosIncrementeado.forEach(printprod);
				
				break;
			case 4:
				Predicate<Producto> filtrarElectroDisponible = producto -> {
					return producto.getCategoria().equals(Categoria.ELECTROHOGAR) && producto.isEstado() == true;
				};
				
				List<Producto> prodDisp = new ArrayList();
				
				prodDisp = productos.stream().filter(filtrarElectroDisponible).collect(Collectors.toList());
				
				prodDisp.forEach(printprod);
				
				break;
			case 5:
				
				productos.sort(Comparator.comparing(Producto::getPrecioUnitario	).reversed());
				
				productos.forEach(prod -> System.out.println(prod));
				
				break;
			case 6:
				List<Producto> cadsMay = new ArrayList<>();
				
				Function<Producto,Producto> funcionMayus = (cad) -> {
					String cadena =  cad.getDescripcion().toUpperCase();
					cad.setDescripcion(cadena);
					return cad;
				};
				
				
				cadsMay = productos.stream().map(funcionMayus).collect(Collectors.toList());
				
				cadsMay.forEach(printprod);
				
				break;
			case 7:
				System.out.println("Fin del programa");
				break;
			default:
				System.out.println("Opcion incorrecta");
			}
		}while(op != 7);
	}
	
	public static void menu() {
		System.out.println("1- Mostrar productos");
		System.out.println("2- Mostrar productos faltantes");
		System.out.println("3- Incrementar el precio de los productos en un 20% ");
		System.out.println("4- Mostrar productos de electrohogar disponibles");
		System.out.println("5- Ordenar productos de forma descendente");
		System.out.println("6- Mostrar productos con descripcion en mayusculas");
		System.out.println("7- Salir ");
	}
	
	
	public static void carga(ArrayList<Producto> productos) {
		Producto prod1 = new Producto("A1A1", "aaa", 1000., OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR,true);
		Producto prod2 = new Producto("B2B2", "bbb", 1020., OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS,true);
		Producto prod3 = new Producto("C3C3", "ccc", 1040., OrigenFabricacion.CHINA, Categoria.INFORMATICA,false);
		Producto prod4 = new Producto("D4D4", "ddd", 1060., OrigenFabricacion.URUGUAY, Categoria.TELEFONIA,false);
		Producto prod5 = new Producto("E6E6", "eee", 1080., OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR,true);
		Producto prod6 = new Producto("F7F7", "fff", 1100., OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS,true);
		Producto prod7 = new Producto("G8G8", "ggg", 1120., OrigenFabricacion.CHINA, Categoria.INFORMATICA,false);
		Producto prod8 = new Producto("H9H9", "hhh", 1140., OrigenFabricacion.URUGUAY, Categoria.TELEFONIA,false);
		Producto prod9 = new Producto("J10J10", "jjj", 1160., OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR,true);
		Producto prod10 = new Producto("K11K11", "kkk", 1180., OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS,true);
		Producto prod11 = new Producto("L12L12", "lll", 1200., OrigenFabricacion.CHINA, Categoria.INFORMATICA,false);
		Producto prod12 = new Producto("M13M13", "mmm", 1220., OrigenFabricacion.CHINA, Categoria.TELEFONIA,false);
		Producto prod13 = new Producto("N14N14", "nnn", 1240., OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR,true);
		Producto prod14 = new Producto("O15O15", "ooo", 1260., OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS,true);
		Producto prod15 = new Producto("P16P16", "ppp", 1280., OrigenFabricacion.BRASIL, Categoria.INFORMATICA,false);
		
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

}

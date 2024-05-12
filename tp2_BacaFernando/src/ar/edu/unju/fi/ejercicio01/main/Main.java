package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.origenFabricacion;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Producto> productos = new ArrayList<>();
		
		Integer opcion;
		
		do {
            mostrarMenu();
            opcion = leerOpcion(scanner);
            switch (opcion) {
                case 1:
                	Producto producto = crearModificarProducto(scanner, opcion, productos);
                	productos.add(producto);
                	break;
                case 2:
                	mostrarProductos(productos);
                    break;
                case 3:
                    crearModificarProducto(scanner, opcion, productos);
                    break;
                case 4:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);
	    
		scanner.close();
		
	}
	
    public static void mostrarMenu() {
        System.out.println("----- Menú-----");
        System.out.println("1 - Crear Producto");
        System.out.println("2 - Mostrar Productos");
        System.out.println("3 - Modificar Producto");
        System.out.println("4 - Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    public static int leerOpcion(Scanner scanner) {
        int num = 0;
        boolean opcionValida = false;
        do {
            try {
                num = scanner.nextInt();
                opcionValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción válida.\n");
                scanner.next();
            }
        } while (!opcionValida);
        return num;
    }
    
    public static Producto crearModificarProducto(Scanner scanner, Integer opcion, ArrayList<Producto> productos) {
    	Producto producto = new Producto();
    	if (opcion == 1) {
    		System.out.print("Ingrese el codigo de producto: ");
        	String codigo = scanner.next();
        	producto.setCodigo(codigo);
        	otrosDatos(scanner, producto, codigo);
		} else {
			System.out.print("Ingrese el codigo del producto a modificar: ");
			String buscarCodigo = scanner.next();
			for (Producto productoBuscado : productos) {
				if (productoBuscado.getCodigo().equals(buscarCodigo)) {
					otrosDatos(scanner, productoBuscado, buscarCodigo);
				} else {
					System.out.println("El codigo ingresado no es correcto.");
				}
			}	
		}
    	System.err.println("-------------------------");
    	return producto;
    }
    
    public static Producto otrosDatos(Scanner scanner, Producto producto, String codigo) {
    	int submenu;
    	System.out.print("Ingrese la descripcion del producto: ");
    	String descripcion = scanner.next();
    	producto.setDescripcion(descripcion);
    	System.out.print("Ingrese el precio del producto: ");
    	Double precioUnitario = scanner.nextDouble();
    	producto.setPrecioUnitario(precioUnitario);
    	System.out.println("Ingrese el origen del producto: ");
    	submenu= 1;
    	Integer opcionOrigen = mostrarSubmenu(scanner, submenu);
    	switch (opcionOrigen) {
		case 1:
			producto.setOrigenFabricacion(origenFabricacion.ARGENTINA);
			break;
		case 2:
			producto.setOrigenFabricacion(origenFabricacion.BRASIL);
			break;
		case 3:
			producto.setOrigenFabricacion(origenFabricacion.CHINA);
			break;
		case 4:
			producto.setOrigenFabricacion(origenFabricacion.URUAGUAY);
			break;
		default:
			break;
		}
    	submenu=2;
    	System.out.println("Ingrese la categoria del producto");
    	Integer opcionCategoria = mostrarSubmenu(scanner, submenu);
    	switch (opcionCategoria) {
		case 1:
			producto.setCategoria(categoria.ELECTROHOGAR);
			break;
		case 2:
			producto.setCategoria(categoria.HERRAMIENTAS);
			break;
		case 3:
			producto.setCategoria(categoria.INMFORMATICA);
			break;
		case 4:
			producto.setCategoria(categoria.TELEFONIA);
			break;
		default:
			break;
		}
    	return producto;
    }
    
    public static Integer mostrarSubmenu(Scanner scanner, Integer submenu) {
    	if (submenu == 1) {
    		System.out.println("	----- Origen de Fabricación -----");
	        System.out.println("	1 - Argentina");
	        System.out.println("	2 - China");
	        System.out.println("	3 - Brasil");
	        System.out.println("	4 - Uruaguay");
		} else {
			System.out.println("	----- Categoria -----");
	        System.out.println("	1 - ElectroHogar");
	        System.out.println("	2 - Herramientas");
	        System.out.println("	3 - Informatica");
	        System.out.println("	4 - Telefonia");
		}    
    	System.out.print("	Elija una opción: ");
        int opcion = scanner.nextInt();
        return opcion;
    }
    
    public static void mostrarProductos(ArrayList<Producto> productos) {
    	if (productos.isEmpty()) {
			System.out.println("No hay productos para mostrar");
		} else {
			for (Producto producto : productos) {
				System.out.println(producto);
			}
		}
    }
        
}

package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Jugador> jugadores = new ArrayList<>();
		
		Integer opcion;
		do {
			menu();
			opcion = scanner.nextInt();
			switch(opcion) {
			case 1:
				Jugador jugador = new Jugador();
				
				System.out.print("Ingrese nombre: ");
				String nombre = scanner.next();
				jugador.setNombre(nombre);
				
				System.out.print("Ingrese apellido: ");
				String apellido = scanner.next();
				jugador.setApellido(apellido);
				
				System.out.println("Ingrese fecha de nacimiento (dd/mm/yy): ");
				String fechaNacString = scanner.next();
				LocalDate fechaNac = null;
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
					fechaNac = LocalDate.parse(fechaNacString,formatter);
				}catch(Exception e) {
					System.err.println("Cadena de fecha inválida");
					System.err.println("Volviendo al menu principal");
				}
				jugador.setFechaNacimiento(fechaNac);
				
				System.out.print("Ingrese estatura: ");
				double estatura = scanner.nextDouble();
				jugador.setEstatura(estatura);
				
				System.out.print("Ingrese peso: ");
				double peso = scanner.nextDouble();
				jugador.setPeso(peso);
				
								
				Integer opcionPosicion;
				do {
					System.out.println("Ingrese posicion: ");
					menu_pos();
					opcionPosicion = scanner.nextInt();
					switch(opcionPosicion) {
					case 1:
						jugador.setPosicion(Posicion.DELANTERO);
						break;
					case 2:
						jugador.setPosicion(Posicion.MEDIO);
						break;
					case 3:
						jugador.setPosicion(Posicion.DEFENSA);
						break;
					case 4:
						jugador.setPosicion(Posicion.ARQUERO);
						break;
					default:
						System.out.println("Opcion incorrecta");
					}
				}while(opcionPosicion < 1 || opcionPosicion > 4);
				jugadores.add(jugador);
				break;
			case 2:
				for(Jugador j:jugadores) {
					System.out.println(j);
				}
				break;
			case 3:
				boolean encontrado = true;
				
				System.out.print("Ingrese nombre del jugador que quiere modificar la posicion: ");
				String nom_mod = scanner.next();
				
				System.out.print("Ingrese apellido del jugador que quiere modificar la posicion: ");
				String apel_mod = scanner.next();
				
				for(Jugador j:jugadores) {
					if( !(j.getNombre().equalsIgnoreCase(nom_mod) ) && !( j.getApellido().equalsIgnoreCase(apel_mod)) ) {
						System.out.println("Jugador no encontrado");
					}else {
							if( j.getNombre().equalsIgnoreCase(nom_mod)  &&  j.getApellido().equalsIgnoreCase(apel_mod))  {
								int pos_mod;
								do {
									System.out.println("Ingrese posicion: ");
									menu_pos();
									pos_mod = scanner.nextInt();
									switch(pos_mod) {
									case 1:
										j.setPosicion(Posicion.DELANTERO);
										break;
									case 2:
										j.setPosicion(Posicion.MEDIO);
										break;
									case 3:
										j.setPosicion(Posicion.DEFENSA);
										break;
									case 4:
										j.setPosicion(Posicion.ARQUERO);
										break;
										
									default:
										System.out.println("Opcion incorrecta");
									}
								}while(pos_mod < 1 || pos_mod > 4 );
							}
					}
				}
				
				
				break;
			case 4:
				boolean enc= true;
				
				System.out.print("Ingrese nombre del jugador que quiere modificar la posicion: ");
				String nom_mod_2 = scanner.next();
				
				System.out.print("Ingrese apellido del jugador que quiere modificar la posicion: ");
				String apel_mod_2 = scanner.next();
				
				for(Jugador j:jugadores) {
					if( !(j.getNombre().equalsIgnoreCase(nom_mod_2) ) && !( j.getApellido().equalsIgnoreCase(apel_mod_2)) ) {
						encontrado = false;
					}
				}
				
				if(enc == false) {
					System.out.println("Jugador no encontrado");
				}else {
					Iterator iterator = jugadores.iterator();
					while(iterator.hasNext()) {
						Jugador j = (Jugador)iterator.next();
						if(j.getNombre().equalsIgnoreCase(nom_mod_2)  &&  j.getApellido().equalsIgnoreCase(apel_mod_2)) {
							iterator.remove();
							
						}
					}
				}
				break;
			case 5:
				System.out.println("Fin del programa");
				break;
			default:
				System.out.println("Opcion incorrecta");
			}
		}while(opcion != 5);

	}
	
	public static void menu() {
		System.out.println("1- Alta de jugador");
		System.out.println("2- Mostrar todos los jugadores");
		System.out.println("3- Modificar la posicion de un jugador");
		System.out.println("4- Eliminar un jugador");
		System.out.println("5- Salir");
		System.out.println("Elija una opcion");
	}
	
	public static void menu_pos() {
		System.out.println("1- Delantero");
		System.out.println("2- Medio");
		System.out.println("3- Defensor");
		System.out.println("4- Arquero");
	}

}

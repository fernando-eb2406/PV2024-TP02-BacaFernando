package ar.edu.unju.fi.ejercicio02.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Efemeride> efemerides = new ArrayList<>();
		
		Integer opcion;
		
		do {
			menu();
			opcion = scanner.nextInt();
			switch(opcion) {
			case 1:
				Efemeride efemeride = new Efemeride();
				System.out.print("Ingrese el codigo de la efemeride: ");
				String codigo = scanner.next();
				efemeride.setCodigo(codigo);
				Integer dia;
				Integer elec_mes;
				do {
					System.out.println("Ingrese el mes");
					elec_mes();
					elec_mes = scanner.nextInt();
					
					switch(elec_mes) {
					case 1:
						efemeride.setMes(Mes.ENERO);
						System.out.println("Ingrese el dia cuando se va a realizar: ");
						do {
							dia = scanner.nextInt();
						}while(dia < 1 || dia > 31);
						efemeride.setDia(dia);
						break;
					case 2:
						efemeride.setMes(Mes.FEBRERO);
						System.out.println("Ingrese el dia cuando se va a realizar: ");
						do {
							dia = scanner.nextInt();
						}while(dia < 1 || dia > 28);
						efemeride.setDia(dia);
						break;
					case 3:
						efemeride.setMes(Mes.MARZO);
						System.out.println("Ingrese el dia cuando se va a realizar: ");
						do {
							dia = scanner.nextInt();
						}while(dia < 1 || dia > 31);
						efemeride.setDia(dia);
						break;
					case 4:
						efemeride.setMes(Mes.ABRIL);
						System.out.println("Ingrese el dia cuando se va a realizar: ");
						do {
							dia = scanner.nextInt();
						}while(dia < 1 || dia > 30);
						efemeride.setDia(dia);
						break;
					case 5:
						efemeride.setMes(Mes.MAYO);
						System.out.println("Ingrese el dia cuando se va a realizar: ");
						do {
							dia = scanner.nextInt();
						}while(dia < 1 || dia > 31);
						efemeride.setDia(dia);
						break;
					case 6:
						efemeride.setMes(Mes.JUNIO);
						System.out.println("Ingrese el dia cuando se va a realizar: ");
						do {
							dia = scanner.nextInt();
						}while(dia < 1 || dia > 30);
						efemeride.setDia(dia);
						break;
					case 7:
						efemeride.setMes(Mes.JULIO);
						System.out.println("Ingrese el dia cuando se va a realizar: ");
						do {
							dia = scanner.nextInt();
						}while(dia < 1 || dia > 31);
						efemeride.setDia(dia);
						break;
					case 8:
						efemeride.setMes(Mes.AGOSTO);
						System.out.println("Ingrese el dia cuando se va a realizar: ");
						do {
							dia = scanner.nextInt();
						}while(dia < 1 || dia > 31);
						efemeride.setDia(dia);
						break;
					case 9:
						efemeride.setMes(Mes.SEPTIEMBRE);
						System.out.println("Ingrese el dia cuando se va a realizar: ");
						do {
							dia = scanner.nextInt();
						}while(dia < 1 || dia > 30);
						efemeride.setDia(dia);
						break;
					case 10:
						efemeride.setMes(Mes.OCTUBRE);
						System.out.println("Ingrese el dia cuando se va a realizar: ");
						do {
							dia = scanner.nextInt();
						}while(dia < 1 || dia > 31);
						efemeride.setDia(dia);
						break;
					case 11:
						efemeride.setMes(Mes.NOVIEMBRE);
						System.out.println("Ingrese el dia cuando se va a realizar: ");
						do {
							dia = scanner.nextInt();
						}while(dia < 1 || dia > 30);
						efemeride.setDia(dia);
						break;
					case 12:
						efemeride.setMes(Mes.DICIEMBRE);
						System.out.println("Ingrese el dia cuando se va a realizar: ");
						do {
							dia = scanner.nextInt();
						}while(dia < 1 || dia > 31);
						efemeride.setDia(dia);
						break;
					default:
						System.out.println("Opcion incorrecta");
					}
				}while(elec_mes < 1 || elec_mes > 12);
				
				System.out.println("Ingrese detalle sobre la efemeride");
				String detalle = scanner.next();
				efemeride.setDetalle(detalle);
				
				efemerides.add(efemeride);
				break;
			case 2:
				for(Efemeride e: efemerides) {
					System.out.println(e);
				}
				
				break;
			case 3:
				System.out.println("Ingrese el codigo de la efemeride que quiere eliminar: ");
				String cod_eli = scanner.next();
				
				Iterator iterator = efemerides.iterator();
				while(iterator.hasNext()) {
					Efemeride e = (Efemeride)iterator.next();
					if(e.getCodigo().equals(cod_eli)) {
						iterator.remove();
					}else {
						System.out.println("Efemeride no encontrada");
					}
				}
				break;
			case 4:
				System.out.println("Ingrese le codigo de la efemeride que quiere modificar");
				String cod_mod = scanner.next();
				for(Efemeride e: efemerides) {
					if(!(e.getCodigo().equals(e))) {
						System.out.println("Efemeride no encontrada");
					}
				}
				
				System.out.println("Ingrese el atributo que quiere modificar");
				menu_mod();
				int op_mod = scanner.nextInt();
				switch(op_mod) {
				case 1:
					System.out.print("Ingrese nuevo detalle: ");
					String det_mod = scanner.next();
					
					for(Efemeride e: efemerides) {
						if(e.getCodigo().equals(cod_mod)) {
							e.setDetalle(det_mod);
						}
					}
					break;
				case 2:
					System.out.println("Ingrese el mes");
					for(Efemeride e: efemerides) {
						if(e.getCodigo().equals(cod_mod)) {
							if((e.getMes()==Mes.ENERO) || (e.getMes()==Mes.MAYO) || (e.getMes()==Mes.JULIO) || (e.getMes()==Mes.AGOSTO) || (e.getMes()==Mes.OCTUBRE) || (e.getMes()==Mes.DICIEMBRE)) {
								mod_mes_31();
								int mes_mod = scanner.nextInt();
								do {
									switch(mes_mod) {
									case 1:
										e.setMes(Mes.ENERO);
										break;
									case 2:
										e.setMes(Mes.MARZO);
										break;
									case 3:
										e.setMes(Mes.MAYO);
										break;
									case 4:
										e.setMes(Mes.JULIO);
										break;
									case 5:
										e.setMes(Mes.AGOSTO);
										break;
									case 6:
										e.setMes(Mes.OCTUBRE);
										break;
									case 7:
										e.setMes(Mes.DICIEMBRE);
										break;
									default:
										System.out.println("Opcion incorrecta");
									}
								}while(mes_mod < 1 || mes_mod > 7);
							}else {
								elec_mes();
								int mes_mod = scanner.nextInt();
								do {
									switch(mes_mod) {
									case 1:
										e.setMes(Mes.ENERO);
										break;
									case 2:
										e.setMes(Mes.FEBRERO);
										break;
									case 3:
										e.setMes(Mes.MARZO);
										break;
									case 4:
										e.setMes(Mes.ABRIL);
										break;
									case 5:
										e.setMes(Mes.MAYO);
										break;
									case 6:
										e.setMes(Mes.JUNIO);
										break;
									case 7:
										e.setMes(Mes.JULIO);
										break;
									case 8:
										e.setMes(Mes.AGOSTO);
										break;
									case 9:
										e.setMes(Mes.SEPTIEMBRE);
										break;
									case 10:
										e.setMes(Mes.OCTUBRE);
										break;
									case 11:
										e.setMes(Mes.NOVIEMBRE);
										break;
									case 12:
										e.setMes(Mes.DICIEMBRE);
										break;
									default:
										System.out.println("Opcion incorrecta");
									}
								}while(mes_mod < 1 || mes_mod > 12);
							}
						}
					}
					break;
				case 3:
					for(Efemeride e:efemerides) {
						if(e.getCodigo().equals(cod_mod)) {
							if((e.getMes()==Mes.ENERO) || (e.getMes()==Mes.MAYO) || (e.getMes()==Mes.JULIO) || (e.getMes()==Mes.AGOSTO) || (e.getMes()==Mes.OCTUBRE) || (e.getMes()==Mes.DICIEMBRE)) {
								int dia_mod;
								do {
								System.out.print("Ingrese el dia que se va a hacer el efemeride: ");
								dia_mod = scanner.nextInt();
								}while(dia_mod < 1 || dia_mod > 31);
							}
							else {
								int dia_mod;
								do {
								System.out.print("Ingrese el dia que se va a hacer el efemeride: ");
								dia_mod = scanner.nextInt();
								}while(dia_mod < 1 || dia_mod > 30);								
							}
						}
					}
					break;
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
		System.out.println("1- Crear efemeride");
		System.out.println("2- Mostrar efemerides");
		System.out.println("3- Eliminar efemeride");
		System.out.println("4- Modificar efemeride");
		System.out.println("5- Salir");
	}
	
	public static void elec_mes() {
		System.out.println("1- Enero");
		System.out.println("2- Febrero");
		System.out.println("3- Marzo");
		System.out.println("4- Abril");
		System.out.println("5- Mayo");
		System.out.println("6- Junio");
		System.out.println("7- Julio");
		System.out.println("8- Agosto");
		System.out.println("9- Septiembre");
		System.out.println("10- Octubre");
		System.out.println("11- Noviembre");
		System.out.println("12- Diciembre");
	}
	
	public static void menu_mod() {
		System.out.println("1- Detalle");
		System.out.println("2- Mes");
		System.out.println("3- Dia");
	}
	
	public static void mod_mes_31() {
		System.out.println("1- Enero");
		System.out.println("2- Marzo");
		System.out.println("3- Mayo");
		System.out.println("4- Julio");
		System.out.println("5- Agosto");
		System.out.println("6- Octubre");
		System.out.println("7- Diciembre");
	}

}

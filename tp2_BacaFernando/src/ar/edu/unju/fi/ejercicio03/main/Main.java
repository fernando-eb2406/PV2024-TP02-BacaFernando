package ar.edu.unju.fi.ejercicio03.main;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		
		Provincia[] provincias = Provincia.values();
		
		for(Provincia provincia: provincias) {
			System.out.println(provincia);
			System.out.println("Cantidad de gente: " + provincia.getPoblacion());
			System.out.println("Total de la superfice: " + provincia.getSuperficie());
			System.out.println("Densidad Poblacional: " + provincia.calcularDensidadPoblacional());
			System.out.println("-----------------------------------");
		}
	}

}

package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {
	
	FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45 , 12f);
	
	Converter<FelinoDomestico, FelinoSalvaje> converter = g1 -> new FelinoSalvaje(g1.getNombre(), g1.getEdad(),g1.getPeso());
	
	FelinoSalvaje felino1 = converter.convert(gato);
	
	converter.mostrarObjeto(felino1);
	
	FelinoSalvaje tigre = new FelinoSalvaje("Tanner", (byte)20, 180f);
	
	boolean noNulo;
	
	noNulo = Converter.isNotNull(tigre);

	if(!noNulo) {
		System.out.println("Objeto nulo");
	} else {
		Converter<FelinoSalvaje, FelinoDomestico> converter2 = g2 -> new FelinoDomestico(g2.getNombre(),g2.getEdad(),g2.getPeso() );
		FelinoDomestico felino2 = converter2.convert(tigre);
		converter2.mostrarObjeto(felino2);
	}

}

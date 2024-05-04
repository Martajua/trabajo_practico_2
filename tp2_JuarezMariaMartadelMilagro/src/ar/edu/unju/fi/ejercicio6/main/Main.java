package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {

		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte) 45, 12f);
		// definición de expresión lambda que define el convertidor de FelinoDomestico a
		// FelinoSalvaje.
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(),
				x.getPeso());
		// se realiza la conversión
		FelinoSalvaje felino1 = converter.convert(gato);
		// mostramos los datos del objeto felino salvaje felino1
		converter.mostrarObjeto(felino1);

		// Realice la conversión de un objeto felino salvaje a felino doméstico.
		FelinoSalvaje felino = new FelinoSalvaje("Tanner", (byte) 20, 186f);

		boolean noNulo = Converter.isNotNull(felino);
		if (noNulo == true) {
			Converter<FelinoSalvaje, FelinoDomestico> converter1 = j -> new FelinoDomestico(j.getNombre(), j.getEdad(),
					j.getEdad());
			FelinoDomestico gato1 = converter1.convert(felino);
			converter1.mostrarObjeto(gato1);
		}else {
			System.out.println("El objeto es nulo");
		}
	}
}

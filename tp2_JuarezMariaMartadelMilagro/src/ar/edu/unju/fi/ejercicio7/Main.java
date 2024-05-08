package ar.edu.unju.fi.ejercicio7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		byte opcion;

		Scanner leer = new Scanner(System.in);

		List<Producto> listaProductos = new ArrayList<>();

		// precarga de productos
		listaProductos.add(
				new Producto("ABC123", "Heladera", 2300.4, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, false));
		listaProductos
				.add(new Producto("ABC124", "Netbook", 30.5, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		listaProductos.add(
				new Producto("ABC125", "Celular Samsung", 100.5, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true));
		listaProductos.add(
				new Producto("ABC126", "Microondas", 300.3, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false));
		listaProductos.add(
				new Producto("ABC127", "Ventilador", 900.0, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		listaProductos.add(new Producto("DEF456", "Desmalezadora", 1200.3, OrigenFabricacion.ARGENTINA,
				Categoria.HERRAMIENTAS, true));
		listaProductos.add(
				new Producto("DEF457", "Linterna", 899.7, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, true));
		listaProductos.add(
				new Producto("DEF458", "CELULAR TCL", 1500.9, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, true));
		listaProductos.add(
				new Producto("DEF459", "Celular Moto", 400.0, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, false));
		listaProductos.add(
				new Producto("DEF460", "MONITOR", 275.2, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		listaProductos.add(
				new Producto("GHI789", "Placa de video", 950.5, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("GHI790", "Sierra Electrica", 645.7, OrigenFabricacion.CHINA,
				Categoria.HERRAMIENTAS, true));
		listaProductos
				.add(new Producto("GHI791", "Taladro", 308.6, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
		listaProductos.add(
				new Producto("GHI792", "MEMORIA RAM", 349.7, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, false));
		listaProductos.add(new Producto("GHI793", "Aire Acondicionado", 241.3, OrigenFabricacion.URUGUAY,
				Categoria.ELECTROHOGAR, false));

		do {
			System.out.println("");
			System.out.println("***MENÚ***");
			System.out.println("1-Mostrar productos");
			System.out.println("2-Mostrar productos faltantes");
			System.out.println("3-Incrementar los precios de los productos en un 20%");
			System.out.println("4-Mostrar productos de la categoria ElectroHogar que esten disponibles");
			System.out.println("5-Ordenar los productos por precio (descendente)");
			System.out.println("6-Mostrar productos con nombres en MAYÚSCULAS");
			System.out.println("7-Salir");
			try {// control del menu principal
				System.out.print("Ingrese opcion: ");
				opcion = leer.nextByte();
				if (opcion < 1 || opcion > 7) {
					opcion = 0;
					throw new IllegalArgumentException("Opcion invalida, debe elegir una opcion del 1 al 3");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				leer.nextLine();
				opcion = 0;
			}
			switch (opcion) {
			case 1:// Mostrar productos en estado true
					// leer.nextLine();
				Consumer<Producto> printConsumer = p -> {
					if (p.isEstado()) {
						System.out.println(p);
					}
				};
				listaProductos.forEach(printConsumer);
				break;
			case 2:// Mostrar productos en estado false
				Predicate<Producto> filterEstadoFalse = p -> !p.isEstado();
				listaProductos.stream().filter(filterEstadoFalse).forEach(System.out::println);
				break;
			case 3:// Incrementar los precios de los productos en un 20%
				Function<Producto, Producto> funcionIncrementar = (p) -> {
					double resultado = p.getPrecioUnitario() + (p.getPrecioUnitario() * 0.2);
					p.setPrecioUnitario(resultado);
					return p;
				};
				List<Producto> productosIncrementados = new ArrayList<>();
				productosIncrementados = listaProductos.stream().map(funcionIncrementar).collect(Collectors.toList());
				productosIncrementados.forEach(System.out::println);
				break;
			case 4:// Mostrar los productos que corresponden a la categoría Electrohogar y estén
					// disponibles para la venta
				Predicate<Producto> filterCategoriaDisponible = p -> p.getCategoria()
						.equals(Producto.Categoria.ELECTROHOGAR) && p.isEstado();
				listaProductos.stream().filter(filterCategoriaDisponible).forEach(System.out::println);
				break;
			case 5:// Ordenar los productos por precio de forma descendente
				listaProductos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
				listaProductos.forEach(System.out::println);
				break;
			case 6:// Mostrar los productos con los nombres en mayúsculas.
				Function<Producto, Producto> funcionMayuscula = (p) -> {
					if (p.getDescripcion().equals(p.getDescripcion().toUpperCase())) {
						return p;
					}
					return null;
				};
				List<Producto> productosNombreMayuscula = new ArrayList<>();
				productosNombreMayuscula = listaProductos.stream().map(funcionMayuscula).filter(p -> p != null)
						.collect(Collectors.toList());
				productosNombreMayuscula.forEach(System.out::println);
				break;
			case 7:// salir
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción Invalida");
				break;
			}
		} while (opcion != 7);
		leer.close();
	}
}

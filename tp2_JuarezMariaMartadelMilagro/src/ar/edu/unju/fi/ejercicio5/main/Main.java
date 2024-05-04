package ar.edu.unju.fi.ejercicio5.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;

public class Main {

	public static void main(String[] args) {
		byte opcion;
		String codigoProducto;
		String respuesta;
		boolean carga = false;
		double montoTotal = 0;
		Scanner leer = new Scanner(System.in);

		List<Producto> listaProductos = new ArrayList<>();
		List<Producto> listaCompra = new ArrayList<>();

		Producto producto = new Producto();

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
				new Producto("DEF458", "Celular TCL", 1500.9, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, true));
		listaProductos.add(
				new Producto("DEF459", "Celular Moto", 400.0, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, false));
		listaProductos.add(
				new Producto("DEF460", "Monitor", 275.2, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		listaProductos.add(
				new Producto("GHI789", "Placa de video", 950.5, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("GHI790", "Sierra Electrica", 645.7, OrigenFabricacion.CHINA,
				Categoria.HERRAMIENTAS, true));
		listaProductos
				.add(new Producto("GHI791", "Taladro", 308.6, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
		listaProductos.add(
				new Producto("GHI792", "Memoria RAM", 349.7, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, false));
		listaProductos.add(new Producto("GHI793", "Aire Acondicionado", 241.3, OrigenFabricacion.URUGUAY,
				Categoria.ELECTROHOGAR, false));

		do {
			System.out.println("");
			System.out.println("***Compras***");
			System.out.println("1-Mostrar productos");
			System.out.println("2-Realizar compra");
			System.out.println("3-Salir");
			try {// control de opciones menu principal
				System.out.print("Elija una opcion: ");
				opcion = leer.nextByte();
				if (opcion < 1 || opcion > 3) {
					opcion = 0;
					throw new IllegalArgumentException("Opcion invalida, debe elegir una opcion del 1 al 3");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				leer.nextLine();
				opcion = 0;
			}
			switch (opcion) {
			case 1:// mostrar productos
				for (Producto prod : listaProductos) {
					if (prod.isEstado() == true) {
						System.out.println(prod);
					}
				}
				break;
			case 2:// realizar compra
				do {
					try {// control de ingreso de codigo
						System.out.print("Ingrese codigo del producto: ");
						codigoProducto = leer.next();
						for (int i = 0; i < listaProductos.size(); i++) {
							producto = listaProductos.get(i);
							if (producto.getCodigo().equals(codigoProducto)) {
								listaCompra.add(producto); // agrego el producto a la lista de compras
								montoTotal += producto.getPrecioUnitario();
							}
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						codigoProducto = "";
						leer.nextLine();
					}
					try {
						do {
							System.out.print("Desea cargar otro producto(S/N):  ");
							respuesta = leer.next();
							if (respuesta.equalsIgnoreCase("S")) {
								carga = true;
							} else if (respuesta.equalsIgnoreCase("N")) {
								carga = false;
							} else {
								System.out.println("Respuesta no válida. Por favor, ingrese S o N.");
							}
						} while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						respuesta = "";
						leer.nextLine();
					}
				} while (carga == true);
				System.out.println("***Opciones de pago***");
				System.out.println("1-Pago efectivo");
				System.out.println("2-Pago con tarjeta");
				do {
					try {
						System.out.print("Ingrese opción: ");
						opcion = leer.nextByte();
						if (opcion < 1 || opcion > 2) {
							opcion = 0;
							throw new IllegalArgumentException("Opcion invalida, debe elegir una opcion del 1 al 2");
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						leer.nextLine();
						opcion = 0;
					}
				} while (opcion == 0);
				do {
					switch (opcion) {
					case 1:// pago efectivo
						PagoEfectivo pagoEfectivo = new PagoEfectivo();
						pagoEfectivo.setMontoPagado(montoTotal);
						pagoEfectivo.imprimirRecibo();
						break;
					case 2:// pago tarjeta
						PagoTarjeta pagoTarjeta = new PagoTarjeta();
						pagoTarjeta.setNumeroTarjeta(4021123454786010l);
						pagoTarjeta.setMontoPagado(montoTotal);
						pagoTarjeta.imprimirRecibo();
						break;
					default:
						System.out.println("Opción invalida");
						break;
					}
				} while (opcion != 1 && opcion != 2);
				break;
			case 3:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción invalida");
				break;
			}
		} while (opcion != 3);
		leer.close();
	}
}

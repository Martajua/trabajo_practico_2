package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
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

		// precarga de productos
		listaProductos.add(new Producto("ABC123", "", 23.4, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, false));
		listaProductos.add(new Producto("ABC124", "", 30.5, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("ABC125", "", 100.5, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true));
		listaProductos.add(new Producto("ABC126", "", 300.3, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false));
		listaProductos.add(new Producto("ABC127", "", 900.0, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		listaProductos
				.add(new Producto("DEF456", "", 1200.3, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true));
		listaProductos.add(new Producto("DEF457", "", 899.7, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, true));
		listaProductos.add(new Producto("DEF458", "", 1500.9, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, true));
		listaProductos.add(new Producto("DEF459", "", 400.0, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, false));
		listaProductos.add(new Producto("DEF460", "", 275.2, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("GHI789", "", 950.5, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
		listaProductos.add(new Producto("GHI790", "", 645.7, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, true));
		listaProductos.add(new Producto("GHI791", "", 308.6, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
		listaProductos.add(new Producto("GHI792", "", 349.7, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, false));
		listaProductos.add(new Producto("GHI793", "", 241.3, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, false));

		do {

			System.out.println("***Compras***");
			System.out.println("1-Mostrar productos");
			System.out.println("2-Realizar compra");
			System.out.println("3-Salir");
			System.out.print("Elija una opcion: ");
			opcion = leer.nextByte();
			switch (opcion) {
			case 1:// mostrar productos
				for (Producto producto : listaProductos) {
					if (producto.isEstado() == true) {
						System.out.println(producto);
					}
				}
				break;
			case 2:// realizar compra
				do {
					System.out.print("Ingrese codigo del producto: ");
					codigoProducto = leer.next();
					for (Producto producto : listaProductos) {
						if (codigoProducto.equals(producto.getCodigo())) {
							listaCompra.add(producto); // agrego el producto a la lista de compras
							montoTotal += producto.getPrecioUnitario();
						}
					}
					System.out.print("Desea cargar otro producto(S/N):  ");
					respuesta = leer.next();
					if (respuesta.equalsIgnoreCase("S")) {
						carga = true;
					} else {
						carga = false;
					}
				} while (carga == true);
				System.out.println("***Opciones de pago***");
				System.out.println("1-Pago efectivo");
				System.out.println("2-Pago con tarjeta");
				System.out.print("Ingrese opción: ");
				opcion = leer.nextByte();
				do {
					switch (opcion) {
					case 1:// pago efectivo
						PagoEfectivo pagoEfectivo = new PagoEfectivo();
						pagoEfectivo.setFechaPago(LocalDate.now());
						pagoEfectivo.setMontoPagado(montoTotal);
						pagoEfectivo.imprimirRecibo();
						break;
					case 2:// pago tarjeta
						PagoTarjeta pagoTarjeta = new PagoTarjeta();
						pagoTarjeta.setNumeroTarjeta(4021123454786010l);
						pagoTarjeta.setFechaPago(LocalDate.now());
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

package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		// variables
		byte opcion;
		String codigoEfemeride = null;
		byte mesNumero = 0;
		byte diaEfemeride = 0;
		String nombreMes = null;
		String detalleEfemeride = null;
		// lista de objetos
		List<Efemeride> listaEfemeride = new ArrayList<>();
		// objeto
		Efemeride efemeride = new Efemeride();
		Scanner leer = new Scanner(System.in);

		do {
			System.out.println("-----------------------");
			System.out.println("---MENU---");
			System.out.println("1-Crear Efeméride");
			System.out.println("2-Mostrar Efemérides");
			System.out.println("3-Eliminar Efeméride");
			System.out.println("4-Modificar Efeméride");
			System.out.println("5-Salir");
			try {// control menu principal
				System.out.print("Ingrese opcion: ");
				opcion = leer.nextByte();
				if (opcion < 1 || opcion > 5) {
					opcion = 0;
					throw new IllegalArgumentException("Opcion invalida, debe elegir una opcion del 1 al 5");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				leer.nextLine();
				opcion = 0;
			}
			switch (opcion) {
			case 1:// crear efemeride
				do {// control codigo
					try {
						System.out.print("Ingrese codigo: ");
						codigoEfemeride = leer.next();
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						codigoEfemeride = "";
						leer.nextLine();// Limpiar el buffer del scanner
					}
				} while (codigoEfemeride.isEmpty());
				do {// control mes
					try {
						System.out.print("Ingrese número del mes: ");
						mesNumero = leer.nextByte();
						if (mesNumero < 1 || mesNumero > 12) {
							throw new IllegalArgumentException("Opcion invalida, debe elegir un mes del 1 al 12");
						} else {
							for (Mes mes : Mes.values()) {
								if (mes.getNUMERO_MES() == mesNumero) {
									nombreMes = mes.name();
								}
							}
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						mesNumero = 0;
						leer.nextLine();// Limpiar el buffer del scanner
					}
				} while (mesNumero == 0);

				do {// control dia
					try {
						System.out.print("Ingrese dia: ");
						diaEfemeride = leer.nextByte();
						if (diaEfemeride < 1 || diaEfemeride > 31) {
							throw new IllegalArgumentException("Opcion invalida, debe elegir un mes del 1 al 31");
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						leer.nextLine();// Limpiar el buffer del scanner
						diaEfemeride = 0;
					}
				} while (diaEfemeride == 0);
				leer.nextLine();
				do {// control detalle
					try {
						System.out.print("Ingrese detalle: ");
						detalleEfemeride = leer.nextLine();
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						codigoEfemeride = "";
						leer.nextLine();// Limpiar el buffer del scanner
					}
				} while (codigoEfemeride.isEmpty());

				// cargo la lista con un nuevo producto
				listaEfemeride.add(new Efemeride(codigoEfemeride, nombreMes, diaEfemeride, detalleEfemeride));
				System.out.println("Se creo el objeto con exito");
				break;
			case 2:// mostrar productos
				if (listaEfemeride.isEmpty()) {
					System.out.println("La lista de efemerides esta vacia");
				} else {
					listaEfemeride.forEach(e -> System.out.println("efemeride: " + e));
				}
				break;
			case 3:// eliminar efemeride
				if (listaEfemeride.isEmpty()) {
					System.out.println("La lista de efemerides esta vacia");
				} else {
					System.out.print("Ingrese codigo efimeride a eliminar:");
					codigoEfemeride = leer.next();
					for (int i = 0; i < listaEfemeride.size(); i++) {
						efemeride = listaEfemeride.get(i);
						if (efemeride.getCodigo().equals(codigoEfemeride)) {
							listaEfemeride.remove(i);
							System.out.println("Se elimino el objeto con exito");
							break;
						} else {
							System.out.println(
									"El codigo " + codigoEfemeride + " no pertenece a ningúna efemeride de la lista");
						}
					}
				}
				break;
			case 4:// modificar productos
				if (listaEfemeride.isEmpty()) {
					System.out.println("La lista de efemerides esta vacia");
				} else {
					System.out.print("Ingrese codigo de efemeride a modificar:");
					codigoEfemeride = leer.next();
					for (int i = 0; i < listaEfemeride.size(); i++) {
						efemeride = listaEfemeride.get(i);
						if (efemeride.getCodigo().equals(codigoEfemeride)) {
							System.out.println("Modificar producto " + efemeride.getCodigo());
							do {// control mes
								try {
									System.out.print("Ingrese número del mes: ");
									mesNumero = leer.nextByte();
									if (mesNumero < 1 || mesNumero > 12) {
										throw new IllegalArgumentException(
												"Opcion invalida, debe elegir un mes del 1 al 12");
									} else {
										for (Mes mes : Mes.values()) {
											if (mes.getNUMERO_MES() == mesNumero) {
												nombreMes = mes.name();
											}
										}
									}
								} catch (Exception e) {
									System.out.println("Error: " + e.getMessage());
									mesNumero = 0;
									leer.nextLine();// Limpiar el buffer del scanner
								}
							} while (mesNumero == 0);
							do {// control dia
								try {
									System.out.print("Ingrese dia: ");
									diaEfemeride = leer.nextByte();
									if (diaEfemeride < 1 || diaEfemeride > 31) {
										throw new IllegalArgumentException(
												"Opcion invalida, debe elegir un mes del 1 al 31");
									}
								} catch (Exception e) {
									System.out.println("Error: " + e.getMessage());
									leer.nextLine();// Limpiar el buffer del scanner
									diaEfemeride = 0;
								}
							} while (diaEfemeride == 0);
							leer.nextLine();
							do {// control detalle
								try {
									System.out.print("Ingrese detalle: ");
									detalleEfemeride = leer.nextLine();
								} catch (Exception e) {
									System.out.println("Error: " + e.getMessage());
									codigoEfemeride = "";
									leer.nextLine();// Limpiar el buffer del scanner
								}
							} while (codigoEfemeride.isEmpty());

							efemeride.setMes(nombreMes);
							efemeride.setDía(diaEfemeride);
							efemeride.setDetalle(detalleEfemeride);
							System.out.println("Efemeride modificada con exito");
							break;
						} else {
							System.out.println(
									"El codigo " + codigoEfemeride + " no pertenece a ningúna efemeride de la lista");
						}
					}
				}
				break;
			case 5:// salir
				System.out.println("Saliendo...");
				break;
			default:
				break;
			}
		} while (opcion != 5);
		leer.close();
	}
}

package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		// variables
		int opcion;
		String nombreJugador = null;
		String apellidoJugador = null;
		LocalDate fechaNacimientoJugador = null;
		String fechaNacimientoString;
		String nacionalidadJugador = null;
		double estaturaJugador = 0;
		double pesoJugador = 0;
		Posicion posicionJugador = null;
		String posicionString;
		// lista de jugadores
		List<Jugador> listaJugadores = new ArrayList<>();

		// objeto de la clase jugador
		Jugador jugador = new Jugador();
		Scanner leer = new Scanner(System.in);

		do {
			System.out.println("---------------------------");
			System.out.println("Menú Jugadores");
			System.out.println("");
			System.out.println("1 – Alta de jugador");
			System.out.println("2 – Mostrar los datos del jugador ");
			System.out.println("3 – Mostrar todos los jugadores ordenados por apellido");
			System.out.println("4 – Modificar los datos de un jugador ");
			System.out.println("5 – Eliminar un jugador");
			System.out.println("6 – Mostrar la cantidad total de jugadores que tiene el ArrayList.");
			System.out.println("7 – Mostrar la cantidad de jugadores que pertenecen a una nacionalidad ");
			System.out.println("8 – Salir");
			System.out.println("---------------------------");
			// controlamos que solo utilize numeros enteros
			do {
				try {
					System.out.print("Ingrese opción: ");
					while (!leer.hasNextInt()) {
						System.out.println("Error: Debe ingresar un número entero.");
						System.out.print("Ingrese opción: ");
						leer.next();
					}
					opcion = leer.nextInt();
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
					opcion = -1;
				}
			} while (opcion == -1);
			switch (opcion) {
			case 1:// alta jugador
					// control ingreso NOMBRE
				do {
					try {
						System.out.print("Ingrese nombre del jugador: ");
						nombreJugador = leer.next();
						// Verificamos si la entrada contiene solo letras
						if (!nombreJugador.matches("[a-zA-Z]+")) {
							throw new IllegalArgumentException("El nombre debe contener solo letras.");
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						// Limpiamos scanner
						nombreJugador = "";
					}
				} while (nombreJugador.isEmpty());
				// control ingreso APELLIDO
				do {
					try {
						System.out.print("Ingrese apellido del jugador: ");
						apellidoJugador = leer.next();
						// Verificamos si la entrada contiene solo letras
						if (!apellidoJugador.matches("[a-zA-Z]+")) {
							throw new IllegalArgumentException("El apellido debe contener solo letras.");
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						// Limpiamos scanner
						apellidoJugador = "";
					}
				} while (apellidoJugador.isEmpty());
				// control ingreso FECHA NACIMIENTO
				do {
					try {
						System.out.print("Ingrese fecha de nacimento (formato: dd-MM-yyyy): ");
						fechaNacimientoString = leer.next();
						// fecha formateada
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
						fechaNacimientoJugador = LocalDate.parse(fechaNacimientoString, formatter);
					} catch (Exception e) {
						System.out.println("Formato de fecha incorrecto. Utilice el formato dd-MM-yyyy.");
						fechaNacimientoJugador = null;
					}
				} while (fechaNacimientoJugador == null);
				// control ingreso NACIONALIDAD
				do {
					try {
						System.out.print("Ingrese nacionalidad del jugador: ");
						nacionalidadJugador = leer.next();
						// Verificamos si la entrada contiene solo letras
						if (!nacionalidadJugador.matches("[a-zA-Z]+")) {
							throw new IllegalArgumentException("La nacionalidad debe contener solo letras.");
						}
					} catch (Exception e) {
						System.out.println("Error: " + e.getMessage());
						// Limpiamos scanner
						nacionalidadJugador = "";
					}
				} while (nacionalidadJugador.isEmpty());
				// control ingreso ESTATURA
				do {
					try {
						System.out.print("Ingrese estatura del jugador (separador decimal \",\"): ");
						estaturaJugador = leer.nextDouble();
						if (estaturaJugador <= 0) {
							throw new IllegalArgumentException("El número debe ser positivo.");
						}
					} catch (Exception e) {
						System.out.println("Error: Debe ingresar un número real válido.");
						estaturaJugador = 0;
						leer.nextLine();
					}
				} while (estaturaJugador == 0);
				// control ingreso PESO
				do {
					try {
						System.out.print("Ingrese peso del jugador (separador decimal \",\"): ");
						pesoJugador = leer.nextDouble();
						if (pesoJugador <= 0) {
							throw new IllegalArgumentException("El número debe ser positivo.");
						}
					} catch (Exception e) {
						System.out.println("Error: Debe ingresar un número real válido.");
						pesoJugador = 0;
						leer.nextLine();
					}
				} while (pesoJugador == 0);
				// control ingreso POSICION
				do {

					try {
						System.out.print("Ingrese posicion del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
						// convierto la cadena a mayuscula ya que las constantes declaradas estan en
						// mayusculas
						posicionString = leer.next().toUpperCase();
						posicionJugador = Posicion.valueOf(posicionString);
					} catch (IllegalArgumentException e) {
						System.out.println("La posicion ingresada no es valida.");
					}
				} while (posicionJugador == null);
				// crear objeto jugador
				jugador = new Jugador(nombreJugador, apellidoJugador, fechaNacimientoJugador, nacionalidadJugador,
						estaturaJugador, pesoJugador, posicionJugador);
				listaJugadores.add(jugador);
				System.out.println("El alta del jugador se dio con exito");
				break;
			case 2:// mostrar datos del jugador
				if (listaJugadores.isEmpty()) {
					System.out.println("El ArrayList no tiene ningún jugador");
				}
				System.out.print("Ingrese nombre: ");
				nombreJugador = leer.next();
				System.out.print("Ingrese apellido: ");
				apellidoJugador = leer.next();
				boolean jugadorEncontrado = false;
				for (int i = 0; i < listaJugadores.size(); i++) {
					jugador = listaJugadores.get(i);
					if (jugador.getNombre().equalsIgnoreCase(nombreJugador)
							&& jugador.getApellido().equalsIgnoreCase(apellidoJugador)) {
						jugadorEncontrado = true;
						System.out.println(jugador.toString());
						break;
					}
				}
				if (!jugadorEncontrado) {
					System.out.println("El jugador no existe.");
				}
				break;
			case 3: // jugadores ordenados por apellido
				if (listaJugadores.isEmpty()) {
					System.out.println("El ArrayList no tiene ningún jugador");
				} else {
					System.out.println("Jugadores ordenados por apellido");
					System.out.println("");
					listaJugadores.sort(Comparator.comparing(Jugador::getApellido));
					// visualizo jugadores
					listaJugadores.forEach(jug -> System.out.println("Jugador: " + jug.getApellido()));
				}
				break;
			case 4:// modificar los datos del jugador
				if (listaJugadores.isEmpty()) {
					System.out.println("El ArrayList no tiene ningún jugador");
				} else {
					System.out.print("Ingrese nombre: ");
					nombreJugador = leer.next();
					System.out.print("Ingrese apellido: ");
					apellidoJugador = leer.next();
					jugadorEncontrado = false;
					for (Jugador j : listaJugadores) {
						if (j.getNombre().equalsIgnoreCase(nombreJugador)
								&& j.getApellido().equalsIgnoreCase(apellidoJugador)) {
							// Mostrar opciones de modificación al usuario
							System.out.println("Jugador encontrado. Proporcione los nuevos datos:");
							try {
								// Control ingreso FECHA NACIMIENTO
								System.out.print("Ingrese fecha de nacimento (formato: dd-MM-yyyy): ");
								fechaNacimientoString = leer.next();
								// fecha formateada
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
								fechaNacimientoJugador = LocalDate.parse(fechaNacimientoString, formatter);
								j.setFechaNacimiento(fechaNacimientoJugador);
								// Control ingreso NACIONALIDAD
								System.out.print("Ingrese nacionalidad del jugador: ");
								nacionalidadJugador = leer.next();
								j.setNacionalidad(nacionalidadJugador);
								// Control ingreso ESTATURA
								System.out.print("Ingrese estatura del jugador (separador decimal \",\"): ");
								estaturaJugador = leer.nextDouble();
								if (estaturaJugador <= 0) {
									throw new IllegalArgumentException("El número debe ser positivo.");
								}
								j.setEstatura(estaturaJugador);
								// Control ingreso PESO
								System.out.print("Ingrese peso del jugador (separador decimal \",\"): ");
								pesoJugador = leer.nextDouble();
								if (pesoJugador <= 0) {
									throw new IllegalArgumentException("El número debe ser positivo.");
								}
								j.setPeso(pesoJugador);
								// Control ingreso POSICION
								System.out.print("Ingrese posicion del jugador (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
								// convierto la cadena a mayuscula ya que las constantes declaradas estan en
								// mayusculas
								posicionString = leer.next().toUpperCase();
								posicionJugador = Posicion.valueOf(posicionString);
								j.setPosicion(posicionJugador);
								jugadorEncontrado = true; // Marcar que se encontró al jugador
								break; // Salir del bucle ya que se encontró al jugador
							} catch (DateTimeParseException | IllegalArgumentException e) {
								System.out.println("Error: " + e.getMessage());
								// Limpiar el scanner en caso de error
								leer.nextLine();
							}
						}
					}
					if (!jugadorEncontrado) {
						System.out.println("El jugador no existe.");
					}
				}
				break;
			case 5:// eliminar un jugador
				if (listaJugadores.isEmpty()) {
					System.out.println("El ArrayList no tiene ningún jugador");
				}
				System.out.print("Ingrese nombre: ");
				nombreJugador = leer.next();
				System.out.print("Ingrese apellido: ");
				apellidoJugador = leer.next();
				jugadorEncontrado = false;
				Iterator<Jugador> iterador = listaJugadores.iterator();
				while (iterador.hasNext()) {
					jugador = iterador.next();
					if (jugador.getNombre().equalsIgnoreCase(nombreJugador)
							&& jugador.getApellido().equalsIgnoreCase(apellidoJugador)) {
						iterador.remove();
						jugadorEncontrado = true;
						System.out.println("Jugador eliminado con exito");
						break;
					}
				}
				if (!jugadorEncontrado) {
					System.out.println("El jugador no existe.");
				}
				break;
			case 6: // cantidad de jugadores
				if (listaJugadores.size() == 1) {
					System.out.println("El ArrayList tiene " + listaJugadores.size() + " jugador.");
				} else {
					System.out.println("El ArrayList tiene " + listaJugadores.size() + " jugadores.");
				}
				break;
			case 7:// cantidad de jugador segun nacionalidad
				int cantidadJugadores = 0;
				if (listaJugadores.isEmpty()) {
					System.out.println("El ArrayList no tiene ningún jugador");
				}
				System.out.println("Ingrese nacionalidad: ");
				nacionalidadJugador = leer.next();
				for (int i = 0; i < listaJugadores.size(); i++) {
					jugador = listaJugadores.get(i);
					if (jugador.getNacionalidad().equalsIgnoreCase(nacionalidadJugador)) {
						cantidadJugadores++;
					}
				}
				System.out.println("La cantidad de jugadores " + nacionalidadJugador + " es: " + cantidadJugadores);
				break;
			case 8: // salir del programa
				System.out.println("Saliendo....");
				break;
			default:
				System.out.println("OPCION INVALIDA");
				break;
			}
		} while (opcion != 8);
		leer.close();
	}

}

package ar.edu.unju.fi.ejercicio1.model;

import java.util.Scanner;

public class Producto {
	private String codigo;
	private String descripcion;
	private double precioUnitario;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;

	public enum OrigenFabricacion {
		ARGENTINA, CHINA, BRASIL, URUGUAY;
	}

	public enum Categoria {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS;
	}

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(String codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion,
			Categoria categoria) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// modulo para cargar el origen de fabricacion
	public OrigenFabricacion menuOrigenDeFabricacion(Scanner leer) {
		byte opc = 0;
		OrigenFabricacion origen = null;
		do {
			System.out.println("-----------------------");
			System.out.println("----Origen de fabricación----");
			System.out.println("1 - Argentina");
			System.out.println("2 - China");
			System.out.println("3 - Brasil");
			System.out.println("4 - Uruguay");
			try {
				System.out.print("Elija una opción: ");
				opc = leer.nextByte();
				if (opc < 1 || opc > 4) {
					throw new IllegalArgumentException("Opcion invalida, debe elegir una opcion del 1 al 4");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				leer.nextLine();
				opc = 0;
			}
			switch (opc) {
			case 1:
				origen = OrigenFabricacion.ARGENTINA;
				break;
			case 2:
				origen = OrigenFabricacion.CHINA;
				break;
			case 3:
				origen = OrigenFabricacion.BRASIL;
				break;
			case 4:
				origen = OrigenFabricacion.URUGUAY;
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
		} while (opc == 0);
		return origen;
	}

	// modulo para cargar la categoria
	public Categoria menuCategoria(Scanner leer) {
		byte opc;
		Categoria categoria = null;
		do {
			System.out.println("-----------------------");
			System.out.println("----Categoría----");
			System.out.println("1 - Telefonía");
			System.out.println("2 - Informatíca");
			System.out.println("3 - Electro hogar");
			System.out.println("4 - Herramientas");
			try {
				System.out.print("Elija una opción: ");
				opc = leer.nextByte();
				if (opc < 1 || opc > 4) {
					throw new IllegalArgumentException("Opcion invalida, debe elegir una opcion del 1 al 4");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				leer.nextLine();
				opc = 0;
			}
			switch (opc) {
			case 1:
				categoria = Categoria.TELEFONIA;
				break;
			case 2:
				categoria = Categoria.INFORMATICA;
				break;
			case 3:
				categoria = Categoria.ELECTROHOGAR;
				break;
			case 4:
				categoria = Categoria.HERRAMIENTAS;
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
		} while (opc == 0);
		return categoria;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", origenFabricacion=" + origenFabricacion + ", categoria=" + categoria + "]";
	}
}

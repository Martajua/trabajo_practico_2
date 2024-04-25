package ar.edu.unju.fi.ejercicio2.constantes;

public enum Mes {
	ENERO((byte) 1), FEBRERO((byte) 2), MARZO((byte) 3), ABRIL((byte) 4), MAYO((byte) 5), JUNIO((byte) 6),
	JULIO((byte) 7), AGOSTO((byte) 8), SEPTIEMBRE((byte) 9), OCTUBRE((byte) 10), NOVIEMBRE((byte) 11),
	DICIEMBRE((byte) 12);

	private byte NUMERO_MES;

	private Mes() {
		// TODO Auto-generated constructor stub
	}

	private Mes(byte nUMERO_MES) {
		NUMERO_MES = nUMERO_MES;
	}

	public byte getNUMERO_MES() {
		return NUMERO_MES;
	}

	public void setNUMERO_MES(byte nUMERO_MES) {
		NUMERO_MES = nUMERO_MES;
	}	
}

package co.com.codesa.clienteposslimgiros.dto;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;

public class PosicionDimensiones{
	
	//private EnumDimensionesComponentes posicion1;
	//private EnumDimensionesComponentes posicion2;
	//private EnumDimensionesComponentes posicion3;
	
	private EnumDimensionesComponentes posiciones[];
	
	/*public PosicionDimensiones(EnumDimensionesComponentes posicion1,
			EnumDimensionesComponentes posicion2,
			EnumDimensionesComponentes posicion3) {
		
		super();
		
		this.posicion1 = posicion1;
		this.posicion2 = posicion2;
		this.posicion3 = posicion3;
		
	}*/
	
	public PosicionDimensiones(EnumDimensionesComponentes posiciones[]) {
		
		super();
		
		this.posiciones = posiciones;
		
	}

	public EnumDimensionesComponentes[] getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(EnumDimensionesComponentes[] posiciones) {
		this.posiciones = posiciones;
	}
	
	/*public EnumDimensionesComponentes getPosicion1() {
		return posicion1;
	}
	public void setPosicion1(EnumDimensionesComponentes posicion1) {
		this.posicion1 = posicion1;
	}
	public EnumDimensionesComponentes getPosicion2() {
		return posicion2;
	}
	public void setPosicion2(EnumDimensionesComponentes posicion2) {
		this.posicion2 = posicion2;
	}
	public EnumDimensionesComponentes getPosicion3() {
		return posicion3;
	}
	public void setPosicion3(EnumDimensionesComponentes posicion3) {
		this.posicion3 = posicion3;
	}*/
	
}

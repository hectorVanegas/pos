package co.com.codesa.clienteposslimgiros.enumeraciones;

import java.util.ResourceBundle;

public enum EnumParametrosPruebas {
	
	//General
	PRU_INT_NOMBRE_FRAME("pru_int_nombre_frame"),
	
	//Informacion usuario GAMBLE
	PRU_INT_LOGIN_GAMBLE("pru_int_login_gamble"),
	PRU_INT_DOCUMENTO_USUARIO_GAMBLE("pru_int_documento_usuario_gamble"),
	PRU_INT_PUNTO_VENTA_GAMBLE("pru_int_punto_venta_gamble"),
	PRU_INT_CODIGO_CENTRO_COSTO_GAMBLE("pru_int_codigo_centro_costo_gamble"),
	PRU_INT_CLAVE_USUARIO_GAMBLE("pru_int_clave_usuario_gamble"),
	
	//Informacion usuario SIMS
	PRU_INT_TOKEN_D_GAMBLE("pru_int_token_d_gamble"),
	PRU_INT_LOGIN_SIMS("pru_int_login_sims"),
	PRU_INT_CLAVE_SIMS("pru_int_clave_sims"),
	
	//Conexion
	PRU_INT_IP_SOCKET_GAMBLE("pru_int_ip_socket_gamble"),
	PRU_INT_PUERTO_SOCKET_GAMBLE("pru_int_puerto_socket_gamble"),
	PRU_INT_TIME_OUT_SOCKET_GAMBLE("pru_int_time_out_socket_gamble"),
	
	//Biometria
	PRU_INT_ACTIVA_BIOMETRIA_USUARIO("pru_int_activa_biometria_usuario"),
	PRU_INT_ACTIVA_BIOMETRIA_TERCERO("pru_int_activa_biometria_tercero"),
	
	//Posicionamiento
	/**
	 * Se desactiva bandera para incorporar posicionamiento absoluto (layout absoluto)
	 * debido a que esta solucion no logro el comportamiento deseado en ambiente linux
	 * Sin embargo es un tema interesante investigar, dado la diversidad de ambientes 
	 * a los que estamos sujetos (Sistemas operativos, resoluciones, entre otros)
	 */
	@Deprecated
	PRU_INT_ACTIVA_POSICIONAMIENTO_ABSOLUTO("pru_int_activa_posicionamiento_absoluto"),
	
	;
	
	private final String etiqueta;

	private String propiedad;
	
	private Object constante;
	
	private boolean procesado;
	
	public static ResourceBundle parametros;
	
	static {
		parametros = ResourceBundle.getBundle("co/com/codesa/clienteposslimgiros/parametros/parametrosPruebas");
	}
	
	private EnumParametrosPruebas(String etiqueta){
		
		this.etiqueta=etiqueta;
	}
	
	private EnumParametrosPruebas(String etiqueta, Object constante){
		
		this.etiqueta=etiqueta;
		this.constante = constante;
	}
	
	private void validaProcesado(){
		
		if(!this.procesado){
			this.cargar();
			this.procesado=true;
		}
	}
	
	private void cargar(){
		
		try{
			this.propiedad=EnumParametrosPruebas.parametros.getString(this.etiqueta);
		}catch(Exception e){
			this.propiedad=null;
		}
	}

	public String getPropiedad() {
		this.validaProcesado();
		return propiedad;
	}

	public void setPropiedad(String valor) {
		this.propiedad = valor;
	}

	public boolean isProcesado() {
		return procesado;
	}

	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public Object getConstante() {
		return constante;
	}

	public void setConstante(Object constante) {
		this.constante = constante;
	}
	
}

package co.com.codesa.clienteposslimgiros.enumeraciones;

import javax.swing.JOptionPane;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 09-mar-2015
 * @clase EnumClasesMensaje
 * 		  Clase enumerador que permite sincronizar tipos de mensajes 
 * 		  manejados por giros, con respecto a los tipos administrados 
 * 		  por JOptionPane
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public enum EnumClasesMensaje {
	
	ERROR("ERROR",
		  JOptionPane.WARNING_MESSAGE,//JOptionPane.ERROR_MESSAGE,
		  EnumEtiquetas.TTL_VENTANA_ADVERTENCIA,//EnumEtiquetas.TTL_VENTANA_ERROR,
		  "E",
		  EnumImagenes.ALE_ADVERTENCIA),//EnumImagenes.ALE_ERROR),
		  
	INFORMACION("INFORMACION",
				JOptionPane.INFORMATION_MESSAGE,
				EnumEtiquetas.TTL_VENTANA_INFORMACION,
				"I",
				EnumImagenes.ALE_INFORMACION),
				
	ADVERTENCIA("ADVERTENCIA",
				JOptionPane.WARNING_MESSAGE,
				EnumEtiquetas.TTL_VENTANA_ADVERTENCIA,
				"W",
				EnumImagenes.ALE_ADVERTENCIA),
				
	CONFIRMACION("CONFIRMACION",
				 JOptionPane.QUESTION_MESSAGE,
				 EnumEtiquetas.TTL_VENTANA_CONFIRMACION,
				 "Q",
				 EnumImagenes.ALE_CONFIRMACION),
	;
	
	/**
     * @variable intIdentificador 
     * 			 identificador de constante, simboliza el tipo sincronizado
     */
	private final int intIdentificador;
	
	/**
     * @variable strNombre 
     * 			 Nombre representativo de la clase de mensaje
     */
	private final String strNombre;
	
	/**
	 * @variable enmEtiTitulo
	 * 			 Titulo dado a la ventana de mensaje desplegada
	 */
	private EnumEtiquetas enmEtiTitulo;
	
	/**
     * @variable strClave
     * 			 Clave que identifica al tipo de mensaje
     */
	private final String strClave;
	
	/**
     * @variable enmImagen
     * 			 Imagen asociada a la clase de mensaje
     */
	private EnumImagenes enmImagen;
	
	
	/**
	 * ****************************************************************.
	 * @metodo EnumClasesMensaje
	 * 		   Inicializacion de la constante de enumeracion
     * @param strNombre 
     * 		  Nombre representativo de la clase de mensaje
     * @param intIdentificador
     * 		  identificador de constante, simboliza el tipo sincronizado
     * @param pEnmEtiTitulo 
     * 		  Titulo dado a la ventana de mensaje desplegada
     * @param strClave 
     * 		  Clave que identifica al tipo de mensaje
     * @param pEnmImagen
     * 		  Imagen asociada a la clase de mensaje
     * @autor Hector Q-en-K
     * ****************************************************************
     */
	private EnumClasesMensaje(String pStrNombre,
							  int pIntIdentificador,
							  EnumEtiquetas pEnmEtiTitulo,
							  String strClave,
							  EnumImagenes pEnmImagen){
		
		this.strNombre=pStrNombre;
		this.intIdentificador=pIntIdentificador;
		this.setEnmEtiTitulo(pEnmEtiTitulo);
		this.strClave=strClave;
		this.enmImagen = pEnmImagen;
	}

	public int getIntIdentificador() {
		return intIdentificador;
	}

	public String getStrNombre() {
		return strNombre;
	}

	public String getStrClave() {
		return strClave;
	}

	public EnumEtiquetas getEnmEtiTitulo() {
		return enmEtiTitulo;
	}

	public void setEnmEtiTitulo(EnumEtiquetas enmEtiTitulo) {
		
		if(enmEtiTitulo == null){
			enmEtiTitulo = EnumEtiquetas.TTL_VENTANA_EMERGENTE;
		}
		
		this.enmEtiTitulo = enmEtiTitulo;
	}

	public EnumImagenes getEnmImagen() {
		return enmImagen;
	}

	public void setEnmImagen(EnumImagenes enmImagen) {
		this.enmImagen = enmImagen;
	}

}

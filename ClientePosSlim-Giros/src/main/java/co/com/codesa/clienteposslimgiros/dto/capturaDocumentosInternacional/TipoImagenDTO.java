package co.com.codesa.clienteposslimgiros.dto.capturaDocumentosInternacional;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTipoImagenes;

/** 
 * ********************************************************************
 * @class  TipoImagenDTO
 *		   Clase DTO que agrupa la informacion asociada los tipos de 
 *		   archivos
 * @author roberth.martinez
 * @date   7/02/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class TipoImagenDTO {
	
	/**
	 * @variable strTipoImagen
	 * 			 variable para identificar el tipo de archivo imagen
	 */
	private String strTipoImagen;
	
	/**
	 * @variable enmTipoImagenes
	 * 			 Enumerador de tipo imagenes
	 */
	private EnumTipoImagenes enmTipoImagenes;
	
	/** 
	 * ********************************************************************
	 * @method TipoImagenDTO
	 * 		   Metodo constructor que se encarga de fabricar la DTO, 
	 * 		   inicializando los aspectos necesarios para ello
	 * @param  pStrTipoImagen
	 * 		   parametro para identificar el tipo de archivo de imagen
	 * @param  pEnmTipoImagenes
	 * 		   Enumerador de tipo imagenes
	 * @author roberth.martinez
	 * @date   7/02/2018
	 * *********************************************************************
	 */
	public TipoImagenDTO(String pStrTipoImagen, 
						 EnumTipoImagenes pEnmTipoImagenes) {
		super();
		this.setStrTipoImagen(pStrTipoImagen);
		this.setEnmTipoImagenes(pEnmTipoImagenes);
		
	}

	/**
	 * @method getStrTipoImagen
	 * 		   Metodo get del atributo strTipoImagen
	 * @return String
	 *		   Valor del atributo strTipoImagen devuelto
	 * @author roberth.martinez
	 * @date   7/02/2018
	 */
	public String getStrTipoImagen() {
		return strTipoImagen;
	}

	/**
	 * @method setStrTipoImagen
	 * 		   Metodo set del atributo strTipoImagen
	 * @param  strTipoImagen
	 *		   Valor que tomara el atributo strTipoImagen
	 * @author roberth.martinez
	 * @date   7/02/2018
	 */
	public void setStrTipoImagen(String strTipoImagen) {
		this.strTipoImagen = strTipoImagen;
	}

	/**
	 * @method getEnmTipoImagenes
	 * 		   Metodo get del atributo enmTipoImagenes
	 * @return EnumTipoImagenes
	 *		   Valor del atributo enmTipoImagenes devuelto
	 * @author roberth.martinez
	 * @date   16/02/2018
	 */
	public EnumTipoImagenes getEnmTipoImagenes() {
		return enmTipoImagenes;
	}

	/**
	 * @method setEnmTipoImagenes
	 * 		   Metodo set del atributo enmTipoImagenes
	 * @param  enmTipoImagenes
	 *		   Valor que tomara el atributo enmTipoImagenes
	 * @author roberth.martinez
	 * @date   16/02/2018
	 */
	public void setEnmTipoImagenes(EnumTipoImagenes enmTipoImagenes) {
		this.enmTipoImagenes = enmTipoImagenes;
	}

	@Override
	public String toString() {
		return this.enmTipoImagenes.getStrTipoImagen();
	}

}

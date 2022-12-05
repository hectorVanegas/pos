package co.com.codesa.clienteposslimgiros.enumeraciones;

/** 
 * ********************************************************************
 * @class  EnumTipoImagenes
 *		   Clase que contiene las constantes de enumeracion que permiten
 *		   administrar los diferentes tipos de imagenes a capturar
 * @author roberth.martinez
 * @date   14/02/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumTipoImagenes {
	
	IMG_ANVERSO_DOC("DOCUMENTO ANVERSO", EnumParametrosApp.CDI_DOCUMENTO_ANVERSO,EnumImagenes.APP_POS_DOCUMENTO_ANVERSO),
	IMG_REVERSO_DOC("DOCUMENTO REVERSO", EnumParametrosApp.CDI_DOCUMENTO_REVERSO,EnumImagenes.APP_POS_DOCUMENTO_REVERSO),
	
	;
	
	/**
	 * @variable strTipoImagen
	 * 			 variable para manejar el tipo de imagen
	 */
	private String strTipoImagen;
	
	/**
	 * @variable strNombreArchivo
	 * 			 ruta y nombre del archhivo capturado
	 */
	private String strNombreArchivo;
	
	/**
	 * @variable enmEtiquetaDescTipoImg
	 * 			 variable para manejar la descripcion del tipo de imagen
	 */
	private EnumEtiquetas enmEtiquetaDescTipoImg;
	
	/**
	 * @variable enmImgImagen
	 * 			 Constante que identifica la imagen asociada al tipo de captura
	 */
	private EnumImagenes enmImgImagen;
	
	/**
	 *  @variable enumParametrosApp
	 * 			 Constante que identifica la constante asociada a la imagen
	 */
	private EnumParametrosApp enumParametrosApp;
	
	/** 
	 * ********************************************************************
	 * @method EnumTipoImagenes
	 * 		   [TODO - DOC]: Descripcion del metodo constructor, importante 
	 *		   mencionar la intencion de una sobrecarga, el despliegue de 
	 *		   comportamientos de interes y otros
	 * @param  pPtrTipoImagen
	 * 		   Tipo imagen
	 * @param  pEnmEtiquetaDescTipoImg
	 * 		   EnumEtiquetas con la descripcion del tipo de imagen
	 * @author roberth.martinez
	 * @date   14/02/2018
	 * *********************************************************************
	 */
	private EnumTipoImagenes(String pPtrTipoImagen, EnumEtiquetas pEnmEtiquetaDescTipoImg,EnumImagenes pEnmImgImagen) {
		this.setStrTipoImagen(pPtrTipoImagen);
		this.setEnmEtiquetaDescTipoImg(pEnmEtiquetaDescTipoImg);
		this.setEnmImgImagen(pEnmImgImagen);
	}
	
	private EnumTipoImagenes(String pPtrTipoImagen, EnumParametrosApp pEnumParametrosApp, EnumImagenes pEnumImgImagen) {
		this.setStrTipoImagen(pPtrTipoImagen);
		this.setEnumParametrosApp(pEnumParametrosApp);
		this.setEnmImgImagen(pEnumImgImagen);
	}

	/**
	 * @method getStrTipoImagen
	 * 		   Metodo get del atributo strTipoImagen
	 * @return String
	 *		   Valor del atributo strTipoImagen devuelto
	 * @author roberth.martinez
	 * @date   14/02/2018
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
	 * @date   14/02/2018
	 */
	public void setStrTipoImagen(String strTipoImagen) {
		this.strTipoImagen = strTipoImagen;
	}

	/**
	 * @method getEnmEtiquetaDescTipoImg
	 * 		   Metodo get del atributo enmEtiquetaDescTipoImg
	 * @return EnumEtiquetas
	 *		   Valor del atributo enmEtiquetaDescTipoImg devuelto
	 * @author roberth.martinez
	 * @date   14/02/2018
	 */
	public EnumEtiquetas getEnmEtiquetaDescTipoImg() {
		return enmEtiquetaDescTipoImg;
	}

	/**
	 * @method setEnmEtiquetaDescTipoImg
	 * 		   Metodo set del atributo enmEtiquetaDescTipoImg
	 * @param  enmEtiquetaDescTipoImg
	 *		   Valor que tomara el atributo enmEtiquetaDescTipoImg
	 * @author roberth.martinez
	 * @date   14/02/2018
	 */
	public void setEnmEtiquetaDescTipoImg(EnumEtiquetas enmEtiquetaDescTipoImg) {
		this.enmEtiquetaDescTipoImg = enmEtiquetaDescTipoImg;
	}

	/**
	 * @method getStrNombreArchivo
	 * 		   Metodo get del atributo strNombreArchivo
	 * @return String
	 *		   Valor del atributo strNombreArchivo devuelto
	 * @author roberth.martinez
	 * @date   15/02/2018
	 */
	public String getStrNombreArchivo() {
		return strNombreArchivo;
	}

	/**
	 * @method setStrNombreArchivo
	 * 		   Metodo set del atributo strNombreArchivo
	 * @param  strNombreArchivo
	 *		   Valor que tomara el atributo strNombreArchivo
	 * @author roberth.martinez
	 * @date   15/02/2018
	 */
	public void setStrNombreArchivo(String strNombreArchivo) {
		this.strNombreArchivo = strNombreArchivo;
	}

	/**
	 * @method	getEnmImgImagen
	 * 		  	Metodo get del atributo enmImgImagen
	 * @return	EnumImagenes
	 *		  	Valor del atributo enmImgImagen devuelto
	 * @author	hector.cuenca
	 * @date  	23/02/2018
	 */
	public EnumImagenes getEnmImgImagen() {
		return enmImgImagen;
	}

	/**
	 * @method	setEnmImgImagen
	 * 		  	Metodo set del atributo enmImgImagen
	 * @param	pEnmImgImagen
	 * 			Valor que tomara el atributo enmImgImagen
	 * @author	hector.cuenca
	 * @date	23/02/2018
	 */
	public void setEnmImgImagen(EnumImagenes pEnmImgImagen) {
		this.enmImgImagen = pEnmImgImagen;
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	getEnumParametrosApp
	 * 		  	metodo get del atributo enumParametrosApp
	 * @return
	 * 			Retorna el enumerador de parametros app asocaido a ala imagen
	 * @author	stiven.garcia
	 * @date	27/03/2018
	 * *********************************************************************
	 */
	public EnumParametrosApp getEnumParametrosApp() {
		return this.enumParametrosApp;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	setEnumParametrosApp
	 * 		  	metodo set de atributo Enumerador parametro de sistema
	 * @param pEnumParametrosApp
	 * 			Enumerador de parametro de app
	 * @author	stiven.garcia
	 * @date	27/03/2018
	 * *********************************************************************
	 */
	public void setEnumParametrosApp(EnumParametrosApp pEnumParametrosApp) {
		this.enumParametrosApp = pEnumParametrosApp;
	}
	
	

}

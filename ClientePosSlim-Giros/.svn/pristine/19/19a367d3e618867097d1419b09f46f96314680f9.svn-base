package co.com.codesa.clienteposslimgiros.enumeraciones;

import java.util.ResourceBundle;

public enum EnumRecursosProperties{

	CONFIGURACION_IMPRESORA("co/com/codesa/clienteposslimgiros/config/configuracion_impresora"),
	ETIQUETAS("co/com/codesa/clienteposslimgiros/etiquetas/etiquetasMsg"),
	DIMENSIONES("co/com/codesa/clienteposslimgiros/config/dimensionesComponentes"),
	PARAMETROS("co/com/codesa/clienteposslimgiros/parametros/parametrosApp"),
	MENSAJES("co/com/codesa/clienteposslimgiros/mensajes/codigosMensaje"),
	EXPRESIONES_REGULARES("co/com/codesa/clienteposslimgiros/config/expresionesRegulares"),
	ETIQUETAS_HTML("co/com/codesa/clienteposslimgiros/config/etiquetasHtml"),
	IMAGENES("co/com/codesa/clienteposslimgiros/config/imagenes"),
	TIPOS_OPERACIONES("co/com/codesa/clienteposslimgiros/operaciones/tiposOperaciones"),
	TIPOS_SERVICIOS("co/com/codesa/clienteposslimgiros/config/tipos_servicios"),
	REGLAS_COMISION_X_TIPO_SERVICIO("co/com/codesa/clienteposslimgiros/config/reglas_comision_x_tipo_servicio"),
	COLORES("co/com/codesa/clienteposslimgiros/config/gui/colores"),
	TIPOS_BIOMETRIA_CAJA("co/com/codesa/clienteposslimgiros/biometria/tiposBiometriaCaja"),
	TIPOS_OPERACIONES_ISO("co/com/codesa/clienteposslimgiros/biometria/tiposOperacionesISO"),
	
	//Plantillas XML
	CONFIG_XML_EJEMPLO("co/com/codesa/clienteposslimgiros/config/xml/config_xml_ejemplo"),
	
	;
	
	private ResourceBundle rsbRecurso;
	
	private String strRutaRecurso;
	
	private EnumRecursosProperties(String pStrRutaRecurso){
		
		this.setStrRutaRecurso(pStrRutaRecurso);
	}
	
	public String getStrRutaRecurso() {
		return strRutaRecurso;
	}

	public void setStrRutaRecurso(String strRutaRecurso) {
		this.strRutaRecurso = strRutaRecurso;
	}

	public ResourceBundle getRsbRecurso() {
		
		if(this.rsbRecurso == null
				&& this.getStrRutaRecurso()!=null
				&& !this.getStrRutaRecurso().isEmpty()){
			
			this.setRsbRecurso(ResourceBundle.getBundle(this.getStrRutaRecurso()));
		}
		
		return rsbRecurso;
	}

	public void setRsbRecurso(ResourceBundle rsbRecurso) {
		this.rsbRecurso = rsbRecurso;
	}
}

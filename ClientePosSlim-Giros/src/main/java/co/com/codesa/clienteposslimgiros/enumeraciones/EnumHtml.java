package co.com.codesa.clienteposslimgiros.enumeraciones;


public enum EnumHtml{

	
	TAG_ABRE_HTML("tag_abre_html"),//<html>
	TAG_CIERRA_HTML("tag_cierra_html"),//</html>
	TAG_ALINEACION_CENTRO("tag_alineacion_centro"),//<P ALIGN=center>
	TAG_ALINEACION_DERECHA("tag_alineacion_derecha"),//<P ALIGN=right>
	TAG_ALINEACION_IZQUIERDA("tag_alineacion_izquierda"),//<P ALIGN=left>
	TAG_ALINEACION_JUSTIFICADA("tag_alineacion_justificada"),//<P ALIGN=justify>
	TAG_SALTO_LINEA("tag_salto_linea"),//<br>
	TAG_TABULAR_LINEA("tag_tabular_linea"),//&#09
	;
	
	
	private final String strNombrePropiedad;
	
	private String strValor;
	
	private boolean booProcesado;
	
	private EnumHtml(String pStrNombrePropiedad){
		
		this.strNombrePropiedad = pStrNombrePropiedad;
	}
	
	private void validaProcesado(){
		
		if(!this.booProcesado){
			
			this.cargar();
			this.booProcesado=true;
		}
	}
	
	private void cargar(){
		
		try{
			
			this.strValor = EnumRecursosProperties.ETIQUETAS_HTML.getRsbRecurso().getString(this.getStrNombrePropiedad());
			
		}catch(Exception e){
			
			e.printStackTrace();
			this.strValor=strNombrePropiedad;
		}
		
	}

	public String getStrValor() {
		
		this.validaProcesado();
		
		return strValor;
	}

	public void setStrValor(String strValor) {
		this.strValor = strValor;
	}

	public String getStrNombrePropiedad() {
		return strNombrePropiedad;
	}
	
}

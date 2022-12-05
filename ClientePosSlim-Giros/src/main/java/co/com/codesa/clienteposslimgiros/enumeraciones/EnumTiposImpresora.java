package co.com.codesa.clienteposslimgiros.enumeraciones;

public enum EnumTiposImpresora{

	TIRILLA("TMU",
			EnumEtiquetas.LBL_TIPO_IMPRESION_TIRILLA,
			EnumConfiguracion.NOMBRE_IMPRESORA_GIROS_TMU),
			
	MEDIA_CARTA("MC",
				EnumEtiquetas.LBL_TIPO_IMPRESION_MEDIA_CARTA,
				EnumConfiguracion.NOMBRE_IMPRESORA_GIROS_MC),
	;
	
	private String strAbreviatura;
	
	private EnumEtiquetas enmEtiDescripcion;
	
	private EnumConfiguracion enmCnfNombreImpresora;
	
	private EnumTiposImpresora(String pStrAbreviatura,
								 EnumEtiquetas pEnmEtiDescripcion,
								 EnumConfiguracion enmCnfNombreImpresora){
		
		this.setStrAbreviatura(pStrAbreviatura);
		this.setEnmEtiDescripcion(pEnmEtiDescripcion);
		this.setEnmCnfNombreImpresora(enmCnfNombreImpresora);
	}

	public String getStrAbreviatura() {
		return strAbreviatura;
	}

	public void setStrAbreviatura(String strAbreviatura) {
		this.strAbreviatura = strAbreviatura;
	}

	public EnumEtiquetas getEnmEtiDescripcion() {
		return enmEtiDescripcion;
	}

	public void setEnmEtiDescripcion(EnumEtiquetas enmEtiDescripcion) {
		this.enmEtiDescripcion = enmEtiDescripcion;
	}

	public EnumConfiguracion getEnmCnfNombreImpresora() {
		return enmCnfNombreImpresora;
	}

	public void setEnmCnfNombreImpresora(EnumConfiguracion enmCnfNombreImpresora) {
		this.enmCnfNombreImpresora = enmCnfNombreImpresora;
	}
	
}

package co.com.codesa.clienteposslimgiros.enumeraciones;

import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum EnumImagenes{

	//Barra de herramientas
	BAR_CONFIRMAR("bar_confirmar"),//ok.png
	BAR_IMPRIMIR("bar_imprimir"),//impresora.png
	BAR_CONSULTAR("bar_consultar"),//search.png
	BAR_CERRAR("bar_cerrar"),//cerrar.png
	BAR_VOLVER("bar_volver"),//atras.png
	BAR_ANOTACIONES("bar_anotaciones"),//operacionInusual.png
	BAR_ANULAR("bar_anular"),//anular.png
	BAR_AYUDA("bar_ayuda"),//ayuda.png
	BAR_LIMPIAR("bar_limpiar"),//menuLimpiar.png
	
	//Operaciones ajenas a la barra de herramientas
	OP_MOSTRAR("op_mostrar"),//show.png
	OP_LIMPIAR("op_limpiar"),//limpiar.png
	OP_EDITAR("op_editar"),//editar.png
	OP_ELIMINAR("op_eliminar"),//eliminar.png
	OP_INGRESAR("op_ingresar"),//ingresar.png
	OP_CONSULTAR("op_consultar"),//consultar.png
	OP_COTIZAR("op_cotizar"),//cotizar.png
	
	//Alertas
	ALE_CONFIRMACION("ale_confirmacion"),//alertaConfirmacion
	ALE_INFORMACION("ale_informacion"),//alertaInformacion
	ALE_ADVERTENCIA("ale_advertencia"),//alertaAdvertencia
	ALE_ERROR("ale_error"),//alertaError
	
	//Imagenes de Aplicacion
	
	//Proceso Impresion
	APP_IMP_IMPRESORA_TMU("app_imp_impresora_tmu"),//Impresora_tmu.png
	APP_IMP_IMPRESORA_MC("app_imp_impresora_mc"),//impresora_mc.png
	
	//Proceso SuperCombo
	APP_SPC_IMAGEN("app_spc_imagen"),//inicio1.png
	APP_SPC_LOGO("app_spc_logo"),//superCombo2.png
	
	//Autenticacion
	APP_LOGO_SUPERGIROS("app_aut_imagen"),//inicio.png
	
	//Diligenciar fecha
	APP_BTN_CALENDARIO("app_btn_calendario"),//calendario.png
	
	//Biometria
	APP_BIO_MANO_DERECHA("app_bio_mano_derecha"),//manoDerecha.png
	APP_BIO_MANO_IZQUIERDA("app_bio_mano_izquierda"),//manoIzquierda.png
	APP_BIO_MANOS("app_bio_manos"),//manos.png
	APP_BIO_HUELLA("app_bio_huella"),//huella.png
	APP_BIO_HUELLA_CAPTURADA("app_bio_huella_capturada"),//huellaCapturada.png
	
	APP_POS_DOCUMENTO_ANVERSO("app_pos_documento_anverso"),
	APP_POS_DOCUMENTO_REVERSO("app_pos_documento_reverso"),
	APP_POS_CAPTURA_IMG("app_pos_captura_img")
	;
	
	private final String strNombrePropiedad;
	
	private String strNombreRecurso;
	
	private boolean booProcesado;
	
	private ImageIcon imgImagen;
	
	private EnumImagenes(String pStrNombrePropiedad){
		
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
			
			this.strNombreRecurso = EnumRecursosProperties.IMAGENES.getRsbRecurso().getString(this.getStrNombrePropiedad());
			
		}catch(Exception e){
			
			e.printStackTrace();
			this.strNombreRecurso=strNombrePropiedad;
			this.imgImagen = null;
		}
	}

	public String getStrNombreRecurso() {
		
		this.validaProcesado();
		
		return strNombreRecurso;
	}

	public void setStrNombreRecurso(String pStrNombreRecurso) {
		this.strNombreRecurso = pStrNombreRecurso;
	}

	public String getStrNombrePropiedad() {
		return strNombrePropiedad;
	}

	public ImageIcon getImgImagen() {
		
		String strBasePath;
		URL urlImagen;
		
		if	(	this.imgImagen	==	null)
		{
			this.validaProcesado();
			
			strBasePath= "/co/com/codesa/clienteposslimgiros/imagenes/";
			urlImagen = this.getClass().getResource(strBasePath+this.strNombreRecurso);

			if(urlImagen !=null){
				
				this.imgImagen = new ImageIcon(urlImagen);
			}
		}
		
		return this.imgImagen;
	}

	public void setImgImagen(ImageIcon imgImagen) {
		this.imgImagen = imgImagen;
	}
	
	public	Icon	obtenerIcono	(	)
	{
		return this.getImgImagen();
	}
	
	public	Icon	ajustarIcono	(	EnumDimensionesComponentes pEnmDimension	) 
	{
		Icon icon;
		
		if	(	pEnmDimension	!=	null	)
		{
			icon	=	this.ajustarIcono	(	pEnmDimension.getRectangulo().getSize()	);
		}	else	{
			
			icon	=	this.getImgImagen();
		}
		
		return icon;
	}
	
	public	Icon	ajustarIcono	(	Dimension pObjDimension	) 
	{
		Icon icon;
		
		if	(	pObjDimension	!=	null	)
		{
			icon	=	new ImageIcon	(	this.getImgImagen().getImage().getScaledInstance	(	pObjDimension.width, 
																									pObjDimension.height, 
																									Image.SCALE_AREA_AVERAGING
																								)
										);
		}	else	{
			
			icon	=	this.getImgImagen();
		}
		
		return icon;
	}
}

package co.com.codesa.clienteposslimgiros.vista.logica.Internacional.capturaDocumentos;

import java.awt.Dialog.ModalExclusionType;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.playtech.camera.Camera;
import com.playtech.camera.Picture;
import com.playtech.camera.util.Utilities;

import co.com.codesa.clienteposslimgiros.dto.capturaDocumentosInternacional.TipoImagenDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTipoImagenes;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaCapturaDocumentoInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGirosInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;

/**
 * 
 * ********************************************************************
 * @class	CapturaDocumentosInternacionalVistaLogica
 *		 	Clase encargada de gestionar el componente de 
 *			capturar las fotos para el documento de identificacion
 *			en el procesos de remesas internacionales
 * @author	stiven.garcia
 * @date  	27/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class CapturaDocumentosInternacionalVistaLogica {
	
	private String strNombreImagenDocumento;
	
	private String strNombreLadoDocumento;
	
	private String strRutaImagenes;
	
	private String strFormatoImagenes;
	
	private Camera camera;
	
	private Usuario objUsuario;
	
	private TipoImagenDTO objTipoImagenDto;
	
	private FormaCapturaDocumentoInternacional objFrmCapturaDocumento;

	
	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static CapturaDocumentosInternacionalVistaLogica instance;

	/**
	 * ********************************************************************
	 * @method CapturaDocumentosInternacionalVistaLogica
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author usuario
	 * @date   27/03/2018
	 * ********************************************************************
	 */
	private CapturaDocumentosInternacionalVistaLogica() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return CapturaDocumentosInternacionalVistaLogica
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author usuario
	 * @date   27/03/2018
	 * ********************************************************************
	 */
	public static CapturaDocumentosInternacionalVistaLogica getInstancia() throws Exception {

		if (instance == null) {

			instance = new CapturaDocumentosInternacionalVistaLogica();
		}

		return instance;
	}
	
	/**
	 * @method gestionarCapturaFotoDocumento
	 * 			Activa el funcionamiento de la camara que se encuentre  
	 * 			instalada en la maquina o equipo. 
	 * @param idTransaccion 
	 * 			Es el idTransaccion asociado al envio o pago 
	 * 			de remesa internacional
	 * @param identificacion
	 * 			Numero de identificacion de la persona que realiza 
	 * 			el envio o el pago de remesa internacional
	 * @param ladoDocumento
	 * 			El lado del documento para el cual se va tomar 
	 * 			la foto Anverso o Reverso
	 * @param objTipoImagenDto
	 * 			Objeto tipoImagen con los datos asociados a la captura de documento
	 * @param objFormaCapturaInternacional
	 * 			Objeto Forma que invoca la captura de fotos del documento
	 * @param objUsuario
	 * 			Objeto Usuario cajero 
	 * @return
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 */
    public boolean gestionarCapturaFotoDocumento(String idTransaccion, 
    											 String identificacion, 
    											 String ladoDocumento, 
    											 TipoImagenDTO objTipoImagenDto,
    											 Object objFormaCapturaInternacional,
    											 Usuario objUsuario) throws Exception{
 	   
    	try {
    		
    		setObjUsuario(objUsuario);
    		setStrRutaImagenes(InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getStrRutaCapturaInternacional());
    		setStrNombreImagenDocumento(ladoDocumento + "_" + idTransaccion + "_" + identificacion);
    		setStrNombreLadoDocumento(ladoDocumento); 
    		setObjTipoImagenDto(objTipoImagenDto);
    		setStrFormatoImagenes(EnumParametrosSistema.FORMATO_IMAGENES_DOCUMENTO_INTERNACIONAL.obtenerValorCadena());
    		objFrmCapturaDocumento = (FormaCapturaDocumentoInternacional)objFormaCapturaInternacional;
    		File directorio = new File(getStrRutaImagenes());
    		
        	if (!directorio.exists()) {
        		directorio.mkdirs();
        	}
        	
        	capturaFotoDocumento();
        	
		} catch (Exception e) {
			EnumMensajes.ERROR_GENERAL.desplegarMensaje(camera, EnumClasesMensaje.INFORMACION);
			System.err.println("No se logro obtener la foto del documento [ERROR: " + e.toString() + "]" );
			return false;
		}
    	
    	return true;
    }
    
    /**
     * @method 
     * 			Metodo encargado de abrir el frame e captura de documentos
     * 			para remesas internacionales
     * 
     * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     */
    private void capturaFotoDocumento() throws Exception{
    	
    	
    	String strDimensionImagenes     = EnumParametrosSistema.DIMENSION_IMAGENES_DOCUMENTO_INTERNACIONAL.obtenerValorCadena();
    	
    	final int ancho =  Integer.parseInt(strDimensionImagenes.split("\\|")[0]);
    	final int alto  =  Integer.parseInt(strDimensionImagenes.split("\\|")[1]);

    	if(camera != null){
    		camera.setVisible(true);
    	}else{
    		camera = new Camera.Builder(ancho,alto)
            .canChangeSize(false)
            .canChangeFormat(false)  
            .useMaxResolution(false)
            .onCompleteListener(new Camera.OnCompleteListener() {
                @Override
                public void onComplete(Camera camera, Picture picture) {
                    BufferedImage bytes = null;
                    try {
                        bytes = Utilities.base64ToImg(picture.getBase64(), picture.getFormat());                       
                        if(Utilities.SaveImg(bytes,getStrRutaImagenes(), getStrNombreImagenDocumento(), getStrFormatoImagenes(), 3, false)){
                        	EnumMensajes.TOMA_FOTO_EXITOSA.desplegarMensaje(camera, EnumClasesMensaje.INFORMACION);
                        	objFrmCapturaDocumento.getCmbTipoImagenDocumento().removeItem(getObjTipoImagenDto());                        	
                        	camera.setVisible(false);
                        }else{
                        	EnumMensajes.TOMA_FOTO_ERRONEA.desplegarMensaje(camera, EnumClasesMensaje.INFORMACION);
                        }
                        asignarResultadoImagen();
                    } catch (IOException ioEx) {
                        System.out.println("ERROR");
                    }catch (Exception e) {
                    	System.out.println("ERROR");
					}            
                }
 
                @Override
                public void onError(Camera camera, Exception error){
                	try {
                		EnumMensajes.TOMA_FOTO_ERRONEA.desplegarMensaje(camera, EnumClasesMensaje.INFORMACION);
					} catch (Exception e) {
						System.err.println("Error inesperado al lanzar el mensaje [" + e.getMessage() + "]");
					}            	
                }

				@Override
				public void onClose() {
					camera.setVisible(false);
					verificarSalirFrame();				
				}
            })
            .build();    	
    		camera.setAlwaysOnTop(true);
    		camera.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
    		camera.display();
    	}        
    }
    
    
    private void asignarResultadoImagen()throws Exception{
    	
    	if(this.getStrNombreLadoDocumento().equals(EnumTipoImagenes.IMG_ANVERSO_DOC.getEnumParametrosApp().getValorPropiedad())){
    		objFrmCapturaDocumento.setBooIsCapturaAnverso(true);
    		objFrmCapturaDocumento.getObjTerceroInternacional().setFilArchivoImgDocAnverso(new File(getStrRutaImagenes() + System.getProperty("file.separator") + getStrNombreImagenDocumento().concat(".").concat(getStrFormatoImagenes())));
    		objFrmCapturaDocumento.getObjTerceroInternacional().getFilArchivoImgDocAnverso().deleteOnExit();
    	}else if (this.getStrNombreLadoDocumento().equals(EnumTipoImagenes.IMG_REVERSO_DOC.getEnumParametrosApp().getValorPropiedad())){
    		objFrmCapturaDocumento.setBooIsCapturaReverso(true);
    		objFrmCapturaDocumento.getObjTerceroInternacional().setFilArchivoImgDocReverso(new File(getStrRutaImagenes() + System.getProperty("file.separator") + getStrNombreImagenDocumento().concat(".").concat(getStrFormatoImagenes())));
    		objFrmCapturaDocumento.getObjTerceroInternacional().getFilArchivoImgDocReverso().deleteOnExit();
    	} 
    	
		
		if(objFrmCapturaDocumento.getCmbTipoImagenDocumento().getItemCount() == 1) {
			EnumMensajes.TOMA_FOTO_TERMINADA.desplegarMensaje(objFrmCapturaDocumento, EnumClasesMensaje.INFORMACION);
		}
    	
    }
    
    private void verificarSalirFrame() {
    	if(getStrNombreLadoDocumento().equals(EnumTipoImagenes.IMG_ANVERSO_DOC.getEnumParametrosApp().getValorPropiedad())){
    		objFrmCapturaDocumento.setBooIsCapturaAnverso(true);
    	}else if (getStrNombreLadoDocumento().equals(EnumTipoImagenes.IMG_REVERSO_DOC.getEnumParametrosApp().getValorPropiedad())){
    		objFrmCapturaDocumento.setBooIsCapturaReverso(true);
    	} 
    }

	public String getStrNombreImagenDocumento() {
		return strNombreImagenDocumento;
	}

	public void setStrNombreImagenDocumento(String pStrNombreImagenDocumento) {
		strNombreImagenDocumento = pStrNombreImagenDocumento;
	}

	public String getStrNombreLadoDocumento() {
		return strNombreLadoDocumento;
	}

	public void setStrNombreLadoDocumento(String pStrNombreLadoDocumento) {
		strNombreLadoDocumento = pStrNombreLadoDocumento;
	}

	public String getStrRutaImagenes() {
		return this.strRutaImagenes;
	}

	public void setStrRutaImagenes(String pStrRutaImagenes) {
		this.strRutaImagenes = pStrRutaImagenes;
	}

	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}

	public TipoImagenDTO getObjTipoImagenDto() {
		return objTipoImagenDto;
	}

	public void setObjTipoImagenDto(TipoImagenDTO objTipoImagenDto) {
		this.objTipoImagenDto = objTipoImagenDto;
	}

	public String getStrFormatoImagenes() {
		return this.strFormatoImagenes;
	}

	public void setStrFormatoImagenes(String pStrFormatoImagenes) {
		this.strFormatoImagenes = pStrFormatoImagenes;
	}
	
	
	
	
	
}

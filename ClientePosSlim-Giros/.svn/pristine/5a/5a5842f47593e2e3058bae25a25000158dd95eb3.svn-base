package co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad;

import java.util.ArrayList;
import java.util.List;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ServicioClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDocumentos;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.claveSeguridad.EnumTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.EventoFormaPanelServicioAdicional;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaPanelClaveSeguridad;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IOperacionesClaveSeguridad;
import co.com.codesa.clienteposslimgiros.utilidades.documentos.UtilDocumentos;
import co.com.codesa.clienteposslimgiros.utilidades.serviciosAdicionales.claveSeguridad.UtilClaveSeguridad;
import co.com.codesa.clienteposslimgiros.vista.logica.serviciosAdicionales.claveSeguridad.ClaveSeguridadVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;

/**
 * ********************************************************************
 * @class  EventoFormaPanelTokenValidacion
 *		   Clase encargada de controlar los eventos de la forma panel 
 *		   (seccion), para integrar el proceso de token de validacion
 * @author hector.cuenca
 * @date   7/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPanelClaveSeguridad extends EventoFormaPanelServicioAdicional<ServicioClaveSeguridadDTO> implements IOperacionesClaveSeguridad{
	
	/**
	 * @variable frmPnlClaveSeguridad
	 * 			 Referencia al componente del cual se estan controlando los 
  	 * 		   	 eventos
	 */
	private FormaPanelClaveSeguridad frmPnlClaveSeguridad;
	
	/**
	 * @variable lstTiposClaveSeguridadPermitidos
	 * 			 Listado de los tipos de clave de seguridad permitidos
	 */
	private List<EnumTiposClaveSeguridad>	lstTiposClaveSeguridadPermitidos;
	
	/**
	 * ********************************************************************
	 * @method EventoFormaOfrecerClaveSeguridad
	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
	 * @param  pFrmPnlClaveSeguridad
	 * 		   Referencia al componente del cual se estan controlando los 
  	 * 		   eventos
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public EventoFormaPanelClaveSeguridad(FormaPanelClaveSeguridad pFrmPnlClaveSeguridad) throws Exception{
		
		super(pFrmPnlClaveSeguridad);
		this.frmPnlClaveSeguridad = pFrmPnlClaveSeguridad;
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception {
		
		this.getFrmPnlClaveSeguridad().getCmbValor().getLblObligatorio().aplicarObligatoriedad(true);
	}
	
	@Override
	protected Object[] obtenerListadoValoresServicio() throws Exception {
		
		return this.getLstTiposClaveSeguridadPermitidos().toArray();
	}

	@Override
	protected void incluirServicio(boolean pBooActivado) throws Exception {
		
		if(pBooActivado){
			
			UtilClaveSeguridad.getInstancia().ofrecerServicioClaveSeguridad(this, 
					  														this.getObjFacturaGiro(), 
					  														this.getEnmTipoOperacion(),
					  														null);
		}else{
			
			super.modificarEstadoServicio(pBooActivado, 
										  EnumEtiquetas.LBL_NO_SELECCIONADO);
			
			this.getObjFacturaGiro().setObjClaveSeguridad(null);
		}
	}
	
	@Override
	protected boolean validarDisponibilidadServicio() throws Exception {
		
		return UtilClaveSeguridad.getInstancia().validarDisponibilidadServicio(this);
	}
	
	@Override
	protected void validarServicio(FacturaGiro pObjFacturaGiro, 
								   EnumTiposOperaciones pEnmTipoOperacion,
								   ServicioClaveSeguridadDTO pObjDtoClaveSeguridad) throws Exception {
		
		Object objSeleccionarItem;
		String strIdTipoTerceroConvenio;
		boolean booOfrecer;
		boolean booServicioIncluido;
		boolean booFacturaPresentaClaveSeguridad;
		
		booServicioIncluido = false;
		booFacturaPresentaClaveSeguridad = false;
		
		if(UtilDocumentos.isDocumentoTipoEnum(pObjFacturaGiro.getDocumento(),
					  						  EnumDocumentos.FACTURA)){

			objSeleccionarItem = EnumEtiquetas.LBL_NO_SELECCIONADO;
			booOfrecer = false;
			
			if(pEnmTipoOperacion.equals(EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO)){

				booFacturaPresentaClaveSeguridad = this.verificarFacturaPresentaClaveSeguridad(pObjFacturaGiro);

				if	(	!booFacturaPresentaClaveSeguridad	)
				{
					booServicioIncluido = true;
					objSeleccionarItem	=	EnumEtiquetas.LBL_NO_APLICA;
				}
				
			}else{
				
				if(pObjFacturaGiro.getDocumento().getNaturaleza().equals(EnumParametrosApp.DOCUMENTO_NATURALEZA_NEGATIVA.getValorPropiedad())){

					if (pObjFacturaGiro.isExterno()) {//Pago externo - no aplica clave seguridad
						
						objSeleccionarItem = EnumEtiquetas.LBL_NO_APLICA;
					}else{
						
						booFacturaPresentaClaveSeguridad = this.verificarFacturaPresentaClaveSeguridad(pObjFacturaGiro);
						
						if	(	!booFacturaPresentaClaveSeguridad	)
						{
							booServicioIncluido = true;
							objSeleccionarItem	=	EnumEtiquetas.LBL_NO_APLICA;
						}
					}
				}else{

					strIdTipoTerceroConvenio = EnumParametrosSistema.ID_TIPO_TERCERO_CONVENIO.obtenerValorCadena();
					booFacturaPresentaClaveSeguridad = false;
					
					if (pObjFacturaGiro.getTerceroDestino().getTipoTecero().getId().equals(strIdTipoTerceroConvenio)) {
						
						objSeleccionarItem = EnumEtiquetas.LBL_NO_APLICA;

					}else {
						
						booOfrecer = true;
						
						if (pObjFacturaGiro.getObjClaveSeguridad() != null) {
						
							booFacturaPresentaClaveSeguridad = true;
						}
					}
				}
			}

			if(booFacturaPresentaClaveSeguridad){

				booServicioIncluido = true;
				objSeleccionarItem = pObjFacturaGiro.getObjClaveSeguridad().getEnmTipoClaveSeguridad();
			}

			this.setObjBooOfrecer(booOfrecer);
			this.setObjFacturaGiro(pObjFacturaGiro);
			this.setEnmTipoOperacion(pEnmTipoOperacion);

		}else{

			objSeleccionarItem = EnumEtiquetas.LBL_NO_APLICA;
		}

		super.modificarEstadoServicio(booServicioIncluido, 
									  objSeleccionarItem);
		
		if(this.getFrmPnlClaveSeguridad().getChkIncluir().isEnabled()
				&& this.getObjBooOfrecer()){
		
			this.incluirServicio(true);
		}
	}
	
	@Override
	protected boolean ejecutarServicio(FacturaGiro pObjFacturaGiro, 
									   EnumTiposOperaciones pEnmTipoOperacion,
									   ServicioClaveSeguridadDTO pObjDtoClaveSeguridad) throws Exception {
		
		boolean booVerifica;
		booVerifica = UtilClaveSeguridad.getInstancia().verificarClaveSeguridad(this, 
																				pObjFacturaGiro, 
																				pEnmTipoOperacion,
																				pObjDtoClaveSeguridad);
		return booVerifica;
	}
	
	/** 
	 * ********************************************************************
	 * @method verificarFacturaPresentaClaveSeguridad
	 * 		   Metodo encargado consultar y verificar si la factura recibida
	 * 		   presenta el servicio incluido de clave de seguridad
	 * @param  pObjFacturaGiro
	 * 		   Objeto factura que contiene todo el detalle de la transaccion 
	 * 		   que se esta llevando a cabo
	 * @return boolean
	 * 		   Bandera que identifica si la factura presenta el servicio
	 * 		   incluido de clave de seguridad
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   10/03/2016
	 * *********************************************************************
	 */
	private boolean verificarFacturaPresentaClaveSeguridad(FacturaGiro pObjFacturaGiro)throws Exception{
		
		return ClaveSeguridadVistaLogica.getInstance().consultarReferenciaTieneClaveSeguridad(super.getObjUsuario(), 
				   															   		  		  pObjFacturaGiro,
				   															   		  		  UtilClaveSeguridad.getInstancia().getHmTiposClaveSeguridad());
	}
	
	

	/**
	 * @method getLstTiposClaveSeguridadPermitidos
	 * 		   Metodo get del atributo lstTiposClaveSeguridadPermitidos
	 * @return List<EnumTiposClaveSeguridad>
	 *		   Valor del atributo lstTiposClaveSeguridadPermitidos devuelto
	 * @author hector.cuenca
	 * @date   4/03/2017
	 */
	public List<EnumTiposClaveSeguridad> getLstTiposClaveSeguridadPermitidos() {
		
		if	(	this.lstTiposClaveSeguridadPermitidos	==	null)
		{
			this.lstTiposClaveSeguridadPermitidos	=	new ArrayList<EnumTiposClaveSeguridad>();
		}
		
		return lstTiposClaveSeguridadPermitidos;
	}

	/**
	 * @method setLstTiposClaveSeguridadPermitidos
	 * 		   Metodo set del atributo lstTiposClaveSeguridadPermitidos
	 * @param  pLstTiposClaveSeguridadPermitidos
	 *		   Valor que tomara el atributo lstTiposClaveSeguridadPermitidos
	 * @author hector.cuenca
	 * @date   4/03/2017
	 */
	public void setLstTiposClaveSeguridadPermitidos(
			List<EnumTiposClaveSeguridad> pLstTiposClaveSeguridadPermitidos) {
		this.lstTiposClaveSeguridadPermitidos = pLstTiposClaveSeguridadPermitidos;
	}

	/**
	 * @method getFrmPnlClaveSeguridad
	 * 		   Metodo get del atributo frmPnlClaveSeguridad
	 * @return FormaPanelTokenValidacion
	 *		   Valor del atributo frmPnlClaveSeguridad devuelto
	 * @author hector.cuenca
	 * @date   7/03/2016
	 */
	public FormaPanelClaveSeguridad getFrmPnlClaveSeguridad() {
		return this.frmPnlClaveSeguridad;
	}

	/**
	 * @method setFrmPnlClaveSeguridad
	 * 		   Metodo set del atributo frmPnlClaveSeguridad
	 * @param  pFrmPnlClaveSeguridad
	 *		   Valor que tomara el atributo frmPnlClaveSeguridad
	 * @author hector.cuenca
	 * @date   7/03/2016
	 */
	public void setFrmPnlClaveSeguridad(
			FormaPanelClaveSeguridad pFrmPnlClaveSeguridad) {
		this.frmPnlClaveSeguridad = pFrmPnlClaveSeguridad;
	}
}

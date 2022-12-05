package co.com.codesa.clienteposslimgiros.eventos.operacioninusual;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio.EnumPeticionesMultiservicio;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.operacioninusual.FormaGestionReclamoInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.Internacional.reclamos.ReclamosInternacionalVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ReclamoInternacional;

public class EventoFormaGestionReclamoInternacional extends EventoAbstracto {
	
	/**
	 * @variable strAnotacion
	 * 		     nota para la operacion inusual
	 **/
	String strAnotacion;
	
	/**
	 * @variable lGestionReclamos
	 * 			 Lista de las opciones de reclamos disponibles
	 */
	private List<String> lGestionReclamos;

	public EventoFormaGestionReclamoInternacional(FormaGenerica pForma) {
		super(pForma);
	}

	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.cargarValoresGestionReclamos();

		this.castFrmGestionReclamo().getJcbGestionReclamos().getPropiedades().cargarCombo(lGestionReclamos.toArray(), 
																						  true, 
																						  EnumEtiquetas.LBL_NO_SELECCIONADO);		
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmGestionReclamo().getJcbGestionReclamos().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmGestionReclamo().getTxtNotas().getLblObligatorio().aplicarObligatoriedad(true);
	}

	@Override
	public void confirmar() throws Exception {
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios	(	super.getFrmForma(), 
				   														true, 
				   														true
				   													);
		
		this.strAnotacion = this.castFrmGestionReclamo().getTxtNotas().getText();
		
		ReclamoInternacional objReclamoInternacional = new ReclamoInternacional();
		objReclamoInternacional.setStrMensaje(this.strAnotacion);
		objReclamoInternacional.setStrDescripcion(this.castFrmGestionReclamo().getJcbGestionReclamos().getSelectedItem().toString());
		
		String strRespuesta = ReclamosInternacionalVistaLogica.getInstancia().registrarReclamoInternacional(getObjUsuario(),
																					  this.castFrmGestionReclamo().getObjFacturaGiroInternacional(),
																					  objReclamoInternacional,
																					  EnumPeticionesMultiservicio.GIN_REGISTRAR_RECLAMOS.getObjServicioPeticion());
		
		EnumMensajes.REGISTRO_RECLAMOS.desplegarMensaje(super.getFrmForma(), 
														   EnumClasesMensaje.INFORMACION, 
														   strRespuesta);
		
		
		
		super.regresarFormaPadre();
	}
	
	@Override
	public void cancelar() throws Exception {
		this.strAnotacion = null;
		super.regresarFormaPadre();
	}
	
	private void cargarValoresGestionReclamos() throws Exception{	
		
		
		hidratarListaGestionReclamos(EnumParametrosSistema.FPISA_DESCRIPCION_RECLAMO_1.obtenerValorCadena());
		hidratarListaGestionReclamos(EnumParametrosSistema.FPISA_DESCRIPCION_RECLAMO_2.obtenerValorCadena());
		hidratarListaGestionReclamos(EnumParametrosSistema.FPISA_DESCRIPCION_RECLAMO_3.obtenerValorCadena());
		hidratarListaGestionReclamos(EnumParametrosSistema.FPISA_DESCRIPCION_RECLAMO_4.obtenerValorCadena());
		hidratarListaGestionReclamos(EnumParametrosSistema.FPISA_DESCRIPCION_RECLAMO_5.obtenerValorCadena());
		hidratarListaGestionReclamos(EnumParametrosSistema.FPISA_DESCRIPCION_RECLAMO_6.obtenerValorCadena());
		hidratarListaGestionReclamos(EnumParametrosSistema.FPISA_DESCRIPCION_RECLAMO_7.obtenerValorCadena());
		hidratarListaGestionReclamos(EnumParametrosSistema.FPISA_DESCRIPCION_RECLAMO_8.obtenerValorCadena());
		hidratarListaGestionReclamos(EnumParametrosSistema.FPISA_DESCRIPCION_RECLAMO_9.obtenerValorCadena());
		hidratarListaGestionReclamos(EnumParametrosSistema.FPISA_DESCRIPCION_RECLAMO_10.obtenerValorCadena());
		hidratarListaGestionReclamos(EnumParametrosSistema.FPISA_DESCRIPCION_RECLAMO_11.obtenerValorCadena());
		hidratarListaGestionReclamos(EnumParametrosSistema.FPISA_DESCRIPCION_RECLAMO_12.obtenerValorCadena());
		
		Collections.sort(lGestionReclamos);
		
		for (int i = 0; i < lGestionReclamos.size(); i++) {
			System.out.println(lGestionReclamos.get(i));
		}
		
	}
	
	/**
	 *  @metodo hidratarListaGestionReclamos
  	 * 		   Metodo encargado de generar la lista de reclamos 
  	 * 		   consultada por parametro de sistema 
	 * @param listaReclamos 
	 * 		  Es una caena string de cada reclamo 
	 * 		  separado por caracter pipe
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @author Stiven.Garcia
	 */
	private void hidratarListaGestionReclamos(String listaReclamos)throws Exception{
		
		if(lGestionReclamos == null) {
			lGestionReclamos = new ArrayList<String>();
		}
		
		StringTokenizer stkReclamo = new StringTokenizer(listaReclamos, "|");
		while (stkReclamo.hasMoreElements()) {
			lGestionReclamos.add(stkReclamo.nextToken());
		}		
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castFrmGestionReclamo
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre frmForma
  	 * @return FormaGestionReclamoInternacional
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor StivenGarcia
  	 * ****************************************************************
  	 */
	public FormaGestionReclamoInternacional castFrmGestionReclamo()throws Exception{
		return (FormaGestionReclamoInternacional)super.getFrmForma();
	}

	public String getStrAnotacion() {
		return strAnotacion;
	}

	public void setStrAnotacion(String strAnotacion) {
		this.strAnotacion = strAnotacion;
	}
}
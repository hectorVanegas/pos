/** 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
package co.com.codesa.clienteposslimgiros.eventos.notas;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.notas.FormaGiroNotas;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.DatoEntidadVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.NotaVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;


/**
 * ****************************************************************.
 * @autor: CesarO.Rendon
 * @fecha: 19-mar-2015 
 * @descripcion: clase encargada de controlar todos los eventos y la 
 * 				 logica de la forma FormaGiroNotas.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaGiroNotas extends EventoAbstracto{
	
	private String strNota;
	private String strReferencia;
	private String strReferenciaTmp;
	private FacturaGiro objFactura;
	private FacturaGiro objFacturaTmp;
	private List<FacturaGiro> lstFacturas;



	/**
	 * ****************************************************************.
	 * @metodo: EventoFormaGiroNotas
	 * @descripcion: contructor del evento.
	 * @param formaGiroSolAutTerceros
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	public EventoFormaGiroNotas(FormaGenerica pForma){
		super(pForma);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarVentanaDesplegada
  	 * 		   Metodo utilizado para centralizar y desacoplar la accion
  	 * 		   inmediatamente despues de hacerse el despliegue de una 
  	 * 		   ventana, ideal para realizar implementaciones de focos
  	 * 		   iniciales
  	 * @param pEvtWindowOpened 
  	 * 		  Evento correspondiente a la ventana, sobre la cual se 
  	 * 		  produce esta accion 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		/**
		 * Seccion de Obliegatoridad de Campos
		 */
		this.castfrmGiroNotas().getTxtReferencia().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmGiroNotas().getCmbNuevaNota().getLblObligatorio().aplicarObligatoriedad(true);
		
		/**
		 * Seccion de foco
		 */
		this.castfrmGiroNotas().getTxtReferencia().requestFocus();
	}

	/**
	 * ****************************************************************.
	 * @metodo iniciarValores
	 * 		   Metodo que permite desacoplar y centralizar todo el 
	 * 		   despliegue logico inicial requerido por la funcionalidad 
	 * 		   una vez desplegada la GUI
	 * @param pArrObjParametrosForma
	 * 		  lista de parametros de forma, para un posible uso por parte
	 * 		  del despliegue inicial de valores
	 * 		  [x]: descripcion del valor enviado en la posicion [x]
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		this.strReferenciaTmp = "";
		this.llenarInformacionFormulario();
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo llenarInformacionFormulario
     * 			metodo utilizado para inicializar los datos de la forma 
     * 			envio giro postal
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void llenarInformacionFormulario()throws Exception{
		
		this.cargarDatosMsjPredeterminados();
		
	}
	
	/**
     * ****************************************************************
     * @throws  Exception
     * @metodo  cargarDatosMsjPredeterminados
     * 			metodo utilizado para cargar los datos al combo de 
     * 			mensajes predeterminados
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */	
	public void cargarDatosMsjPredeterminados()throws Exception{
		
		List<DatoEntidad> lMensajes;
		
		lMensajes = DatoEntidadVistaLogica.getInstance().consultarDatosPorEntidad(super.getObjUsuario(),
																				  EnumParametrosApp.ENT_ANOTACIONES_GIRO.getObjConstante());
		
		this.castfrmGiroNotas().getCmbNuevaNota().getPropiedades().cargarCombo(lMensajes.toArray(), 
												 							   true, 
												 							   EnumEtiquetas.LBL_NO_SELECCIONADO);
	}
	
	@Override
	public void accionarIngresoLiberado(Component pComponent,
										KeyEvent pEvtKeyReleased)throws Exception{
		
		if(pComponent.equals(this.castfrmGiroNotas().getTxtReferencia()) &&
				!this.strReferenciaTmp.equals(this.castfrmGiroNotas().getTxtReferencia().getText())){
			
			this.strReferenciaTmp = this.castfrmGiroNotas().getTxtReferencia().getText();
			this.limpiarInfo();
		}
	}

	/**
	 * ****************************************************************
	 * @throws Exception 
	 * @metodo confirmar
	 * 		   logica para actualizar la nota de una factura, 
	 * 		   validando datos obligatorios
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	@Override
	public void confirmar() throws Exception {
		boolean booActualizar;
		if (this.objFactura == null) {
			
			EnumMensajes.PRIMERO_DEBE_CONSULTAR.desplegarMensaje(super.getFrmForma(), 
																 EnumClasesMensaje.ADVERTENCIA);
			
		}else{
			
			UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmGiroNotas().getCmbNuevaNota(), 
																		this.castfrmGiroNotas().getLblNuevaNota().getTextoOriginal(), 
																		true, 
																		true);
			//se obtiene el  valor de la nota seleccinada
			strNota = this.castfrmGiroNotas().getCmbNuevaNota().getSelectedItem().toString();	
			
			//se envia mensaje de pregunta para confirmar si desea actualizar la nota
			booActualizar = EnumMensajes.NOTAS_ADICION_PREGUNTA.desplegarMensaje(super.getFrmForma(), 
											  							  		 EnumClasesMensaje.CONFIRMACION,
											  							  		 strNota,
											  							  		 objFactura.getReferenciaControl()).isOpcion();
			
			//si acepta los cambios
			if (booActualizar) {
				//se envia la trama de actualizacion notas de factura
				NotaVistaLogica.getInstance().actualizaNotasGiro(super.getObjUsuario(),
																 objFactura, 
																 strNota);
				//se muestra mensaje de exito
				EnumMensajes.NOTAS_INSERTADA_EXITO.desplegarMensaje(super.getFrmForma(), EnumClasesMensaje.INFORMACION, "");
				//se cierra la forma
				super.cerrarForma();			
			}
			
		}
	}
	
	/**
	 * ****************************************************************.
	 * @metodo consultar
	 * 		   valida y consulta la informacion del giro con la 
	 * 		   referencia ingresada en la forma.
	 * @throws Exception
	 * @autor  CesarO.Rendon
	 * ****************************************************************
	 */
	@Override
	public void consultar() throws Exception {
		//se limpia la informacion de la pantalla
		limpiarInfo();
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castfrmGiroNotas().getTxtReferencia(), 
			    													this.castfrmGiroNotas().getLblReferencia().getTextoOriginal(), 
			    													true, 
			    													true);
		//se obtiene el valor de refencia en la forma
		strReferencia=this.castfrmGiroNotas().getTxtReferencia().getText();	
		
		if (this.objFacturaTmp != null && this.objFacturaTmp.getReferenciaControl().equals(strReferencia)) {
		
			this.objFactura = this.objFacturaTmp;
		}else{
			//se envia la trama pra consultar la info del giro
			lstFacturas = GiroVistaLogica.getInstance().consultarInfoGiro(super.getObjUsuario(),
																		  strReferencia);

			//si la respuesta tiene una lista de giros
			if (this.lstFacturas!=null && !this.lstFacturas.isEmpty()) {
				this.objFactura = this.lstFacturas.get(0);
				//luego de tener la info del giro se consulta las notas que tiene el giro
				NotaVistaLogica.getInstance().consultaNotasGiro(super.getObjUsuario(),
																this.objFactura);
				this.objFacturaTmp = this.objFactura;
			}
		}
		
		//se llama al cargue de la info del giro
		cargarInfoGiro(this.objFactura);
		//selecciona el mensaje default
		this.castfrmGiroNotas().getCmbNuevaNota().setSelectedIndex(0);
		//deja el foco en el combo de mensajes
		this.castfrmGiroNotas().getCmbNuevaNota().requestFocus();
	}

	@Override
	public Window cerrarForma() throws Exception {
		
		boolean booSalir;
		
		if (this.objFactura != null) {	
			
			booSalir = EnumMensajes.NOTAS_CONFIRMA_SALIR.desplegarMensaje(super.getFrmForma(), 
																		  EnumClasesMensaje.CONFIRMACION,
																		  this.strNota,
																		  this.objFactura.getReferenciaControl()).isOpcion();
			//si responde que no desea salir
			if (!booSalir) {
				
				return null;
			}
			
		}
		
		return super.cerrarForma();
		
	}
	/**
	 * ****************************************************************.
	 * @throws Exception 
	 * @metodo: limpiarInfo
	 * @descripcion: limpia la informacion de la pantalla.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	private void limpiarInfo() throws Exception {
		this.castfrmGiroNotas().getTxtCodAgenOr().setText(null);
		this.castfrmGiroNotas().getTxtNomAgenOr().setText(null);
		this.castfrmGiroNotas().getTxtCodAgenDe().setText(null);
		this.castfrmGiroNotas().getTxtNomAgenDe().setText(null);
		this.castfrmGiroNotas().getTxtRemitente().setText(null);
		this.castfrmGiroNotas().getTxtBeneficiario().setText(null);
		this.castfrmGiroNotas().getTxtFechaGiro().setText(null);
		this.castfrmGiroNotas().getTxaNotas().setText(null);
		this.castfrmGiroNotas().getCmbNuevaNota().setSelectedIndex(0);
		this.objFactura = null;
		this.strNota = "";
	}

	/**
	 * ****************************************************************.
	 * @metodo: cargarInfoGiro
	 * @descripcion: carga la inforamcion de un giro en la forma.
	 * @param pFacturaGiro
	 * @throws Exception 
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	private void cargarInfoGiro(FacturaGiro pFacturaGiro) throws Exception {
		
		this.castfrmGiroNotas().getTxtCodAgenOr().setText(pFacturaGiro.getAgenciaOrigen().getCodigo());
		this.castfrmGiroNotas().getTxtNomAgenOr().setText(pFacturaGiro.getAgenciaOrigen().getNombre());
		this.castfrmGiroNotas().getTxtCodAgenDe().setText(pFacturaGiro.getAgenciaDestino().getCodigo());
		this.castfrmGiroNotas().getTxtNomAgenDe().setText(pFacturaGiro.getAgenciaDestino().getNombre());
		this.castfrmGiroNotas().getTxtRemitente().setText(pFacturaGiro.getTerceroOrigen().getNombres()+" "+pFacturaGiro.getTerceroOrigen().getApellido1());
		this.castfrmGiroNotas().getTxtBeneficiario().setText(pFacturaGiro.getTerceroDestino().getNombres()+" "+pFacturaGiro.getTerceroDestino().getApellido1());
		this.castfrmGiroNotas().getTxtFechaGiro().setText(pFacturaGiro.getFechasys());
		this.castfrmGiroNotas().getTxaNotas().append(pFacturaGiro.getObjNota().toString());	
	
	}

	/**
  	 * ****************************************************************.
  	 * @throws  Exception
  	 * @metodo  castfrmGiroNotas
  	 * 			Metodo estandar para formatear el tipo de dato general 
  	 * 			a un tipo especifico ("Casteo"), del atributo 
  	 * 			super.getFrmForma()
  	 * @return  FormaGiroNotas, valor especifico recuperado
  	 * @autor   Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaGiroNotas castfrmGiroNotas()throws Exception{
		return (FormaGiroNotas)super.getFrmForma();
	}

}

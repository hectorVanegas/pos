package co.com.codesa.clienteposslimgiros.formas.genericas;

import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.generico.promocion.EventoFormaPanelPropiedadesPeps;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.interfaces.promocion.IOperacionesPropiedades;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.propiedadesPeps.PropiedadesPepsVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;

/**
 * 
 * ********************************************************************
 * @class	FormaPanelPropiedadesPeps
 *		 	[TODO - DOC]: Descripcion de la clase, su intencion, 
 *		 	proposito y objetivo
 * @author	stiven.garcia
 * @date  	26/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPanelPropiedadesPeps extends FormaPanelDesplazableGenerico {
	
	/**
	 * @varibale serialVersionUID
	 */
	private static final long serialVersionUID = 4606143056761248600L;
	
	/**
	 * @variable 	tblPropiedadesPeps
	 * 			 	Grilla donde se concentra la gestion de promociones
	 */
	private	GrillaUtil	tblPropiedadesPeps;
	
	/**
	 * @variable 	cmbSeleccionRespuesta
	 * 			 	combo encargado de representar las
	 * 				posibles respuestas para las propiedades
	 */
	private CajaComboUtil cmbSeleccionRespuesta;
	
	/**
	 * @variable 	operaciones
	 */
	private IOperacionesPropiedades operaciones;

	/**
	 * 
	 * ********************************************************************
	 * @method	FormaPanelPropiedadesPeps
	 * 		  	[TODO - DOC]: Descripcion del metodo constructor, importante 
	 *		  	mencionar la intencion de una sobrecarga, el despliegue de 
	 *		  	comportamientos de interes y otros
	 * @param pFrmPadre
	 * 			Forma Padre de la forma a visualziar
	 * @param pEnmDimensionPanel
	 * 			Especifica las dimensiones del panel para ser visualizados en la forma
	 * @param pStrNombreComponente
	 * 			Nombre del componente a pitar en la forma
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	public FormaPanelPropiedadesPeps(FormaGenerica pFrmPadre,
							   		EnumDimensionesComponentes pEnmDimensionPanel,
							   		String pStrNombreComponente) throws Exception {
		
		super	(	pFrmPadre,
					pEnmDimensionPanel,
					pStrNombreComponente,
					null,
					null,
					null
				);
		
		super.setEvaControlEventos(new EventoFormaPanelPropiedadesPeps(this));
		this.setOperaciones(this.getEvaControlEventos());
		
		super.iniciar();
	}

	@Override
	protected void inicializarSeccionDesplazable() throws Exception {
		super.setBooAplicarTransparenciaFondo(false);
		this.setViewportView(this.iniciarPopTblPropiedadesPeps());
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	iniciarPopTblPropiedadesPeps
	 * 		  	[TODO - DOC]: Descripcion del metodo, cual es su uso, la 
	 * 		  	necesidad y su aporte y como se integra con la funcionalidad
	 * @return
	 * 			Grilla con las propiedades peps 
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	public GrillaUtil iniciarPopTblPropiedadesPeps() throws Exception{
		
		if(	tblPropiedadesPeps == null	) {
			
			this.tblPropiedadesPeps = UtilComponentesGUI.getInstance().crearGrilla( "tblPropiedadesPeps", 
																					new EnumEtiquetas[] {EnumEtiquetas.TTL_PPS_GRILLA_PEPS_CODIGO,
																										 EnumEtiquetas.TTL_PPS_GRILLA_PEPS_PROPIEDAD,
																										 EnumEtiquetas.TTL_PPS_GRILLA_PEPS_OBLIGATORIO,
																										 EnumEtiquetas.TTL_PPS_GRILLA_PEPS_EJEMPLO,
																										 EnumEtiquetas.TTL_PPS_GRILLA_PEPS_DETALLE
																										 },
																					null,
																					new boolean [] {false,
																									false,
																									false,
																									false,
																									true
																								   },
																					new int[] {10,
																							   200,
																							   10,
																							   10,
																							   50
																							  },
																					super.getEvaControlEventos());
		}
		
		return tblPropiedadesPeps;
		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	iniciarPropCmbRespuestaPropiedad
	 * 		  	metodo encargado de pintar el combo para la respuesta de las 
	 * 			porpiedades Peps
	 * @return
	 * 			CajaComboUtil con las posibles respuestas
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbRespuestaPropiedad() throws Exception{
		this.cmbSeleccionRespuesta = UtilComponentesGUI.getInstance().crearComboBox(null,
																					"cmbSeleccionRespuesta", 
																					true, 
																					true, 
																					super.getEvaControlEventos(), 
																					null);
		this.cmbSeleccionRespuesta.setBorder(BorderFactory.createEmptyBorder());
		this.cmbSeleccionRespuesta.setFocusable(false);
		
		return this.cmbSeleccionRespuesta;
		
	}	
	
	public GrillaUtil getTblPropiedadesPeps() {
		return tblPropiedadesPeps;
	}

	public void setTblPropiedadesPeps(GrillaUtil tblPropiedadesPeps) {
		this.tblPropiedadesPeps = tblPropiedadesPeps;
	}

	public CajaComboUtil getCmbSeleccionRespuesta() {
		return cmbSeleccionRespuesta;
	}

	public void setCmbSeleccionRespuesta(CajaComboUtil cmbSeleccionRespuesta) {
		this.cmbSeleccionRespuesta = cmbSeleccionRespuesta;
	}	

	public IOperacionesPropiedades getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(IOperacionesPropiedades pOperaciones) {
		this.operaciones = pOperaciones;
	}

	@Override
	public EventoFormaPanelPropiedadesPeps getEvaControlEventos() {
		return (EventoFormaPanelPropiedadesPeps)super.getEvaControlEventos();
	}
	
	public static void main(String[] args) {
		
		HashMap<String,Propiedad> lstPropiedad;
		Propiedad objPropiedad;
		
		try {
			
			JPanel panelContenido = new JPanel ();
			
			JDialog dialogo = new JDialog();
			FormaPanelPropiedadesPeps frmPropiedades;
			//frm.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			panelContenido.setLayout(null);
			dialogo.setBounds(0, 0, 900, 500);
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null, true, EnumDesplegarFormaConEventos.SI);
			
			List<Propiedad> lPropiedades = PropiedadesPepsVistaLogica.getInstance().consultarPropiedadesPeps(InformacionSessionGiros.getInstance().getObjUsuario());
			
			lstPropiedad = new HashMap<String,Propiedad>();
			
			for (Propiedad propiedad : lPropiedades) {
				lstPropiedad.put(propiedad.getStrCodigo(), propiedad);
			}
						
			frmPropiedades = new FormaPanelPropiedadesPeps( null ,
															EnumDimensionesComponentes.JPN_EGP_PANEL_CUERPO,
															"PropiedadesPeps"
														   );
			
			
			frmPropiedades.getOperaciones().adicionarPropiedades(lstPropiedad);
			
			panelContenido.add(frmPropiedades);
			
			dialogo.add(panelContenido);
			
			dialogo.setVisible(true);
			//frm.add(frmPropiedades);			
			//frm.setVisible(true);		
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}

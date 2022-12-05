package co.com.codesa.clienteposslimgiros.formas.genericas;

import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.gridpropiedadesconvenios.EventoFormaPanelPropiedadesTransmiteTirillas;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.interfaces.promocion.IOperacionesPropiedades;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.propiedadesPruebaAdmisionEntregaTirilla.PropiedadesPruebaAdmisionEntregaTirilla;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;

/**
 * 
 * ********************************************************************
 * @class	FormaPanelPropiedadesAdmisionEntregaTirilla
 *		 	Clase que presenta las propiedades del panel para 
 *          Prueba(evidencia) de entrega de Admision(Envio de giro)
 *          Entrega(pago del giro) de tirilla al cliente 
  * @author	dsalazar[PlayTech]
 * @date  	14-feb-2019
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPanelPropiedadesAdmisionEntregaTirilla extends FormaPanelDesplazableGenerico {
	
	/**
	 * @varibale serialVersionUID
	 */
	private static final long serialVersionUID = 4606143056761248600L;
	
	/**
	 * @variable 	tblPropiedadesTransmiteTirilla
	 * 			 	Grilla donde se concentra la gestion de promociones
	 */
	private	GrillaUtil	tblPropiedadesAdmisionEnviaTirilla;
	
	/**
	 * @variable 	cmbSeleccionRespuesta
	 * 			 	combo encargado de representar las
	 * 				posibles respuestas para las propiedades
	 */
	private CajaComboUtil cmbSeleccionRespuesta;
	
	/**
	 * @variable 	txtValor
	 * 			 	text encargado de capturar las
	 * 				posibles respuestas para las propiedades
	 */
	private CajaTextoUtil txtValor;
	
	/**
	 * @variable 	operaciones
	 */
	private IOperacionesPropiedades operaciones;

	/**
	 * 
	 * ********************************************************************
	 * @method	FormaPanelPropiedadesAdmisionEntregaTirilla
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
	 * @author	dsalazar[PlayTech]
	 * @date	14-feb-2019
	 * *********************************************************************
	 */
	public FormaPanelPropiedadesAdmisionEntregaTirilla(FormaGenerica pFrmPadre,
							   		EnumDimensionesComponentes pEnmDimensionPanel,
							   		String pStrNombreComponente) throws Exception {
		
		super	(	pFrmPadre,
					pEnmDimensionPanel,
					pStrNombreComponente,
					null,
					null,
					null
				);
		
		super.setEvaControlEventos(new EventoFormaPanelPropiedadesTransmiteTirillas(this));
		this.setOperaciones(this.getEvaControlEventos());
		
		super.iniciar();
	}

	@Override
	protected void inicializarSeccionDesplazable() throws Exception {
		super.setBooAplicarTransparenciaFondo(false);
		this.setViewportView(this.iniciarPopTblPropiedadesTransmisionTirilla());
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	iniciarPopTblPropiedadesTransmisionTirilla
	 * 		  	[TODO - DOC]: Descripcion del metodo, cual es su uso, la 
	 * 		  	necesidad y su aporte y como se integra con la funcionalidad
	 * @return
	 * 			Grilla con las propiedades transmision de tirilla 
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	dsalazar[PlayTech]
	 * @date	14-feb-2019
	 * *********************************************************************
	 */
	public GrillaUtil iniciarPopTblPropiedadesTransmisionTirilla() throws Exception{
		
		if(	tblPropiedadesAdmisionEnviaTirilla == null	) {
			
			this.tblPropiedadesAdmisionEnviaTirilla = UtilComponentesGUI.getInstance().crearGrilla( "tblPropiedadesAdmisionEnviaTirilla", 
																					new EnumEtiquetas[] {EnumEtiquetas.TTL_CRC_GRILLA_ADMENV_CODIGO,
																										 EnumEtiquetas.TTL_CRC_GRILLA_ADMENV_PROPIEDAD,
																										 EnumEtiquetas.TTL_CRC_GRILLA_ADMENV_OBLIGATORIO,
																										 EnumEtiquetas.TTL_CRC_GRILLA_ADMENV_EJEMPLO,
																										 EnumEtiquetas.TTL_CRC_GRILLA_ADMENV_DETALLE
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
		
		return tblPropiedadesAdmisionEnviaTirilla;
		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	iniciarPropCmbRespuestaPropiedad
	 * 		  	metodo encargado de pintar el combo para la respuesta de las 
	 * 			propiedades transmision de tirillas
	 * @return
	 * 			CajaComboUtil con las posibles respuestas
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	dalazar[PlayTech]
	 * @date	14-feb-2019
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbRespuestaPropiedad() throws Exception {
		this.cmbSeleccionRespuesta = UtilComponentesGUI.getInstance()
				.crearComboBox(null, "cmbSeleccionRespuesta", true, true,
						super.getEvaControlEventos(), null);
		this.cmbSeleccionRespuesta.setBorder(BorderFactory.createEmptyBorder());
		this.cmbSeleccionRespuesta.setFocusable(false);

		return this.cmbSeleccionRespuesta;

	}

	/*
	 * ********************************************************************
	 * @method	iniciarPropTxtValor
	 * 		  	metodo encargado de pintar el control textboox para la respuesta  
	 * 			de propiedades transmision de tirillas
	 * @return
	 * 			CajaTextoUtil con la respuesta
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	dalazar[PlayTech]
	 * @date	04-marzo-2019
	 * *********************************************************************
	 * */
	public CajaTextoUtil iniciarPropTxtValor(
			EnumDimensionesComponentes pEnmDimension, String pStrNombre)
			throws Exception {

		if (this.txtValor == null) {

			if (pEnmDimension == null) {
				pEnmDimension = EnumDimensionesComponentes.TXT_CRC_VALOR_PROPIEDAD;
			}

			if (pStrNombre == null || pStrNombre.trim().isEmpty()) {
				pStrNombre = "txtValor";
			}

			this.txtValor = UtilComponentesGUI.getInstance().crearTextField(
					pEnmDimension, pStrNombre, null, true, false, true,
					super.getEvaControlEventos(), null);

			this.txtValor.setToolTipText(EnumEtiquetas.TLT_CRC_VALOR_PROPIEDAD);
			this.txtValor.setEditable(true);
			this.txtValor.setFocusable(false);
		}
		return this.txtValor;
	}
	
	public GrillaUtil getTblPropiedadesAdmiGrillaUtil() {
		return tblPropiedadesAdmisionEnviaTirilla;
	}

	public void setTblPropiedadesAdmisionEnviaTirilla(
			GrillaUtil tblPropiedadesAdmisionEnviaTirilla) {
		this.tblPropiedadesAdmisionEnviaTirilla = tblPropiedadesAdmisionEnviaTirilla;
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
	public EventoFormaPanelPropiedadesTransmiteTirillas getEvaControlEventos() {
		return (EventoFormaPanelPropiedadesTransmiteTirillas)super.getEvaControlEventos();
	}
	
	public static void main(String[] args) {
		
		HashMap<String,Propiedad> lstPropiedad;
		Propiedad objPropiedad;
		
		try {
			
			JPanel panelContenido = new JPanel ();
			
			JDialog dialogo = new JDialog();
			FormaPanelPropiedadesAdmisionEntregaTirilla frmPropiedades;
			//frm.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			panelContenido.setLayout(null);
			dialogo.setBounds(0, 0, 900, 500);
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null, true, EnumDesplegarFormaConEventos.SI);
			
			
			List<Propiedad> lPropiedades = PropiedadesPruebaAdmisionEntregaTirilla.getInstance().consultarListaPropiedadTransmisionTirillas(InformacionSessionGiros.getInstance().getObjUsuario()); 
			
			lstPropiedad = new HashMap<String,Propiedad>();
			
			for (Propiedad propiedad : lPropiedades) {
				lstPropiedad.put(propiedad.getStrCodigo(), propiedad);
			}
						
			frmPropiedades = new FormaPanelPropiedadesAdmisionEntregaTirilla( null ,
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

	/**
	 * @return the txtValor
	 */
	public CajaTextoUtil getTxtValor() {
		return txtValor;
	}

	/**
	 * @param txtValor the txtValor to set
	 */
	public void setTxtValor(CajaTextoUtil txtValor) {
		this.txtValor = txtValor;
	}
	
	

}

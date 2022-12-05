package co.com.codesa.clienteposslimgiros.formas.operacioninusual;

import java.awt.Font;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaSenalAlertaInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EditorCeldaGrilla;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * 
 * ********************************************************************
 * @class	FormaSenalAlertaInternacional
 *		 	Forma para la gestion de senales alerta en giros internacionales
 * @author	roberth.matinez
 * @date  	02/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaSenalAlertaInternacional extends FormaGenerica {


	/**
	 * @variable	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable 	tblSenalesAlerta
	 * 			 	Grilla donde se concentra la gestion de senales alerta
	 */
	private	GrillaUtil	tblSenalesAlerta;
	
	/**
	 * @variable	txtSenalAlerta
	 * 			 	Caja de texto para ingresar el dato de cada promocion
	 */
	private CajaTextoUtil txtSenalAlerta;

	/**
	 * 
	 * ********************************************************************
	 * @method	FormaSenalAlertaInternacional
	 * 		  	Constructor de la forma para la gestion de senales alerta
	 * @param 	pFrmPadre
	 * 			ventana de la cual extiende esta forma
	 * @param 	pBooModal
	 * 			bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  	la ventana de la cual extiende
  	 * @param	pHmEditorCeldaSenalesAlerta
  	 * 			Listado de los componentes de edicion configurados y exclusivos 
	 * 			para cada senal alerta, indexado por el codigo de estas
	 * @throws 	Exception	
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.matinez
	 * @date	02/04/2018
	 * *********************************************************************
	 */
	public FormaSenalAlertaInternacional(FormaGenerica pFrmPadre,
										 boolean pBooModal,
										 HashMap<String,EditorCeldaGrilla>	pHmEditorCeldaSenalesAlerta) throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaSenalAlertaInternacional(this, pHmEditorCeldaSenalesAlerta));
		
		inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_GSA_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_GSA_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_GSA_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNVOLVER);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosEncabezado) throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosCuerpo) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_GSA_CUERPO,
																"pnlCuerpo",
	  													 		null,
	  													 		null,
	  													 		null);
		
		pnlCuerpo.add(this.iniciarPropTblSenalesAlerta().getScpContenedor());
		
		return pnlCuerpo;
	}
	
	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}
	
	/**
     * ****************************************************************
     * @method	iniciarPropTblSenalesAlerta
     * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	tblSenalesAlerta
     * @return 	GrillaUtil
     * 		   	Tabla gestionada
     * @throws 	Exception
     * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
     * @author 	roberth.martinez
     * @date   	02/04/2018
     * ****************************************************************
     */
	public GrillaUtil iniciarPropTblSenalesAlerta() throws Exception
	{
		if	(	this.tblSenalesAlerta	==	null	)
		{
			
			this.tblSenalesAlerta	=	UtilComponentesGUI.getInstance().crearGrilla	(	"tblSenalesAlerta",
															   							new EnumEtiquetas[]{EnumEtiquetas.TTL_GSA_GRILLA_CODIGO,
																					 	 					EnumEtiquetas.TTL_GSA_GRILLA_SENAL_ALERTA,
																					 	 					EnumEtiquetas.TTL_GSA_GRILLA_COMENTARIO},
																					 	null,//invisibles
																					 	new boolean[] {	false, 
																				   	   	   				false,
																				   	   	   				true},//editable por columna
																				   	   	new int[] {	30,
																			   	   	   				150,
																			   	   	   				100},//dimensiones
																			   	   	   	super.getEventoForma()//evento
																	    			);
			this.tblSenalesAlerta.getScpContenedorRound(EnumDimensionesComponentes.SCP_GSA_SENALES_ALERTA);
		}
		
		return this.tblSenalesAlerta;
	}
	
	/**
     * ****************************************************************
     * @method	iniciarPropTxtSenalAlerta
     * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtSenalAlerta
     * @return 	CajaTextoUtil
     * 		   	Caja de texto gestionada
     * @throws 	Exception
     * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
     * @author 	roberth.martinez
	 * @date	03/04/2018
     * ****************************************************************
     */
	public	CajaTextoUtil	iniciarPropTxtSenalAlerta	()	throws	Exception
	{
		String strFormatoIngreso;
		
		this.txtSenalAlerta	=	UtilComponentesGUI.getInstance().crearTextField	(null, 
																     		 	 "txtSenalAlerta", 
																     		 	 "",
																     		 	 true, 
																     		 	 true, 
																     		 	 true, 
																     		 	 super.getEventoForma(),
																     		 	 null);
		this.txtSenalAlerta.setBorder(BorderFactory.createEmptyBorder());
		
		/**
		 * La fuente (Font) recuperada de la grilla no funciona como se espera, sobre
		 * la caja de texto, por tal razon, para estandarizar la visual de las celdas,
		 * se personaliza la fuente de la caja de texto que se adjuntara a la celda de 
		 * ingreso, con 11 puntos como el equivalente al propuesto por la grilla
		 */
		this.txtSenalAlerta.setFont(this.txtSenalAlerta.getFont().deriveFont(Font.PLAIN, 11));
		
		this.txtSenalAlerta.setHorizontalAlignment(SwingConstants.CENTER);
		
		strFormatoIngreso = EnumExpresionesRegulares.INT_COMENTARIO_SENAL_ALERTA.getValor();

		this.txtSenalAlerta.getPropiedades().setControlFormatoIngreso(strFormatoIngreso);
		
		return this.txtSenalAlerta;
	}
	
	/**
	 * @method	getTblSenalesAlerta
	 * 		  	Metodo get del atributo tblSenalesAlerta
	 * @return	GrillaUtil
	 *		  	Valor del atributo tblSenalesAlerta devuelto
	 * @author	roberth.martinez
	 * @date  	2/04/2018
	 */
	public GrillaUtil getTblSenalesAlerta() {
		return tblSenalesAlerta;
	}

	/**
	 * @method	setTblSenalesAlerta
	 * 		  	Metodo set del atributo tblSenalesAlerta
	 * @param	pTblSenalesAlerta
	 * 			Valor que tomara el atributo tblSenalesAlerta
	 * @author	roberth.martinez
	 * @date	2/04/2018
	 */
	public void setTblSenalesAlerta(GrillaUtil pTblSenalesAlerta) {
		tblSenalesAlerta = pTblSenalesAlerta;
	}

	/**
	 * @method	getTxtSenalAlerta
	 * 		  	Metodo get del atributo txtSenalAlerta
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtSenalAlerta devuelto
	 * @author	roberth.martinez
	 * @date  	3/04/2018
	 */
	public CajaTextoUtil getTxtSenalAlerta() {
		return this.txtSenalAlerta;
	}

	/**
	 * @method	setTxtSenalAlerta
	 * 		  	Metodo set del atributo txtSenalAlerta
	 * @param	pTxtSenalAlerta
	 * 			Valor que tomara el atributo txtSenalAlerta
	 * @author	roberth.martinez
	 * @date	3/04/2018
	 */
	public void setTxtSenalAlerta(CajaTextoUtil pTxtSenalAlerta) {
		this.txtSenalAlerta = pTxtSenalAlerta;
	}

	/** 
	 * ********************************************************************
	 * @method 	main
	 * 		   	Metodo principal (main), para realizar una prueba de unidad
	 * 			de la forma
	 * @param 	args
	 * 			Cadena de argumentos demandada por el metodo principal (main)
	 * @author 	roberth.martinez
	 * @date   	25/03/2018
	 * *********************************************************************
	 */
	public static void main(String[] args) {
		
		try{
	    
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaSenalAlertaInternacional.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			HashMap<String,EditorCeldaGrilla>	hmEditorCeldaSenalesAlerta = new HashMap<String, EditorCeldaGrilla>();
			new FormaSenalAlertaInternacional(null,true, hmEditorCeldaSenalesAlerta);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}

}
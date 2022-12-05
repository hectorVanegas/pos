package co.com.codesa.clienteposslimgiros.formas.declaraionorigenesfondo;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.declaracionorigenfondos.EventoFormaDeclaracionOrigenFondos;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class FormaDeclaracionOrigenesFondos extends FormaGenerica{
	
	//Declaracion de componentes Graficos
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable lblDeseaIncluir
	 * 			 Etiqueta que anuncia y ofrece el servicio de token de validacion
	 */
	private EtiquetaUtil lblPregunta;
	
	/**
	 * @variable txtCodigoPlan
	 * 			 campo de texto sobre la forma que contiene el codigo del plan
	 **/
	private AreaTextoUtil txtRespuesta;
	
	
	public FormaDeclaracionOrigenesFondos(FormaGenerica pFrmPader, boolean pBooModal) throws Exception {
		super(pFrmPader, pBooModal);
		
		super.setEventoForma(new EventoFormaDeclaracionOrigenFondos(this));
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		super.setTituloForma(EnumEtiquetas.TTL_DOF_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_DOF_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_DOF_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNVOLVER);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI
				.getInstance()
				.crearPanel(
						EnumDimensionesComponentes.JPN_DOF_PANEL_ENCABEZADO,
						"pnlEncabezado",
					    null,
					    null,
					    null);
		
		pnlEncabezado.add(this.iniciarPropLblPregunta());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.JPN_DOF_PANEL_CUERPO,
																"pnlCuerpo",
		  													 	null,
		  													 	null,
		  													 	null);
		
		pnlCuerpo.add(this.iniciarPropTxtRespuesta());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		
		return null;
	}
	
	public EtiquetaUtil iniciarPropLblPregunta() throws Exception {
		if(this.lblPregunta == null) {
			this.lblPregunta = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_DOF_PREGUNTA, 
																	   	   "lblPregunta", 
																	   	   EnumEtiquetas.LBL_DOF_PREGUNTA,
																	   	   false,
																	   	   null,
																	   	   true);
		}
		return this.lblPregunta;
	}
	
	public AreaTextoUtil iniciarPropTxtRespuesta() throws Exception{
		
		
		this.txtRespuesta = UtilComponentesGUI.getInstance().crearTextArea(EnumDimensionesComponentes.TXT_DOF_RESPUESTA,
				   "txtRespuestaDOF", 
				   "", 
				   true, 
				   true, 
				   true, 
				   super.getEventoForma(),
				   EnumEtiquetas.LBL_DOF_RESPUESTA);

		this.txtRespuesta.setBorder(BorderFactory.createEmptyBorder());
		
		
		this.txtRespuesta.getScpContenedorRound(EnumDimensionesComponentes.TXA_AQC_NOTAS);
		return this.txtRespuesta;
	}

	/**
     * ****************************************************************
     * @method inicializarPanelEmpresaCaja
     * 		   metodo utilizado para inicializar el componente panel de 
     * 		   Empresa y caja
     * @return JPanel componente JPanel
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   4/3/2015
     * ****************************************************************
     */
	
	
	public static void main(String[] args) {
		try {
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null, 
					true, 
					EnumDesplegarFormaConEventos.SI);
			
			
			new FormaDeclaracionOrigenesFondos(null, true);
		} catch (Exception e) {
			Logger.getInstance().error(e.getMessage());
		}
	}
	
	public void setLblPregunta(EtiquetaUtil lblPregunta) {
		this.lblPregunta = lblPregunta;
	}
	
	public EtiquetaUtil getLblPregunta() {
		return lblPregunta;
	}
	
	public void setTxtRespuesta(AreaTextoUtil txtRespuesta) {
		this.txtRespuesta = txtRespuesta;
	}
	public AreaTextoUtil getTxtRespuesta() {
		return txtRespuesta;
	}

}

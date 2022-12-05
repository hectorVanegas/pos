package co.com.codesa.clienteposslimgiros.formas.convenio;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.convenio.EventoFormaConvenioPropiedades;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;

/**
 * ****************************************************************
 * @autor: Roberth Martinez Vargas
 * @fecha: 23-sep-2015
 * @descripcion: Clase para diligenciar las propiedades de un 
 *               convenio
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos 
 *             reservados.
 * ****************************************************************
 */

public class FormaConvenioPropiedades extends FormaGenerica{

	private EtiquetaUtil lblIdentificacion;
	private EtiquetaUtil lblNombre;
	private CajaTextoUtil txtIdentificacion;
	private CajaTextoUtil txtNombre;
	private CajaTextoUtil txtValorPropiedad;
	private GrillaUtil tblPropiedades;
	private JScrollPane scrTablaPropiedades;
	
	private static final long serialVersionUID = 1L;
	

	public FormaConvenioPropiedades(FormaGenerica pFrmPadre, 
									boolean pBooModal, 
									FacturaGiro pFacturaGiro) throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaConvenioPropiedades(this, 
																pFacturaGiro));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_CVP_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_CVP_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_CVP_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNVOLVER);
			
		super.iniciar(pArrObjParametrosForma);
		
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {

		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CVP_ENCABEZADO,
																	"pnlEncabezado",
		  														 	null,
		  														 	EnumEtiquetas.TTL_CVP_PNL_CONVENIO,
		  														 	null);
		pnlEncabezado.add(this.iniciarPropLblIdentificacion());
		pnlEncabezado.add(this.iniciarPropLblNombre());
		pnlEncabezado.add(this.iniciarPropTxtIdentificacion());
		pnlEncabezado.add(this.iniciarPropTxtNombre());
		
		return pnlEncabezado;
	} 

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CVP_CUERPO,
																"pnlCuerpo",
																BorderFactory.createEmptyBorder(),
		  													 	null,
		  													 	null);
		pnlCuerpo.add(this.iniciarPropScrTablaPropiedades());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblIdentificacion
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de Identificacion del convenio
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblIdentificacion() throws Exception{
		if (this.lblIdentificacion == null) {
			this.lblIdentificacion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CVP_IDENTIFICACION, 
																	   		 	 "lblIdentificacion", 
																	   		 	 EnumEtiquetas.LBL_CVP_IDENTIFICACION,
																	   		 	 false,
																	   		 	 null,
																	   		 	 true);
		}

		return this.lblIdentificacion;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblNombre
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de Nombre del convenio
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblNombre() throws Exception{
		if (this.lblNombre == null) {
			this.lblNombre = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_CVP_NOMBRE, 
																	 	 "lblNombre", 
																	 	 EnumEtiquetas.LBL_CVP_NOMBRE,
																	 	 false,
																	 	 null,
																	 	 true);
		}

		return this.lblNombre;
	}
	
	/**
     * ****************************************************************
     * @metodo iniciarPropTxtIdentificacion
     * 	       metodo utilizado para inicializar el componente text 
     * 		   para la identificacion del convenio
     * @return CajaTextoUtil componente CajaTextoUtil
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtIdentificacion() throws Exception{
		
		if(this.txtIdentificacion==null){
			
			this.txtIdentificacion = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CVP_IDENTIFICACION, 
																			     	 "txtIdentificacion", 
																			     	 "",
																			     	 true, 
																			     	 false, 
																			     	 true, 
																			     	 super.getEventoForma(),
																			     	 EnumEtiquetas.LBL_CVP_IDENTIFICACION);
			
		}
		
		return this.txtIdentificacion;
	}
	
	/**
     * ****************************************************************
     * @metodo iniciarPropTxtNombre
     * 	       metodo utilizado para inicializar el componente text 
     * 		   para el nombre del convenio
     * @return CajaTextoUtil componente CajaTextoUtil
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtNombre() throws Exception{
		
		if(this.txtNombre==null){
			
			this.txtNombre = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_CVP_NOMBRE, 
																	     	 "txtNombre", 
																	     	 "",
																	     	 true, 
																	     	 false, 
																	     	 true, 
																	     	 super.getEventoForma(),
																	     	 EnumEtiquetas.LBL_CVP_NOMBRE);
			
		}
		
		return this.txtNombre;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropScrTablaPropiedades
     * 		   metodo utilizado para inicializar el componente de 
     * 		   scrollPanel para la grilla de Propiedades
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public JScrollPane iniciarPropScrTablaPropiedades() throws Exception{
		
		if(this.scrTablaPropiedades==null){
			
			/*this.scrTablaPropiedades = UtilComponentesGUI.getInstance().crearScroll("scrTablaPropiedades",
																		  			EnumDimensionesComponentes.GRI_CVP_PROPIEDADES,
																		  			null);*/
			
			this.scrTablaPropiedades	=	this.iniciarPropTblPropiedades().getScpContenedorRound(EnumDimensionesComponentes.GRI_CVP_PROPIEDADES);
			
			this.scrTablaPropiedades.setBorder	(	BorderFactory.createTitledBorder(	null,
																						EnumEtiquetas.TTL_CVP_PNL_PROPIEDADES.toString(),
																						TitledBorder.CENTER,
																						TitledBorder.TOP
																					)
												);
			
			//this.scrTablaPropiedades.setViewportView(this.iniciarPropTblPropiedades());
		}
		
		return this.scrTablaPropiedades;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropTblPropiedades
     * 	 	   metodo utilizado para inicializar el componente de 
     * 		   grilla de propiedades
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public GrillaUtil iniciarPropTblPropiedades() throws Exception{
		
		//TableColumn objColumnaValor;
		
		if(this.tblPropiedades==null){
			
			this.tblPropiedades = UtilComponentesGUI.getInstance().crearGrilla("tblPropiedades",
																	       	   new EnumEtiquetas[]{EnumEtiquetas.TTL_CVP_GRILLA_PROPIEDAD,
																					    		   EnumEtiquetas.TTL_CVP_GRILLA_LISTAR,
																					    		   EnumEtiquetas.TTL_CVP_GRILLA_EJEMPLO,
																					    		   EnumEtiquetas.TTL_CVP_GRILLA_DETALLE},
																		       null,//invisibles
																		       new boolean[] {false, 
																							  false, 
																							  false, 
																							  true},//editable por columna
																			   new int[] {100,
																						  80,
																						  120,
																						  120},//dimensiones
																			   super.getEventoForma()//evento
																		  	   );
			
			this.tblPropiedades.getScpContenedorRound(EnumDimensionesComponentes.GRI_CVP_PROPIEDADES);
			
			/*objColumnaValor = this.tblPropiedades.getColumn(EnumEtiquetas.TTL_CVP_GRILLA_DETALLE.getValor());
			
			objColumnaValor.setCellEditor(new EditorCeldaGrilla(this.iniciarPropTxtValorPropiedad(),
										  						this));*/

		}
		
		return this.tblPropiedades;
	}
	
	/**
     * ****************************************************************
     * @metodo iniciarPropTxtValorPropiedad
     * 	       metodo utilizado para inicializar el componente text 
     * 		   para el valor de la propiedad
     * @return CajaTextoUtil componente CajaTextoUtil
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtValorPropiedad() throws Exception{
		
		//if(this.txtValorPropiedad==null){
			
			this.txtValorPropiedad = UtilComponentesGUI.getInstance().crearTextField(null, 
																	     		 	 "txtValorPropiedad", 
																	     		 	 "",
																	     		 	 true, 
																	     		 	 true, 
																	     		 	 true, 
																	     		 	 super.getEventoForma(),
																	     		 	 null);
			this.txtValorPropiedad.setBorder(BorderFactory.createEmptyBorder());
		//}
		
		return this.txtValorPropiedad;
	}

	public GrillaUtil getTblPropiedades() {
		return tblPropiedades;
	}

	public void setTblPropiedades(GrillaUtil tblPropiedades) {
		this.tblPropiedades = tblPropiedades;
	}

	public CajaTextoUtil getTxtValorPropiedad() {
		return txtValorPropiedad;
	}

	public void setTxtValorPropiedad(CajaTextoUtil txtValorPropiedad) {
		this.txtValorPropiedad = txtValorPropiedad;
	}

	public CajaTextoUtil getTxtIdentificacion() {
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(CajaTextoUtil txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
	}

	public CajaTextoUtil getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(CajaTextoUtil txtNombre) {
		this.txtNombre = txtNombre;
	}
	
	public static void main(String[] args) {
		
		try{
	        
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaConvenioPropiedades.class,
																   true, 
																   EnumDesplegarFormaConEventos.NO);
			new FormaConvenioPropiedades(null,
										 true, 
										 new FacturaGiro());
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}

}

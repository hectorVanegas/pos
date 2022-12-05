package co.com.codesa.clienteposslimgiros.formas.convenio;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.convenio.EventoFormaConvenioSedes;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTerritorio;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Convenio;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 07-abr-2015
 * @descripcion: Clase para consultar y seleccionar la sede de un convenio
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */

public class FormaConvenioSedes extends FormaGenerica{

	private static final long serialVersionUID = 1L;
	
	private GrillaUtil tblSedes;
	private JScrollPane scrTablaSedes;
	
	private Convenio convenio;
	private FormaPanelTerritorio pnlTerritorioUbicacionSede;
	
	public FormaConvenioSedes(FormaGenerica pFrmPadre, 
							  boolean pBooModal, 
							  Convenio pConvenio, 
							  Agencia pAgencia) throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		this.convenio = pConvenio;
		
		super.setEventoForma(new EventoFormaConvenioSedes(this));
		
		this.inicializarForma(pConvenio.getNombreCorto());
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_CVS_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_CVS_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_CVS_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNCONSULTAR,
								EnumBotonesEncabezado.BTNVOLVER);
			
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosEncabezado) throws Exception {
		
		JPanel pnlEncabezado;
		
		EnumEtiquetas.TTL_CVS_PNL_CONVENIO.setValor(String.valueOf(pArrObjParametrosEncabezado[0]));
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CVS_ENCABEZADO,
																	"pnlEncabezado",
		  														 	null,
		  														 	EnumEtiquetas.TTL_CVS_PNL_CONVENIO,
		  														 	null);
		
		pnlEncabezado.add(this.iniciarPropPnlTerritorioUbicacionSede());
		pnlEncabezado.add(this.iniciarPropScrTablaSedes());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosCuerpo) throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosPiePagina) throws Exception {
		return null;
	}
	
	/**
  	 * ****************************************************************
  	 * @metodo iniciarPropPnlTerritorioUbicacionSede
  	 *         Metodo estandar para autogestionar el valor del atributo
  	 *         pnlTerritorioUbicacionSede
  	 * @return JPanel, seccion de territorio y agencia origen gestionada
  	 * @throws Exception 
  	 * @autor  Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaPanelTerritorio iniciarPropPnlTerritorioUbicacionSede() throws Exception{
		
		if(this.pnlTerritorioUbicacionSede==null){
			
			this.pnlTerritorioUbicacionSede = new FormaPanelTerritorio("pnlTerritorioUbicacionSede",
																	   true,//pTitulos
					 												   true,//pTituloCombo
					 												   new String[]{"cmbDeptoSede",
																					"cmbMunicipioSede",
																					"cmbZonaSede"},
					 												   1,//pCategoria
					 												   true,//pAPartir
					 												   false,//pActivaAgencia
					 												   EnumDimensionesComponentes.PNL_CVS_TERRI_CONV_SEDE,//rectangulo
					 												   null);//deptoBase
			this.pnlTerritorioUbicacionSede.getLblTituloCombos().setText(EnumEtiquetas.LBL_CVS_CONV_SEDE.toString());
			this.pnlTerritorioUbicacionSede.habilitarComponenteCompleto(true);
		}
		
		return this.pnlTerritorioUbicacionSede;
		
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropScrTablaSedes
     * 		   metodo utilizado para inicializar el componente de 
     * 		   scrollPanel para la grilla de sedes
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public JScrollPane iniciarPropScrTablaSedes() throws Exception{
		
		if(this.scrTablaSedes==null){
			
			this.scrTablaSedes = UtilComponentesGUI.getInstance().crearScroll("scrTablaSedes",
																		  	  EnumDimensionesComponentes.GRI_CVS_SEDES,
																		  	  null);
			
			this.scrTablaSedes.setViewportView(this.iniciarPropTblSedes());
		}
		
		return this.scrTablaSedes;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropTblSedes
     * 	       metodo utilizado para inicializar el componente de grilla de sedes
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public GrillaUtil iniciarPropTblSedes() throws Exception{
		
		if(this.tblSedes==null){
			
			this.tblSedes = UtilComponentesGUI.getInstance().crearGrilla("tblSedes",
															   			 new EnumEtiquetas[]{EnumEtiquetas.TTL_CVS_TBL_SEDE_ID,
																					  		 EnumEtiquetas.TTL_CVS_TBL_SEDE_NOMBRE,
																					  		 EnumEtiquetas.TTL_CVS_TBL_SEDE_DIRECCION,
																					  		 EnumEtiquetas.TTL_CVS_TBL_SEDE_TELEFONOS,
																					  		 EnumEtiquetas.TTL_CVS_TBL_SEDE_CODIGO_EXTERNO,
																					  		 EnumEtiquetas.TTL_CVS_TBL_SEDE_IDENTIFICACION,
																					  		 EnumEtiquetas.TTL_CVS_TBL_SEDE_TERCERO,
																					  		 EnumEtiquetas.TTL_CVS_TBL_SEDE_PRECIO},
															   			 null,//invisibles
															   			 null,//editable por columna
																		 new int[] {30,
																					150,
																					200,
																					90,
																					150,
																					110,
																					110,
																					70},//dimensiones
															   		     super.getEventoForma()//evento
																		 );
		}
		
		return this.tblSedes;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castTxtEspecificacionAbierta
  	 * 		   Metodo estandar para formatear el tipo de dato general a
  	 * 		   un tipo especifico ("Casteo"), del atributo txtEspecificacionAbierta
  	 * @return CajaTextoUtil 
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaConvenioSedes castEvaFrmConvenioSedes()throws Exception{
		return (EventoFormaConvenioSedes)super.getEventoForma();
	}
	
	public FormaPanelTerritorio getPnlTerritorioUbicacionSede() {
		return pnlTerritorioUbicacionSede;
	}

	public void setPnlTerritorioUbicacionSede(
			FormaPanelTerritorio pnlTerritorioUbicacionSede) {
		this.pnlTerritorioUbicacionSede = pnlTerritorioUbicacionSede;
	}
	
	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public GrillaUtil getTblSedes() {
		return tblSedes;
	}

	public void setTblSedes(GrillaUtil tblSedes) {
		this.tblSedes = tblSedes;
	}
	
	public static void main(String[] args) {
		
		try{
	        
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaConvenioSedes.class,
																   false, 
																   EnumDesplegarFormaConEventos.SI);
			Convenio cnv = new Convenio();
            Tercero ter = new Tercero();
            ter.setIdentificacion("500000000");
            ter.setTipoIdentificacion(new DatoEntidad("8"));
            cnv.setTercero(ter);
            cnv.setNombreCorto("CONVENIO CDA");
			new FormaConvenioSedes(null, true, cnv, null);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}

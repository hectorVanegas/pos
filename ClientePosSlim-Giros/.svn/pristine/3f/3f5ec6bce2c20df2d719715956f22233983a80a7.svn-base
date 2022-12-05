package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import java.util.HashMap;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import co.com.codesa.clienteposslim.vista.JScrollPaneRound;
import co.com.codesa.clienteposslim.vista.JTableRound;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.eventos.componentesGUI.EventoCompGrillaUtil;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUI;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponentesObligatorios;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesGrilla;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;


/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 18-jun-2015 
 * @clase GrillaUtil
 * 		  Clase encargada de emular el comportamiento de un JTable
 * 		  adicionando una serie de aspectos y/o utilidades de interes
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class GrillaUtil extends JTableRound implements ComponenteGUI, ComponentesObligatorios{
	
	private static final long serialVersionUID = -1284688714974852986L;
	
	private RenderGrilla objRender;
	
	private ModeloGrilla objModelo;
	
	private TableRowSorter<TableModel> objOrdena;
	
	private PropiedadesGrilla propiedades;
	
	/**
	 * @variable evaCmpGrillaUtil 
	 * 			 realiza el control de todos los eventos asociados al
	 * 			 componente
	 **/
	private EventoCompGrillaUtil evaCmpGrillaUtil;
	
	private ObligatoriedadUtil lblObligatorio;
	
	public GrillaUtil(String pStrNombre,
					  EnumEtiquetas pArrEnmEtiquetas[],
					  boolean pArrBooColumnasEditables[],
					  EnumEtiquetas pArrEnmColumnasNoVisibles[],
					  int pArrIntTamanosColumnasPersonalizados[],
					  EventoAbstracto pEvento) throws Exception{
		
		super();
		
		this.inicializarAspectos(pStrNombre,
								 pArrEnmEtiquetas,
								 pArrBooColumnasEditables,
								 pArrEnmColumnasNoVisibles,
								 pArrIntTamanosColumnasPersonalizados,
								 pEvento,
								 EnumColores.TBL_FONDO_CABECERA,
								 EnumColores.TBL_FONDO_DEGRADADO_CABECERA,
								 EnumColores.GNRL_CONTORNO
								 );
	}
	
	private void inicializarAspectos(String pStrNombre,
									 EnumEtiquetas pArrEnmEtiquetas[],
			  						 boolean pArrBooColumnasEditables[],
			  						 EnumEtiquetas pArrEnmColumnasNoVisibles[],
			  						 int pArrIntTamanosColumnasPersonalizados[],
			  						 EventoAbstracto pEvento,
			  						 EnumColores pEnmColFondoCabecera,
			  						 EnumColores pEnmColFondoDegradadoCabecera,
			  						 EnumColores pEnmColContorno
			  						 )throws Exception{
		
		super.setColorContorno(pEnmColContorno.getColColor());
		super.setObjColFondoCabecera(pEnmColFondoCabecera.getColColor());
		super.setObjColFondoDegradadoCabecera(pEnmColFondoDegradadoCabecera.getColColor());
		
		this.inicializarModelo(pArrEnmEtiquetas,
				   			   pArrBooColumnasEditables);
		
		this.inicializarGrilla(pStrNombre,
							   pArrEnmColumnasNoVisibles,
							   pArrIntTamanosColumnasPersonalizados,
							   pEvento);
		
		this.inicializarEventos();
		this.inicializarRender();
		
		/**
		 * Se anula posiblidad de realizar ordenamiento sobre la grilla, dado algunos problemas
		 * cuando se intenta eliminar el registro de una grilla por medio de la fila seleccionada.
		 * 
		 * Una vez reconocido su comportamiento e interaccion con estos conceptos y se pretenda 
		 * habilitar nuevamente esta propiedad, se recomienda realizar una retrospectiva ajustando 
		 * las funcionalidades que usen grillas, ya que estas se pueden ver afectadas
		 */
		this.activarOrdenamiento(false);
		
		UtilidadesGiros.getInstance().setTransferHandlerComponet(this);
	}
	
	private void inicializarGrilla(String pStrNombre,
								   EnumEtiquetas pArrEnmColumnasNoVisibles[],
								   int pArrIntTamanosColumnasPersonalizados[],
								   EventoAbstracto pEvento)throws Exception{
		
		this.setName(pStrNombre);
		this.setColumnSelectionAllowed(false);
		//this.setOpaque(false);
		this.setRowHeight(18);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		/**
		 * deshabilitar propiedad para reorganizar columnas setReorderingAllowed
		 * se suspende el reordenamiento de columnas, hasta reconocer claramente su funcionamiento
		 * con respecto a los conceptos de modelo y vista de la grilla, ya que la reorganizacion
		 * estaba causando conflictos al recuperar el valor esperado de una celda.
		 * 
		 * Una vez reconocido su comportamiento e interaccion con estos conceptos y se pretenda 
		 * habilitar nuevamente esta propiedad, se recomienda realizar una retrospectiva ajustando 
		 * las funcionalidades que usen grillas, ya que estas se pueden ver afectadas
		 */
		this.getTableHeader().setReorderingAllowed(false);
		
		this.personalizarColumnasGrilla(pArrEnmColumnasNoVisibles,
	   									pArrIntTamanosColumnasPersonalizados);
		
		if(pEvento!=null){
			
			this.addMouseListener(pEvento);
			this.addKeyListener(pEvento);
			this.addFocusListener(pEvento);
			this.getSelectionModel().addListSelectionListener(pEvento);
		}	
		
		this.lblObligatorio = new ObligatoriedadUtil(null);
	}
	
	private void inicializarEventos()throws Exception{
		
		this.evaCmpGrillaUtil = new EventoCompGrillaUtil(this);
		this.addKeyListener(this.evaCmpGrillaUtil);
		this.propiedades = this.evaCmpGrillaUtil;
	}
	
	private void inicializarRender()throws Exception{
		
		this.objRender = new RenderGrilla();
		
		this.setDefaultRenderer(String.class, objRender);
		this.setDefaultRenderer(Object.class, objRender);
		this.setDefaultRenderer(Double.class, objRender);
		this.setDefaultRenderer(Long.class, objRender);
		this.setDefaultRenderer(Integer.class, objRender);
	}
	
	private void inicializarModelo(EnumEtiquetas pArrEnmEtiquetas[],
				 				   boolean pArrBooColumnasEditables[]){
			
		this.objModelo = new ModeloGrilla();
		
		this.objModelo.setColumnIdentifiers(pArrEnmEtiquetas);
		/*this.objModelo.setDataVector(pMatObjfilas, 
					 		 		 pArrStrEtiquetas);*/
		
		this.objModelo.setCanEdit(pArrBooColumnasEditables);
		this.setModel(this.objModelo);
	}
	
	public void activarOrdenamiento(boolean pBooActivarOrdenamiento)throws Exception{
		
		if(pBooActivarOrdenamiento){
			
			this.objOrdena = new TableRowSorter<TableModel>((DefaultTableModel)this.getModel());
			//this.getTableHeader().setToolTipText(EnumEtiquetas.TLP_CABECERA_GRILLA.toString());
			
		}else{
			
			this.objOrdena = null;
			//this.getTableHeader().setToolTipText(null);
		}
		
		this.setRowSorter(this.objOrdena);
	}
	
	private void personalizarColumnasGrilla(EnumEtiquetas columnasNoVisibles[], 
										    int tamanosColumnasPersonalizados[]) {
		TableColumn columna;
		int tamanoConsumido = 0;
		int tamanoColumna = 0;
		HashMap<String, EnumEtiquetas> hmColumnasNoVisibles = new HashMap<String, EnumEtiquetas>();

		if (columnasNoVisibles != null) {

			for (EnumEtiquetas nombre : columnasNoVisibles) {

				columna = this.getColumn(nombre.toString());

				columna.setResizable(false);
				columna.setMaxWidth(0);
				columna.setMinWidth(0);
				columna.setPreferredWidth(0);

				hmColumnasNoVisibles.put(nombre.toString(), nombre);
			}
		}

		if (tamanosColumnasPersonalizados != null) {

			// grilla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

			for (int i = 0; i < this.getColumnCount(); i++) {

				columna = this.getColumnModel().getColumn(i);

				if (!hmColumnasNoVisibles.containsKey(columna.getIdentifier())) {

					try {

						tamanoColumna = tamanosColumnasPersonalizados[tamanoConsumido];

						columna.setPreferredWidth(tamanoColumna);

						tamanoConsumido++;

					} catch (Exception e) {
						break;
					}
				}
			}
		}
	}
	
	@Override
	public ObligatoriedadUtil getLblObligatorio() {
		return lblObligatorio;
	}

	@Override
	public void setLblObligatorio(ObligatoriedadUtil lblObligatorio) {
		this.lblObligatorio = lblObligatorio;
	}
	
	@Override
	public void setVisible(boolean pBooVisible) {
		
		super.setVisible(pBooVisible);
		
		UtilComponentesGUI.getInstance().activaObligatoriedad(this, 
														  this.lblObligatorio);
	}
	
	@Override
	public void setEnabled(boolean pBooEnabled) {
		
		super.setEnabled(pBooEnabled);
		
		UtilComponentesGUI.getInstance().activaObligatoriedad(this, 
				  										  this.lblObligatorio);
	}
	
	@Override
	public void setValorContenido(Object pObjeto)throws Exception{}

	public RenderGrilla getObjRender() {
		return objRender;
	}

	public void setObjRender(RenderGrilla objRender) {
		this.objRender = objRender;
	}

	public ModeloGrilla getObjModelo() {
		return objModelo;
	}

	public void setObjModelo(ModeloGrilla objModelo) {
		this.objModelo = objModelo;
	}

	public TableRowSorter<TableModel> getObjOrdena() {
		return objOrdena;
	}

	public void setObjOrdena(TableRowSorter<TableModel> objOrdena) {
		this.objOrdena = objOrdena;
	}

	public PropiedadesGrilla getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(PropiedadesGrilla propiedades) {
		this.propiedades = propiedades;
	}

	@Deprecated
	@Override
	public void setToolTipText(String text) {
		super.setToolTipText(text);
	}
	
	@Override
	public void setToolTipText(EnumEtiquetas pEnmEtiquetas,
							   String ...pArrStrParametros){
		
		UtilidadesGiros.getInstance().setToolTipText(this, 
				 									 pEnmEtiquetas, 
				 									 pArrStrParametros);
	}
	
	public JScrollPane getScpContenedorRound(	EnumDimensionesComponentes	pObjRecDimension	) 
	{
		JScrollPane	scpContenedor;
		
		if	(	pObjRecDimension == null	)
		{
			scpContenedor	=	super.getScpContenedor();
			
		}	else	{
			
			scpContenedor	=	super.getScpContenedor	(	pObjRecDimension.getRectangulo()	);
		}
		
		return scpContenedor;
	}
	
	@Override
	protected	void	crearContenedor() 
	{
		JScrollPaneRound	scpComponente;
		
		try{
			
			scpComponente	=	new SeccionDesplazableUtil	(	null,//pEnmDimension, 
																"scp"+this.getName(),//pStrNombreComponente, 
																null,//pBorde, 
																null,//pIntJustificacionTitulo, 
																null//pEnmTitulo, 
																//pArrStrParametrosTitulo
															);
			super.setScpContenedor(scpComponente);
			
		}catch(Exception e){
			
			super.crearContenedor();
		}
	}
}

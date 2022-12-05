package co.com.codesa.clienteposslimgiros.utilidades.formas;

import java.awt.Component;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JTextFieldDateEditor;

import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;

/** 
 * ********************************************************************
 * @class  	UtilFormas
 *		   	Clase utilitaria relacionada con operaciones hacia las formas
 *			(GUI)
 * @author 	hector.cuenca
 * @date   	31/05/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilFormas {

	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static UtilFormas instance;

	/**
	 * ********************************************************************
	 * @method UtilFormas
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   31/05/2017
	 * ********************************************************************
	 */
	private UtilFormas() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return UtilFormas
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   31/05/2017
	 * ********************************************************************
	 */
	public static UtilFormas getInstancia() throws Exception {

		if (instance == null) {

			instance = new UtilFormas();
		}

		return instance;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	limpiarComponentes
	 * 		   	Metodo que permite limpiar el contenido diligenciado en el
	 * 			listado de componentes recibido, e incluyendo los sub componentes
	 * 			que estos puedan contener
	 * @param	pLstCmpExcluirLimpieza
	 * 			Listado de componentes que se excluiran del proceso de 
	 * 			limpieza
	 * @param 	pArrObjCmpGraficos
	 * 			Listado de componentes que se procesaran para limpiar su 
	 * 			contenido
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	public	void	limpiarComponentes	(	List<Component>	pLstCmpExcluirLimpieza,
											Component ... pArrObjCmpGraficos	
										)
			throws Exception
	{
		if	(	pArrObjCmpGraficos	!=	null	)
		{
			for	(	Component cmpGrafico	:	pArrObjCmpGraficos)
			{
				this.limpiarComponente	(	pLstCmpExcluirLimpieza,
											cmpGrafico
										);
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method 	limpiarComponente
	 * 		   	Metodo que permite limpiar el contenido del componente 
	 * 			recibido, e incluyendo los sub componentes que este pueda 
	 * 			contener
	 * @param	pLstCmpExcluirLimpieza
	 * 			Listado de componentes que se excluiran del proceso de 
	 * 			limpieza
	 * @param 	pObjCmpGrafico
	 * 			Componente que se procesara para limpiar su contenido
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	hector.cuenca
	 * @date   	5/06/2017
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	public	void	limpiarComponente	(	List<Component>	pLstCmpExcluirLimpieza,
											Component	pObjCmpGrafico	
										)	
			throws Exception
	{
		JComboBox	cmbListado;
		JTextComponent	txtCaja;
		JTable	tblGrilla;
		JScrollPane	scpSeccionDesplazable;
		JPanel	pnlSeccion;
		
		if	(	pObjCmpGrafico	!=	null	)
		{
			if	(		pLstCmpExcluirLimpieza	==	null
					||	pLstCmpExcluirLimpieza	!=	null
					&&	!pLstCmpExcluirLimpieza.contains(pObjCmpGrafico)
				)
			{
				if	(		pObjCmpGrafico	instanceof	JTextComponent
						&&	(txtCaja	=	((JTextComponent)pObjCmpGrafico)).isEditable()
						&&	txtCaja.isEnabled()
					)
				{
					if	(	pObjCmpGrafico	instanceof	JTextFieldDateEditor	)
					{
						((JTextFieldDateEditor)txtCaja).setDate(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim());
						
					}	else	{
						txtCaja.setText("");
					}
					
				}	else	if	(		pObjCmpGrafico	instanceof	JComboBox
									&&	(cmbListado	=	((JComboBox) pObjCmpGrafico)).isEnabled()
								)
				{
					if	(	pObjCmpGrafico	instanceof	CajaComboUtil	)
					{
						((CajaComboUtil) pObjCmpGrafico).getPropiedades().restablecer();
					}else{
						cmbListado.setSelectedIndex(0);
					}
					
				}	else	if	(	pObjCmpGrafico	instanceof	JPanel	)
				{
					pnlSeccion	=	(JPanel) pObjCmpGrafico;
					this.limpiarComponentes	(	pLstCmpExcluirLimpieza,
												pnlSeccion.getComponents()
											);
					
				}	else	if	(	pObjCmpGrafico	instanceof	JScrollPane	)
				{
					scpSeccionDesplazable	=	(JScrollPane) pObjCmpGrafico;
					
					this.limpiarComponentes	(	pLstCmpExcluirLimpieza,
												scpSeccionDesplazable.getViewport().getComponents()
											);
					
				}	else	if	(	pObjCmpGrafico	instanceof	JTable	)
				{
					tblGrilla	=	(JTable)pObjCmpGrafico;
					((DefaultTableModel)tblGrilla.getModel()).setNumRows(0);
					
					if	(		tblGrilla.getRowSorter()	!=	null
							//&&	tblGrilla.getRowSorter()	instanceof	TableRowSorter<?>
						)
					{
						tblGrilla.setRowSorter(null);
						//((TableRowSorter<TableModel>)tblGrilla.getRowSorter()).setRowFilter(RowFilter.andFilter(null));
					}
					
				}/*	else	{
					
					System.err.println(pObjCmpGrafico.getName()+": "+pObjCmpGrafico.getClass().getSimpleName());
				}*/
			}
		}
	}
}

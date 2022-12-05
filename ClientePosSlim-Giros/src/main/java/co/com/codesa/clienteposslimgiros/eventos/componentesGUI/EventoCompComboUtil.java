package co.com.codesa.clienteposslimgiros.eventos.componentesGUI;

import javax.swing.DefaultComboBoxModel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesCombo;


/**
 * ****************************************************************.
 * @autor Roberth Martinez Vargas
 * @fecha 23-oct-2015 
 * @clase EventoCompComboUtil
 * 		  Clase encargada de controlar los eventos de un componente 
 * 		  Combo
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoCompComboUtil extends EventoAbstracto implements PropiedadesCombo{
	
	/**
	 * @variable cmpComponenteTexto
	 * 			 referente al componente de texto del cual se estan 
	 * 			 controlando los eventos
	 **/
	private CajaComboUtil cmpComponenteCombo;
	
	/**
	 * @variable 	objValorInicial
	 * 			 	Elemento inicial sugerido para cuando se reinicie
	 * 				el componente sin restablecer sus valores
	 */
	private Object objValorInicial;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoCompTextoUtil (Constructor)
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pComponente
  	 * 		  referencia al componente de texto del cual se estan 
  	 * 		  controlando los eventos
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoCompComboUtil(CajaComboUtil pCajaComboUtil) throws Exception{
		
		this.cmpComponenteCombo = pCajaComboUtil;
	}

	@Override
	public	void	cargarCombo	(	Object 	pArrObjLista[],
									Boolean pObjBooIncluyeSeleccionarSinObservacion
								)	throws	Exception
	{
		this.cargar	(	pArrObjLista,
						pObjBooIncluyeSeleccionarSinObservacion
					);
		
		this.adicionarItemVacio	(	pObjBooIncluyeSeleccionarSinObservacion	);
		
		this.setObjValorInicial(this.cmpComponenteCombo.getSelectedItem());
	}
	
	@Override
	public	void	cargarCombo	(	Object[]	pArrObjLista,
									Boolean		pObjBooIncluyeSeleccionarSinObservacion,
									Object 		pObjValorInicial
								)	throws	Exception
	{
		Object objItemVacio;
		
		this.cargar	(	pArrObjLista,
						pObjBooIncluyeSeleccionarSinObservacion
					);
		
		objItemVacio	=	this.adicionarItemVacio	(	pObjBooIncluyeSeleccionarSinObservacion	);
		
		this.seleccionarValorInicial(	pArrObjLista,
										objItemVacio,
										pObjValorInicial
									);
		this.setObjValorInicial(this.cmpComponenteCombo.getSelectedItem());
	}
	
	private	void	seleccionarValorInicial	(	Object[]	pArrObjLista,
												Object 		objItemVacio,
												Object 		pObjValorInicial
											)	throws Exception
	{
		if	(	pObjValorInicial	==	null	)
		{
			if	(		pArrObjLista!=null	
					&&	pArrObjLista.length	==	1	)
			{
				pObjValorInicial	=	pArrObjLista[0];
				
			}else	if	(	objItemVacio	!=	null	)	
			{
				pObjValorInicial	=	objItemVacio;
			}
		}
		
		if	(	pObjValorInicial	!=	null	)
		{
			this.cmpComponenteCombo.setSelectedItem(null);
			this.cmpComponenteCombo.setSelectedItem(pObjValorInicial);
		}
	}
	
	private	void	cargar	(	Object	pArrObjLista[],
								Boolean pObjBooIncluyeSeleccionarSinObservacion
							)	throws Exception
	{
		DefaultComboBoxModel modelo;
		
		if(pArrObjLista!=null){
			modelo = new DefaultComboBoxModel(pArrObjLista);
		}else{
			modelo = new DefaultComboBoxModel();
		}
		
		this.cmpComponenteCombo.setModel(modelo);
	}
	
	private	Object	adicionarItemVacio	(	Boolean pObjBooIncluyeSeleccionarSinObservacion	)	throws Exception
	{
		Object objItemVacio;
		
		if	(	pObjBooIncluyeSeleccionarSinObservacion == null	)	
		{
			objItemVacio	=	null;
			
		}	else	{
			
			if	(	pObjBooIncluyeSeleccionarSinObservacion	)
			{
				objItemVacio	=	EnumEtiquetas.LBL_NO_SELECCIONADO;
				
			}	else	{
				
				objItemVacio	=	EnumEtiquetas.LBL_SIN_OBSERVACION;
			}
			
			this.cmpComponenteCombo.getDefaultComboBoxModel().insertElementAt(objItemVacio, 0);
		}
		
		return objItemVacio;
	}

	@Override
	public void removerListaCombo(Boolean pObjBooIncluyeSeleccionarSinObservacion)throws Exception{
		
		Object objValorXDefecto;
		
		if(pObjBooIncluyeSeleccionarSinObservacion!=null){
			
			if(pObjBooIncluyeSeleccionarSinObservacion.booleanValue()){
				
				objValorXDefecto = EnumEtiquetas.LBL_NO_SELECCIONADO; 
						
			}else{
				
				objValorXDefecto = EnumEtiquetas.LBL_SIN_OBSERVACION;
			}
			
		}else{
			
			objValorXDefecto = null;
		}
		
		this.cargarCombo(null, 
						 pObjBooIncluyeSeleccionarSinObservacion, 
						 objValorXDefecto);
	}

	@Override
	public	void	restablecer	()	
			throws Exception
	{
		if	(	this.getObjValorInicial()	==	null	)
		{
			this.cmpComponenteCombo.setSelectedIndex(0);
		}else{
			this.cmpComponenteCombo.setSelectedItem(this.getObjValorInicial());
		}
	}
	
	/**
	 * @method getObjValorInicial
	 * 		   Metodo get del atributo objValorInicial
	 * @return Object
	 *		   Valor del atributo objValorInicial devuelto
	 * @author hector.cuenca
	 * @date   9/06/2017
	 */
	public Object getObjValorInicial() {
		return objValorInicial;
	}

	/**
	 * @method setObjValorInicial
	 * 		   Metodo set del atributo objValorInicial
	 * @param  pObjValorInicial
	 *		   Valor que tomara el atributo objValorInicial
	 * @author hector.cuenca
	 * @date   9/06/2017
	 */
	public void setObjValorInicial(Object pObjValorInicial) {
		this.objValorInicial = pObjValorInicial;
	}

}

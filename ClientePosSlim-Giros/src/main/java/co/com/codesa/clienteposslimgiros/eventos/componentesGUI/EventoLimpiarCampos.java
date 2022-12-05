package co.com.codesa.clienteposslimgiros.eventos.componentesGUI;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;

/** 
 * ********************************************************************
 * @class 	EventoLimpiarCampos
 *		   	Clase que permite crear, inicializar y controlar los eventos
 *			generados exclusivamente para desencadenar operaciones de limpieza
 *			de formulario, forzadas por la edicion o interaccion del usuario
 *			con un componente particular del formulario 
 * @author 	hector.cuenca
 * @date   	8/06/2017
 * @copyright	Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public	class	EventoLimpiarCampos	implements	ItemListener,
												DocumentListener
{
	
	/**
	 * @variable	evaControlEventosForma
	 * 			 	Clase que controla los eventos de la forma
	 */
	private	EventoAbstracto	evaControlEventosForma;
	
	/**
	 * @variable	objCmpAccionaLimpieza
	 * 			 	Componente que desencadena la limpieza
	 */
	private Component	objCmpAccionaLimpieza;
	
	/**
	 * @variable 	arrObjCmpALimpiar
	 * 				Listado de componentes a limpiar cuando se accione el proceso
	 */
	private Component[]	arrObjCmpALimpiar;
	
	/** 
	 * ********************************************************************
	 * @method 	EventoLimpiarCampos
	 * 		   	Metodo constructor que se encarga de iniacializar los atributos
	 * 			requeridos para construir un objeto de esta clase
	 * @param 	pEvaControlEventosForma
	 * 			Clase que controla los eventos de la forma
	 * @param 	pObjCmpAccionaLimpieza
	 * 			Componente que desencadena la limpieza
	 * @param 	pArrObjCmpALimpiar
	 * 			Listado de componentes a limpiar cuando se accione el proceso
	 * @author 	hector.cuenca
	 * @date   	8/06/2017
	 * *********************************************************************
	 */
	public EventoLimpiarCampos	(	EventoAbstracto	pEvaControlEventosForma,
									Component	pObjCmpAccionaLimpieza,
									Component ...	pArrObjCmpALimpiar
								)
	{
		this.setEvaControlEventosForma(pEvaControlEventosForma);
		this.setObjCmpAccionaLimpieza(pObjCmpAccionaLimpieza);
		this.setArrObjCmpALimpiar(pArrObjCmpALimpiar);
	}
	
	@Override
	public void insertUpdate(DocumentEvent pEvtInsertUpdate) 
	{
		try 
		{
			this.getEvaControlEventosForma().limpiarXCampo	(	this.getObjCmpAccionaLimpieza(), 
																this.getArrObjCmpALimpiar()
															);
		} catch (Exception e) 
		{
			this.getEvaControlEventosForma().controlExcepcion(e);
		}
	}

	@Override
	public void removeUpdate(DocumentEvent pEvtRemoveUpdate) 
	{
		try 
		{
			this.getEvaControlEventosForma().limpiarXCampo	(	this.getObjCmpAccionaLimpieza(), 
																this.getArrObjCmpALimpiar()
															);
		} catch (Exception e) 
		{
			this.getEvaControlEventosForma().controlExcepcion(e);
		}
	}

	@Override
	public void changedUpdate(DocumentEvent pE) {}
	
	@Override
	public void itemStateChanged(ItemEvent pEvtItemStateChanged) {
		try 
		{
			this.getEvaControlEventosForma().limpiarXCampo	(	this.getObjCmpAccionaLimpieza(), 
																this.getArrObjCmpALimpiar()
															);
			
		} catch (Exception e) 
		{
			this.getEvaControlEventosForma().controlExcepcion(e);
		}
	}

	/**
	 * @method getEvaControlEventosForma
	 * 		   Metodo get del atributo evaControlEventosForma
	 * @return EventoAbstracto
	 *		   Valor del atributo evaControlEventosForma devuelto
	 * @author hector.cuenca
	 * @date   8/06/2017
	 */
	public EventoAbstracto getEvaControlEventosForma() {
		return evaControlEventosForma;
	}

	/**
	 * @method setEvaControlEventosForma
	 * 		   Metodo set del atributo evaControlEventosForma
	 * @param  pEvaControlEventosForma
	 *		   Valor que tomara el atributo evaControlEventosForma
	 * @author hector.cuenca
	 * @date   8/06/2017
	 */
	public void setEvaControlEventosForma(EventoAbstracto pEvaControlEventosForma) {
		this.evaControlEventosForma = pEvaControlEventosForma;
	}

	/**
	 * @method getObjCmpAccionaLimpieza
	 * 		   Metodo get del atributo objCmpAccionaLimpieza
	 * @return Component
	 *		   Valor del atributo objCmpAccionaLimpieza devuelto
	 * @author hector.cuenca
	 * @date   8/06/2017
	 */
	public Component getObjCmpAccionaLimpieza() {
		return objCmpAccionaLimpieza;
	}

	/**
	 * @method setObjCmpAccionaLimpieza
	 * 		   Metodo set del atributo objCmpAccionaLimpieza
	 * @param  pObjCmpAccionaLimpieza
	 *		   Valor que tomara el atributo objCmpAccionaLimpieza
	 * @author hector.cuenca
	 * @date   8/06/2017
	 */
	public void setObjCmpAccionaLimpieza(Component pObjCmpAccionaLimpieza) {
		this.objCmpAccionaLimpieza = pObjCmpAccionaLimpieza;
	}

	/**
	 * @method getArrObjCmpALimpiar
	 * 		   Metodo get del atributo arrObjCmpALimpiar
	 * @return Component []
	 *		   Valor del atributo arrObjCmpALimpiar devuelto
	 * @author hector.cuenca
	 * @date   8/06/2017
	 */
	public Component[] getArrObjCmpALimpiar() {
		return arrObjCmpALimpiar;
	}

	/**
	 * @method setArrObjCmpALimpiar
	 * 		   Metodo set del atributo arrObjCmpALimpiar
	 * @param  pArrObjCmpALimpiar
	 *		   Valor que tomara el atributo arrObjCmpALimpiar
	 * @author hector.cuenca
	 * @date   8/06/2017
	 */
	public void setArrObjCmpALimpiar(Component[] pArrObjCmpALimpiar) {
		this.arrObjCmpALimpiar = pArrObjCmpALimpiar;
	}
	
	
}

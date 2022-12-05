/*
 * Andres Cardenas.
 * Copyright  1998-2015 Codesa, Todos los derechos reservados.         
 */
package co.com.codesa.clienteposslimgiros.dto;

import org.w3c.dom.Node;

import co.com.codesa.clienteposslim.utilidades.Utilidades;

/**
 * ****************************************************************.
 * @autor: Andres Cardenas
 * @fecha: 10-mar-2015
 * @descripcion: Clase que representa un menu o un submenu del menu general.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class MenuDTO {

	private String nombreMenu;
	private String meneNemonic;
	private Node nodo;
	boolean habilitarInicio;
	private String id;
	
	
	public MenuDTO(String nombreMenu, String meneNemonic, Node nodo,String pHabilitarInicio, String pId) {
		this.nombreMenu = nombreMenu;
		this.meneNemonic = meneNemonic;
		this.nodo = nodo;
		
		if(pHabilitarInicio.equalsIgnoreCase("S")){
			this.habilitarInicio=true;
		}else {
			this.habilitarInicio=false;
		}
		
		if(!pId.equals("*") && Utilidades.esEntero(pId)){
			this.id= pId;
		}
		
	}
	
	public String getMeneNemonic() {
		return meneNemonic;
	}


	public void setMeneNemonic(String meneNemonic) {
		this.meneNemonic = meneNemonic;
	}


	public String getNombreMenu() {
		return nombreMenu;
	}
	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public Node getNodo() {
		return nodo;
	}
	public void setNodo(Node nodo) {
		this.nodo = nodo;
	}

	public boolean isHabilitarInicio() {
		return habilitarInicio;
	}

	public void setHabilitarInicio(boolean habilitarInicio) {
		this.habilitarInicio = habilitarInicio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}

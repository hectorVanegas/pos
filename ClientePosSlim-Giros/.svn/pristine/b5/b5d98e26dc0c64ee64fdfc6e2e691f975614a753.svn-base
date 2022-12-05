/*
 * Andres Cardenas.
 * Copyright  1998-2015 Codesa, Todos los derechos reservados.         
 */
package co.com.codesa.clienteposslimgiros.dto;

import co.com.codesa.clienteposslim.utilidades.Utilidades;
/**
 * ****************************************************************.
 * @autor: Andres Cardenas
 * @fecha: 10-mar-2015
 * @descripcion: Clase que representa un item del menu general.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class ItemDTO {
	
	private String nombre;
	private String mnemonic;
	private String forma;
	private String atajo;
	private boolean habilitarInicio;
	private String id;
	
	public ItemDTO(String nombre, String mnemonic, String forma,String pHabilitarInicio) {
		this.nombre = nombre;
		this.mnemonic = mnemonic;
		this.forma = forma;
		
		if(pHabilitarInicio.equalsIgnoreCase("S")){
			this.habilitarInicio=true;
		}else{
			this.habilitarInicio=false;
		}
		
	}
	
	public ItemDTO(){
		
	} 

	public String getMnemonic() {
		return mnemonic;
	}

	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}

	public String getForma() {
		return forma;
	}
	public void setForma(String forma) {
		this.forma = forma;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAtajo() {
		return atajo;
	}

	public void setAtajo(String atajo) {
		this.atajo = atajo;
	}

	public boolean isHabilitarInicio() {
		return habilitarInicio;
	}

	public void setHabilitarInicio(boolean habilitarInicio) {
		this.habilitarInicio = habilitarInicio;
	}
	
	public void setHabilitarInicio( String pHabilitarInicio) {

		if(pHabilitarInicio.equalsIgnoreCase("S")){
			this.habilitarInicio=true;
		}else{
			this.habilitarInicio=false;
		}
	}	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(!id.equals("*") && Utilidades.esEntero(id)){
			this.id= id;
		}
	}
	
}

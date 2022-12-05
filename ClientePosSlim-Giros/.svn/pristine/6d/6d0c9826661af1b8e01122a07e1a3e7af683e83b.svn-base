package co.com.codesa.clienteposslimgiros.utilidades.datosAdicionales;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.BorderFactory;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EditorCeldaGrilla;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoAdicional;
import co.com.codesa.codesawrappergiros.modelo.interfaces.giros.iObjetoUsaDatosAdicionales;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 25-sep-2015
 * @Clase UtilDatosAdicionales 
 * 		  Clase utilitaria relacionada con el uso de datos adicionales
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilDatosAdicionales {
	
	/**
  	 * ****************************************************************.
  	 * @metodo incorporarDatosSobre
  	 * 		   Permite incorporar al objeto, que usa el concepto de datos
  	 * 		   adicionales, un listado de estos datos
  	 * @param pObjUsaDatosAdicionales
  	 * 		  Objeto de negocio que usa el concepto de datos adicionales
  	 * @param pArrObjDatosAdicionales
  	 * 		  Listado de datos adicionales a incorporar sobre el objeto
  	 * 		  de negocio
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static void incorporarDatosSobre(iObjetoUsaDatosAdicionales pObjUsaDatosAdicionales,
									 		DatoAdicional ...pArrObjDatosAdicionales)throws Exception{
		
		List<String> lstLLaveDatosAdicionales;
		
		for(DatoAdicional objDatoAdicional : pArrObjDatosAdicionales){
			
			pObjUsaDatosAdicionales.getHmDatosAdicionales().put(objDatoAdicional.getStrId(), 
																objDatoAdicional);
			if(objDatoAdicional.getArrStrParteLLave()!=null){
				
				for(String strNombreLLave : objDatoAdicional.getArrStrParteLLave()){
				
					if(pObjUsaDatosAdicionales.getHmLLavesDatosAdicionales().containsKey(strNombreLLave)){
						
						lstLLaveDatosAdicionales = pObjUsaDatosAdicionales.getHmLLavesDatosAdicionales().get(strNombreLLave);
						
					}else{
						
						lstLLaveDatosAdicionales = new ArrayList<String>();
						pObjUsaDatosAdicionales.getHmLLavesDatosAdicionales().put(strNombreLLave,lstLLaveDatosAdicionales);
					}
					
					lstLLaveDatosAdicionales.add(objDatoAdicional.getStrId());
				}
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarUnicidad
  	 * 		   Permite validar la unicidad con respecto a los datos 
  	 * 		   adicionales de un objeto que usa datos adicionales, frente 
  	 * 		   a un listado de objetos que tambien usan estos, en caso de
  	 * 		   encontrar problemas con la unicidad, provocara una excepcion
  	 * 		   lanzando el respectivo mensaje y adjuntando a este la llave 
  	 * 		   por la cual se produjo la inconsistencia
  	 * @param pObjUsaDatosAdicionales
  	 * 		  Objeto que usa datos adicionales, y del cual se requiere 
  	 * 		  validar la unicidad con respecto a esos datos
  	 * @param pLstObjUsanDatosAdicionales
  	 * 		  Listado de objetos que usan datos adicionales, frente al cual
  	 * 		  se realizara la validacion de unicidad
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static void validarUnicidad(iObjetoUsaDatosAdicionales pObjUsaDatosAdicionales,
									   Collection<? extends iObjetoUsaDatosAdicionales> pLstObjUsanDatosAdicionales)throws Exception{
		
		DatoAdicional objDatAdiValidando;
		DatoAdicional objDatAdiSimilar;
		String strLLaveNoCumplida;
		boolean booDetectaDuplicidad;
		
		if(pLstObjUsanDatosAdicionales != null 
				&& !pLstObjUsanDatosAdicionales.isEmpty()
				&& pObjUsaDatosAdicionales != null
				&& pObjUsaDatosAdicionales.getHmLLavesDatosAdicionales() != null
				&& !pObjUsaDatosAdicionales.getHmLLavesDatosAdicionales().isEmpty()){
			
			if(pLstObjUsanDatosAdicionales.contains(pObjUsaDatosAdicionales)){
				
				for(iObjetoUsaDatosAdicionales objSimilar : pLstObjUsanDatosAdicionales){
					
					if(objSimilar.equals(pObjUsaDatosAdicionales)){
						
						for(List<String> lstLLave : pObjUsaDatosAdicionales.getHmLLavesDatosAdicionales().values()){
							
							booDetectaDuplicidad = true;
							strLLaveNoCumplida = "";
							
							for(String strParteLLave : lstLLave){
								
								objDatAdiValidando = pObjUsaDatosAdicionales.getHmDatosAdicionales().get(strParteLLave);
								objDatAdiSimilar = objSimilar.getHmDatosAdicionales().get(strParteLLave);
								
								if(!objDatAdiValidando.getObjValor().equals(objDatAdiSimilar.getObjValor())){
									
									booDetectaDuplicidad = false;
									break;
									
								}else{
									
									strLLaveNoCumplida+=objDatAdiValidando.getStrNombre()+" - ";
								}
							}

							if(booDetectaDuplicidad){
								
								throw EnumMensajes.DUPLICIDAD_EN_DATOS_ADICIONALES.generarExcepcion(EnumClasesMensaje.ERROR,
																									strLLaveNoCumplida.replaceAll("( - )$",""));
							}
						}
					}
				}
			}
		}
	}

	/**
  	 * ****************************************************************.
  	 * @metodo generarNombreBanco
  	 * 		   Crea el dato adicional NombreBanco e inicializa todas 
  	 * 		   las propiedades especificas que este demanda
  	 * @param pBooObligatorio
  	 * 		  Bandera que identifica si el dato adicional es obligatorio o
  	 * 		  no (true y false respectivamente)
  	 * @param pArrStrParteLLave
  	 * 		  Recibe el listado que representa a que llaves pertenecera
  	 * 		  este dato adicional, preparandolo para una validacion de
  	 * 		  unicidad.
  	 * 		  LLave: simboliza el armado de una estructura unica con 
  	 * 		         respecto a un conjunto de datos; similar los 
  	 * 				 conceptos de llave primaria e indice unico para las
  	 * 				 bases de datos relacionales
  	 * @return DatoAdicional
  	 * 		   Retorna el dato adicional generado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static DatoAdicional generarNombreBanco(boolean pBooObligatorio,
												   String ...pArrStrParteLLave) throws Exception{
		
		DatoAdicional objDatAdiNombreBanco;
		CajaTextoUtil objComponente = null;
		EditorCeldaGrilla objEditorCelda;
		
		objComponente = UtilComponentesGUI.getInstance().crearTextField(null, 
				 														"medPagTarjNombreBanco", 
				 														"",
				 														true, 
				 														true, 
				 														true, 
				 														null,
				 														null);
		objComponente.setBorder(BorderFactory.createEmptyBorder());
		objComponente.getPropiedades().setActivaMayusculaMinuscula(true);
		
		objEditorCelda = new EditorCeldaGrilla(objComponente, 
											   null);
		
		objDatAdiNombreBanco = new DatoAdicional("NOMBRE_BANCO",
			   									  EnumEtiquetas.TTL_DAT_ADI_NOMBRE_BANCO.toString(),
			   									  objComponente,
			   									  objEditorCelda,
			   									  pBooObligatorio);
		
		objDatAdiNombreBanco.setArrStrParteLLave(pArrStrParteLLave);
		
		return objDatAdiNombreBanco;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo generarCodigoAprobacion
  	 * 		   Crea el dato adicional CodigoAprobacion e inicializa todas 
  	 * 		   las propiedades especificas que este demanda
  	 * @param pBooObligatorio
  	 * 		  Bandera que identifica si el dato adicional es obligatorio o
  	 * 		  no (true y false respectivamente)
  	 * @param pArrStrParteLLave
  	 * 		  Recibe el listado que representa a que llaves pertenecera
  	 * 		  este dato adicional, preparandolo para una validacion de
  	 * 		  unicidad.
  	 * 		  LLave: simboliza el armado de una estructura unica con 
  	 * 		         respecto a un conjunto de datos; similar los 
  	 * 				 conceptos de llave primaria e indice unico para las
  	 * 				 bases de datos relacionales
  	 * @return DatoAdicional
  	 * 		   Retorna el dato adicional generado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static DatoAdicional generarCodigoAprobacion(boolean pBooObligatorio,
														String ...pArrStrParteLLave)throws Exception {
		
		DatoAdicional objDatAdiCodigoAprobacion;
		CajaTextoUtil objComponente = null;
		EditorCeldaGrilla objEditorCelda;
			
		objComponente = UtilComponentesGUI.getInstance().crearTextField(null, 
				 														"medPagTarjCodigoAprobacion", 
				 														"",
				 														true, 
				 														true, 
				 														true, 
				 														null,
				 														null);
		objComponente.setBorder(BorderFactory.createEmptyBorder());
		objComponente.getPropiedades().setActivaMayusculaMinuscula(true);
		objComponente.getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.CODIGO_APROBACION_TARJETAS_INGRESO.getValor());
		objComponente.getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.CODIGO_APROBACION_TARJETAS_FINAL.getValor());
		
		objEditorCelda = new EditorCeldaGrilla(objComponente, 
				   							   null);
		
		objDatAdiCodigoAprobacion = new DatoAdicional("COD_APROBACION",
													  EnumEtiquetas.TTL_DAT_ADI_CODIGO_APROBACION.toString(),
													  objComponente,
													  objEditorCelda,
													  pBooObligatorio);
		
		objComponente.setToolTipText(objDatAdiCodigoAprobacion.getStrNombre());
		
		objDatAdiCodigoAprobacion.setArrStrParteLLave(pArrStrParteLLave);
		
		return objDatAdiCodigoAprobacion;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo generarTipoTarjeta
  	 * 		   Crea el dato adicional TipoTarjeta e inicializa todas 
  	 * 		   las propiedades especificas que este demanda
  	 * @param pBooObligatorio
  	 * 		  Bandera que identifica si el dato adicional es obligatorio o
  	 * 		  no (true y false respectivamente)
  	 * @param pArrStrParteLLave
  	 * 		  Recibe el listado que representa a que llaves pertenecera
  	 * 		  este dato adicional, preparandolo para una validacion de
  	 * 		  unicidad.
  	 * 		  LLave: simboliza el armado de una estructura unica con 
  	 * 		         respecto a un conjunto de datos; similar los 
  	 * 				 conceptos de llave primaria e indice unico para las
  	 * 				 bases de datos relacionales
  	 * @return DatoAdicional
  	 * 		   Retorna el dato adicional generado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static DatoAdicional generarTipoTarjeta(boolean pBooObligatorio,
												   String ...pArrStrParteLLave) throws Exception{
		
		DatoAdicional objDatAdiTipoTarjeta;
		CajaComboUtil objComponente = null;
		EditorCeldaGrilla objEditorCelda;
		
		objComponente = UtilComponentesGUI.getInstance().crearComboBox(null,
		  	   	 												   	   "medPagTarjTipoTarjeta",
		  	   	 												   	   true, 
		  	   	 												   	   true, 
		  	   	 												   	   null,
		  	   	 												   	   EnumEtiquetas.TTL_DAT_ADI_TIPO_TARJETA);
		objComponente.setBorder(BorderFactory.createEmptyBorder());
		objComponente.getPropiedades().cargarCombo(EnumEtiquetas.VLR_DAT_ADI_TIPO_TARJETA.getValorArreglo(), 
												   true, 
												   EnumEtiquetas.LBL_NO_SELECCIONADO);
		
		objComponente.setFocusable(false);
		
		objEditorCelda = new EditorCeldaGrilla(objComponente, 
				   							   null);
		
		objDatAdiTipoTarjeta = new DatoAdicional("TIPO_TARJETA",
				   								  EnumEtiquetas.TTL_DAT_ADI_TIPO_TARJETA.toString(),
				   								  objComponente,
				   								  objEditorCelda,
				   								  pBooObligatorio);
		
		objDatAdiTipoTarjeta.setArrStrParteLLave(pArrStrParteLLave);
		
		return objDatAdiTipoTarjeta;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo generarTipoTarjeta
  	 * 		   Crea el dato adicional TipoTarjeta e inicializa todas 
  	 * 		   las propiedades especificas que este demanda
  	 * @param pBooObligatorio
  	 * 		  Bandera que identifica si el dato adicional es obligatorio o
  	 * 		  no (true y false respectivamente)
  	 * @param pArrStrParteLLave
  	 * 		  Recibe el listado que representa a que llaves pertenecera
  	 * 		  este dato adicional, preparandolo para una validacion de
  	 * 		  unicidad.
  	 * 		  LLave: simboliza el armado de una estructura unica con 
  	 * 		         respecto a un conjunto de datos; similar los 
  	 * 				 conceptos de llave primaria e indice unico para las
  	 * 				 bases de datos relacionales
  	 * @return DatoAdicional
  	 * 		   Retorna el dato adicional generado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static DatoAdicional generarTipoLista(boolean pBooObligatorio,
												   String ...pArrStrParteLLave) throws Exception{
		
		DatoAdicional objDatAdiTipoLista;
		CajaComboUtil objComponente = null;
		EditorCeldaGrilla objEditorCelda;
		
		objComponente = UtilComponentesGUI.getInstance().crearComboBox(null,
		  	   	 												   	   "cmbTipoLista",
		  	   	 												   	   true, 
		  	   	 												   	   true, 
		  	   	 												   	   null,
		  	   	 												   	   EnumEtiquetas.TTL_DAT_ADI_TIPO_TARJETA);
		objComponente.setBorder(BorderFactory.createEmptyBorder());
		objComponente.getPropiedades().cargarCombo(EnumEtiquetas.VLR_DAT_ADI_TIPO_TARJETA.getValorArreglo(), 
												   true, 
												   EnumEtiquetas.LBL_NO_SELECCIONADO);
		
		objComponente.setFocusable(false);
		
		objEditorCelda = new EditorCeldaGrilla(objComponente, 
				   							   null);
		
		objDatAdiTipoLista = new DatoAdicional("TIPO_LISTA",
				   								  EnumEtiquetas.TTL_DAT_ADI_TIPO_TARJETA.toString(),
				   								  objComponente,
				   								  objEditorCelda,
				   								  pBooObligatorio);
		
		objDatAdiTipoLista.setArrStrParteLLave(pArrStrParteLLave);
		
		return objDatAdiTipoLista;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo generarPin
  	 * 		   Crea el dato adicional Pin e inicializa todas las 
  	 * 		   propiedades especificas que este demanda
  	 * @param pBooObligatorio
  	 * 		  Bandera que identifica si el dato adicional es obligatorio o
  	 * 		  no (true y false respectivamente)
  	 * @param pArrStrParteLLave
  	 * 		  Recibe el listado que representa a que llaves pertenecera
  	 * 		  este dato adicional, preparandolo para una validacion de
  	 * 		  unicidad.
  	 * 		  LLave: simboliza el armado de una estructura unica con 
  	 * 		         respecto a un conjunto de datos; similar los 
  	 * 				 conceptos de llave primaria e indice unico para las
  	 * 				 bases de datos relacionales
  	 * @return DatoAdicional
  	 * 		   Retorna el dato adicional generado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static DatoAdicional generarPin(boolean pBooObligatorio,
										   String ...pArrStrParteLLave)throws Exception {
		
		DatoAdicional objDatAdiCodigoAprobacion;
		CajaTextoUtil objComponente = null;
		EditorCeldaGrilla objEditorCelda;
			
		objComponente = UtilComponentesGUI.getInstance().crearTextField(null, 
				 														"pin", 
				 														"",
				 														true, 
				 														true, 
				 														true, 
				 														null,
				 														null);
		objComponente.setBorder(BorderFactory.createEmptyBorder());
		objComponente.getPropiedades().setActivaMayusculaMinuscula(true);
		objComponente.getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO.getValor());
		objComponente.getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO.getValor());
		
		objEditorCelda = new EditorCeldaGrilla(objComponente, 
				   							   null);
		
		objDatAdiCodigoAprobacion = new DatoAdicional("PIN",
													  EnumEtiquetas.TTL_DAT_ADI_PIN.toString(),
													  objComponente,
													  objEditorCelda,
													  pBooObligatorio);
		
		objComponente.setToolTipText(objDatAdiCodigoAprobacion.getStrNombre());
		
		objDatAdiCodigoAprobacion.setArrStrParteLLave(pArrStrParteLLave);
		
		return objDatAdiCodigoAprobacion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo generarPinRemesas
  	 * 		   Crea el dato adicional Pin e inicializa todas las 
  	 * 		   propiedades especificas que este demanda
  	 * @param pBooObligatorio
  	 * 		  Bandera que identifica si el dato adicional es obligatorio o
  	 * 		  no (true y false respectivamente)
  	 * @param pArrStrParteLLave
  	 * 		  Recibe el listado que representa a que llaves pertenecera
  	 * 		  este dato adicional, preparandolo para una validacion de
  	 * 		  unicidad.
  	 * 		  LLave: simboliza el armado de una estructura unica con 
  	 * 		         respecto a un conjunto de datos; similar los 
  	 * 				 conceptos de llave primaria e indice unico para las
  	 * 				 bases de datos relacionales
  	 * @return DatoAdicional
  	 * 		   Retorna el dato adicional generado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 		  
  	 * @autor carlos.mora
  	 * ****************************************************************
  	 */
	public static DatoAdicional generarPinRemesas(boolean pBooObligatorio,
										   String ...pArrStrParteLLave)throws Exception {
		
		DatoAdicional objDatAdiCodigoAprobacion;
		CajaTextoUtil objComponente = null;
		EditorCeldaGrilla objEditorCelda;
			
		objComponente = UtilComponentesGUI.getInstance().crearTextField(null, 
				 														"pin", 
				 														"",
				 														true, 
				 														true, 
				 														true, 
				 														null,
				 														null);
		objComponente.setBorder(BorderFactory.createEmptyBorder());
		objComponente.getPropiedades().setActivaMayusculaMinuscula(true);
		objComponente.getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO_INTERNACIONAL.getValor());
		objComponente.getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO_INTERNACIONAL.getValor());
		
		objEditorCelda = new EditorCeldaGrilla(objComponente, 
				   							   null);
		
		objDatAdiCodigoAprobacion = new DatoAdicional("PIN",
													  EnumEtiquetas.TTL_DAT_ADI_PIN.toString(),
													  objComponente,
													  objEditorCelda,
													  pBooObligatorio);
		
		objComponente.setToolTipText(objDatAdiCodigoAprobacion.getStrNombre());
		
		objDatAdiCodigoAprobacion.setArrStrParteLLave(pArrStrParteLLave);
		
		return objDatAdiCodigoAprobacion;
	}
	
}

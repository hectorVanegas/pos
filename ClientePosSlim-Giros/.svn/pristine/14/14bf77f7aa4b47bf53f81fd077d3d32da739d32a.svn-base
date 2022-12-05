package co.com.codesa.clienteposslimgiros.utilidades.html;

import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumHtml;


/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 18-nov-2015
 * @Clase UtilHtml 
 * 		  Clase utilitaria relacionada con operaciones html
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilHtml {

	public static String generarEstructuraHtml(String pStrTexto,
											   int pIntConstantePosicion){
		
		pStrTexto = UtilHtml.removerEstructuraHtml(pStrTexto);

		pStrTexto = EnumHtml.TAG_ABRE_HTML.getStrValor() 
						+ pStrTexto
						+ EnumHtml.TAG_CIERRA_HTML.getStrValor();
		
		pStrTexto = pStrTexto.replaceAll("\n|\r", 
				 		 				 EnumHtml.TAG_SALTO_LINEA.getStrValor());
		
		pStrTexto = pStrTexto.replaceAll("\t", 
					 		 			 EnumHtml.TAG_TABULAR_LINEA.getStrValor());
		
		pStrTexto = UtilHtml.calcularHtmlHorizontalAlignment(pStrTexto,
															 pIntConstantePosicion);
		
		return pStrTexto;
	}
	
	public static String removerEstructuraHtml(String pStrTexto){
		
		if(pStrTexto!=null
				&& pStrTexto.contains(EnumHtml.TAG_ABRE_HTML.getStrValor())){
		
			pStrTexto = pStrTexto.replaceAll(EnumHtml.TAG_SALTO_LINEA.getStrValor(), 
					 						 "\n");

			pStrTexto = pStrTexto.replaceAll(EnumHtml.TAG_TABULAR_LINEA.getStrValor(), 
					 						 "\t");

			pStrTexto = pStrTexto.replaceAll("\\<[^>]*>", "");
		}
		
		return pStrTexto;
	}
	
	private static String calcularHtmlHorizontalAlignment(String pStrTexto,
												   int pIntConstantePosicion){
		EnumHtml enmHtml;

		if(pStrTexto.contains(EnumHtml.TAG_ABRE_HTML.getStrValor())){

			if(pIntConstantePosicion == SwingConstants.CENTER){
				
				enmHtml = EnumHtml.TAG_ALINEACION_CENTRO;

			}else if(pIntConstantePosicion == SwingConstants.RIGHT){
				
				enmHtml = EnumHtml.TAG_ALINEACION_DERECHA;

			}else if(pIntConstantePosicion == SwingConstants.LEFT){
				
				enmHtml = EnumHtml.TAG_ALINEACION_IZQUIERDA;
				
			}else{
				
				enmHtml = EnumHtml.TAG_ALINEACION_JUSTIFICADA;
			}

			pStrTexto = pStrTexto.replaceAll(EnumHtml.TAG_ALINEACION_CENTRO.getStrValor()+"|"
												+ EnumHtml.TAG_ALINEACION_DERECHA.getStrValor()+"|"
												+ EnumHtml.TAG_ALINEACION_IZQUIERDA.getStrValor(), 
											 "");

			pStrTexto = pStrTexto.replace(EnumHtml.TAG_ABRE_HTML.getStrValor(), 
										  EnumHtml.TAG_ABRE_HTML.getStrValor()+enmHtml.getStrValor());
		}

		return pStrTexto;
	}
}

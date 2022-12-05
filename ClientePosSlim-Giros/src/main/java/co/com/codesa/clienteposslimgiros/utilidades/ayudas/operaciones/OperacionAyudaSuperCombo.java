package co.com.codesa.clienteposslimgiros.utilidades.ayudas.operaciones;

import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesSuperCombo;

public class OperacionAyudaSuperCombo extends OperacionAyuda{

	public OperacionAyudaSuperCombo()throws Exception{
	
		super();
		this.gestionarSecciones();
	}
	
	private void gestionarSecciones()throws Exception{
		
		/**
		 * super.adicionar(this.construirSeccion'NOMBRE_DICIENTE_IDEA_CONTENIDO_AYUDA'());
		 */
		
		super.adicionar(this.construirSeccionComisionCajero());
		super.adicionar(this.construirSeccionCaptarCliente());
		super.adicionar(this.construirSeccionTelefonos());
		super.adicionar(this.construirSeccionImpresiones());
		super.adicionar(this.construirSeccionLineas());
		super.adicionar(this.construirSeccionRecuerde());
	}
	
	private SeccionUtil construirSeccionComisionCajero()throws Exception{
		
		SeccionUtil pnlSeccionAyuda;
		SeccionUtil pnlAnuncioPrincipal;
		SeccionUtil pnlResumen;
		EtiquetaUtil lblTitulo;
		EtiquetaUtil lblImgPropaganda;
		EtiquetaUtil lblImgLogo;
		EtiquetaUtil lblResumen;
		
		pnlSeccionAyuda = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_COMI_CAJERO,
																	  "pnlSeccionAyuda",
														  		   	  null,
														  		  	  null,
														  		  	  null);
		
		pnlSeccionAyuda.setName("PNL_AYU_SCM_COMI_CAJERO");
		
		pnlAnuncioPrincipal = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_COMI_CAJERO_TITULO,
																		  "pnlAnuncioPrincipal",
	  		   	  														  null,
	  		   	  														  null,
	  		   	  														  null);
		
		pnlResumen = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_COMI_CAJERO_RESUMEN,
																 "pnlResumen",
						  									     null,
						  									     null,
						  									     null);
		
		lblTitulo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_COMI_CAJERO_TITULO, 
															    "lblTitulo", 
															    EnumEtiquetas.LBL_AYU_SCB_COMI_CAJERO_TITULO, 
															    false, 
															    null, 
															    true);
		lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 32));
		lblTitulo.setForeground(new java.awt.Color(0, 0, 204));
		
		lblImgPropaganda = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_COMI_CAJERO_IMG_PROMO, 
			    													   "lblImgPropaganda", 
			    													   null, 
			    													   false, 
			    													   EnumImagenes.APP_SPC_IMAGEN.obtenerIcono(), 
			    													   true);
		
		lblImgLogo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_COMI_CAJERO_IMG_LOGO, 
		   													   	 "lblImgLogo", 
		   													   	 null, 
		   													   	 false, 
		   													   	 EnumImagenes.APP_SPC_LOGO.obtenerIcono(), 
		   													   	 true);
		
		lblResumen = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_COMI_CAJERO_RESUMEN, 
			    											     "lblResumen", 
			    											     EnumEtiquetas.LBL_AYU_SCB_COMI_CAJERO_RESUMEN, 
			    											     false, 
			    											     null, 
			    											     true);
		lblResumen.setHorizontalAlignment(SwingConstants.CENTER);
		lblResumen.setFont(new Font("Tahoma", 1, 12));
		//lblResumen.setFont(lblResumen.getFont().deriveFont(Font.BOLD));
		
		pnlAnuncioPrincipal.add(lblTitulo);
		pnlAnuncioPrincipal.add(lblImgPropaganda);
		pnlAnuncioPrincipal.add(lblImgLogo);
		pnlResumen.add(lblResumen);
		
		pnlSeccionAyuda.add(pnlAnuncioPrincipal);
		pnlSeccionAyuda.add(pnlResumen);
		
		return pnlSeccionAyuda;
	}
	
	private SeccionUtil construirSeccionCaptarCliente()throws Exception{
		
		SeccionUtil pnlSeccionAyuda;
		SeccionUtil pnlAnuncioPrincipal;
		SeccionUtil pnlResumen;
		EtiquetaUtil lblTitulo;
		EtiquetaUtil lblTituloDigame;
		EtiquetaUtil lblPreguntele;
		EtiquetaUtil lblPesitos;
		EtiquetaUtil lblDesea;
		EtiquetaUtil lblImgAceptar;
		EtiquetaUtil lblImgRechaza;
		EtiquetaUtil lblDependiendo;
		
		pnlSeccionAyuda = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_CAPTAR_CLIENTE,
																	  "pnlSeccionAyuda",
														  		   	  null,
														  		  	  null,
														  		  	  null);
		
		pnlSeccionAyuda.setName("PNL_AYU_SCM_CAPTAR_CLIENTE");
		
		pnlAnuncioPrincipal = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_CAPTAR_CLIENTE_TITULO,
																		  "pnlAnuncioPrincipal",
	  		   	  														  null,
	  		   	  														  null,
	  		   	  														  null);
		
		pnlResumen = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_CAPTAR_CLIENTE_RESUMEN,
																 "pnlResumen",
						  									     null,
						  									     null,
						  									     null);
		
		lblTitulo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_CAPTAR_CLIENTE_TITULO, 
															    "lblTitulo", 
															    EnumEtiquetas.LBL_AYU_SCB_CAPTAR_CLIENTE_TITULO, 
															    false, 
															    null, 
															    true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 20));
		lblTitulo.setForeground(new java.awt.Color(223, 35, 35));
		//lblTitulo.setBorder(BorderFactory.createEtchedBorder());
		
		lblTituloDigame = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_CAPTAR_CLIENTE_TT_DIGAME, 
			    												"lblTituloDigame", 
			    												EnumEtiquetas.LBL_AYU_SCB_CAPTAR_CLIENTE_DIGAME, 
			    												false, 
			    												null, 
			    												true);
		lblTituloDigame.setFont(new java.awt.Font("Tahoma", 1, 20));
		lblTituloDigame.setForeground(new java.awt.Color(0, 0, 204));
		
		lblPreguntele = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_CAPTAR_CLIENTE_PREGUNTELE, 
																 	"lblPreguntele", 
																 	EnumEtiquetas.LBL_AYU_SCB_CAPTAR_CLIENTE_PREGUNTELE, 
																 	false, 
																 	null, 
																 	true);
		lblPreguntele.setFont(new java.awt.Font("Tahoma", 1, 10));
		
		lblPesitos = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_CAPTAR_CLIENTE_PESITOS, 
				 										  	     "lblPesitos", 
				 										  	     EnumEtiquetas.LBL_AYU_SCB_CAPTAR_CLIENTE_PESITOS, 
				 										  	     false, 
				 										  	     null, 
				 										  	     true);
		
		lblPesitos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesitos.setHorizontalTextPosition(SwingConstants.CENTER);
		
		lblDesea = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_CAPTAR_CLIENTE_DESEA, 
		  	     											   "lblDesea", 
		  	     											   EnumEtiquetas.LBL_AYU_SCB_CAPTAR_CLIENTE_DESEA, 
		  	     											   false, 
		  	     											   null, 
		  	     											   true);
		
		lblDesea.setFont(new java.awt.Font("Tahoma", 1, 14));
		
		lblImgAceptar = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_CAPTAR_CLIENTE_IMG_ACEPTA, 
				   	 												"lblImgAceptar", 
				   	 												null, 
				   	 												false, 
				   	 												EnumImagenes.BAR_CONFIRMAR.ajustarIcono(EnumDimensionesComponentes.LBL_AYU_SCM_CAPTAR_CLIENTE_IMG_ACEPTA), 
				   	 												true);
		
		lblImgRechaza = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_CAPTAR_CLIENTE_IMG_RECHAZA, 
																	"lblImgRechaza", 
																	null, 
																	false, 
																	EnumImagenes.BAR_ANULAR.ajustarIcono(EnumDimensionesComponentes.LBL_AYU_SCM_CAPTAR_CLIENTE_IMG_RECHAZA), 
																	true);
		
		lblDependiendo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_CAPTAR_CLIENTE_DEPENDIENDO, 
				   													 "lblDependiendo", 
				   													 EnumEtiquetas.LBL_AYU_SCB_CAPTAR_CLIENTE_DEPENDIENDO, 
				   													 false, 
				   													 null, 
				   													 true);
		
		pnlAnuncioPrincipal.add(lblTitulo);
		pnlAnuncioPrincipal.add(lblTituloDigame);
		pnlResumen.add(lblPreguntele);
		pnlResumen.add(lblPesitos);
		pnlResumen.add(lblDesea);
		pnlResumen.add(lblImgAceptar);
		pnlResumen.add(lblImgRechaza);
		pnlResumen.add(lblDependiendo);
		pnlSeccionAyuda.add(pnlAnuncioPrincipal);
		pnlSeccionAyuda.add(pnlResumen);
		
		return pnlSeccionAyuda;
	}
	
	private SeccionUtil construirSeccionTelefonos()throws Exception{
		
		SeccionUtil pnlSeccionAyuda;
		SeccionUtil pnlAnuncioPrincipal;
		SeccionUtil pnlResumen;
		EtiquetaUtil lblTitulo;
		EtiquetaUtil lblValide;
		EtiquetaUtil lblMensajes;
		EtiquetaUtil lblTelRem;
		EtiquetaUtil lblTelDes;
		CajaTextoUtil txtTelRem;
		CajaTextoUtil txtTelDes;
		
		pnlSeccionAyuda = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_VAL_TELEFONO,
																	  "pnlSeccionAyuda",
	  		   	  													  null,
	  		   	  													  null,
	  		   	  													  null);

		pnlSeccionAyuda.setName("PNL_AYU_VAL_TELEFONO");

		pnlAnuncioPrincipal = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_VAL_TELEFONO_TITULO,
																	      "pnlAnuncioPrincipal",
							  											  null,
							  											  null,
							  											  null);

		pnlResumen = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_VAL_TELEFONO_RESUMEN,
																 "pnlResumen",
															     null,
															     null,
															     null);

		lblTitulo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_VAL_TELEFONO_TITULO, 
													  			"lblTitulo", 
													  			EnumEtiquetas.LBL_AYU_SCB_VAL_TELEFONO_TITULO, 
													  			false, 
													  			null, 
													  			true);
		lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 32));
		lblTitulo.setForeground(new java.awt.Color(0, 0, 204));
		
		lblValide = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_VAL_TELEFONO_VALIDE, 
	  															"lblValide", 
	  															EnumEtiquetas.LBL_AYU_SCB_VAL_TELEFONO_VALIDE, 
	  															false, 
	  															null, 
	  															true);
		lblValide.setFont(new Font("Tahoma", 1, 14));
		
		lblMensajes = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_VAL_TELEFONO_MENSAJES, 
																  "lblMensajes", 
																  EnumEtiquetas.LBL_AYU_SCB_VAL_TELEFONO_MENSAJES, 
																  false, 
																  null, 
																  true);
		lblMensajes.setFont(new Font("Tahoma", 1, 14));
		
		lblTelRem = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_VAL_TELEFONO_TEL_REM, 
				  											    "lblTelRem", 
				  											    EnumEtiquetas.LBL_AYU_SCB_VAL_TELEFONO_TEL_REM, 
				  											    false, 
				  											    null, 
				  											    true);
		lblTelRem.setFont(new Font("Tahoma", 1, 14));
		
		lblTelDes = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_VAL_TELEFONO_TEL_DES, 
				    									        "lblTelDes", 
				    									        EnumEtiquetas.LBL_AYU_SCB_VAL_TELEFONO_TEL_DES, 
				    									        false, 
				    									        null, 
				    									        true);
		lblTelDes.setFont(new Font("Tahoma", 1, 14));
		
		txtTelRem = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AYU_SCM_VAL_TELEFONO_TEL_REM, 
																	"txtTelRem", 
																	"", 
																	true, 
																	false, 
																	true, 
																	null,
																	null);
		
		txtTelDes = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AYU_SCM_VAL_TELEFONO_TEL_DES, 
																	"txtTelDes", 
																	"", 
																	true, 
																	false, 
																	true, 
																	null,
																	null);
				
		
		pnlAnuncioPrincipal.add(lblTitulo);
		pnlResumen.add(lblValide);
		pnlResumen.add(lblMensajes);
		pnlResumen.add(lblTelRem);
		pnlResumen.add(lblTelDes);
		pnlResumen.add(txtTelRem);
		pnlResumen.add(txtTelDes);
		pnlSeccionAyuda.add(pnlAnuncioPrincipal);
		pnlSeccionAyuda.add(pnlResumen);
		
		return pnlSeccionAyuda;
	}
	
	private SeccionUtil construirSeccionImpresiones()throws Exception{
		
		SeccionUtil pnlSeccionAyuda;
		SeccionUtil pnlResumen;
		EtiquetaUtil lblFinalice;
		EtiquetaUtil lblImprimien;
		BotonUtil btnAceptar;
		
		pnlSeccionAyuda = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_IMPRESIONES,
																	  "pnlSeccionAyuda",
	  		   	  													  null,
	  		   	  													  null,
	  		   	  													  null);

		pnlSeccionAyuda.setName("PNL_AYU_IMPRESIONES");

		pnlResumen = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_IMPRESIONES_RESUMEN,
															     "pnlResumen",
							  									 null,
							  									 null,
							  									 null);

	

		lblFinalice = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_IMPRESIONES_FINALICE, 
													  			  "lblFinalice", 
													  			  EnumEtiquetas.LBL_AYU_SCB_IMPRESIONES_FINALICE, 
													  			  false, 
													  			  null, 
													  			  true);
		lblFinalice.setFont(new Font("Tahoma", 1, 16));
		
		lblImprimien = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_IMPRESIONES_IMPRIMEN, 
	  			  												   "lblImprimien", 
	  			  												   EnumEtiquetas.LBL_AYU_SCB_IMPRESIONES_IMPRIMEN, 
	  			  												   false, 
	  			  												   null, 
	  			  												   true);
		lblImprimien.setFont(new Font("Tahoma", 1, 14));
		
		btnAceptar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AYU_SCM_IMPRESIONES_ACEPTAR, 
																 "btnAceptar", 
																 EnumEtiquetas.BTN_AYU_SCB_IMPRESIONES_ACEPTAR, 
																 true, 
																 true, 
																 null, 
																 null);
		btnAceptar.setFocusable(false);
		btnAceptar.setRolloverEnabled(false);

		pnlResumen.add(lblFinalice);
		pnlResumen.add(btnAceptar);
		pnlResumen.add(lblImprimien);
		pnlSeccionAyuda.add(pnlResumen);
		
		return pnlSeccionAyuda;
	}
	
	private SeccionUtil construirSeccionLineas()throws Exception{
		
		SeccionUtil pnlSeccionAyuda;
		SeccionUtil pnlResumen;
		EtiquetaUtil lblReclamo;
		String[] arrTelefonos;
		
		arrTelefonos = ValidacionesSuperCombo.getObjSuperCombo().getStrTelefonosAseguradora();
		pnlSeccionAyuda = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_TELE_LINEAS,
																	  "pnlSeccionAyuda",
	  		   	  													  null,
	  		   	  													  null,
	  		   	  													  null);

		pnlSeccionAyuda.setName("PNL_AYU_TELEFONOS_LINEAS");

		pnlResumen = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_TELE_LINEAS_RESUMEN,
															     "pnlResumen",
							  									 null,
							  									 null,
							  									 null);

	

		lblReclamo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_TELE_LINEAS_EFECTIVO, 
													  			  "lblReclamo", 
													  			  EnumEtiquetas.LBL_AYU_SCB_TELEFONOS_LINEAS, 
													  			  false, 
													  			  null, 
													  			  true, 
													  			  arrTelefonos);
		lblReclamo.setFont(new Font("Tahoma", 1, 14));
		
		pnlResumen.add(lblReclamo);

		pnlSeccionAyuda.add(pnlResumen);
		
		return pnlSeccionAyuda;
	}
	
	private SeccionUtil construirSeccionRecuerde()throws Exception{
		
		SeccionUtil pnlSeccionAyuda;
		SeccionUtil pnlAnuncioPrincipal;
		SeccionUtil pnlResumen;
		EtiquetaUtil lblTitulo;
		EtiquetaUtil lblAnula;
		
		pnlSeccionAyuda = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_RECUERDE,
																	  "pnlSeccionAyuda",
	  		   	  													  null,
	  		   	  													  null,
	  		   	  													  null);

		pnlSeccionAyuda.setName("PNL_AYU_RECUERDE");

		pnlAnuncioPrincipal = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_RECUERDE_TITULO,
																	      "pnlAnuncioPrincipal",
							  											  null,
							  											  null,
							  											  null);

		pnlResumen = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_SCM_RECUERDE_RESUMEN,
																 "pnlResumen",
															     null,
															     null,
															     null);

		lblTitulo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_RECUERDE_TITULO, 
													  			"lblTitulo", 
													  			EnumEtiquetas.LBL_AYU_SCB_RECUERDE_TITULO, 
													  			false, 
													  			null, 
													  			true);
		lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 28));
		lblTitulo.setForeground(new java.awt.Color(0, 0, 204));
		lblTitulo.setHorizontalAlignment(SwingConstants.HORIZONTAL);
		
		lblAnula = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_SCM_RECUERDE_ANULA, 
	  														   "lblAnula", 
	  														   EnumEtiquetas.LBL_AYU_SCB_RECUERDE_ANULA, 
	  														   false, 
	  														   null, 
	  														   true);
		lblAnula.setFont(new Font("Tahoma", 1, 12));
		
		
				
		
		pnlAnuncioPrincipal.add(lblTitulo);
		pnlResumen.add(lblAnula);
		pnlSeccionAyuda.add(pnlAnuncioPrincipal);
		pnlSeccionAyuda.add(pnlResumen);
		
		return pnlSeccionAyuda;
	}

	public static void main(String args[]){
		
		try {
			JDialog dialogo = new JDialog();
			dialogo.setBounds(0, 0, 900, 500);
			
			dialogo.setLayout(null);
			//dialogo.add(pnlSeccionAyuda);
			
			dialogo.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

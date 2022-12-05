/*
 * Andres Cardenas.
 * Copyright  1998-2015 Codesa, Todos los derechos reservados.         
 */
package co.com.codesa.clienteposslimgiros.vista.logica;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import co.com.codesa.clienteposslim.utilidades.Utilidades;
import co.com.codesa.clienteposslimgiros.dto.ItemDTO;
import co.com.codesa.clienteposslimgiros.dto.MenuDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTipoElementoMenu;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Modulo;
import co.com.codesa.codesawrapper.modelo.enumeraciones.EnumModulos;

/**
 * ****************************************************************.
 * @autor: Andres Cardenas
 * @fecha: 05-mar-2015
 * @descripcion: Clase que tendra aspectos de logica  general
 * relacionada con giros, como saber si esta activo giros.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class GeneralGirosVistaLogica {

	private static GeneralGirosVistaLogica instancia ;
	private GeneralGirosVistaLogica(){}	
	private ArrayList<JMenuItem> listaMenuGiros;
	private Hashtable<String, JMenuItem> htIdentificacionElementosMenu = new Hashtable<String, JMenuItem>();

	public static GeneralGirosVistaLogica getInstance(){		
		if (instancia == null)
			instancia= new GeneralGirosVistaLogica();

		return instancia;
	}


	/**
	 * @variable:htMneMonic Corresponde a un hashtable el cual
	 * tiene como clave una letra del alfabeto y como  valor un numero entero,
	 * que corresponde a una letra  teniendo en cuenta el tag <MNEMONIC>
	 **/
	private static Hashtable<String, Integer> htMneMonic;


	static{
		htMneMonic= new Hashtable<String, Integer>();
		htMneMonic.put("A", 0x41);
		htMneMonic.put("B", 0x42);
		htMneMonic.put("C", 0x43);
		htMneMonic.put("D", 0x44);
		htMneMonic.put("E", 0x45);
		htMneMonic.put("F", 0x46);
		htMneMonic.put("G", 0x47);
		htMneMonic.put("H", 0x48);
		htMneMonic.put("I", 0x49);
		htMneMonic.put("J", 0x4A);
		htMneMonic.put("K", 0x4B);
		htMneMonic.put("L", 0x4C);
		htMneMonic.put("M", 0x4D);
		htMneMonic.put("N", 0x4E);
		htMneMonic.put("O", 0x4F);
		htMneMonic.put("P", 0x50);
		htMneMonic.put("Q", 0x51);
		htMneMonic.put("R", 0x52);
		htMneMonic.put("S", 0x53);
		htMneMonic.put("T", 0x54);
		htMneMonic.put("U", 0x55 );
		htMneMonic.put("V", 0x56);
		htMneMonic.put("W", 0x57);
		htMneMonic.put("X", 0x58);
		htMneMonic.put("Y", 0x59);
		htMneMonic.put("Z", 0x5A);
		htMneMonic.put("ALT", 1 << 3);
		htMneMonic.put("CONTROL", 1 << 1);
	}
	
	/**
	 * @propiedad blnVersionHabilitada valida si los menus se habilitan o no
	 */
	private boolean blnVersionHabilitada;


	/**
	 * ************************************************************************************.
	 * @metodo: activoGiros
	 * @descripcion: metodo que permite determinar si se debe pintar el accordion
	 * de giros, teniendo en cuenta lo obtenido en la trama 932. El parametro
	 * del sistema relacionado con este comportamiento es ACTGIROS, ademas esta informacion
	 * es almacenada en InformacionSession del modulo ClientePosSlim.
	 * @autor: Andres Cardenas
	 * ************************************************************************************
	 */
	//TODO LIMPIAR
//	public void activoGiros(){
//
//		String valorParametro;
//		boolean configuraGiros=false;
//		
//		if(InformacionSession.getInstance().getlTipoServicios()!=null){ 
//			 configuraGiros = InformacionSession.getInstance().getlTipoServicios().contains(TipoServicioEnum.GIROS.getIdTipoServicio());	
//		}	
//
//		if(configuraGiros){
//			valorParametro="S";
//		}else{
//			valorParametro="N";
//		}
//
//		InformacionSession.getInstance().setActivoGiros(valorParametro);
//	}

	/**
	 * *********************************************************************.
	 * @param pEventoFormaInicio corresponde al evento de la forma de inicio
	 * @return JMenuBar menuInicial con todos sus submenus e items.
	 * @metodo: generarMenuBar
	 * @descripcion: metodo que permite crear el menu general.
	 * @autor: Andres Cardenas
	 * *********************************************************************
	 */
	public JMenuBar generarMenuBar(EventoAbstracto pEventoFormaInicio){

		JMenuBar menuCompleto=null;

		try {

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document= documentBuilder.parse(UtilidadesGiros.getInstance().inputFileInJAR("menu.xml",EnumModulos.CLIENTEPOSSLIM_GIROS));
			document.getDocumentElement().normalize();
			List<MenuDTO> listaMenuPintar = obtenerMenus(document);

			menuCompleto = new JMenuBar();
			listaMenuGiros = new ArrayList<JMenuItem>();

			JMenu menuIterado;
			for (int i = 0; i < listaMenuPintar.size(); i++) {

				menuIterado= new JMenu();
				menuIterado.setText(listaMenuPintar.get(i).getNombreMenu());
				menuIterado.setMnemonic(htMneMonic.get(listaMenuPintar.get(i).getMeneNemonic()));
				adicionarIdElemento(menuIterado, listaMenuPintar.get(i));
				adicionarHijosMenu(listaMenuPintar.get(i).getNodo(),menuIterado,pEventoFormaInicio);
				habilitarElementoIniciando(menuIterado, listaMenuPintar.get(i));
				menuCompleto.add(menuIterado);
				listaMenuGiros.add(i, menuIterado);
				

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		InformacionSessionGiros.getInstance().setHtIdMenu(htIdentificacionElementosMenu);

		return menuCompleto;
	}


	/**
	 * **********************************************************************.
	 * @param pDocumento corresponde aun objecto que representa el archivo
	 * menu.xml
	 * @return List<MenuDTO> lista con los menus contenidos en el archivo 
	 * menu.xml
	 * @metodo: obtenerMenus
	 * @descripcion: metodo que permite obtener todos elementos del tag <MENU>
	 * del archivo menu.xml.
	 * @autor: Andres Cardenas
	 * **********************************************************************
	 */
	public List<MenuDTO> obtenerMenus(Document pDocumento){


		List<MenuDTO> listaMenuRetornar=null;

		NodeList listaMenu = pDocumento.getElementsByTagName("MENU");


		if(listaMenu.getLength()>0){
			listaMenuRetornar = new ArrayList<MenuDTO>();

			for (int i = 0; i < listaMenu.getLength(); i++) {
				NamedNodeMap atributosMenu = listaMenu.item(i).getAttributes();
				MenuDTO menuTemporal = new MenuDTO(atributosMenu.item(3).getNodeValue(), atributosMenu.item(2).getNodeValue().toUpperCase(),
						listaMenu.item(i),atributosMenu.item(0).getNodeValue(),
						atributosMenu.item(1).getNodeValue());


				listaMenuRetornar.add(menuTemporal);
			}
		}

		return listaMenuRetornar;

	}

	/**
	 * ****************************************************************.
	 * @param pMenu corresponde a un objeto de tio Jmenu, el cual sera
	 * el menu al cual sera adicionado un item.
	 * @param ItemDTO Objeto que representa un item del menu.
	 * @param EventoAbstracto corresponde a una instancia que administra los
	 * eventos a la forma llamada "FormaInicioGiros"
	 * @metodo: adicionarItemAMenu
	 * @descripcion: metodo que permite adicionar un item a un menu
	 * @autor: Andres Cardenas
	 * ****************************************************************
	 */
	public void adicionarItemAMenu(JMenu pMenu,ItemDTO pItem,EventoAbstracto pEventoFormaInicio){

		if(pMenu!=null && pItem!=null){
			JMenuItem menuItem = new JMenuItem();
			menuItem.setText(pItem.getNombre());
			menuItem.setName(pItem.getNombre());
			menuItem.addActionListener(pEventoFormaInicio);
			adicionarAtajo(pItem.getAtajo(),menuItem);
			adicionarMneMonic(pItem.getMnemonic(), menuItem);
			adicionarIdElemento(menuItem, pItem);
			habilitarElementoIniciando(menuItem, pItem);
			adicionarAMenu(pItem.getNombre(), pItem.getForma());

			pMenu.add(menuItem);
		}

	}

	/**
	 * ****************************************************************.
	 * @param pNodo corresponde a un nodo del archivo menu.xml
	 * @return EnumTipoElementoMenu menu que permite tipificar un elemento
	 * del menu.xml, en Menu,submenu o item.
	 * @metodo: obtenerTipoNodo
	 * @descripcion: metodo que permite determinar de que tipo es un nodo, teniendo
	 * en cuenta que existen 3, los cuales son:
	 * -menu
	 * -submenu
	 * -item
	 * @autor: Andres Cardenas
	 * ****************************************************************
	 */
	public EnumTipoElementoMenu obtenerTipoNodo(Node pNodo){
		EnumTipoElementoMenu tipoElemento=null;	

		String nombreNodo=pNodo.getNodeName();

		if(nombreNodo.equals("MENUITEM")){
			tipoElemento=EnumTipoElementoMenu.ITEM;
		}else if(nombreNodo.equals("SUBMENU")){
			tipoElemento=EnumTipoElementoMenu.SUBMENU;
		}

		return tipoElemento;
	}

	/**
	 * ****************************************************************.
	 * @param pNodo corresponde a un nodo del archivo menu.xml
	 * @return ItemDTO
	 * @metodo: obtenerItemDeNodo
	 * @descripcion:metodo que permite apartir de un nodo crear una clase
	 * que contendra la informacion requerida.
	 * @autor: Andres Cardenas
	 * ****************************************************************
	 */
	public ItemDTO obtenerItemDeNodo(Node pNodo){

		NodeList listaElementos = pNodo.getChildNodes();

		ItemDTO itemDto = new ItemDTO();
		itemDto.setNombre(listaElementos.item(1).getTextContent());

		String mneMonic= listaElementos.item(3).getTextContent();
		itemDto.setMnemonic(mneMonic.toUpperCase());
		itemDto.setForma(listaElementos.item(5).getTextContent());
		itemDto.setAtajo(listaElementos.item(7).getTextContent());
		itemDto.setHabilitarInicio(listaElementos.item(9).getTextContent());
		itemDto.setId(listaElementos.item(11).getTextContent());

		return itemDto;
	}



	/**
	 * ****************************************************************.
	 * @param pNodo corresponde a un nodo del archivo menu.xml
	 * @param pMenu menu al que se le desea adicionar un item
	 * @param pEventoFormaInicio evento de la forma llamada 
	 * "FormaInicioGiros"
	 * @metodo: adicionarHijosMenu
	 * @descripcion:metodo que permite adicionar todos los hijos
	 * de un nodo, que para este caso seria un menu.
	 * @autor: Andres Cardenas
	 * ****************************************************************
	 */
	public void adicionarHijosMenu(Node pNodo, JMenu pMenu,EventoAbstracto pEventoFormaInicio){

		NodeList listaHijos = pNodo.getChildNodes();

		for (int i = 0; i < listaHijos.getLength(); i++) {

			EnumTipoElementoMenu tipoElemento = obtenerTipoNodo(listaHijos.item(i));

			if(tipoElemento==null){
				continue;
			}

			if(tipoElemento.equals(EnumTipoElementoMenu.ITEM)){
				ItemDTO itemDto= obtenerItemDeNodo(listaHijos.item(i));
				adicionarItemAMenu(pMenu, itemDto,pEventoFormaInicio);
			}else if(tipoElemento.equals(EnumTipoElementoMenu.SUBMENU)){

				NamedNodeMap atributosMenu = listaHijos.item(i).getAttributes();
				JMenu menu = new JMenu();
				menu.setText(atributosMenu.item(3).getNodeValue());
				adicionarMneMonic(atributosMenu.item(2).getNodeValue(), menu);
				habilitarElementoIniciando(menu, atributosMenu.item(0).getNodeValue());
				adicionarIdElemento(menu, atributosMenu.item(1).getNodeValue());
				adicionarHijosMenu(listaHijos.item(i), menu,pEventoFormaInicio);
				pMenu.add(menu);

			}
		}


	} 

	/**
	 * ****************************************************************.
	 * @param pMneMonic letra al que se le desea poner el mnemonic, en un
	 * menuitem
	 * @param Object corresponde a un objeto que puede ser JMenu o MenuItem
	 * @metodo: adicionarMneMonic
	 * @descripcion:metodo que permite adicionar Mnemonic a un item
	 * del menu general.
	 * @autor: Andres Cardenas
	 * *****************************************************************
	 */
	public void adicionarMneMonic(String pMneMonic,Object pElemento ){

		boolean contieneClave =htMneMonic.containsKey(pMneMonic);

		if(contieneClave){
			if(pElemento instanceof JMenu){
				((JMenu)pElemento).setMnemonic(htMneMonic.get(pMneMonic));
			}else if(pElemento instanceof JMenuItem){
				((JMenuItem)pElemento).setMnemonic(htMneMonic.get(pMneMonic));
			}


		}
	}

	/**
	 * ****************************************************************.
	 * @param pAtajo cadena que contiene el atajo separado por coma, Ej.
	 * ALT,A
	 * @param pMenuItem corresponde al menuItem al que se le va adicionar
	 * el atajo de teclado.
	 * @descripcion:metodo que permite adicionar los atajos de teclado
	 * para el acceso a cada uno de los menuitems del menuGeneral
	 * @autor: Andres Cardenas
	 * *****************************************************************
	 */
	public void adicionarAtajo(String pAtajo,JMenuItem pMenuItem ){

		if(pAtajo!=null && !pAtajo.equals("*")){
			String elementosAtajo[] = pAtajo.split(",");

			if(elementosAtajo.length == 2){
				pMenuItem.setAccelerator(KeyStroke.getKeyStroke(htMneMonic.get(elementosAtajo[1]),htMneMonic.get(elementosAtajo[0])));
			}
		}
	}


	/**
	 * ****************************************************************.
	 * @param pNombre de un MenuItem
	 * @param pClase nombre de la clase que debera abrir el menuItem
	 * del menu general.
	 * @metodo: adicionarAMenu
	 * @descripcion:metodo que permite almacenar en un hashtable
	 * la clase que se debera abrir cuando se realice click en un
	 * menuitem del menu general.
	 * @autor: Andres Cardenas
	 * *****************************************************************
	 */
	public void adicionarAMenu(String pNombre, String pClase){



		if(pNombre!=null && !pNombre.equals("") && pClase!=null &&
				!pClase.equals("") && !pClase.equals("*")){

			if(InformacionSessionGiros.getInstance().getHtMenu()==null){
				InformacionSessionGiros.getInstance().setHtMenu(new Hashtable<String, String>());
			}
			InformacionSessionGiros.getInstance().getHtMenu().put(pNombre, pClase);
		}
	}

	/**
	 * ****************************************************************.
	 * @param JMenuItem  puede ser un JMenuItem o un JMenu del JMenuBar
	 * @param pElementoDTO corresponde a una instancia de tipo MenuDTO, ItemDTO,
	 * o un String en caso de que sea invocado por un submenu.
	 * @metodo: habilitarElementoIniciando
	 * @descripcion:metodo que permite determinar si un elemento debe habilitarse o no
	 * al momento de la creacion del menu, teniendo encuenta el tag <HABILITAR> si es
	 * un menu item o una propiedad habilitar si es un menu o un submenu.
	 * @autor: Andres Cardenas
	 * *****************************************************************
	 */
	public void habilitarElementoIniciando(JMenuItem pElemento,Object pElementoDTO){
		boolean habilitarInicio=true;

		if(pElementoDTO instanceof MenuDTO){
			habilitarInicio =((MenuDTO)pElementoDTO).isHabilitarInicio();
		}else if (pElementoDTO instanceof ItemDTO){
			habilitarInicio = ((ItemDTO)pElementoDTO).isHabilitarInicio();
		}else {
			String valorXmlSubmenu = pElementoDTO.toString();
			if(valorXmlSubmenu.equalsIgnoreCase("N")){
				habilitarInicio=false;
			}
		}

		pElemento.setEnabled(habilitarInicio);


	}

	/**
	 * ****************************************************************.
	 * @param JMenuItem  puede ser un JMenuItem o un JMenu del JMenuBar
	 * @param pElementoDTO corresponde a una instancia de tipo MenuDTO, ItemDTO,
	 * o un String en caso de que sea invocado por un submenu.
	 * @metodo: adicionarIdElemento
	 * @descripcion:metodo que permite relacionar el id de un menu, submenu, o 
	 * un item teniendo encuenta el id ingresado en menu.xml en el tag id. Es 
	 * importante mencionar que si es un item el tag usado es <ID>, pero si 
	 * es un menu o un submenu es una propiedad llamada id.
	 * @autor: Andres Cardenas
	 * *****************************************************************
	 */
	public void adicionarIdElemento(JMenuItem pElemento,Object pElementoDTO){
		//Integer idElemento=null;
		String idElemento=null;

		if(pElementoDTO instanceof MenuDTO){
			idElemento = ((MenuDTO)pElementoDTO).getId();
		}else if (pElementoDTO instanceof ItemDTO){
			idElemento=((ItemDTO)pElementoDTO).getId();
		}else {
			String idSubmenu = pElementoDTO.toString();

			if(!idSubmenu.equals("*") && Utilidades.esEntero(idSubmenu)){
				//idElemento= new Integer(idSubmenu);
				idElemento= idSubmenu;
			}
			idSubmenu=null;
		}

		if(idElemento!=null){
			htIdentificacionElementosMenu.put(idElemento, pElemento);
		}
	}

	
	/**
	 * ****************************************************************.
	 * @metodo: procesarPermisosMenu (Metodo)
	 * @descripcion: Metodo que ejecuta las verificaciones correspondientes
	 * 				 para habilitar o no las opciones de menu, segun los
	 * 				 modulos recuperados de la BD
	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
	 * 		   excepcion presentada 
	 * @autor: Hector Q-en-K
	 * ****************************************************************
	 */
	public void procesarPermisosMenu(boolean habilitar)throws Exception{

		List<Modulo> modulosPermitidos = InformacionSessionGiros.getInstance().getObjUsuario().getModulos();
		Hashtable<String, JMenuItem> htMenu = InformacionSessionGiros.getInstance().getHtIdMenu();
		JMenuItem menuDetectado;

		if(htMenu!=null && htMenu.size()>0 &&
				modulosPermitidos!=null && modulosPermitidos.size()>0){

			if(habilitar){

				for(Modulo opcionPermitida : modulosPermitidos){

					menuDetectado = htMenu.get(opcionPermitida.getCodigo());

					if(menuDetectado!=null){
						menuDetectado.setEnabled(true);
					}
				}
			}else{

				for(JMenuItem menuItem : htMenu.values()){
					menuItem.setEnabled(false);
				}
			}
		}
	}
	
	/**
	 * ****************************************************************.
	 * @metodo: procesarPermisosMenuVersion (Metodo)
	 * @descripcion: Metodo que deshabilita las opciones de menu ya que
	 * 				 la version del cliente girosno se encuentra
	 * 				 parametrizada en el parametro VERSHABI.
	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
	 * 		   excepcion presentada 
	 * @autor: Didier.Silva
	 * ****************************************************************
	 */
	public void procesarPermisosMenuVersion(boolean habilitar)throws Exception{

		if(!habilitar){
			
			if(!listaMenuGiros.isEmpty()){
				
				int cont = 0;
				
				for(JMenuItem jMenuItem : listaMenuGiros){
					
					if(cont != 0){
						
						jMenuItem.setEnabled(false);
						
					}
					
					cont ++;
				}
			}
			
		} else {
			
			this.procesarPermisosMenu(habilitar);
		}
	}
	
	public void procesarPermisosMenu2(boolean habilitar)throws Exception{

		List<Modulo> modulosPermitidos = InformacionSessionGiros.getInstance().getObjUsuario().getModulos();	
		Hashtable<String, JMenuItem> htMenu = InformacionSessionGiros.getInstance().getHtIdMenu();
		JMenuItem menuDetectado;

		if(htMenu!=null && htMenu.size()>0 &&
				modulosPermitidos!=null && modulosPermitidos.size()>0){

			if(habilitar){

				for(Modulo opcionPermitida : modulosPermitidos){

					menuDetectado = htMenu.get(opcionPermitida.getCodigo());

					if(menuDetectado!=null){
						menuDetectado.setEnabled(true);
					}
				}
			}else{

				for(JMenuItem menuItem : htMenu.values()){
					menuItem.setEnabled(false);
				}
			}
		}
	}
	
	
	/**
	 * @return the blnVersionHabilitada
	 */
	public boolean isBlnVersionHabilitada() {
		return blnVersionHabilitada;
	}


	/**
	 * @param blnVersionHabilitada the blnVersionHabilitada to set
	 */
	public void setBlnVersionHabilitada(boolean blnVersionHabilitada) {
		this.blnVersionHabilitada = blnVersionHabilitada;
	}

	public ArrayList<JMenuItem> getListaMenuGiros() {
		return listaMenuGiros;
	}


	public void setListaMenuGiros(ArrayList<JMenuItem> listaMenuGiros) {
		this.listaMenuGiros = listaMenuGiros;
	}
}

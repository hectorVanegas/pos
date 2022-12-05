package co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.posicionamiento;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.beans.Beans;
import java.util.Hashtable;

import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.posicionamiento.LayoutManagerAbsoluto;

public class LayoutAbsoluto implements LayoutManagerAbsoluto{

	private static final int PREFERRED = 0;
    private static final int MINIMUM =   1;

    @SuppressWarnings("rawtypes")
	private Hashtable consTable = new Hashtable();
    private LayoutAbsolutoConstraints
    defaultConstraints = new LayoutAbsolutoConstraints();
    public int width;
    public int height;

    // Si se indica -1 en los par�metros width o height, se da a entender
    // que se desea utilizar el tama�o preferido del componente
    public LayoutAbsoluto(){
        width = -1;
        height = -1;
        }

    // Aqu� se especifica el ancho y la altura que se desea para el 
    // componente, una vez que se vaya a presentar en el contenedor
    public LayoutAbsoluto( int w,int h ) {
        width = w;
        height = h;
        }
           
    public void addLayoutComponent( String name,Component comp ) {
        // No se utiliza. El usuario debe llamar a setConstraints()
        // y despu�s utilizar el m�todo add(comp) gen�rico, al igual
        // que se hace en el caso del GridBagLayout
        }

    // Se usa para obtener los valores que actualmente tienen
    // asignados los par�metros que controlan el posicionamiento
    // de un determinado componente sobre la zola de control del
    // layout
    public Object getConstraints( Component comp ) {
        return( lookupConstraints(comp).clone() );
        }

    // Aqu� es donde se controlan todos los par�metros que se
    // permiten, los constraints, para poder modificar la posici�n
    // y tama�o del componente, y para indicarle al contenedor las
    // caracter�sticas especiales de posicionamiento que se
    // quieren aplicar al componente
    public void layoutContainer( Container parent ) {
        Component comp;
        Component comps[];
        LayoutAbsolutoConstraints cons;
        Dimension d;
        Dimension pD;
        int x;
        int y;

        comps = parent.getComponents();
        Insets insets = parent.getInsets();
        pD = parent.getSize();
        for( int i=0; i < comps.length; i++ ) {
            comp = comps[i];
            // Se obtienen los par�metros actuales, que en principio
            // ser�n los de defecto, m�s los que se hayan modificado
            // en el constructor
            cons = lookupConstraints( comp );
            // Se aplican los desplazamientos "insets" a la posici�n
            x = cons.x + cons.insets.left + insets.left;
            y = cons.y + cons.insets.top + insets.top;
            // Se obtiene el tama�o preferido para el componente 
            d = comp.getPreferredSize();
            // Si no se quiere que el componente se presente con su
            // tama�o preferido, se modifica su anchura y su altura
            // con los valores que se indiquen
            if( cons.width != -1 )
                d.width = cons.width;
            if( cons.height != -1 )
                d.height = cons.height;
            // Ahora se controla el par�metro "fill" de forma que
            // el componente ocupe todo el espacio que se le
            // indique, y en la direcci�n que se le diga, en caso
            // de que se quiera cambiar. Observar que en este caso
            // tambi�n hay que tener en cuenta los "insets" o
            // separaciones de los bordes que se hayan indicado,
            // porque esa es una zona que hay que respetar
            if( (cons.fill == LayoutAbsolutoConstraints.BOTH) ||
                (cons.fill == LayoutAbsolutoConstraints.HORIZONTAL) ) {
                x = insets.left + cons.insets.left;
                d.width = pD.width - cons.insets.left - 
                    cons.insets.right - insets.left - insets.right;
                }
            if( (cons.fill == LayoutAbsolutoConstraints.BOTH) ||
                (cons.fill == LayoutAbsolutoConstraints.VERTICAL) ){
                y = insets.top + cons.insets.top;
                d.height = pD.height - cons.insets.top - 
                    cons.insets.bottom - insets.top - insets.bottom;
                }
            // A continuaci�n se controla el par�metro "anchor", para
            // anclar el componente en alguna de las posiciones que 
            // est�n permitidas
            switch( cons.anchor ){
                case LayoutAbsolutoConstraints.NORTH:
                    x = ( pD.width - d.width ) / 2;
                    y = cons.insets.top + insets.top;
                    break;
                case LayoutAbsolutoConstraints.NORTHEAST:
                    x = pD.width - d.width - cons.insets.right - insets.right;
                    y = cons.insets.top + insets.top;
                    break;
                case LayoutAbsolutoConstraints.EAST:
                    x = pD.width - d.width - cons.insets.right - insets.right;
                    y = ( pD.height - d.height ) / 2;
                    break;
                case LayoutAbsolutoConstraints.SOUTHEAST:
                    x = pD.width - d.width - cons.insets.right - insets.right;
                    y = pD.height - d.height - cons.insets.bottom - 
                        insets.bottom;
                    break;
                case LayoutAbsolutoConstraints.SOUTH:
                    x = ( pD.width - d.width ) / 2;
                    y = pD.height - d.height - cons.insets.bottom - 
                        insets.bottom;
                    break;
                case LayoutAbsolutoConstraints.SOUTHWEST:
                    x = cons.insets.left + insets.left;
                    y = pD.height - d.height - cons.insets.bottom - 
                        insets.bottom;
                    break;
                case LayoutAbsolutoConstraints.WEST:
                    x = cons.insets.left + insets.left;
                    y = ( pD.height - d.height ) / 2;
                    break;
                case LayoutAbsolutoConstraints.NORTHWEST:
                    x = cons.insets.left + insets.left;
                    y = cons.insets.top + insets.top;
                    break;
                default:
                    break;
                }
            // Y, finalmente, se fija la posci�n y dimensi�n del
            // componente, una vez tenidos en cuenta todos los
            // par�mentros que permite modificar su posicionamiento
            comp.setBounds( x,y,d.width,d.height );
            }
        }

    // Devuelve el tama�o que ocupan todos los componentes en el
    // contenedor, es decir, devuelve el tama�o que debe tener el
    // contenedor para poder visulaizar todos los componentes, en
    // funci�n de su tama�o y posici�n en el layout
    private Dimension layoutSize( Container parent,int tipo ) {
        int ancho;
        int alto;

        // En caso de que no se indique que el layout debe 
        // considerar el tama�o preferido, hay que ir calculando
        // las posiciones y tama�os de los componentes que se van
        // a posicionar en su interior para saber el tama�o
        // m�nimo que ha de tener para contenerlos a todos
        if( (width == -1) || (height == -1) ){
            Component comp;
            Component comps[];
            LayoutAbsolutoConstraints cons;
            Dimension d;
            int x;
            int y;

            ancho = alto = 0;
            comps = parent.getComponents();
            for( int i=0; i < comps.length; i++ ) {
                comp = comps[i];
                cons = lookupConstraints( comp );
                if( tipo == PREFERRED )
                    d = comp.getPreferredSize();
                else
                    d = comp.getMinimumSize();
                if( cons.width != -1 )
                    d.width = cons.width;
                if( cons.height != -1 )
                    d.height = cons.height;
                if( cons.anchor == LayoutAbsolutoConstraints.NONE ) {
                    x = cons.x;
                    y = cons.y;
                    }
                else {
                    x = cons.insets.left;
                    y = cons.insets.top;
                    }
                if( (cons.fill != LayoutAbsolutoConstraints.BOTH) && 
                    (cons.fill != LayoutAbsolutoConstraints.HORIZONTAL) )
                    ancho = Math.max( ancho,x + d.width );
                else
                    ancho = Math.max( ancho,d.width + cons.insets.left +
                        cons.insets.right );
                if( (cons.fill != LayoutAbsolutoConstraints.BOTH) && 
                    (cons.fill != LayoutAbsolutoConstraints.VERTICAL) )
                    alto = Math.max( alto,y + d.height );
                else
                    alto = Math.max( alto,d.height + cons.insets.top +
                        cons.insets.bottom );
                }
            if( width != -1 )
                ancho = width;
            if( height != -1 )
                alto = height;
            }
        else {
            ancho = width;
            alto = height;
        }

        // Una vez que se sabe el tama�o necesario para contener
        // a todos los componentes o se ha indicado un tama�o fijo,
        // se aplican los desplazamientos desde los bordes, para
        // devolver el tama�o definitivo que debe tener el
        // contenedor
        Insets insets = parent.getInsets();
        return( new Dimension( ancho + insets.left + insets.right,
            alto + insets.top + insets.bottom ) );
        }

    // Devuelve los valores de los par�metros que se han indicado
    // para el componente, o en caso de que no se haya indicado
    // ninguno en especial, devuelve los valores por defecto que
    // se asginan a todos los componentes
    private LayoutAbsolutoConstraints lookupConstraints( Component comp ) {
        LayoutAbsolutoConstraints p = 
            (LayoutAbsolutoConstraints)consTable.get( comp );
        if( p == null ) {
            setConstraints( comp,defaultConstraints );
            p = defaultConstraints;
            }
        return( p );
        }

    // Devuelve el m�nimo tama�o que se ha especificado para el
    // contendor que est� controlado por el layout
    public Dimension minimumLayoutSize( Container parent ) {
        return( layoutSize( parent,MINIMUM ) );
        }

    // Devuelve el tama�o preferido
    public Dimension preferredLayoutSize( Container parent ) {
        return( layoutSize( parent,PREFERRED ) );
        }

    // Elimina un componente del Layout, haciendo que desaparezca
    // tambi�n de la visualizaci�n en pantalla o donde se est�
    // mapenado el contenedor
    public void removeLayoutComponent( Component comp ) {
        consTable.remove( comp );
        }

    // Aqu� se aplican los valores que contiene el objeto de
    // tipo Constraints al componente que se desea controlar
    // en posici�n y tama�o sobre el contenedor que est� siendo
    // manejado por el layout que se ha creado
    @SuppressWarnings("unchecked")
	public void setConstraints( Component comp,Object cons ) {
        if( (cons == null) || (cons instanceof LayoutAbsolutoConstraints) ){
            LayoutAbsolutoConstraints pCons;
            // Si no se indica ning�n objeto que contenga los valores de
            // posicionamiento, se aplican los valores de defecto
            if( cons == null )
                pCons = (LayoutAbsolutoConstraints)defaultConstraints.clone();
            else
                pCons = (LayoutAbsolutoConstraints)
                    ( (LayoutAbsolutoConstraints)cons ).clone();
            // Una vez fijados los valores de los par�metros, se incluye
            // el componente en la lista de componentes que est�n siendo
            // manejados por el layout manager
            consTable.put( comp,pCons );
            // Lo siguiente es necesario para el caso en qhe se aniden
            // layout del tipo absoluto que estamos creando. Cuando los
            // constraints del componente est�n destinados a ser el�sticos
            // o no-el�ticos, es cuando se comprueba para ver si el
            // componente es en s� mismo un contenedor, con otro layout
            // absoluto como controlador de posicionamiento de los
            // componentes y, si es as�, fijar el layout para que sea
            // el�stico o no-el�stico, seg�n sea necesario
            if( Beans.isInstanceOf( comp,Container.class ) ) {
                if( ( (Container)Beans.getInstanceOf( comp,
                    Container.class ) ).getLayout()
                      instanceof LayoutAbsoluto ) {   
                    LayoutAbsoluto layout;
                    layout = (LayoutAbsoluto)
                        ( (Container)Beans.getInstanceOf( comp, 
                          Container.class ) ).getLayout();
                    layout.width = pCons.width;
                    layout.height = pCons.height;
                    }
                }
            }
        }

    // Devuelve un objeto igual, pero ya con el ancho y alto determinado
    // pos los valores de los par�metros correspondientes, sean los de
    // defecto o los que se indiquen espec�ficamente
    @Override
    public Object clone() {
        LayoutAbsoluto p = new LayoutAbsoluto( width,height );
        return( p );
        }
    
}

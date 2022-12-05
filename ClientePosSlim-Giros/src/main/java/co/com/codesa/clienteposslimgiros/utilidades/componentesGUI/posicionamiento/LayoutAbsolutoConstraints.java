package co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.posicionamiento;

import java.awt.Insets;

public class LayoutAbsolutoConstraints implements Cloneable{

	// Los nombres de los parámetros son semejantes a los que se utilizan
    // en el objeto de tipo GridBagConstraints
    public static final int NONE = 0;
    public static final int BOTH = 1;
    public static final int HORIZONTAL = 2;
    public static final int VERTICAL = 3;

    public static final int NORTH = 1;
    public static final int NORTHEAST = 2;
    public static final int EAST = 3;
    public static final int SOUTHEAST = 4;
    public static final int SOUTH = 5;
    public static final int SOUTHWEST = 6;
    public static final int WEST = 7;
    public static final int NORTHWEST = 8;

    public int x;
    public int y;
    public int width;
    public int height;
    public int anchor;
    public int fill;
    public Insets insets;

    // Los valores -1 en width y height significan que se ha de
    // utilizar el valor preferido para el Componente de que se
    // trate
    public LayoutAbsolutoConstraints() {
        x = 0;
        y = 0;
        width = -1;
        height = -1;
        anchor = NONE;
        fill = NONE;
        insets = new Insets( 0,0,0,0 );
        }

    @Override
    public Object clone() {
        LayoutAbsolutoConstraints lCon = new LayoutAbsolutoConstraints();
        lCon.x = x;
        lCon.y = y;
        lCon.width = width;
        lCon.height = height;
        lCon.anchor = anchor;
        lCon.fill = fill;
        lCon.insets = (Insets)insets.clone();
        return( lCon );
        }
}

package IA;

import Principal.Cuadro;
import java.util.ArrayList;

/**
 *
 * @author joaquin
 */
public class Nodo 
{    
    public Nodo padre;
    public String name;
    public Cuadro asociado;
    public ArrayList<Nodo> hijos;
    public int id;
    //public int id, linea, columna;
    
    public Nodo()
    {
        this.hijos=new ArrayList<>();
    }
    
}

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
    public int id;
    public double f,g,h;
    public String name;
    public Cuadro cuadro;
    public ArrayList<Nodo> hijos;    
    //public int id, linea, columna;
    
    public Nodo(Cuadro ccc, Nodo ppp)
    {
        this.hijos=new ArrayList<>();
        this.cuadro=ccc;
        this.padre=ppp;
        this.f=0;
        this.g=0;
        this.h=0;
    }
    
    public void calcularName()
    {
        
    }
    
    public void calcularFGH(double ggg, double hhh)
    {
        this.g = ggg;
        this.h = hhh;        
        this.f = ggg+ hhh;
    }
    
}

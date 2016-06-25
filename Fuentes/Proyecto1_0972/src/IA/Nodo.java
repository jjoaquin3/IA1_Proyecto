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
        this.calcularFGH();        
    }   
    
    public void calcularFGH()
    {
        this.calcularG();
        this.calcularH_Cuadrado();
        //this.calcularH_Diagonal();
        this.f = this.g + this.h;
    }        
        
    private void calcularG()
    {
        if(padre==null)
            this.g= this.cuadro.distancia;
        else
            this.g = this.padre.g + cuadro.distancia;
    }
    
    private void calcularH_Cuadrado()
    {
        double ff = Double.parseDouble(String.valueOf(cuadro.data.fin.fila));
        double fc = Double.parseDouble(String.valueOf(cuadro.data.fin.columna));        
        double nf = Double.parseDouble(String.valueOf(cuadro.fila));        
        double nc = Double.parseDouble(String.valueOf(cuadro.columna));
        this.h = (Math.abs(ff-nf) + Math.abs(fc - nc))*10;
    }
    
    private void calcularH_Diagonal()
    {
        //Pitagoras :D
        double ff = Double.parseDouble(String.valueOf(cuadro.data.fin.fila));
        double fc = Double.parseDouble(String.valueOf(cuadro.data.fin.columna));        
        double nf = Double.parseDouble(String.valueOf(cuadro.fila));        
        double nc = Double.parseDouble(String.valueOf(cuadro.columna));                
        this.h = (Math.sqrt(Math.abs(ff-nf) + Math.abs(fc - nc)))*10;
    }                
}

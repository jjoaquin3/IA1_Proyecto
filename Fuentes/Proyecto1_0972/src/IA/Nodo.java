package IA;

import Principal.Cuadro;
import java.util.LinkedList;

/**
 *
 * @author joaquin
 */
public class Nodo 
{    
    public Nodo padre;
    public int id;
    public double f,g,h;
    public boolean solucion;
    public String name;
    public Cuadro cuadro;
    //public ArrayList<Nodo> hijos;    
    public LinkedList<Nodo> hijos;
    //public int id, linea, columna;
   
    public Nodo(Cuadro ccc, Nodo ppp)
    {     
        this.solucion=false;
        //this.hijos=new ArrayList<>();
        this.hijos = new LinkedList<>();
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
    
    public String calcularNombre()
    {
        StringBuilder reto = new StringBuilder(this.cuadro.id+"\n");
        reto.append("g(n) = ").append(this.g).append("\n");
        reto.append("h(n) = ").append(this.h).append("\n");
        reto.append("f(n) = ").append(this.f);
        return reto.toString();
    }
    
    private void calcularH_Cuadrado()
    {
        //this.h = this.cuadro.distancia;
        double ff = Double.parseDouble(String.valueOf(cuadro.data.fin.fila));
        double fc = Double.parseDouble(String.valueOf(cuadro.data.fin.columna));        
        double nf = Double.parseDouble(String.valueOf(cuadro.fila));        
        double nc = Double.parseDouble(String.valueOf(cuadro.columna));
        this.h = (Math.abs(ff-nf) + Math.abs(fc - nc));
    }
    
    private void calcularH_Diagonal()
    {
        //Pitagoras :D
        double ff = Double.parseDouble(String.valueOf(cuadro.data.fin.fila));
        double fc = Double.parseDouble(String.valueOf(cuadro.data.fin.columna));        
        double nf = Double.parseDouble(String.valueOf(cuadro.fila));        
        double nc = Double.parseDouble(String.valueOf(cuadro.columna));                
        this.h = (Math.sqrt(Math.abs(ff-nf) + Math.abs(fc - nc)));
    }                
}

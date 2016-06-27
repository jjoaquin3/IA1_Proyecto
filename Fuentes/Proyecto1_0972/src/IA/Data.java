package IA;

import Principal.Cuadro;
import java.util.LinkedList;

/**
 *
 * @author joaquin
 */
public class Data 
{
    public Cuadro inicio, fin;
    public int activo, tamanio, pixeles;
    public String[] rutas;
    public Cuadro[][] matriz;
    public LinkedList<Nodo> solucion;
    public Nodo raiz;

    public Data(int ttt, int ppp)
    {
        this.activo = -1;
        this.tamanio=ttt;
        this.pixeles=ppp;
        this.rutas=new String[10]; 
        rutas=new String[10];
        rutas[0]="/Images/Inicio.png";
        rutas[1]="/Images/Final.png";        
        rutas[2]="/Images/Asfalto.png";
        rutas[3]="/Images/Trafico3.png";
        rutas[4]="/Images/Accidente.png";        
        rutas[5]="/Images/Trabajo.png";
        rutas[6]="/Images/Escolar.png";
        rutas[7]="/Images/Lluvia.png";
        rutas[8]="/Images/Desnivel.png";
        rutas[9]="/Images/Borrar.png";       
        this.solucion=new LinkedList<>();
    }   
    
    public void upMatriz(Cuadro[][] mmm){
        this.matriz=mmm;
    }
    
    public void graficarArbol()
    {
        Graficador g = new Graficador();
        g.graficarAST(raiz, "Busqueda");        
    }
    
}

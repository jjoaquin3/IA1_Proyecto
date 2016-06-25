package IA;

import Principal.Cuadro;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author joaquin
 */
public class AEstrella 
{
    public LinkedList<Nodo> abiertos;
    public LinkedList<Nodo> cerrados;
    public Data data;
    
    public AEstrella(Data ddd)
    {
        this.data = ddd;
    }        
        
    private double calcularH(Cuadro actual)
    {
        double ff = Double.parseDouble(String.valueOf(data.fin.fila));
        double cf = Double.parseDouble(String.valueOf(data.fin.columna));
        
        double fn = Double.parseDouble(String.valueOf(actual.fila));        
        double cn = Double.parseDouble(String.valueOf(actual.columna));
        
        //Pitagoras :D
        Double h = Math.sqrt(Math.abs(ff-fn) + Math.abs(cf - cn));
        return h;
    }
    
    private boolean esMeta(Nodo n)
    {
        if(n.cuadro.fila == data.fin.fila)
        {
            if(n.cuadro.columna==data.fin.columna)
                return true;
        }        
        return false;
    }
    
    public void algoritmo()            
    {
        //Iniciar lista de abiertos y cerrados
        this.abiertos=new LinkedList<>();
        this.cerrados=new LinkedList<>();
        
        //meter inicio a lista de abiertos
        Nodo inicio = new Nodo(data.inicio, null);
        this.abiertos.addFirst(inicio);
        
        
        boolean encontrado = false;
        do 
        {
            if (this.abiertos.size()==0) 
            {
                System.out.println("Error");
                return;
            }
            
            Nodo nodo = abiertos.pop();
            cerrados.addLast(nodo);
            
            if(esMeta(nodo))
            {
                System.out.println("Meta encontrada");
                //encontrado = true;
                break;
            }            
            
            //agregar todos los hijos de primero a Abiertos
            LinkedList<Nodo> sucesores = this.calcularSucesores(nodo);
            for(Nodo item:sucesores)
            {
                if(item!=null)
                    this.abiertos.addLast(item);
            }
            
            //
            
            
            
        } while (!encontrado);        
    }
    
    private LinkedList calcularSucesores(Nodo padre)
    {
        LinkedList<Nodo> sucesores = new LinkedList<>();
        sucesores.add(arriba(padre));
        sucesores.add(derecha(padre));
        sucesores.add(abajo(padre));
        sucesores.add(izquierda(padre));
        return sucesores;
    }
    
    private Nodo arriba(Nodo padre)
    {
        Nodo retorno=null;
        int fila = padre.cuadro.fila+1;        
        if(fila>16)
            return retorno;        
        Cuadro cuadro = data.matriz[fila][padre.cuadro.columna];
        if(cuadro.tipo==-1)
            return retorno;        
        //hay un camino :D
        retorno = new Nodo(cuadro, padre);
        double g = padre.g + cuadro.distancia;
        double h = this.calcularH(cuadro);
        retorno.calcularFGH(g, h);
        return retorno;
    }
    
    private Nodo abajo(Nodo padre)
    {
        Nodo retorno=null;
        int fila = padre.cuadro.fila-1;        
        if(fila<0)
            return retorno;        
        Cuadro cuadro = data.matriz[fila][padre.cuadro.columna];
        if(cuadro.tipo==-1)
            return retorno;        
        //hay un camino :D
        retorno = new Nodo(cuadro, padre);
        double g = padre.g + cuadro.distancia;
        double h = this.calcularH(cuadro);
        retorno.calcularFGH(g, h);
        return retorno;
    }
    
    private Nodo derecha(Nodo padre)
    {
        Nodo retorno=null;
        int columna = padre.cuadro.columna+1;
        if(columna>16)
            return retorno;                
        Cuadro cuadro = data.matriz[padre.cuadro.fila][columna];        
        if(cuadro.tipo==-1)
            return retorno;
        //hay un camino :D
        retorno = new Nodo(cuadro, padre);
        double g = padre.g + cuadro.distancia;
        double h = this.calcularH(cuadro);
        retorno.calcularFGH(g, h);
        return retorno;
    }
    
    private Nodo izquierda(Nodo padre)
    {
        Nodo retorno=null;
        int columna = padre.cuadro.columna-1;
        if(columna<0)
            return retorno;                
        Cuadro cuadro = data.matriz[padre.cuadro.fila][columna];        
        if(cuadro.tipo==-1)
            return retorno;
        //hay un camino :D
        retorno = new Nodo(cuadro, padre);
        double g = padre.g + cuadro.distancia;
        double h = this.calcularH(cuadro);
        retorno.calcularFGH(g, h);
        return retorno;
    }
    
    
}

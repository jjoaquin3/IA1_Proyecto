package IA;

import Principal.Cuadro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author joaquin
 */
public class Estrella
{
    public LinkedList<Nodo> abiertos, cerrados;
    public Data data;

    public Estrella(Data ddd)
    {
        this.data = ddd;
    }

    public void algoritmo()
    {        
        this.abiertos = new LinkedList<>(); //Lista de nodos posibles a evaluar
        this.cerrados = new LinkedList<>(); //Lista de nodos evaluados
        this.data.solucion=new LinkedList<>();  //Lista de nodos solucion       
        Nodo inicio = new Nodo(data.inicio, null);  
        this.data.raiz = inicio;        
        this.abiertos.add(inicio);          //Nodo inicial a lista de abiertos
        
        do 
        {            
            this.ordenarAbiertos();         //ordenar por valor de F            
            Nodo actual = abiertos.pop();   //sacar el de menor valor F            
            cerrados.addLast(actual);       //mover a cerrados
            
            if (esFinal(actual))            //nodo actual es el final
            {
                this.operarSolucion(actual);    //actualizo lista soluciones
                break;
            }            
            operarSucesores(actual);        //creo sucesores del nodo actual
        } 
        while (abiertos.size() != 0);
        System.out.println("------------> Analisis Terminado");
        
        if(this.data.solucion.size()==0)
            JOptionPane.showMessageDialog(null,"Analisis terminado, no existen caminos a tomar","Proyecto IA1",JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"Analisis terminado con exito","Proyecto IA1",JOptionPane.INFORMATION_MESSAGE);
    }

    private void operarSolucion(Nodo solucion)
    {
        Nodo temporal = solucion;           //llenar la lista de soluciones
        while(temporal!=null)
        {
            temporal.solucion=true;
            data.solucion.addFirst(temporal);
            temporal=temporal.padre;
        }
        System.out.println("------------> Ruta solucion establecida");
    }    
    
    Nodo igual;
    private void operarSucesores(Nodo actual)
    {
        ArrayList<Nodo> sucesores = this.calcularSucesores(actual);        
        for (Nodo nodo_sucesor : sucesores)             //por cada sucesor encontrado
        {            
            if (nodo_sucesor == null)                   //si es nulo itero de nuevo
                continue;
            //sucesor no en lista de abiertos
            if (this.existeAbiertos(nodo_sucesor)==false) 
            {
                nodo_sucesor.calcularFGH();
                actual.hijos.add(nodo_sucesor);         //agregar hijo como hijo de actual
                this.abiertos.addFirst(nodo_sucesor);   //agregar a lista de abiertos sucesor
                continue;
            }
            //sucesor en lista de abiertos
            if (igual.g < nodo_sucesor.g)               //g en otro cuadro es mejor que este sucesor?
            {                                   
                actual.hijos.add(new Nodo(igual.cuadro, actual));   //actualizar arbol
                igual.calcularFGH();                    
            }
        }
    }
    
    private void ordenarAbiertos()
    {
        if (abiertos.size() < 2)
            return;        
        Collections.sort(abiertos, new Comparator<Nodo>() 
        {
            @Override
            public int compare(Nodo o1, Nodo o2) 
            {
                return new Double(o1.f).compareTo(o2.f);
            }
        });
    }
    
    private boolean esFinal(Nodo actual)
    {
        if (actual.cuadro.fila == data.fin.fila) 
        {
            if (actual.cuadro.columna == data.fin.columna)
                return true;
        }
        return false;
    }

    private boolean existeAbiertos(Nodo sucesor)
    {
        this.igual=null;
        for (Nodo item : abiertos) 
        {
            if (item.cuadro.fila == sucesor.cuadro.fila) 
            {
                if (item.cuadro.columna == sucesor.cuadro.columna)
                {
                    this.igual =item;
                    return true;
                }                    
            }
        }
        return false;
    }

    private boolean existeCerrados(Nodo sucesor)
    {
        for (Nodo item : cerrados) 
        {
            if (item.cuadro.fila == sucesor.cuadro.fila) 
            {
                if (item.cuadro.columna == sucesor.cuadro.columna) 
                    return true;
            }
        }
        return false;
    }    

    private ArrayList<Nodo> calcularSucesores(Nodo padre)
    {
        ArrayList<Nodo> sucesores = new ArrayList<>();
        sucesores.add(movArriba(padre));
        sucesores.add(movArribaDerecha(padre));
        sucesores.add(movDerecha(padre));
        sucesores.add(movAbajoDerecha(padre));
        sucesores.add(movAbajo(padre));
        sucesores.add(movAbajoIzquierda(padre));
        sucesores.add(movIzquierda(padre));
        sucesores.add(movArribaIzquierda(padre));
        return sucesores;
    }

    private Nodo movArriba(Nodo padre)
    {
        int fila = padre.cuadro.fila + 1;
        if (fila > data.tamanio-1) 
            return null;        
        Cuadro cuadro = data.matriz[fila][padre.cuadro.columna];
        if (cuadro.tipo == -1)
            return null;
        
        Nodo retorno = new Nodo(cuadro, padre); //existe en cerrados?
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }

    private Nodo movAbajo(Nodo padre)
    {
        int fila = padre.cuadro.fila - 1;
        if (fila < 0) 
            return null;        
        Cuadro cuadro = data.matriz[fila][padre.cuadro.columna];
        if (cuadro.tipo == -1)
            return null;
        
        Nodo retorno = new Nodo(cuadro, padre); //existe en cerrados?
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }

    private Nodo movDerecha(Nodo padre) 
    {
        int columna = padre.cuadro.columna + 1;
        if (columna > data.tamanio-1) 
            return null;        
        Cuadro cuadro = data.matriz[padre.cuadro.fila][columna];
        if (cuadro.tipo == -1)
            return null;
        
        Nodo retorno = new Nodo(cuadro, padre); //existe en cerrados?
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }

    private Nodo movIzquierda(Nodo padre)
    {
        int columna = padre.cuadro.columna - 1;
        if (columna < 0) 
            return null;        
        Cuadro cuadro = data.matriz[padre.cuadro.fila][columna];
        if (cuadro.tipo == -1)
            return null;
        
        Nodo retorno = new Nodo(cuadro, padre); //existe en cerrados?
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }
    
    private Nodo movArribaDerecha(Nodo padre)
    {                        
        int fila = padre.cuadro.fila + 1;
        if (fila > data.tamanio-1) 
            return null;        
        int columna = padre.cuadro.columna + 1;
        if (columna > data.tamanio-1) 
            return null;
        
        Cuadro cuadro = data.matriz[fila][columna];
        if (cuadro.tipo == -1)
            return null;
        
        Nodo retorno = new Nodo(cuadro, padre); //existe en cerrados?
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }
    
    private Nodo movAbajoDerecha(Nodo padre)
    {
        int fila = padre.cuadro.fila - 1;
        if (fila < 0) 
            return null;        
        int columna = padre.cuadro.columna + 1;
        if(columna > data.tamanio-1)
            return null;
        
        Cuadro cuadro = data.matriz[fila][columna];
        if (cuadro.tipo == -1)
            return null;
        
        Nodo retorno = new Nodo(cuadro, padre); //existe en cerrados?
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }
    
    private Nodo movArribaIzquierda(Nodo padre)
    {                        
        int fila = padre.cuadro.fila + 1;
        if (fila > data.tamanio-1)
            return null;        
        int columna = padre.cuadro.columna - 1;
        if (columna < 0)
            return null;
        
        Cuadro cuadro = data.matriz[fila][columna];
        if (cuadro.tipo == -1)
            return null;
        
        Nodo retorno = new Nodo(cuadro, padre); //existe en cerrados?
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }
    
    private Nodo movAbajoIzquierda(Nodo padre)
    {
        int fila = padre.cuadro.fila - 1;
        if (fila < 0) 
            return null;                
        int columna = padre.cuadro.columna - 1;
        if (columna <0) 
            return null;
        
        Cuadro cuadro = data.matriz[fila][columna];
        if (cuadro.tipo == -1)
            return null;        
        
        Nodo retorno = new Nodo(cuadro, padre); //existe en cerrados?
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }
    
}

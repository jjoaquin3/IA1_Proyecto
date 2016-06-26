package IA;

import Principal.Cuadro;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author joaquin
 */
public class Estrella {

    public LinkedList<Nodo> abiertos;
    public LinkedList<Nodo> cerrados;
    public Data data;

    public Estrella(Data ddd) {
        this.data = ddd;
    }

    public void algoritmo() {
        //Iniciar lista de abiertos y cerrados
        this.abiertos = new LinkedList<>();
        this.cerrados = new LinkedList<>();

        //meter inicio a lista de abiertos
        Nodo inicio = new Nodo(data.inicio, null);
        this.abiertos.add(inicio);

        do 
        {            
            this.ordenarAbiertos();         //ordenar por valor de F            
            Nodo actual = abiertos.pop();   //sacar el de menor valor F            
            cerrados.addLast(actual);       //mover a cerrados
            
            if (esFinal(actual)) 
            {
                System.out.println("solucion");    
                this.operarSolucion(actual);
                break;
            }            
            operarSucesores(actual);
        } 
        while (abiertos.size() != 0);
        System.out.println("Termino :D");
        Graficador g = new Graficador();
        g.graficarAST(inicio, "Busqueda");
    }

    private void operarSolucion(Nodo solucion)
    {
        data.solucion=new LinkedList<>();
        
        Nodo temporal = solucion;
        while(temporal!=null)
        {
            temporal.solucion=true;
            data.solucion.addFirst(temporal);
            temporal=temporal.padre;
        }
    }    
    
    Nodo igual;
    private void operarSucesores(Nodo actual) 
    {
        ArrayList<Nodo> sucesores = this.calcularSucesores(actual);        
        for (Nodo nodo_sucesor : sucesores) //si es nulo iterar de nuevo
        {            
            if (nodo_sucesor == null)
                continue;

            if (this.existeAbiertos(nodo_sucesor)==false) 
            {
                nodo_sucesor.padre=actual;
                nodo_sucesor.calcularFGH();
                actual.hijos.add(nodo_sucesor);
                this.abiertos.addFirst(nodo_sucesor);                
                continue;
            }

            //si esta en abiertos, //valor de costo G para el nodo encontrado igual
            double g_encontrado = igual.g;
            double g_sucesor = nodo_sucesor.g;

            //g en otro cuadro es mejor que este sucesor?
            if (g_encontrado < g_sucesor) 
            {                                   
                //this.actualizarPadre(actual, igual);            
                //igual.padre.hijos.remove(igual);
                actual.hijos.add(this.copiarIgual(igual, actual));    
                igual.calcularFGH();
            }
        }
    }
    
    private Nodo copiarIgual(Nodo igual, Nodo padre)
    {
        Nodo reto = new Nodo(igual.cuadro, padre);        
        return reto;
    }

    private void actualizarPadre(Nodo padre, Nodo hijo)
    {
        hijo.padre.hijos.remove(hijo);
        hijo.padre=padre;
        padre.hijos.add(hijo);        
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
        //hay un camino :D 
        //existe este cuadro en cerrados?
        Nodo retorno = new Nodo(cuadro, padre);
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
        //hay un camino :D 
        //existe este cuadro en cerrados?
        Nodo retorno = new Nodo(cuadro, padre);
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
        //hay un camino :D 
        //existe este cuadro en cerrados?
        Nodo retorno = new Nodo(cuadro, padre);
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
        //hay un camino :D 
        //existe este cuadro en cerrados?
        Nodo retorno = new Nodo(cuadro, padre);
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
        //hay un camino :D 
        //existe este cuadro en cerrados?
        Nodo retorno = new Nodo(cuadro, padre);
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
        //hay un camino :D 
        //existe este cuadro en cerrados?
        Nodo retorno = new Nodo(cuadro, padre);
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
        //hay un camino :D 
        //existe este cuadro en cerrados?
        Nodo retorno = new Nodo(cuadro, padre);
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
        //hay un camino :D 
        //existe este cuadro en cerrados?
        Nodo retorno = new Nodo(cuadro, padre);
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }

}

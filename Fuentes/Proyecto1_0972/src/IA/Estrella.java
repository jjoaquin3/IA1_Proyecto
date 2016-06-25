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
        this.abiertos.addFirst(inicio);

        do {            
            this.ordenarAbiertos();         //ordenar por valor de F            
            Nodo actual = abiertos.pop();   //sacar el de menor valor F            
            cerrados.addLast(actual);       //mover a cerrados
            
            if (esFinal(actual)) 
            {
                System.out.println("solucion");
                break;
            }            
            operarSucesores(actual);
        } 
        while (abiertos.size() != 0);
        System.out.println("Termino :D");
    }

    Nodo igual;
    private void operarSucesores(Nodo actual) 
    {
        ArrayList<Nodo> sucesores = this.calcularSucesores(actual);        
        for (Nodo nodo_sucesor : sucesores) //si es nulo iterar de nuevo
        {            
            if (nodo_sucesor == null)
                continue;

            if (!this.existeAbiertos(nodo_sucesor)) 
            {
                this.abiertos.addFirst(nodo_sucesor);
                actual.hijos.add(nodo_sucesor);
                continue;
            }

            //si esta en abiertos, //valor de costo G para el nodo encontrado igual
            double g_encontrado = igual.g;
            double g_sucesor = nodo_sucesor.g;

            //g en otro cuadro es mejor que este sucesor?
            if (g_encontrado < g_sucesor) {
                igual.padre = actual;
                igual.calcularFGH();
            }
        }
    }

    private void ordenarAbiertos() 
    {
        if (abiertos.size() < 1)
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
        sucesores.add(movDerecha(padre));
        sucesores.add(movAbajo(padre));
        sucesores.add(movIzquierda(padre));
        return sucesores;
    }

    private Nodo movArriba(Nodo padre) 
    {
        int fila = padre.cuadro.fila + 1;
        if (fila > 16) {
            return null;
        }
        Cuadro cuadro = data.matriz[fila][padre.cuadro.columna];
        if (cuadro.tipo == -1) {
            return null;
        }
        //hay un camino :D

        //existe esta cuadro en cerrados?
        Nodo retorno = new Nodo(cuadro, padre);
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }

    private Nodo movAbajo(Nodo padre) 
    {
        int fila = padre.cuadro.fila - 1;
        if (fila < 0) {
            return null;
        }
        Cuadro cuadro = data.matriz[fila][padre.cuadro.columna];
        if (cuadro.tipo == -1) {
            return null;
        }
        //hay un camino :D

        //existe esta cuadro en cerrados?
        Nodo retorno = new Nodo(cuadro, padre);
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }

    private Nodo movDerecha(Nodo padre) 
    {
        int columna = padre.cuadro.columna + 1;
        if (columna > 16) {
            return null;
        }
        Cuadro cuadro = data.matriz[padre.cuadro.fila][columna];
        if (cuadro.tipo == -1) {
            return null;
        }
        //hay un camino :D

        //existe esta cuadro en cerrados?
        Nodo retorno = new Nodo(cuadro, padre);
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }

    private Nodo movIzquierda(Nodo padre) 
    {
        int columna = padre.cuadro.columna - 1;
        if (columna < 0) {
            return null;
        }
        Cuadro cuadro = data.matriz[padre.cuadro.fila][columna];
        if (cuadro.tipo == -1) {
            return null;
        }
        //hay un camino :D

        //existe esta cuadro en cerrados?
        Nodo retorno = new Nodo(cuadro, padre);
        if (this.existeCerrados(retorno))
            return null;
        return retorno;
    }

}

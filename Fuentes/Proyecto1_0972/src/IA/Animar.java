package IA;

import java.awt.Image;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author joaquin
 */
public class Animar extends Thread
{
    public Data data;
    public Boolean terminar = false;
    
    public Animar()
    {
        super();
    }
       
    @Override
    public void run()
    {
        LinkedList<Nodo> solucion = data.solucion;
        Nodo actual = solucion.pop();
        int iterador = 0;
        int tipoAnterior = 0;
        while(true && !this.terminar)
        {
            try
            {          
                if(solucion.size()==0)
                    break;
                
                Nodo siguiente = solucion.pop();                
                if(iterador==0)
                {
                    actual.cuadro.upCamino();
                    tipoAnterior = siguiente.cuadro.tipo;
                    siguiente.cuadro.upInicio();
                    actual = siguiente;
                    iterador++;
                    Animar.sleep(3000); 
                    continue;
                }
                        
                data.activo=tipoAnterior;
                actual.cuadro.accionActualizar();
                tipoAnterior = siguiente.cuadro.tipo;
                siguiente.cuadro.upInicio();
                actual = siguiente;
                                                
                if(solucion.size()==0)
                {
                    data.fin=null;
                    JOptionPane.showMessageDialog(null,"Recorrido Completo","Proyecto IA1",JOptionPane.INFORMATION_MESSAGE);
                    break;
                }                
                Animar.sleep(3000); 
            }
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Animar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

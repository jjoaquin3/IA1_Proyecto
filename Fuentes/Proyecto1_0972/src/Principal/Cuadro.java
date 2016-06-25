package Principal;

import IA.Data;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Joaquin
 */
public class Cuadro extends JButton implements ActionListener
{
    public int fila, columna, tipo, id;
    protected Data data;

    @SuppressWarnings("LeakingThisInConstructor")
    public Cuadro(int fff,int ccc, int ppp, Data ttt)
    {
        this.tipo = -1;
        this.fila = fff;
        this.columna = ccc;        
        this.data=ttt;
        this.id = ttt.tamanio*fff+ccc;
        this.setText(String.valueOf(id));
        this.setFocusPainted(false);
        this.addActionListener(this);
        this.setContentAreaFilled(false);        
        this.setBounds(columna*ppp,fila*ppp,ppp,ppp);
        this.updateUI();
    }
        
    public void establecerIcono(String ruta)
    {        
//        File f = new File(ruta);
//        if(!f.exists())
//            return;
 
        this.setText("");
        ImageIcon icono_proceso = (new ImageIcon(getClass().getResource(ruta)));        
        ImageIcon icono_final = new ImageIcon();
        icono_final.setImage(icono_proceso.getImage().getScaledInstance(data.pixeles, data.pixeles, Image.SCALE_DEFAULT));        
        this.setIcon(icono_final);
        this.updateUI();
    }
    
    public void borrarIcono()
    {
        this.setIcon(null);
        this.setText(String.valueOf(id));
        this.revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {               
        System.out.println("["+(fila+1)+":"+(columna+1)+"]"); 
        if(data.activo<0)
            return;
                        
        if(data.activo==0)
        {
            //si voy a poner un inicio
            if(data.inicio!=null)
            {
                JOptionPane.showMessageDialog(null,"Ya existe inicio","Warning",JOptionPane.WARNING_MESSAGE,null);
                return;
            }
            data.inicio=this;            
        }
        else if(data.activo==1)
        {
            //si voy a poner un fin
            if(data.fin!=null)
            {
                JOptionPane.showMessageDialog(null,"Ya existe fin","Warning",JOptionPane.WARNING_MESSAGE,null);
                return;
            }
            data.fin=this;            
        }
        else if(data.activo==9)
        {                   
            //si voy a poner un borrar
            
            //si soy inicio o fin los elimino
            if(this.tipo==0)
                this.data.inicio=null;
            else if(this.tipo==1)
                this.data.fin=null;
            
            this.tipo = -1;
            this.borrarIcono();
            return;
        }        
        this.establecerIcono(data.rutas[data.activo]);
        this.tipo=data.activo;
    }       
}

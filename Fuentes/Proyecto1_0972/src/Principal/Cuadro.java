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
    public int fila, columna, tipo, id, distancia;
    public Data data;

    @SuppressWarnings("LeakingThisInConstructor")
    public Cuadro(int fff,int ccc, int ppp, Data ttt)
    {
        this.tipo = -1;         //bloqueado
        this.distancia = 0;     //como esta bloqueado no tiene distancia
        this.data=ttt;
        this.fila = fff;
        this.columna = ccc;        
        this.id = ttt.tamanio*fff+ccc;
        this.setText(String.valueOf(id));
        this.setFocusPainted(false);
        this.addActionListener(this);
        this.setContentAreaFilled(false);        
        this.setBounds(columna*ppp,fila*ppp,ppp,ppp);
        this.updateUI();
    }
        
    private void establecerIcono(String ruta)
    {
        this.setText("");
        ImageIcon icono_proceso = (new ImageIcon(getClass().getResource(ruta)));        
        ImageIcon icono_final = new ImageIcon();
        icono_final.setImage(icono_proceso.getImage().getScaledInstance(data.pixeles, data.pixeles, Image.SCALE_DEFAULT));        
        this.setIcon(icono_final);
        this.updateUI();
    }
    
    private void borrarIcono()
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
                                      
        if(this.tipo==0)
        {
            if(data.activo>-1)
                this.data.inicio=null;  
        }
        else if(this.tipo==1)
        {
            if(data.activo>-1 )
                this.data.fin=null;  
        }
        
        switch (data.activo) 
        {
            case 0:
                if(data.inicio!=null)
                {
                    JOptionPane.showMessageDialog(null,"Ya existe inicio","Warning",JOptionPane.WARNING_MESSAGE,null);
                    return;
                }
                data.inicio=this;
                this.distancia=0;
                break;
            case 1:
                if(data.fin!=null)
                {
                    JOptionPane.showMessageDialog(null,"Ya existe fin","Warning",JOptionPane.WARNING_MESSAGE,null);
                    return;
                }
                data.fin=this;       
                this.distancia=0;
                break;
            case 2:
                this.distancia=1;
                break;
            case 3:
                this.distancia=15;
                break;
            case 4:
                this.distancia=20;
                break;
            case 5:
                this.distancia=25;
                break;
            case 6:
                this.distancia=10;
                break;
            case 7:
                this.distancia=5;
                break;
            case 8:
                this.distancia=0;
                break;
            case 9:
                this.tipo = -1;     //ahora esta bloqueado
                this.distancia=0;   //como esta bloqueado no tiene distancia
                this.borrarIcono();
                return;
            default:
                return;
        }        
        
        this.establecerIcono(data.rutas[data.activo]);
        this.tipo=data.activo;
        
        
        
    }       
}

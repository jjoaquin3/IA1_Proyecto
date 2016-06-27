package IA;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaquin
 */
public class Graficador 
{
    String separador=System.getProperty("file.separator");
    String rutaSalidas = System.getProperty("user.home")+separador+"SalidasDOT";
    public Graficador()
    {        
        File folder = new File(rutaSalidas);
        if(!folder.exists())
            folder.mkdir();           
    }
    
    int contador;
    //public StringBuffer graphviz;
    public void graficarAST(Nodo raiz, String nombre){        
        contador=0;
        StringBuffer graphviz = new StringBuffer("\ndigraph G {\r\nnode [shape=\"doublecircle\", style=\"filled\", fillcolor=\"yellow\", fontcolor=\"black\"];\n");
        listarNodos(raiz, graphviz);
        enlazarNodos(raiz,graphviz);
        graphviz.append("}");
        
        String[] cmd = new String[5];
        cmd[0] = "dot";     //cmd[0] = "dot.exe"; //-----> para windows
        cmd[1] = "-Tjpg";   //extencion de la imagen 
        cmd[2] = rutaSalidas+separador+nombre+".txt";    //ruta del dot
        cmd[3] = "-o";      //saber
        cmd[4] = rutaSalidas+separador+nombre+".jpg";    //ruta de la imagen
        this.creararchivo(cmd[2],graphviz.toString());                
        Runtime rt = Runtime.getRuntime();

        try 
        {
            rt.exec( cmd );            
            this.autoAbrir(rutaSalidas+separador+nombre+".jpg");                                    
        } catch (IOException ex) 
        {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
            
    private void listarNodos(Nodo praiz, StringBuffer graphviz){
        if(praiz.solucion)        
            graphviz.append("node").append(contador).append("[label=\"").append(praiz.calcularNombre()).append("\", fillcolor=\"limegreen\"];\n");        
        else
            graphviz.append("node").append(contador).append("[label=\"").append(praiz.calcularNombre()).append("\"];\n");
        praiz.id=contador;  
        contador++;
        for(Nodo temp:praiz.hijos)
            listarNodos(temp, graphviz);
    }    
    
    private void enlazarNodos(Nodo praiz, StringBuffer graphviz){        
        for(Nodo temp:praiz.hijos)
        {
            graphviz.append("\"node").append(praiz.id).append("\"->\"node").append(temp.id).append("\";\n");
            enlazarNodos(temp, graphviz);
        }
    }
    
    public void autoAbrir(String ruta){
        File f = new File(ruta);
        if(f.exists())
        {
            try 
            {
                Desktop.getDesktop().open(f);
            }catch (IOException ex) 
            {
                Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public synchronized void creararchivo(String ruta,String contenido){   try 
        {            
            File archivo = new File(ruta);
            BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(contenido);
            bw.close();
        }catch (IOException ex) 
        {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

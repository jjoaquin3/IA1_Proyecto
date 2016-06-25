package IA;

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
    String rescritorio = System.getProperty("user.home")+separador+"SalidasDOT";
    public Graficador()
    {        
        File folder = new File(rescritorio);
        if(!folder.exists())
            folder.mkdir();           
    }
    
    int contador;
    //public StringBuffer graphviz;
    public void graficarAST(Nodo raiz, String nombre)
    {        
        contador=0;
        StringBuffer graphviz = new StringBuffer("\ndigraph G {\r\nnode [shape=doublecircle, style=filled, color=khaki1, fontcolor=black];\n");
        listarNodos(raiz, graphviz);
        enlazarNodos(raiz,graphviz);
        graphviz.append("}");
        
        String[] cmd = new String[5];
        cmd[0] = "dot";     //cmd[0] = "dot.exe"; //-----> para windows
        cmd[1] = "-Tjpg";   //extencion de la imagen 
        cmd[2] = rescritorio+separador+"SalidasDOT"+separador+nombre+".txt";    //ruta del dot
        cmd[3] = "-o";      //saber
        cmd[4] = rescritorio+separador+"SalidasDOT"+separador+nombre+".jpg";    //ruta de la imagen
        this.creararchivo(cmd[2],graphviz.toString());                
        Runtime rt = Runtime.getRuntime();

        try 
        {
            rt.exec( cmd );
        } catch (IOException ex) 
        {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
            
    private void listarNodos(Nodo praiz, StringBuffer graphviz)
    {        
        graphviz.append("node").append(contador).append("[label=\"").append(praiz.name).append("\"];\n");
        praiz.id=contador;  
        contador++;
        for(Nodo temp:praiz.hijos)
            listarNodos(temp, graphviz);
    }    
    
    private void enlazarNodos(Nodo praiz, StringBuffer graphviz)
    {        
        for(Nodo temp:praiz.hijos)
        {            
            String relacion="\"node"+praiz.id+"\"->\"node"+temp.id+"\";\n";
            graphviz.append(relacion);
            enlazarNodos(temp, graphviz);
        }
    }
    
    public synchronized void creararchivo(String ruta,String contenido)
    {   try 
        {            
            File archivo = new File(ruta);
            BufferedWriter bw;
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(contenido);
            bw.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Graficador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}

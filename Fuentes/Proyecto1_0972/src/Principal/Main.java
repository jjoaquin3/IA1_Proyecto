package Principal;

import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Joaquin
 */
public class Main 
{
    public static void main(String[] args) 
    {
//         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
//        {
//            if ("Windows".equals(info.getName())) 
//            {
//                try
//                {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
         
        try
        {
            JFrame.setDefaultLookAndFeelDecorated(true);
            SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin");           
        }catch(Exception ex){}
        
        Home h = new Home();
        h.setVisible(true);
    }    
}

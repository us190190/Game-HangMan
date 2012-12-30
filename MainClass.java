package hangman;

import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author us190190
 */
public class MainClass {       
    public static void main(String[] args) throws InterruptedException, InvocationTargetException{
        Hangman a=new Hangman();
        a.init();        
       
        // Creating JFrame(window) to hold or contain the applet
        JFrame f=new JFrame("HangMan                           ©us190190"); 
        f.add(a);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(410, 260); 
        f.setResizable(false);
        f.setVisible(true);        
        
        SwingUtilities.invokeAndWait(
                new Runnable()
                { @Override public void run(){new MainClass();} }
                );        
    }
}

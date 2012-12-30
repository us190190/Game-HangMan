/**
 * Here is a game "Hangman" coded in JAVA. 
 * The source of words is a file containing 15000 words. 
 * As per the user's decision the associated Hangman image 
 * changes or not. This was coded by me in the last semester 
 * of my B.Tech (Jan 2012).
 */
 
package hangman;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author us190190
 */

/*
<applet code="Hangman" width=600 height=600>
</applet>
*/
public class Hangman extends Applet{
    
    String msg="";
    String w="";
    String pressed="";
    char keyChar;
    int lives=7;
    int i;
    
    @Override
    public void init(){        
        Frame window=new Frame("HangMan");        
        this.addKeyListener(new KeyAdapter(){
        @Override public void keyPressed(KeyEvent e) {              
        keyChar = e.getKeyChar();
        
        char buf1[]=msg.toCharArray();
        char buf2[]=w.toCharArray();        
        char flag='n';
        char skip='n';
        
        for(i=0;i<pressed.length();i++)    
         { if(keyChar==pressed.charAt(i)) skip='y';  }
        
        if(lives>0 && skip=='n')
        {        
          for(i=0;i<w.length();i++){
            if(buf2[i]==keyChar){
                buf1[i]=keyChar;
                flag='y';
            }
          }
          
         if(flag=='n') lives--;
         msg=new String(buf1);
         msg=msg.toLowerCase();
         }
         if(skip=='n') pressed+=keyChar;        
        
        repaint();
        }
        });
        //window.add(this);        
        
        window.setSize(400, 450);        
        setLocation(0, 0);
        setFont(new Font("Murga", Font.PLAIN, 40));        //Candombe //Miss Lankfort //Miss Stephams //Murga
        setBackground(Color.black);        
        
        int r=new Random().nextInt(58112);
        
        File read_words=new File("w2.txt");
        try{
            Scanner word=new Scanner(read_words);
            for(i=0;i<r;i++){
              w=word.nextLine();
              w=w.toLowerCase();
            }
        }
        catch(FileNotFoundException e){
            System.err.println("File not found");
        }       
        
        for(i=0;i<w.length();i++){
            msg+="_";
        }
                
    }
    
    @Override
    public void paint(Graphics g){                 
        g.setColor(Color.white);
        g.drawString("Hangman", 20, 50);
        g.drawString("    _______|^", 30, 55);
        
        BufferedImage img=null;
        showStatus("Pressed character : "+Character.toString(keyChar));
        if(msg.equalsIgnoreCase(w)) showStatus("You Win :D");
        if(lives==0) showStatus("Game Over !          "+" word was : "+w); 
        
        g.drawString(msg,20,200);
        
        try {
            img=ImageIO.read(new File(lives+".jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Hangman.class.getName()).log(Level.SEVERE, null, ex);
        }        
        g.drawImage(img, 200, 0, this);
    }
}

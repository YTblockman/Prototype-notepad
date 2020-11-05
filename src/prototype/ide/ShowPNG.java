package prototype.ide;


import java.awt.*; 
import javax.swing.*; 

public class ShowPNG
{    
  public static JFrame show(String arg){
    try {     
	    JFrame frame = new JFrame("Prototype Image Wiewer [" +arg +"]");
	    JPanel panel = new JPanel(); 
	    panel.setSize(500,640);
	    panel.setBackground(Color.BLACK); 
	    ImageIcon icon = new ImageIcon(arg); 
	    JLabel label = new JLabel(); 
	    label.setIcon(icon); 
	    panel.add(label);
	    frame.getContentPane().add(panel); 
	    frame.setVisible(true);
	    frame.pack();
	    frame.setResizable(false);
	    return frame;
    }catch(Exception e) {
    	JOptionPane.showMessageDialog(null, "Can't open file!", "InfoBox: " + "", JOptionPane.ERROR_MESSAGE);
    	return null;
    }
    
  }
  
}
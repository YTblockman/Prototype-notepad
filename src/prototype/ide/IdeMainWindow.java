package prototype.ide;
import java.awt.Dimension;
import java.awt.Toolkit;
// Java Program to create a simple JTextArea 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import prototype.startup.ShowWindowFrame; 
@SuppressWarnings("serial")
public class IdeMainWindow extends JFrame implements ActionListener { 
	public static File load;
    // JFrame 
    static JFrame f; 
  
    // JButton 
    static JButton b; 
  
    // label to display text 
    static JLabel l; 
  
    // text area 
    static JTextArea jt; 
  
    // default constructor 
    public IdeMainWindow() 
    { 
    } 
  
    @SuppressWarnings("deprecation")
	public static JFrame run() 
    { 
    	JMenuBar mb = new JMenuBar();
    	JMenu file = new JMenu("File"); //$NON-NLS-1$
    	JMenu Window = new JMenu("Help"); //$NON-NLS-1$
        JMenuItem miOpen = new JMenuItem("Open (Opens file)", KeyEvent.VK_O);
        miOpen.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
        JMenuItem help = new JMenuItem("General Help", KeyEvent.VK_H);
        help.setAccelerator(KeyStroke.getKeyStroke('H', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
        JMenuItem miSave = new JMenuItem("Save (Saves file)", KeyEvent.VK_S);
        miSave.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
        JMenuItem miExit = new JMenuItem("Close (Quits)", KeyEvent.VK_F4);
    	Dimension sz = Toolkit.getDefaultToolkit().getScreenSize();
        f = new JFrame("Prototype Notepad (Pre)"); 
        file.add(miOpen);
        file.add(miSave);
        file.add(miExit);
        Window.add(help);
        mb.add(file);
        mb.add(Window);
        f.setJMenuBar(mb);
        l = new JLabel("nothing entered"); 
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);;
        b = new JButton("submit"); 

        IdeMainWindow te = new IdeMainWindow(); 
  
        b.addActionListener(te); 
  
        jt = new JTextArea((int)sz.getHeight() /20, (int)sz.getWidth()/15); 
  
        JPanel p = new JPanel(); 
  
        // add the text area and button to panel 
        p.add(jt); 
        //p.add(b); 
        //p.add(l); 
  
        f.add(p); 
        // set the size of frame 
        f.setSize((int)sz.getHeight() /2, (int)sz.getWidth()/2);
        JScrollPane jp = new JScrollPane(jt);
        f.add(jp);
        f.pack();
        f.show(); 
        
        
        /*adding listeners*/
        
        miOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               load =  OpenFile.Explorer();
               try {
				if(load.canRead()) {
					   
				       if(load.isFile()) {
				    	   if(load.getName().contains(".png") || load.getName().contains(".jpg") || load.getName().contains(".svg")) {
					     	  try {
								ShowWindowFrame.filewind(load, load.getName() + " [Prototype image wiew] " + load.getPath());
	
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
				    	   }else {
				    		   JOptionPane.showMessageDialog(null, "Can't open file, file type is invalid!", "Invalid file type! " + "", JOptionPane.ERROR_MESSAGE);
				    	   }
				   }else {
					   JOptionPane.showMessageDialog(null, "Can't open file, can't read!", "read error! " + "", JOptionPane.ERROR_MESSAGE);
				   }
				  }
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Can't open file specified!", "File Error " + "", JOptionPane.ERROR_MESSAGE);
			}
            }
        });
        miExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });
        
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              	
            }
        });
        miSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Save file");   
                 
                int userSelection = fileChooser.showSaveDialog(f);
                 
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                    if (!CreateFile.save(fileToSave.getPath(), jt.getText())) {
                    	JOptionPane.showMessageDialog(null, "File was overwrited!", "Prototype file writer " + "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        
        return f;
    
    } 
    
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
        jt.setText(s + " " + e);
    } 
    public static JTextArea getArea(){
    	return jt;
    }
} 
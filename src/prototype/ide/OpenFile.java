package prototype.ide;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class OpenFile {
	public static File selectedFile; 
	public static File Explorer() {
		 // l.setText(jt.getText()); 
    	JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setDialogTitle("Open file");
        int returnValue = fileChooser.showOpenDialog(IdeMainWindow.f);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
          selectedFile = fileChooser.getSelectedFile();
          System.out.println(selectedFile.getName());
          return selectedFile;/*
          if(selectedFile.isFile() && selectedFile.getName().contains(".png")) {
        	  try {
				ShowWindowFrame.filewind(selectedFile, selectedFile.getName() + " [Prototype image wiew] " + selectedFile.getPath());

			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
          }
        JOptionPane.showMessageDialog(null, "No file selected, Reader won't work!", "No file" + "", JOptionPane.INFORMATION_MESSAGE);
        return null;
	}
}

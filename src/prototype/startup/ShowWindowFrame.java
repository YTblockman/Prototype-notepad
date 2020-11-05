package prototype.startup;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;

import prototype.ide.ProjectResc;
import prototype.ide.ShowPNG;

public class ShowWindowFrame {
	public static JFrame window(String path, String name) throws InterruptedException {
		JFrame frame = new JFrame(name);
		frame.setContentPane(new JLabel(ProjectResc.getImageIcon(path)));
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); 
		return frame;
	}
	public static void filewind(File selectedFile, String name) throws InterruptedException {
		 ShowPNG.show(selectedFile.getPath()).setIconImage(ProjectResc.getImageIcon("/prototype/resources/logo.png").getImage());;
		 
	}
}

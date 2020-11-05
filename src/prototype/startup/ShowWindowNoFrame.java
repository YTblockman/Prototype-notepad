package prototype.startup;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import prototype.ide.ProjectResc;

public class ShowWindowNoFrame {
	public static JFrame window(String path, int secs) throws InterruptedException {
		JFrame frame = new JFrame("Starting up...");
		frame.setUndecorated(true);
		frame.setContentPane(new JLabel(ProjectResc.getImageIcon(path)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); 
		TimeUnit.SECONDS.sleep(secs);
		
		frame.setVisible(false);
		return frame;
	}
}

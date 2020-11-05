package prototype.ide;

import java.net.URL;

import javax.swing.ImageIcon;


public class ProjectResc {
	public static ImageIcon getImageIcon(String pathTo) {
		URL iconURL = ProjectResc.class.getResource(pathTo);
		if(iconURL == null){
		    return null;
		}
		ImageIcon icon = new ImageIcon(iconURL);
		return icon;
	}
}

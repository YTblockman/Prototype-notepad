package prototype.startup;

import prototype.ide.IdeMainWindow;
import prototype.ide.ProjectResc;

public class Startup {
	public static String imports = "\nimport discord\nimport asyncio\nimport sys\nimport time";
	public static String on_start_method = "";
	public static void main(String[] args) throws InterruptedException {
		ShowWindowNoFrame.window("/prototype/resources/Prototype.png", 2).setAlwaysOnTop(true);;
		IdeMainWindow.run().setIconImage(ProjectResc.getImageIcon("/prototype/resources/logo.png").getImage());
		IdeMainWindow.getArea().setText("");
	}
}
/*
package prototype.startup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Startup extends JFrame {

    public Startup() {
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File"); //$NON-NLS-1$
        JMenu colorM = new JMenu("Color");
        JMenuItem quitM = new JMenuItem("Quit", KeyEvent.VK_Q);

        JRadioButtonMenuItem cb1 = new JRadioButtonMenuItem("Black", true);
        JRadioButtonMenuItem cb2 = new JRadioButtonMenuItem("Red", true);
        JRadioButtonMenuItem cb3 = new JRadioButtonMenuItem("Blue", true);
        JRadioButtonMenuItem cb4 = new JRadioButtonMenuItem("Green", true);

        ButtonGroup group = new ButtonGroup();
        group.add(cb1);
        group.add(cb2);
        group.add(cb3);
        group.add(cb4);

        setJMenuBar(mb);
        mb.add(file);
        mb.add(colorM);
        file.add(quitM);
        colorM.add(cb1);
        colorM.add(cb2);
        colorM.add(cb3);
        colorM.add(cb4);

        quitM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setVisible(true);
    }

    /**
     * @param args
     
    public static void main(String[] args) {
        new Startup();
    }

}*/
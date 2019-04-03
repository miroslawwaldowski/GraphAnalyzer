import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;


@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	
	public static final int HEIGHT = 300;
    public static final int WIDTH = 300;
	JButton buttonAnalyze; 
	JButton buttonOpen;
	
	public MainWindow() {

		Translator.translator();		
		
		this.setSize(WIDTH,HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("GraphAnalyzer");
		
		setLayout(new FlowLayout());
		
		buttonAnalyze = new JButton("Analizuj"); 
		buttonOpen = new JButton("Otworz");
		
		buttonAnalyze.addActionListener(new buttonListener());
		buttonOpen.addActionListener(new buttonListener());
		

 		this.add(buttonOpen);
 		this.add(buttonAnalyze);
 		
 		this.setVisible(true);
	}
	
	class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonAnalyze) {
				System.out.println("A");
			} else if (e.getSource() == buttonOpen){
				
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter GXLfilter = new FileNameExtensionFilter(
			    "GXL (Graph eXchange Language)", "gxl");
			    chooser.setFileFilter(GXLfilter);
			    chooser.setAcceptAllFileFilterUsed(false);
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				int x = chooser.showOpenDialog(MainWindow.this);

			    if(x == JFileChooser.APPROVE_OPTION) {   	
			    	
			    File fileToOpen = chooser.getSelectedFile();
			    GxlReader.readGXL(fileToOpen);
			    
			    }		    
			}			
		}	
	}
}

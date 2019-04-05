import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;


@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	
	public static final int HEIGHT = 500;
    public static final int WIDTH = 400;
	JButton buttonAnalyze; 
	JButton buttonOpen;
	JTextArea textArea;
	
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
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		textArea = new JTextArea("",1,22);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(border);
		
        JScrollPane scroll = new JScrollPane (textArea);
        scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
        scroll.setPreferredSize(new Dimension((9*WIDTH)/10, HEIGHT-80));

 		this.add(buttonOpen);
 		this.add(buttonAnalyze);
 		this.add(scroll);

 		this.setVisible(true);
	}
	
	class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonAnalyze) {
				if (GraphAnalyzer.graphsArray==null) {
					setComunicate("Wczytaj grafy z pliku");
				}else {
					Analyzer.analyzeGraphs();
					for (int i =0; i<GraphAnalyzer.graphsFrequency.length; i++) {
						setComunicate("czêstotliwoœci grafu "+GraphAnalyzer.graphsArray[i].getName()+":");
						for (int k=0; k < GraphAnalyzer.graphsFrequency[i].getListofLists().size();k++) {
							String text = GraphAnalyzer.graphsFrequency[i].getList(k).toString();
							int nr = k+1;
							setComunicate("- czêstotliwoœæ nr "+nr+" - "+text);
						}
						setComunicate("suma czêstotliwoœci = "+GraphAnalyzer.graphsFrequency[i].getListofLists().size()+"\n");
					}
					
				}
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
			    
			    setComunicate("Iloœæ wczytanych grafów: "+GraphAnalyzer.graphsArray.length+"\n");
			    for (int i=0;i<GraphAnalyzer.graphsArray.length;i++) {
					String text = "Graf nr "+(i+1)+":\n- nazwa: "
					+GraphAnalyzer.graphsArray[i].getName()+"\n- iloœæ wierzcho³ków: "
					+GraphAnalyzer.graphsArray[i].getPoints().length+"\n- iloœæ krawêdzi: "
					+GraphAnalyzer.graphsArray[i].getEdges()[0].length+"\n";
					setComunicate(text);
			    	
				}
			}			
		}	
	}
	
	public void setComunicate(String s) {			
		textArea.append(s);
		textArea.append("\n");
		textArea.getCaret().setDot( Integer.MAX_VALUE );	
	}
}

import java.awt.EventQueue;

public class GraphAnalyzer {

	public static Graphs [] graphsArray;
	public static GraphFrequency [] graphsFrequency;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow();
			}
		});

	}

}

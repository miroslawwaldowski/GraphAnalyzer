import java.util.ArrayList;
import java.util.Arrays;

public class Analyzer {
	
	public static void analyzeGraphs(){
		//tablica z listami czestotliwosci o wielkosci ilosci grafow
		GraphAnalyzer.graphsFrequency = new GraphFrequency [GraphAnalyzer.graphsArray.length];
		
		for (int i=0;i<GraphAnalyzer.graphsArray.length;i++) {
			
			//lista z listami czestotkiwosci
			ArrayList<ArrayList<String>> listOfFrequency = new ArrayList<ArrayList<String>>();
			
			//lista punktow do rozdzielenia
			ArrayList<String> listOfPoints = new ArrayList<String>(Arrays.asList(GraphAnalyzer.graphsArray[i].getPoints()));		

			while (!listOfPoints.isEmpty()) {
				
				//list z punktami nalezacymi do jednej czestotliwosci
				ArrayList<String> oneFrequencyPoint = new ArrayList<String>();
				
				for (int k=0;k<listOfPoints.size();k++) {
					String c = listOfPoints.get(k);
					if (oneFrequencyPoint.isEmpty()) {
						oneFrequencyPoint.add(listOfPoints.get(k));
					}else {
						boolean hasEdge = false;
						//sprawdzic czy dany punkt z listy ma krawedz z punktami z nowej listy
						//wyszukac czy ma krawêdz w pêtki i jesli jest indeks to porównaæ z indeksem
						EDGE_CHECKER:
						for (int m=0; m<GraphAnalyzer.graphsArray[i].getEdges()[0].length;m++) {
							String a = GraphAnalyzer.graphsArray[i].getEdgeSource(m);
							String b = GraphAnalyzer.graphsArray[i].getEdgeTarget(m);
							//sprawdza czy punkt jest w spisie krawedzi
							if (c.equals(a) || c.equals(b)) {
								//jesli tak to sprawdza czy ma krawedz z punktami z nowej listy
								for (int l=0;l<oneFrequencyPoint.size();l++) {
									String d = oneFrequencyPoint.get(l);
									//jesli nie znajdzie to dopisze do nowej listy
									if(b.equals(d)||a.equals(d)) {
										hasEdge = true;
										break EDGE_CHECKER;
									}//END if(b.equals(d)||a.equals(d))
								}//END for (int l=0;l<oneFrequencyPoint.size();l++)
							}//END if (c.equals(a) || c.equals(b))
						}// END for (int m=0; m<GraphAnalyzer.graphsArray[i].getEdges()[0].length;m++)
						//jesli nie posiada krawedzi z nowymi, kopiuje do nowej 
						if (hasEdge == false) {
							oneFrequencyPoint.add(listOfPoints.get(k));
						}
					}//END if (oneFrequencyPoint.isEmpty())
				}		
				//czyœci liste punktow ze skopiowanych punktow 
				for (int k=0;k<listOfPoints.size();k++) {
					for (int l=0;l<oneFrequencyPoint.size();l++) {
						if (listOfPoints.get(k)==oneFrequencyPoint.get(l)) {
							listOfPoints.remove(k);
						}
					}
				}
				listOfFrequency.add(oneFrequencyPoint);
			}//END while (!listOfPoints.isEmpty())
			GraphAnalyzer.graphsFrequency[i] = new GraphFrequency(listOfFrequency); 
		}
	}
}

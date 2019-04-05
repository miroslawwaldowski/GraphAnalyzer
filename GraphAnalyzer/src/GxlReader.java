import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;

import net.sourceforge.gxl.GXLDocument;
import net.sourceforge.gxl.GXLEdge;
import net.sourceforge.gxl.GXLGraph;
import net.sourceforge.gxl.GXLNode;

public class GxlReader {

	public static void readGXL(File fileToRead) {
				
		try {
			
			GXLDocument gxlDocument = new GXLDocument(fileToRead);
			int graphCount = gxlDocument.getDocumentElement().getGraphCount();
			GXLGraph [] graphs = new GXLGraph[graphCount];
			GraphAnalyzer.graphsArray = new Graphs[graphCount];
			
			for (int i=0;i<graphCount;i++) {
				
				graphs[i] = gxlDocument.getDocumentElement().getGraphAt(i);
				
				List<GXLNode> nodeList = new ArrayList<GXLNode>();
				List<GXLEdge> edgeList = new ArrayList<GXLEdge>();
				int numberElement = graphs[i].getChildCount();
				String name = graphs[i].getID();
				
				for (int k=0;k<numberElement;k++) {
					if (graphs[i].getChildAt(k).getClass() == GXLNode.class) {
						GXLNode node = (GXLNode) graphs[i].getChildAt(k);
						nodeList.add(node);
					} else if (graphs[i].getChildAt(k).getClass() == GXLEdge.class) {
						GXLEdge edge = (GXLEdge) graphs[i].getChildAt(k);
						edgeList.add(edge);
					}				
				}
				
				String [] points = new String [nodeList.size()];
				for (int k=0;k<nodeList.size();k++) {
					points[k]=nodeList.get(k).getID();
				}
				
				String [][] edges = new String [2][edgeList.size()];
				for (int k=0;k<edgeList.size();k++) {
					edges[0][k]=edgeList.get(k).getSourceID();
					edges[1][k]=edgeList.get(k).getTargetID();
				}				
				GraphAnalyzer.graphsArray[i] = new Graphs(name, points, edges); 			
			}
		} catch (IOException | SAXException e) {
			e.printStackTrace();
		}	
	}
	
}
	


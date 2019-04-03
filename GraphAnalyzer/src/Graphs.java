
public class Graphs {
	
	private String name;
	private String [] points;
	private String [][] edges; // [0][] - source point; [1][] - target point

	public Graphs(String name, String [] points, String [][] edges ){
		this.name = name;
		this.points = points;
		this.edges = edges;
	}
	
	public String getName () {return name;}
	public String [] getPoints () {return points;}
	public String getPoint (int i) {return points[i];}
	public String [][] getEdges () {return edges;}
	public String getEdgeSource (int i) {return edges[0][i];}
	public String getEdgeTarget (int i) {return edges[1][i];}
	
	public void setName (String name) {this.name = name;}
	public void setPoints (String [] points) {this.points = points;}
	public void setPoint (String point, int i) {this.points[i] = point;}
	public void setEdges (String [][] edges) {this.edges = edges;}
	public void setEdgeSurce (String edgeSurce, int i) {this.edges[0][i] = edgeSurce;}
	public void setEdgeTarget (String edgeTarget, int i) {this.edges[1][i] = edgeTarget;}

}

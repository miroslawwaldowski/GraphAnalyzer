import java.util.ArrayList;

public class GraphFrequency {

	private ArrayList<ArrayList<String>> listOfFrequency = new ArrayList<ArrayList<String>>();
		
	public GraphFrequency(ArrayList<ArrayList<String>> lists){	
		this.listOfFrequency = lists;
	}
	
	public ArrayList<ArrayList<String>> getListofLists () {return listOfFrequency;}
	public ArrayList<String> getList (int i) {return listOfFrequency.get(i);}
	public String getPoint (int i, int k) {return listOfFrequency.get(i).get(k);}
	
	public void setListofLists (ArrayList<ArrayList<String>> listOfFrequency) {this.listOfFrequency = listOfFrequency;}
	public void setList (ArrayList<String> list, int i) {this.listOfFrequency.set(i, list);}
	public void setPoint (String point, int i, int k) {this.listOfFrequency.get(i).set(k, point);}
}

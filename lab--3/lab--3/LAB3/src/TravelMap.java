import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class TravelMap {
public ArrayList<Node> nodes;
public ArrayList<Edge> edges;
TravelMap(){
nodes = new ArrayList<Node>();
edges = new ArrayList<Edge>();
}
public void addNode(Node thisNode){
nodes.add(thisNode);
}

public void addEdge(Node e1,Node e2,int cost,boolean twoWay){
edges.add(new Edge(e1,e2,cost,twoWay));


}
    public void addEdge(Node e1,Node e2,int cost){
        edges.add(new Edge(e1,e2,cost,true));


    }
public void showEdges(){
    for(Edge e:edges){
        e.display();

    }

}
    @Override
    public String toString() {
        String buffer="";
        buffer = getNodes()+" \n" + getEdges();
        return buffer;

    }
    public String getNodes(){
    String namesOfNodes="";
ArrayList<Node> Copy=nodes;
    Collections.sort(Copy);
    for(Node d:Copy) namesOfNodes=namesOfNodes+d.name+" ";
    return namesOfNodes;

}
public String getEdges(){
    String edgesDetails="";
    for(Edge e:edges)edgesDetails=edgesDetails+e.pair[0].name+" to "+e.pair[1].name+" costs "+e.cost+" tw "+e.twoWay+"\n";
return edgesDetails;
}
}

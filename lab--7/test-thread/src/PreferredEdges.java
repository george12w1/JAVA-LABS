import java.util.LinkedList;
import java.util.List;

public class PreferredEdges {
    public List<Edge> edges;
    public int n;
    PreferredEdges(int vertices){
        edges= new LinkedList<>();
        for(int i=0;i<vertices;i++)
        for(int j=0;j<vertices;j++)
            if(i<j)
                edges.add(new Edge(i,j));
    this.n=vertices;
    }
    public void deleteOptions(Edge e){
        for(int i=0;i<edges.size();i++)
            if(edges.get(i).i==e.i ||edges.get(i).i==e.j ||edges.get(i).j==e.j ||edges.get(i).j==e.i)
                edges.remove(i);
    }
    public int found(Edge e){
        int index=-1;
        for(int i=0;i<edges.size();i++)
            for(int j=0;j<5;j++)
            if((e.i==edges.get(i).i && e.j==edges.get(i).j)
            ||(e.j==edges.get(i).i && e.i==edges.get(i).j)
            ){
                index=i;break;}
            return index;
    }

}

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Graph {
    List<Edge> edges;
    Graph(){
        edges= new LinkedList<>();
    }
    public void add(Edge a){
        if(!edgeAlreadyExist(a))edges.add(a);

    }
    public boolean edgeAlreadyExist(Edge a){
        boolean exist=false;
        for(int i=0;i<edges.size();i++)
            if((edges.get(i).i==a.i && edges.get(i).j==a.j)
                    ||(edges.get(i).i==a.j && edges.get(i).j==a.i)

            )exist=true;
        return exist;

    }
    public Edge pollFirst(){
        Edge temp=null;
        try {
            temp= edges.get(0);
            edges.remove(0);
        }catch(IndexOutOfBoundsException out){

            System.out.println(out);
        }
        return temp;

    }
    public void shuffle(){
        List<Edge> temp;
        Random rn=new Random();
        int shuffleValue=100;
        while(shuffleValue>0) {
            shuffleValue--;
            int n1 = rn.nextInt(edges.size());
            int n2 = rn.nextInt(edges.size());
            Edge tempEdge=edges.get(n1);
            edges.set(n1,edges.get(n2));
            edges.set(n2,tempEdge);

        }
    }
    @Override
    public String toString(){
        String buffer="";
        for(int i=0;i<edges.size();i++)
            buffer+=edges.get(i).i + " - " + edges.get(i).j+"\n";
        return buffer;
    }



    public boolean isSpanningTree(int vertices){
        boolean is=true;
        for(int i=0;i<vertices;i++){
            if(!hasEdge(i))is=false;
        }
        return is;
    }
    public boolean hasEdge(int vertices){
        boolean has=false;
        for(int i=0;i<edges.size();i++)
            if(edges.get(i).i==vertices || edges.get(i).j==vertices )
                has=true;
        return has;
    }
}

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
    TravelMap map=new TravelMap();
    Hotel v1=new Hotel("v1",12);
    Museum v2=new Museum("v2","A");
    Museum v3=new Museum("v3","B");
    Church v4=new Church("v4","A");
    Church v5=new Church("v5","B");
    Restaurant v6=new Restaurant("v6",100);

    map.addNode(v1);map.addNode(v2);map.addNode(v3);
    map.addNode(v4);
    //map.addNode(v5);map.addNode(v6);


    map.addEdge(v1,v2,15);
    map.addEdge(v1,v3,1);
    map.addEdge(v3,v2,1);
    map.addEdge(v3,v4,1);
    map.addEdge(v4,v5,1);
    map.addEdge(v5,v6,1);
    map.addEdge(v2,v6,10);

   // System.out.println(map);
        List<Node> visitableButNotPayable=map.nodes;
        //System.out.println(visitableButNotPayable.stream().collect(Collectors.partitioningBy((Node n)->n.hour>0 && n.price<1 )));
       Dijktras solveThis = new Dijktras(map);
        //System.out.println("Average price per ticket "+
            //    visitableButNotPayable.stream().filter((Node d)->d.price>0).mapToInt((Node d)->d.price=d.price).sum()
              //  /visitableButNotPayable.stream().filter((Node d)->d.price>0).count());





    }


}

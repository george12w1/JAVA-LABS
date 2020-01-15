import java.util.ArrayList;

public class Dijktras {
    TravelMap map;
    Node nodes[];
    Edge edges[];
    Node previousNode[];
    Integer cost[];
    Node unvisited[];
    Dijktras(TravelMap map){
        this.map=map;

        nodes=new Node[map.nodes.size()];
        previousNode=new Node[map.nodes.size()];
        unvisited=new Node[map.nodes.size()];
        cost=new Integer[map.nodes.size()];

        nodes=arrayToListNode(map.nodes);
        previousNode=arrayToListNode(map.nodes);
        unvisited=nodes;

        edges=new Edge[map.edges.size()];
        edges=arrayToListEdge(map.edges);

        solveThis(nodes[0]);
    }
    public Node[] arrayToListNode(ArrayList<Node> array){
        Node toReturn[]=new Node[array.size()];
        for(int i=0;i<array.size();i++)
            toReturn[i]=array.get(i);
        return toReturn;
    }
    public Edge[] arrayToListEdge(ArrayList<Edge> array){
        Edge toReturn[]=new Edge[array.size()];
        for(int i=0;i<array.size();i++)
            toReturn[i]=array.get(i);
        return toReturn;
    }


    public Node[] neighboards(Node node){
        Node nofNode[];
        Node clone[]=new Node[100];
        int tempCounter=0;
        for(int i=0;i<nodes.length;i++)
            if(hasEdge(node,nodes[i]))
            {clone[tempCounter]=nodes[i];tempCounter++;
            }
        nofNode=new Node[tempCounter];
            for(int i=0;i<tempCounter;i++)
                nofNode[i]=clone[i];

        return nofNode;
    }
    public boolean hasEdge(Node n1,Node n2){
        boolean has=false;
        for(int i=0;i<edges.length;i++){
            if((edges[i].pair[0]==n1 && edges[i].pair[1]==n2)
            || (edges[i].pair[1]==n1 && edges[i].pair[0]== n2 && edges[i].twoWay==true)
            )has=true;
        }
        return has;

    }

    public int cost(Node n1,Node n2){
        int tempCost=0;
        for(int i=0;i<edges.length;i++){
            if((edges[i].pair[0]==n1 && edges[i].pair[1]==n2)
                    || (edges[i].pair[1]==n1 && edges[i].pair[0]== n2 && edges[i].twoWay==true)
            )tempCost=edges[i].cost;
        }
        return tempCost;

    }
    public void displayNeig(Node node){
        Node neigh[]=neighboards(node);
        for(int i=0;i<neigh.length;i++)
            System.out.print(neigh[i].name);
        System.out.println();

    }
    public void solveThis(Node startNode){
        for(int i=0;i<nodes.length;i++){
            if(nodes[i]==startNode)cost[i]=0;
            else cost[i]=100;
        }

          while(unvisited.length!=0){
            for(int i=0;i<neighboards(nodes[getTheSmallestCost()]).length;i++){

                if(
                        cost[getTheSmallestCost()]
                                +cost(
                                        nodes[getTheSmallestCost()]
                                ,neighboards(nodes[getTheSmallestCost()])[i])
                                <cost[whereToFind(neighboards(nodes[getTheSmallestCost()])[i])]

                ) {
                    cost[whereToFind(neighboards(nodes[getTheSmallestCost()])[i])] = cost[getTheSmallestCost()]
                            + cost(
                            nodes[getTheSmallestCost()]
                            , neighboards(nodes[getTheSmallestCost()])[i]);
                    previousNode[whereToFind(neighboards(nodes[getTheSmallestCost()])[i])]=nodes[getTheSmallestCost()];
                }

                displayStep();

                reFrUn(nodes[getTheSmallestCost()]);
                System.out.println(getTheSmallestCost());
            }


        }

    }
    public int getTheSmallestCost(){
        int max=9999999;
        int toReturn=0;
        for(int i=0;i<nodes.length;i++)
            if(foundInUnvisited(nodes[i]) && cost[i]<max){
                max=cost[i];
                toReturn=i;
            }
        return toReturn;

    }
    public int whereToFind(Node node){
        int toReturn=0;
        for(int i=0;i<nodes.length;i++){
            if(nodes[i] == node){
                toReturn=i;
                break;
            }

        }

        return toReturn;
    }
    public boolean foundInUnvisited(Node node){
        boolean toReturn=false;
        for(int i=0;i<unvisited.length;i++){
            if(unvisited[i]==node)toReturn=true;

        }
        return toReturn;

    }

    public void displayStep(){
        for(int i=0;i<nodes.length;i++){
            System.out.println(nodes[i].name + " | "+cost[i]+" | "+previousNode[i].name);

        }
        for(int i=0;i<unvisited.length;i++)
            System.out.print(unvisited[i].name+"|");

        System.out.println();

    }
    public void reFrUn(Node node){
        Node[] aux=new Node[unvisited.length-1];
        int tempCounter=0;
        for(int i=0;i<unvisited.length;i++){
           if(node != unvisited[i] && unvisited[i]!=null)
           {
               aux[tempCounter]=unvisited[i];
               tempCounter++;
           }



       }
        unvisited=aux;
    }

}

public class Edge {
public Node pair[]=new Node[2];
public int cost;
public boolean twoWay=true;
Edge(Node n1,Node n2,int cost,boolean twoWay){
    this.cost=cost;
    this.twoWay=twoWay;
    this.pair[0]=n1;
    this.pair[1]=n2;
}
public void display(){
    System.out.println(pair[0].name+" to "+pair[1].name);
    System.out.println("this travel cost "+cost);
    System.out.println("is this two way ? "+twoWay);
    System.out.println();
}
}

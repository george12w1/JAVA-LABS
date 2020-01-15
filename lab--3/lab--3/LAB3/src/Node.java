public class Node implements Comparable<Node>{
    public String name;
    public int hour;
    public int price;
    public String rank;
    public int compareTo(Node other){
        return name.compareTo(other.name);
    }

}

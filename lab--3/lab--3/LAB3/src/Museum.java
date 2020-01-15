public class Museum extends  Node implements Classifiable {
 public void setRank(String rank){
     this.rank=rank;
 }
 Museum(String name,String rank){
     this.name=name;
     setRank(rank);
 }


}

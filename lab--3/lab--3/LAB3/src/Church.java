public class Church extends Node implements Classifiable {

    public void setRank(String rank){
        this.rank=rank;
    }
    Church(String name,String rank){
        this.name=name;
        setRank(rank);

    }


}

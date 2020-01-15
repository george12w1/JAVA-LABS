import java.util.Random;

public class RandomPlayer extends Player {

    public RandomPlayer(String name) {
        super(name);
    }

    @Override
    public String toString(){
        String buffer="";
        buffer+="\n THE GAME STOPPED ALL THREADS \n";
        buffer+="the winner is RandomPlayer "+name+"\n";
        buffer+=graph;
        return buffer;
    }
    //the random player choose the edge randomly
    @Override
    public void extract(){
        Edge extracted=null;
        Random rn=new Random();
        int size=game.getBoard().complete.edges.size();
        int rnumber=rn.nextInt(size);
        extracted=game.getBoard().complete.edges.get(0);
        game.getBoard().complete.edges.remove(extracted);
        graph.add(extracted);

    }

}

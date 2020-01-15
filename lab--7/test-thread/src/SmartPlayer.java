import java.util.Scanner;

public class SmartPlayer extends Player {
    public PreferredEdges preffered;
    public SmartPlayer(String name) {
        super(name);
        preffered=new PreferredEdges(5);
    }

    @Override
    public String toString(){
        String buffer="";
        buffer+="\n THE GAME STOPPED ALL THREADS \n";
        buffer+="the winner is SmartPlayer "+name+"\n";
        buffer+=graph;
        return buffer;
    }
    @Override
    public void extract(){
        Edge extracted=null;
        int move=goodMove();
        extracted=game.getBoard().complete.edges.get(move);
        System.out.println(extracted.i+" "+extracted.j);
        game.getBoard().complete.edges.remove(extracted);
        graph.add(extracted);

    }
    public int goodMove(){
        int move=0;
        try{Thread.sleep(1500);
            //game.getBoard().displayAll();
             }catch (InterruptedException e){};
        int size=game.getBoard().complete.edges.size()-1;
        for(int i=0;i<size;i++){

            if(preffered.found(game.getBoard().complete.edges.get(i))!=-1){
                move=i;
                preffered.deleteOptions(game.getBoard().complete.edges.get(i));
            break;
            }
        }
        //choose the edge that is consecutive and is different from all

        return move;
    }
}

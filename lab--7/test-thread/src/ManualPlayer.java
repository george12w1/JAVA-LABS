import java.util.Scanner;

public class ManualPlayer extends Player {

    public ManualPlayer(String name) {
        super(name);
    }

    @Override
    public String toString(){
        String buffer="";
        buffer+="\n THE GAME STOPPED ALL THREADS \n";
        buffer+="the winner is ManualPlayer "+name+"\n";
        buffer+=graph;
        return buffer;
    }
    @Override
    public void extract(){
        Edge extracted=null;
        //display all valable edges
        try{Thread.sleep(THINKING_TIME+1);}catch(InterruptedException e){};
        game.getBoard().displayAll();

        Scanner sc = new Scanner(System.in);
        int decided;
        int size=game.getBoard().complete.edges.size();
        do{decided = sc.nextInt();
        if(decided<0 || decided>game.getBoard().complete.edges.size())
           game.getBoard().displayAll();
            System.out.println("GIVE ME A NUMBER FROM 0 TO "+size+" - 1");
        }while(decided<0 || decided>size);
        extracted=game.getBoard().complete.edges.get(decided);
        game.getBoard().complete.edges.remove(extracted);
        graph.add(extracted);
    }

}

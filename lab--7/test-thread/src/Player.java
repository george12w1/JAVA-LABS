public class Player implements Runnable {
    protected String name;
    protected Game game;
    protected int THINKING_TIME=500;
    protected Graph graph;
    public boolean run=true;
    private int id;
    Board board;
    public Player(String name) {
        this.name = name;

        graph=new Graph();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGame(Game game) {
        this.game = game;
        board=game.getBoard();
    }

    @Override
    public String toString(){
      String buffer="";
      buffer+="\n THE GAME STOPPED ALL THREADS \n";
      buffer+="the winner is "+name+"\n";
      buffer+=graph;
      return buffer;
    }

    public void extract(){
        Edge extracted=board.extract();
        graph.add(extracted);
    }
    @Override
    public void run(){

        if(game.getTurn(id)){
            if(id==game.getPlayers().size())
            System.out.println(name+" ----- end of step extraction");
            else System.out.println(name);

            //extract edge
           extract();
            if(graph.isSpanningTree(game.getBoard().vertices)){
                System.out.println(this);
               game.stop();

            }
            //notifyAll();
        }
        //else wait();
        try{Thread.sleep(THINKING_TIME);}catch(InterruptedException e){};
        if(run)run();
    }

}

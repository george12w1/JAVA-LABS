import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players = new ArrayList<>();
    private int turn=1;
    private Board board;
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public void setTurn(int turn) {
        this.turn = turn;
    }
    Thread time;
    public boolean getTurn(int id) {
        if(id==turn){
            if(turn==players.size())turn=1;
            else turn++;
            return true;
        }
        else
        return false;

    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setId(players.size());
        player.setGame(this);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void start(){

        time=new Thread(new Time(1000
                ,this));

        for(int i=0;i<players.size();i++){
            Thread pl=new Thread(players.get(i));
            pl.start();
        }
        time.start();
    }
    public void stop(){
        for(int i=0;i<this.getPlayers().size();i++)
            this.getPlayers().get(i).run=false;
            time.interrupt();
        System.out.println("THE GAME STOPPED THE TIME KEEPER");
        }
}

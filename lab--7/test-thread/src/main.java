public class main {
    public static void main(String[] args){
        Game game = new Game();

        game.setBoard(new Board(10));
        game.addPlayer(new RandomPlayer("Player 1"));
        game.addPlayer(new RandomPlayer("Player 2"));
        game.addPlayer(new SmartPlayer("Player 3"));
        //game.addPlayer(new Player("Player 3"));
        //game.addPlayer(new Player("Player 4"));
        game.start();

    }
}

public class Time implements Runnable {
    private int limitation;
    private int time=0;
    private Game game;

    public Time(int limitation, Game game) {
        this.limitation = limitation;
        this.game = game;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(1000);
            time++;
            System.out.println("GAME TIME IS "+time);
            if (time < limitation) run();
            else {
                System.out.println("sorry the time excedeed ( "+limitation+" seconds)");
                game.stop();

            }

        }catch(InterruptedException f){};
    }

}
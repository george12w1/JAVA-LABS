public class Board {
    public final Graph complete;
    public int vertices;

    public Board(int n) {
        vertices = n;
        complete = new Graph();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) complete.add(new Edge(i, j));


            }
        }
        complete.shuffle();
    }

    public synchronized Edge extract() {
        Edge edge = complete.pollFirst();

        return edge;
    }

    public boolean isEmpty() {
        boolean b = complete.edges.size() == 0;
        return b;
    }

    public void displayAll() {
        System.out.println("Choose from this list");
        for (int i = 0; i <complete.edges.size(); i++) {
            System.out.println(i + "-(" + complete.edges.get(i).i + "," + complete.edges.get(i).j + ")");
        }
    }
}
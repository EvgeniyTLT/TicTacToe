public class Main {
    public static void main(String[] args) {


        char[][] char2Darr = new char[3][3];
        GridPainter gp = new GridPainter(char2Darr);
        gp.emptyGrid();
        GameLogic game = new GameLogic(gp);
        gp.show();
        game.start();

    }
}

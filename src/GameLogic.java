import java.util.Scanner;

public class GameLogic {
    private final GridPainter gp;
    private char winner;
    private int counterSpace = 0;
    private final Player playerX = new Player('x');
    private final Player player0 = new Player('0');
    private char activePlayer = player0.znak;


    public GameLogic(GridPainter grid) {
        this.gp = grid;
    }

    private void checkWinner(char element1, char element2, char element3) {
        if (element1 == element2 && element2 == element3) {
            winner = element1;
        }
    }

    private boolean horizontalWin() {

        checkWinner(gp.grid[0][0], gp.grid[0][1], gp.grid[0][2]);
        checkWinner(gp.grid[1][0], gp.grid[1][1], gp.grid[1][2]);
        checkWinner(gp.grid[2][0], gp.grid[2][1], gp.grid[2][2]);

        if (winner == '0' || winner == 'x') return true;
        else return false;
    }

    private boolean verticalWin() {
        if (gp.grid[0][0] == gp.grid[0][1] && gp.grid[0][1] == gp.grid[0][2]) {
            winner = gp.grid[0][1];

        } else if (gp.grid[0][1] == gp.grid[1][1] && gp.grid[1][1] == gp.grid[2][1]) {
            winner = gp.grid[2][1];

        } else if (gp.grid[0][2] == gp.grid[1][2] && gp.grid[1][2] == gp.grid[2][2]) {
            winner = gp.grid[2][2];

        }
        if (winner == '0' || winner == 'x') return true;
        else return false;
    }

    private boolean diagonalWin() {
        if (gp.grid[0][0] == gp.grid[1][1] && gp.grid[1][1] == gp.grid[2][2]) {
            winner = gp.grid[0][0];
        } else if (gp.grid[0][2] == gp.grid[1][1] && gp.grid[1][1] == gp.grid[2][0]) {
            winner = gp.grid[2][0];
        }
        if (winner == '0' || winner == 'x') return true;
        else return false;

    }

    private void counterSpace() {
        counterSpace = 0;
        for (int i = 0; i < gp.grid.length; i++) {
            for (int j = 0; j < gp.grid[i].length; j++) {
                if (gp.grid[i][j] == '_') counterSpace++;
            }

        }
    }


    private boolean isDraw() {
        if (counterSpace == 0 && winner != '0' && winner != 'x') return true;
        else return false;
    }

    private boolean canMove() {
        if (counterSpace != 0 && winner != '0' && winner != 'x') return true;
        else return false;
    }

    private void showStatus() {
        if (checkWin()) System.out.println("winner is " + winner);
        if (isDraw()) System.out.println("Никто не победил");

    }

    private boolean checkWin() {
        return verticalWin() || diagonalWin() || horizontalWin();
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        counterSpace();
        while (canMove() && !isDraw() && !checkWin()) {
            switchActivePlayer();
            try {
                String coordinate = scanner.nextLine();
                char[] coor = coordinate.toCharArray();
                int gor = Character.getNumericValue(coor[0]);
                int ver = Character.getNumericValue(coor[2]);
                gp.grid[gor][ver] = activePlayer;
            } catch (Exception e) {
                System.out.println("Неправильный ввод");
                switchActivePlayer();
            }


            gp.show();
            counterSpace();
        }
        showStatus();
    }

    private void switchActivePlayer() {
        if (activePlayer == player0.znak) activePlayer = playerX.znak;
        else activePlayer = player0.znak;
    }
}

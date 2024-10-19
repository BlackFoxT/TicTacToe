package Game;

import java.util.ArrayList;
import java.util.List;

public class GameTable {
    public char[][] table = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};

    public void printTable() {
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[0].length; col++) {
                System.out.print(table[row][col]);
                if (col < table[0].length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < table.length - 1) {
                System.out.println("- - - - -");
            }
        }
    }

    public List<Character> getEmptySpaces() {
        List<Character> emptySpaces = new ArrayList<>();
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[0].length; col++) {
                if (table[row][col] >= '1' && table[row][col] <= '9') {
                    emptySpaces.add(table[row][col]);
                }
            }
        }
        return emptySpaces;
    }

    private boolean contains(char letter) {
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[0].length; col++) {
                if (table[row][col] == letter) {
                    return true;
                }
            }
        }
        return false;
    }

    private void setMove(char letter, char pos) {
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[0].length; col++) {
                if (table[row][col] == pos) {
                    table[row][col] = letter;
                }
            }
        }
    }

    public boolean setTable(char letter, char pos) {
        if (!contains(pos)) {
            return false;
        }
        setMove(letter, pos);
        return true;
    }

    private boolean checkRow(int row) {
        char firstValue = table[row][0];
        for (int i = 1; i < table[row].length; i++) {
            if (table[row][i] != firstValue) {
                return false;
            }
        }
        return true;
    }

    private boolean checkEveryRow() {
        for (int i = 0; i < table.length; i++) {
            if (checkRow(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(int col) {
        char firstValue = table[0][col];
        for (int i = 1; i < table.length; i++) {
            if (table[i][col] != firstValue) {
                return false;
            }
        }
        return true;
    }

    private boolean checkEveryColumn() {
        for (int i = 0; i < table[0].length; i++) {
            if (checkColumn(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkEveryCross() {
        return ((table[0][0] == table[1][1] && table[1][1] == table[2][2]) ||
                (table[0][2] == table[1][1] && table[1][1] == table[2][0]));
    }

    public boolean noMorePlay() {
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[0].length; col++) {
                char cell = table[row][col];
                if (cell >= '1' && cell <= '9') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isGameFinished() {
        return (checkEveryRow() || checkEveryColumn() || checkEveryCross());
    }
}

package Players;

import java.util.List;

public abstract class Player {
    public String name;

    public String choseCoinSide() {
        return null;
    }

    public char choseEmptySpace(List<Character> emptySpaces) {
        return '0';
    }
}

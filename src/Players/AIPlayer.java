package Players;

import java.util.List;

public class AIPlayer extends Player {
    public AIPlayer() {
        setName();
    }

    public void setName() {
        name = "AI" + (int)(10 + (Math.random() * 100));
    }

    @Override
    public String choseCoinSide() {
        String options[] = {"H", "T"};
        return options[(int) (Math.random() * options.length)];
    }

    @Override
    public char choseEmptySpace(List<Character> emptySpaces) {
        if (!emptySpaces.isEmpty()) {
            return emptySpaces.get((int) (Math.random() * emptySpaces.size()));
        }
        return '0';
    }
}

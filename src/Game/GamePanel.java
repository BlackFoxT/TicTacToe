package Game;

import Players.Player;
import Players.User;
import Players.AIPlayer;
import java.util.Scanner;

public class GamePanel {

    public String[] desicionArray = {"H", "T"};

    User player1 = new User();
    User player2 = new User();
    AIPlayer aiPlayer1 = new AIPlayer();
    AIPlayer aiPlayer2 = new AIPlayer();

    String name1;
    String name2;

    public void start() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("Welcome to TicTacToe!!");
        System.out.println("Please select a mode:");
        System.out.println("1) Player VS Player");
        System.out.println("2) Player VS Computer");
        System.out.println("3) Computer VS Computer");
        System.out.print("Choose your option: ");
        option = input.nextInt();

        while (!(option > 0 && option < 4)) {
            System.out.print("Choose your option correctly: ");
            option = input.nextInt();
        }

        switch (option) {
            case 1:
                System.out.print("Please enter a name for the first player: ");
                name1 = input.next();
                player1.name = name1;
                System.out.print("Please enter a name for the second player: ");
                name2 = input.next();

                while (player1.name.equals(name2)) {
                    System.out.print("Please enter a different name for the second player: ");
                    name2 = input.next();
                }
                player2.name = name2;
                this.gameStart(player1, player2);
                break;

            case 2:
                System.out.print("Please enter a name for the player: ");
                name1 = input.next();
                player1.name = name1;

                while (player1.name.equals(aiPlayer1.name)) {
                    aiPlayer1.setName();
                }
                this.gameStart(player1, aiPlayer1);
                break;

            case 3:
                while (aiPlayer1.name.equals(aiPlayer2.name)) {
                    aiPlayer2.setName();
                }
                this.gameStart(aiPlayer1, aiPlayer2);
                break;
        }
    }

    public void gameStart(Player p1, Player p2) throws InterruptedException {
        String userDesicion;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe game");
        System.out.println("--------------------------");
        System.out.println("The game will start with a coin toss");

        System.out.print(p1.name + ", please select a side heads(H) or tails(T)? ");
        if (p1 instanceof User) {
            userDesicion = input.nextLine().toUpperCase();
        } else {
            Thread.sleep(500);
            userDesicion = p1.choseCoinSide();
        }

        while (!(userDesicion.equals("H") || userDesicion.equals("T"))) {
            System.out.print("Please choose correctly, " + p1.name + ". Heads(H) or tails(T)? ");
            if (p1 instanceof User) {
                userDesicion = input.nextLine().toUpperCase();
            } else {
                Thread.sleep(500);
                userDesicion = p1.choseCoinSide();
            }
        }

        String desicion = desicionArray[(int) (Math.random() * desicionArray.length)];

        if (userDesicion.equals(desicion)) {
            System.out.println(p1.name + " wins the coin toss! Game will start with " + p1.name);
            System.out.println("--------------------------");
            this.playGame(p1, p2);
        } else {
            System.out.println(p1.name + " loses the coin toss! Game will start with " + p2.name);
            System.out.println("--------------------------");
            this.playGame(p2, p1);
        }
    }

    public void playGame(Player p1, Player p2) throws InterruptedException {
        GameTable table = new GameTable();
        Scanner input = new Scanner(System.in);

        table.printTable();
        System.out.println("\n");
        while (!table.noMorePlay()) {
            System.out.println(p1.name + ", it's your turn. Choose a position to set with X: ");
            char pos = ' ';
            if (p1 instanceof User) {
                pos = input.nextLine().charAt(0);
            } else {
                Thread.sleep(500);
                pos = p1.choseEmptySpace(table.getEmptySpaces());
            }
            while (!table.setTable('X', pos)) {
                System.out.println("Please enter a valid location, " + p1.name);
                if (p1 instanceof User) {
                    pos = input.nextLine().charAt(0);
                } else {
                    Thread.sleep(500);
                    pos = p1.choseEmptySpace(table.getEmptySpaces());
                }
            }

            table.printTable();
            System.out.println("\n");
            if (table.isGameFinished()) {
                System.out.println("Game finished! " + p1.name + " won!!");
                return;
            } else {
                if (!table.noMorePlay()) {
                    char pos1 = ' ';
                    System.out.println(p2.name + ", it's your turn. Choose a position to set with O: ");
                    if (p2 instanceof User) {
                        pos1 = input.nextLine().charAt(0);
                    } else {
                        Thread.sleep(500);
                        pos1 = p2.choseEmptySpace(table.getEmptySpaces());
                    }
                    while (!table.setTable('O', pos1)) {
                        System.out.println("Please enter a valid location, " + p2.name);

                        if (p2 instanceof User) {
                            pos1 = input.nextLine().charAt(0);
                        } else {
                            Thread.sleep(500);
                            pos1 = p2.choseEmptySpace(table.getEmptySpaces());
                        }
                    }

                    table.printTable();
                    System.out.println("\n");
                    if (table.isGameFinished()) {
                        System.out.println("Game finished! " + p2.name + " won!!");
                        return;
                    }
                }
            }
        }

        System.out.println("Game finished! No winner in this game!!");
    }
}

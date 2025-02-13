# Tic-Tac-Toe Game

This is a simple Tic-Tac-Toe game implemented in Java. It allows users to play in three different modes:
1. Player vs Player
2. Player vs Computer
3. Computer vs Computer

## Features
- Command-line interface.
- Coin toss to decide the first player.
- AI opponent that selects moves randomly.
- Classic 3x3 Tic-Tac-Toe game logic.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) installed (Java 8 or later).

### Running the Game
1. Clone this repository or download the source code.
2. Navigate to the project directory.
3. Compile the game using the following command:
   ```sh
   javac Main.java
   ```
4. Run the game:
   ```sh
   java Main
   ```

## Code Structure

```
TicTacToe/
├── Main.java               # Entry point of the game
├── Game/
│   ├── GamePanel.java      # Handles game logic and player interactions
│   ├── GameTable.java      # Represents the game board
├── Players/
│   ├── Player.java         # Abstract base class for players
│   ├── User.java           # Represents a human player
│   ├── AIPlayer.java       # Represents an AI player
```

## How to Play
1. Run the game and choose a mode.
2. If playing against another player, both players enter their names.
3. If playing against AI, the user enters their name, and the AI name is randomly generated.
4. A coin toss decides who starts first.
5. Players take turns selecting positions (1-9) to place their mark (`X` or `O`).
6. The game continues until a player wins or the board is full.

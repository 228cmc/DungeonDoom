# Dungeon of Doom Game

## Overview
"Dungeon of Doom" is a text-based Java game. You control a human player who collects gold and tries to escape while a bot chases you. The board has walls, exits, and gold. You play by typing commands.


## Features
- **Human Player**: You control it with commands like `LOOK`, `MOVE`, or `PICKUP`.
- **Bot Player**: The bot chases you automatically.
- **Game Elements**:
  - **Walls**: You can’t go through them.
  - **Gold**: Collect enough to win.
  - **Exits**: Reach one to escape.
  - **Empty Floor**: Spaces where you can move.
- **Commands**:
  - `LOOK`: See a 5x5 view of the board.
  - `MOVE`: Move your player in a direction.
  - `PICKUP`: Pick up gold if it's there.
  - `HELLO`: Show how much gold is needed to win.
  - `QUIT`: End the game.



## Folder organization
.
├── Main.java
├── Board.java
├── BotPlayer.java
├── HumanPlayer.java
├── Player.java
├── Wall.java
├── Gold.java
├── EmptyFloor.java
├── exampleBoard.txt


exampleBoard.txt :This is the default sample game board provided for testing. If you want to use a custom board file, place your own file (e.g., otherBoardYours.txt) at the same level as exampleBoard.txt and the Java files.

.
├── Main.java
├── Board.java
├── BotPlayer.java
├── HumanPlayer.java
├── Player.java
├── Wall.java
├── Gold.java
├── EmptyFloor.java
├── exampleBoard.txt
├── otherBoardYours.txt



## Classes

### **Main**
The starting point of the game. It:
- Reads the board file.
- Runs the game loop.
- Processes user commands.

### **Board**
The game board:
- Loads the board layout.
- Manages walls, gold, players, and exits.
- Handles commands like `MOVE`, `LOOK`, or `PICKUP`.

### **Player**
A base class for both human and bot. Includes:
- Player position (`x` and `y`) and gold collected.
- Movement methods like `moveNorth()` and `moveSouth()`.

### **HumanPlayer**
The class for the player you control.

### **BotPlayer**
The bot that chases you. It has:
- `chaseHuman()`: Moves toward the human.

### **Wall**
Represents a wall

### **Gold**
Represents gold. Includes:
- `requiredGold()`: Shows how much gold you need to win.

### **EmptyFloor**
Checks the board dimensions and validates lines in the board file


## How to Play

1. **Set Up**:
   - Prepare a `.txt` file for the board. Allowed characters:
     - `P`: Player
     - `B`: Bot
     - `G`: Gold
     - `E`: Exit
     - `#`: Wall
     - `.`: Empty floor


   - Example:
     ```
     ########
     #P....E#
     #..G...#
     #......#
     #B.....#
     ########
     ```



2. **Run the Game**:

   - Compile: `javac Main.java`
   - Run: `java Main <file_path>`


3. **Commands**:
   - `LOOK`: Shows a 5x5 area around you.
   - `MOVE`: Move north, south, east, or west
   - `PICKUP`: Pick up gold
   - `HELLO`: shows how much gold you need to win
   - `QUIT`: ends the game.



## Rules

1. Collect enough gold (`2` by default)
2. go to an exit with the gold to win.
3. If the bot catches you, you lose.
4. you can’t move through walls



## Ideas to Improve
-Improve file path handling to ensure compatibility across operating systems (e.g., normalize paths to handle both \ and / automatically).
-that the bot can also pick gold right now the functionality can be implemented from the parent class but it hasn't been implemented yet.
- Add more bots for extra difficulty.
- Add traps or power-ups.
- Make a graphical version.


## Author
- Made by **me**. 



## License
MIT License.
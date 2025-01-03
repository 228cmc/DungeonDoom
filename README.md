"Dungeon of Doom" is a text-based Java game where you collect gold, avoid a chasing bot, and escape through exits by typing commands.

how to play: 

Use exampleBoard.txt or place a valid .txt file (e.g., customBoard.txt) with P, B, G, E, #, . at the same level as the Java files.

Compile: javac Main.java
Run: java Main <file_path>

Commands :
LOOK: view a 5x5 board section.
MOVE <direction>: Move north, south, east, or west.
PICKUP:  Collect gold.
HELLO: show gold needed to win.
QUIT : Exit game.

Rules:
Collect enough gold and reach an exit to win.
Avoid the bot.
Walls block movement.


Classes and object-oriented design

the game applies object-oriented programming principles by organizing functionality into specific classes such as :  wall, gold, wall, player, HumanPlayer, Botplayer, Board. 
the player class is an abstract base class that defines shared attributes like position (x, y) and collected gold. both humanplayer and botplayer inherit from it, using inheritance to share common methods like movement while implementing their unique behaviors/ specialization. For example the botplayer includes the chasehuman method to track the human player.

the board class encapsulates the game’s logic, managing interactions between players, walls, exits, and gold. it processes commands like move + direction or pickup and updates the board state. the gold class includes a static requiredgold method, ensuring the game enforces a fixed win condition, showcasing encapsulation of data and behavior.

the emptyfloor class validates the board dimensions and layout, keeping validation logic isolated. 






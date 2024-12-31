import java.util.Scanner;

public class Main { 
    public static void main (String[] args) {  
        String filePath;
        Scanner scanner = new Scanner(System.in);// create a Scanner object that allows capturing user input from the console


        if (args.length < 1) {
            System.out.println("No file path given,  please type the path:");
            filePath = scanner.nextLine();
        } else {
            filePath = args[0];
        }

        
        Board board = new Board(); // initialize the board
        board.initializeBoard(filePath);


        
        String command; // declare clares a String variable named command to store the input provided by the user.

        System.out.println("type a command (QUIT, LOOK, MOVE, HELLO, GOLD) :");
        while (true) {
            command = scanner.nextLine();
            board.processCommand(command);
        }
    }
}

import java.util.Scanner;

public class Main { 
    public static void main (String[] args) {  
        String filePath;

        if (args.length < 1) {
            System.out.println("No file path given,  please type the path:");
            Scanner scanner = new Scanner(System.in);
            filePath = scanner.nextLine();
            scanner.close();
        } else {
            filePath = args[0];
        }

        Board board = new Board();
        board.initializeBoard(filePath);
    }
}

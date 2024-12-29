public class Board {

    //declare variables with objects defined in other java files
    private  EmptyFloor emptyFloor; // Declare a variable named emptyFloor that will hold an object of type EmptyFloor
    private  Wall wall; 
    private  int titles;
    private Gold gold; 
    private BotPlayer botPlayer;
    private HumanPlayer humanPlayer;

    public Board(){
        this.emptyFloor = new EmptyFloor(titles, titles); //we use new because we are not longer working with primitive variables
        this.wall = new Wall(titles);  //
        this.botPlayer = new BotPlayer(titles, titles, titles);
        this.humanPlayer  = new HumanPlayer(titles, titles, titles);
    
}

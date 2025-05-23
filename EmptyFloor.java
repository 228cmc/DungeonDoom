import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

public class EmptyFloor { 
/**
 * This class represents the empty floor of the game board
 * in general it was build to get the dimensions of the board and get the valid lines of the board from the file
 * it has two attributes width and heigth
 * it has methods such as getters and setters for each attributes and  a method called getValidLines to get from the txt the adequate data
 */

    //atributes
    int width;
    int height;

    public EmptyFloor( int width, int height){
    /**contructor of the class  with the specified dimensions
     * @param width : the initial width of the board
     * @param height the iniial height of the board
     *
     */
        this.width = width;
        this.height = height;
    }

    //getters and setters 
    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) { 
        this.height= height;
    }

    public  List<String>   getValidLines(String filePath){
    /**public method finds dimensions of the board and its valid lines
     * 
     * it reads the txt board file and   applies the private method containsValidLetters to determine or not if a line is valid
     * according to the first valid line the width and height are determined to apply another condition to be a valid line
     * 
     * @param filePath : the path of the game board file
     * @return    a list fo valid lines to be used in the game
    */


        // inicialize line, lines, count for determining first line
        String line; 
        List<String> lines = new ArrayList<>();
        int count =0;

        try{
            FileReader fileReader; // create a variable type fileReader
            fileReader = new FileReader(filePath); //asigned the variable to the new object

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(fileReader);



            while((line = bufferedReader.readLine()) !=null) {

                line = line.trim();//allow spaces at the beginning and end

                //first validation according to the characters
                if (containsValidLetters(line)) {
                    count++;
                    if (count ==1){
                        this.setWidth(line.length()); //set width 
                    }
                    //second validation according to the dimensions
                    if(this.width == line.length()) { 
                        lines.add(line);
                    }
                } 
            }

            this.setHeight(lines.size()); //determine height with setter
            //System.out.println("height " + this.height);
            bufferedReader.close();


        } catch(Exception e) { //error handling
            System.out.println("error");
        }

        return lines; //return the lines that work

    }




    private boolean containsValidLetters(String line) {

    /**this method is a private method to evaluate syntaxis  using regex. 
     * it returns true if valid, false if not 
     * the only characters allowed are P,B,G,E  . #  . they can be 1 or more times
     * 
     * @param line : line to validate
     * @return  true  if the line contains only valid characters, false otherwise
     */
        if (!line.matches("[PBGE.#]+")) {//= meaming one or more  [values permitted in the line]
            return false; 
        }
        return true;
    }
}
